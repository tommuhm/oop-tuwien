
@Author(name = "Ulrich Aschl")
public class RadRoboter extends Erkundungsroboter {

	private double wegstrecke;
	// Invariante: wegstrecke darf nicht kleiner als 0 sein.

	// Vorbedingung: art darf nicht null sein
	// Vorbedingung: stunden muss groesser gleich 0 sein
	// Vorbedingung: wegstrecke muss groesser gleich 0 sein
	@Author(name = "Ulrich Aschl")
	public RadRoboter(Einsatzart art, int stunden, double wegstrecke) {
		super(art, stunden);
		this.wegstrecke = wegstrecke;
	}

	// Vorbedingung: art darf nicht null sein
	@Author(name = "Ulrich Aschl")
	public RadRoboter(Einsatzart art) {
		super(art);
		this.wegstrecke = 0;
	}

	// Nachbedingung: wegstrecke wird um (+1) erhoeht.
	@Author(name = "Ulrich Aschl")
	public void erhoeheWegstrecke() {
		this.wegstrecke++;
	}

	// Nachbedingung: gibt wegstrecke zurueck
	@Author(name = "Ulrich Aschl")
	public double getWegstrecke() {
		return this.wegstrecke;
	}

	// Nachbedingung: gibt einen String zurueck, der sich aus toString von Erkundungsroboter und der aktuellen Wegstrecke zusammensetzt.
	@Override
	@Author(name = "Ulrich Aschl")
	public String toString() {
		return super.toString() + " Wegstrecke: " + this.getWegstrecke();
	}
}
