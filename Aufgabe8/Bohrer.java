
@Author(name="Ulrich Aschl")
public class Bohrer implements Einsatzart {
	
	private double laenge;
	// Invariante: laenge darf nicht kleiner 0 sein.
	
	// Vorbedingung: laenge darf nicht kleiner 0 sein.
	public Bohrer(double laenge) {
		this.laenge = laenge;
	}
	
	// Nachbedingung: gibt die Länge des Bohrers zurück.
	public double getLaenge() {
		return this.laenge;
	}
	
	// Nachbedingung: Gibt die Länge des Bohrers als String aus.
	@Override
	public String toString() {
		return "Bohrer: " + this.laenge + " cm";
	}
}
