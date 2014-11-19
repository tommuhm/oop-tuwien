
public class Snowboarder extends Person {

	private int groesse;

	// Vorbedingung: name darf nicht null sein
	public Snowboarder(String name, int groesse) {
		super(name);
		this.groesse = groesse;
	}

	// Vorbedingung: o darf nicht null sein
	// Nachbedingung: true, wenn die Attribute von o gleich den Attributen des aktuellen Objekts sind
	@Override
	public boolean equals(Object o) {
		if (o instanceof Snowboarder) {
			return super.equals(o) && ((Snowboarder) o).groesse == this.groesse;
		}
		return false;
	}

	// Nachbedinung: gibt den namen und die groesse des Snowboarders zurueck
	@Override
	public String toString() {
		return super.toString() + " Groesse: " + groesse;
	}
}
