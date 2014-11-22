import java.util.HashMap;


public class Mission {

	private String name;
	private Raumsonde raumsonde;
	
	private Modul schwerstesModul;
	
	private HashMap<Himmelskoerper, Modul> ladung;
	private int aktuelleLast;
	
	public Mission (String name, Raumsonde raumsonde){
		this.name = name;
		this.raumsonde = raumsonde;
		
		this.aktuelleLast = 0;
		this.ladung = new HashMap<Himmelskoerper, Modul>();
		this.schwerstesModul = null;
	}
	
	public Mission (String name, int nutzlast) {
		this.name = name;
		this.raumsonde = new Raumsonde(nutzlast);

		this.aktuelleLast = 0;
		this.ladung = new HashMap<Himmelskoerper, Modul>();
		this.schwerstesModul = null;
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
			this.umstellenAuf(schwerstesModul);
			return m;
		}

		m = new ModulFallschirm(220);
		if(himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) < raumsonde.getMaxNutzlast() ) {
			this.add(himmelskoerper, m);
			this.umstellenAuf(schwerstesModul);
			return m;
		}
		
		m = new ModulDuesen(250);
		if(himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) < raumsonde.getMaxNutzlast() ) {
			this.add(himmelskoerper, m);
			this.umstellenAuf(schwerstesModul);
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
		
		if(this.schwerstesModul == null || (this.schwerstesModul != null && this.schwerstesModul.getGewicht() < m.getGewicht())) {
			this.schwerstesModul = m;
		}
	}
	
	public Himmelskoerper remove (String name) {
		Himmelskoerper himmelskoerper = null;
		for(Himmelskoerper hTemp : ladung.keySet()) {
			if(hTemp.getName().equals(name)) {
				himmelskoerper = hTemp;
				break;
			}
		}
		
		if(himmelskoerper != null) {
			ladung.remove(himmelskoerper);
		}
		
		return himmelskoerper;
	}

	public void missionslist() {
		for(Himmelskoerper hTemp : ladung.keySet()) {
			System.out.println(" " + hTemp.getName());
		}
	}
	
	public void utilization() { //Maybe nur in Prozent?
		float fAktuell = this.aktuelleLast;
		float fMax = this.raumsonde.getMaxNutzlast();
		float prozent =  fAktuell / fMax * 100;
				
		System.out.println(this.aktuelleLast + "/" + this.raumsonde.getMaxNutzlast() + " (" + prozent +  "%)");
	}
}
