
public class Skier extends Person {

	private double gewicht;

	// Vorbedingung: name darf nicht null sein
	public Skier(String name, double gewicht) {
		super(name);
		this.gewicht = gewicht;
	}
	
	// Nachbedinung: gibt den namen und das gewicht des Skiers zurueck
	@Override
	public String toString() {
		return super.toString() + ", Gewicht: " + gewicht;
	}

}
