
public class Skier extends Person {

	private double gewicht;

	// Vorbedingung: name darf nicht null sein
	public Skier(String name, double gewicht) {
		super(name);
		this.gewicht = gewicht;
	}
	
	// Vorbedingung: o darf nicht null sein
	// Nachbedingung: true, wenn die Attribute von o gleich den Attributen des aktuellen Objekts sind
	@Override
	public boolean equals(Object o) {
		if (o instanceof Skier) {
			return super.equals(o) && ((Skier) o).gewicht == this.gewicht;
		} return false;
	}

	// Nachbedinung: gibt den namen und das gewicht des Skiers zurueck
	@Override
	public String toString() {
		return super.toString() + " Gewicht: " + gewicht;
	}

}
