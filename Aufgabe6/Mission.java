import java.util.HashMap;


public class Mission {

	private String name;
	private RaumSonde raumsonde;
	
	private HashMap<Himmelskoerper, Modul> ladung;
	private int aktuelleLast;
	
	public Mission (String name, RaumSonde raumsonde){
		this.name = name;
		this.raumsonde = raumsonde;
		
		this.aktuelleLast = 0;
	}
	
	public Mission (String name, int nutzlast) {
		this.name = name;
		this.raumsonde = new RaumSonde(nutzlast);

		this.aktuelleLast = 0;
		this.ladung = new HashMap<Himmelskoerper, Modul>();
	}
	
	public Modul add(Himmelskoerper himmelskoerper) {
		Modul m = new ModulGas(200); //200 KG
		if(himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) < raumsonde.getMaxNutzlast() ) { // Hier können keine anderen umgestellt werden.
			this.add(himmelskoerper, m);
			return m;
		}
		
		m = new ModulSchwach(200);
		if(himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) < raumsonde.getMaxNutzlast() ) {
			this.add(himmelskoerper, m);
			this.umstellenAuf(m);
			return m;
		}

		m = new ModulFallschirm(220);
		if(himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) < raumsonde.getMaxNutzlast() ) {
			this.add(himmelskoerper, m);
			this.umstellenAuf(m);
			return m;
		}
		
		m = new ModulDuesen(250);
		if(himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) < raumsonde.getMaxNutzlast() ) {
			this.add(himmelskoerper, m);
			this.umstellenAuf(m);
			return m;
		}
		
		return null;
	}
	
	private void umstellenAuf(Modul m) {
		Modul mTemp;
		int last = 0;
		for(Himmelskoerper hTemp : ladung.keySet()) {
			mTemp = ladung.get(hTemp);
			if(hTemp.passtModul(m)) {
				last += m.getGewicht();
			} else {
				last += mTemp.getGewicht();
			}
		}
		
		if(last >= this.raumsonde.getMaxNutzlast()) {
			return; //Nichts wurde verändert.
		}
		
		for(Himmelskoerper hTemp : ladung.keySet()) {
			mTemp = ladung.get(hTemp);
			if(hTemp.passtModul(m)) {
				this.aktuelleLast -= mTemp.getGewicht();
				this.aktuelleLast += m.getGewicht();
				ladung.put(hTemp, m.clone());
			}
		}
	}

	//Nachbedingung: Darf nur aufgerufen werden, wenn die Nutzlast anschließend nicht überstiegen wird.
	private void add(Himmelskoerper himmelskoerper, Modul m) {
		this.ladung.put(himmelskoerper, m);
		this.aktuelleLast += m.getGewicht();
	}
	
	public Himmelskoerper remove (String name) {
		//TODO implement remove.
		return null;
	}

	public void missionslist() {
		//TODO implement
		return;
	}

	public void utilization() {
		//TODO implement
		return;
	}
}
