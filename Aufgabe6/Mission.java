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
		
		if(himmelskoerper.passtModul(m) && (this.aktuelleLast + m.getGewicht()) < raumsonde.getMaxNutzlast() ) {
			
		}
		
		
		return null;
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
