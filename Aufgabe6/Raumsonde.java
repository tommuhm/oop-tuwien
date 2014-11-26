public class Raumsonde {

	private int maxNutzlast;

	// Vorbedingung: Parameter maxNutzlast muss groesser als 0 sein
	public Raumsonde(int maxNutzlast) {
		this.maxNutzlast = maxNutzlast;
	}

	// Nachbedingung: gibt die maximale Nutzlast zurueck
	public int getMaxNutzlast() {
		return maxNutzlast;
	}
}
