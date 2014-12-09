
@Author(name = "Ulrich Aschl")
public class SprungRoboter extends Erkundungsroboter {

	private int spruenge;
	// Invariante: spruenge darf nicht kleiner als 0 sein.

	// Vorbedingung: art darf nicht null sein
	// Vorbedingung: stunden muss größer gleich 0 sein
	// Vorbedingung: spruenge muss größer gleich 0 sein
	@Author(name = "Ulrich Aschl")
	public SprungRoboter(Einsatzart art, int stunden, int spruenge) {
		super(art, stunden);
		this.spruenge = spruenge;
	}

	// Vorbedingung: art darf nicht null sein
	@Author(name = "Ulrich Aschl")
	public SprungRoboter(Einsatzart art) {
		super(art);
		this.spruenge = 0;
	}

	// Nachbedingung: spruenge wird um (+1) erhöht.
	@Author(name = "Ulrich Aschl")
	public void erhoeheSpruenge() {
		this.spruenge++;
	}

	// Nachbedingung: gibt spruenge zurück
	@Author(name = "Ulrich Aschl")
	public int getSpruenge() {
		return this.spruenge;
	}

	// Nachbedingung: gibt einen String zurück, der sich aus toString von Erkundungsroboter und der aktuellen Anzahl an Sprüngen zusammensetzt.
	@Author(name = "Ulrich Aschl")
	@Override
	public String toString() {
		return super.toString() + ", Spruenge: " + this.getSpruenge();
	}
}
