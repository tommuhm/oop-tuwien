public class Raumsonde {

	private int maxNutzlast;
	
	//Vorbedingung: maxNutzlast muss groesser als null sein
	public Raumsonde(int maxNutzlast) {
		this.maxNutzlast = maxNutzlast;		
	}

	//Nachbedingung: gibt die maximale Nutzlast zurueck
	public int getMaxNutzlast() {
		return maxNutzlast;
	}
}
