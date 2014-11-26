import java.util.HashMap;


public class Mission {

	private String name;
	private Raumsonde raumsonde;
	private Modul schwerstesModul;
	private HashMap<Himmelskoerper, Modul> ladung;
	private int aktuelleLast;
	// Invariante: name darf nicht null sein
	// Invariante: raumsonde darf nicht null sein
	// Invariante: ladung darf nicht null sein
	// Invariante: aktuelleLast darf nur groesser gleich 0 sein

	// Vorbedingung: Der Parameter name darf nicht null sein
	// Vorbedingung: Der Parameter raumsonde darf nicht null sein
	public Mission(String name, Raumsonde raumsonde) {
		this.name = name;
		this.raumsonde = raumsonde;

		this.aktuelleLast = 0;
		this.ladung = new HashMap<Himmelskoerper, Modul>();
		this.schwerstesModul = null;
	}

	// Vorbedingung: Der Parameter name darf nicht null sein
	// Vorbedingung: Der Parameter nutzlast muss groesser gleich 0 sein
	public Mission(String name, int nutzlast) {
		this.name = name;
		this.raumsonde = new Raumsonde(nutzlast);

		this.aktuelleLast = 0;
		this.ladung = new HashMap<Himmelskoerper, Modul>();
		this.schwerstesModul = null;
	}

	// Vorbedingung: himmelskoerper darf nicht null sein
	// Nachbedingung: falls noch ausreichend platz ist muss anschliessend der himmelskoerper und das passende Modul an ladung angehaengt werden.
	// Nachbedingung: falls ein himmelskoerper hinzugefuegt wurde, muessen, wenn ausreichend platz, alle Module umgestellt werden.
	// Nachbedingung: falls ein himmelskoerper hinzugefuegt wurde, wird das passende Modul zurueckgegeben.
	public Modul add(Himmelskoerper himmelskoerper) {
		Modul m = new ModulGas(200);
		if (himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) <= raumsonde.getMaxNutzlast()) { // Hier koennen keine anderen umgestellt werden.
			this.add(himmelskoerper, m);
			return m;
		}

		m = new ModulSchwach(200);
		if (himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) <= raumsonde.getMaxNutzlast()) {
			this.add(himmelskoerper, m);
			this.umstellenAuf(schwerstesModul);
			return m;
		}

		m = new ModulFallschirm(220);
		if (himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) <= raumsonde.getMaxNutzlast()) {
			this.add(himmelskoerper, m);
			this.umstellenAuf(schwerstesModul);
			return m;
		}

		m = new ModulDuesen(250);
		if (himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) <= raumsonde.getMaxNutzlast()) {
			this.add(himmelskoerper, m);
			this.umstellenAuf(schwerstesModul);
			return m;
		}

		return null;
	}

	// Vorbedingung: m ist nicht null
	// Nachbedingung: Wenn moeglich werden alle Module in ladung auf das neue Modul m umgestellt.
	private void umstellenAuf(Modul m) {
		Modul mTemp;
		int last = 0;
		for (Himmelskoerper hTemp : ladung.keySet()) {
			mTemp = ladung.get(hTemp);
			if (hTemp.passtModul(m)) {
				last += m.getGewicht();
			} else {
				last += mTemp.getGewicht();
			}
		}

		if (last > this.raumsonde.getMaxNutzlast()) {
			return; //Nichts wurde veraendert.
		}

		for (Himmelskoerper hTemp : ladung.keySet()) {
			mTemp = ladung.get(hTemp);
			if (hTemp.passtModul(m)) {
				this.aktuelleLast -= mTemp.getGewicht();
				this.aktuelleLast += m.getGewicht();
				ladung.put(hTemp, m.klonen());
			}
		}
	}

	// Vorbedingung: himmelskoerper und m duerfen nicht null sein.
	// Nachbedingung: Darf nur aufgerufen werden, wenn die Nutzlast im Endeffekt nicht ueberstiegen wird.
	// Nachbedingung: ladung muss himmelskoerper und m enthalten.
	private void add(Himmelskoerper himmelskoerper, Modul m) {
		this.ladung.put(himmelskoerper, m);
		this.aktuelleLast += m.getGewicht();

		if (this.schwerstesModul == null || this.schwerstesModul.getGewicht() < m.getGewicht()) {
			this.schwerstesModul = m;
		}
	}

	// Vorbedingung: name darf nicht null sein
	// Nachbedingung: wenn ein himmelskoerper mit den namen name in ladung ist wird dieser entfernt und die aktuelle last verringert.
	// Nachbedingung: falls ein himmelskoerper entfernt wurde, wird dieser zurueckgegeben.
	public Himmelskoerper remove(String name) {
		Himmelskoerper himmelskoerper = null;
		for (Himmelskoerper hTemp : ladung.keySet()) {
			if (hTemp.getName().equals(name)) {
				himmelskoerper = hTemp;
				break;
			}
		}

		if (himmelskoerper != null) {
			this.aktuelleLast -= this.ladung.get(himmelskoerper).getGewicht();
			this.ladung.remove(himmelskoerper);
		}

		return himmelskoerper;
	}

	// Nachbedingung: gibt die aktuelle Liste an Himmelskoerpern aus.
	public void missionslist() {
		for (Himmelskoerper hTemp : ladung.keySet()) {
			System.out.println(" " + hTemp.getName());
		}
	}

	// Nachbedingung: gibt den aktuellen Grad an Ladung aus. (In KG und Prozent)
	public void utilization() {
		float fAktuell = this.aktuelleLast;
		float fMax = this.raumsonde.getMaxNutzlast();
		float prozent = fAktuell / fMax * 100;

		System.out.println(" " + fAktuell + "/" + fMax + " (" + prozent + "%)");
	}

}
