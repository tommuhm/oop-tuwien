
@Author(name="Ulrich Aschl")
public class RadRoboter extends Erkundungsroboter{
	
	private double wegstrecke;
	// Invariante: wegstrecke darf nicht kleiner als 0 sein.
	
	// Vorbedingung: art darf nicht null sein
	// Vorbedingung: stunden muss größer gleich 0 sein
	// Vorbedingung: wegstrecke muss größer gleich 0 sein 
	public RadRoboter(Einsatzart art,  int stunden, double wegstrecke) {
		super(art, stunden);
		this.wegstrecke = wegstrecke;
	}

	// Vorbedingung: art darf nicht null sein
	public RadRoboter(Einsatzart art) {
		super(art);
		this.wegstrecke = 0;
	}

	// Nachbedingung: wegstrecke wird um (+1) erhöht.
	public void erhoeheWegstrecke() {
		this.wegstrecke++;
	}

	// Nachbedingung: gibt wegstrecke zurück
	public double getWegstrecke() {
		return this.wegstrecke;
	}

	// Nachbedingung: gibt einen String zurück, der sich aus toString von Erkundungsroboter und der aktuellen Wegstrecke zusammensetzt.
	@Override
	public String toString() {
		return super.toString() + " Wegstrecke: " + this.getWegstrecke();
	}
}
