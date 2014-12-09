
@Author(name = "Ulrich Aschl")
public class Bohrer implements Einsatzart {

	private double laenge;
	// Invariante: laenge darf nicht kleiner 0 sein.

	// Vorbedingung: laenge darf nicht kleiner 0 sein.
	@Author(name = "Ulrich Aschl")
	public Bohrer(double laenge) {
		this.laenge = laenge;
	}

	// Nachbedingung: gibt die Länge des Bohrers zurück.
	@Author(name = "Ulrich Aschl")
	public double getLaenge() {
		return this.laenge;
	}

	// Nachbedingung: Gibt die Länge des Bohrers als String aus.
	@Override
	@Author(name = "Ulrich Aschl")
	public String toString() {
		return "Bohrer: " + this.laenge + " cm";
	}
}
