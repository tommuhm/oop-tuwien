
public class Snowboarder extends Person {

	private int groesse;

	// Vorbedingung: name darf nicht null sein
	public Snowboarder(String name, int groesse) {
		super(name);
		this.groesse = groesse;
	}

	// Nachbedinung: gibt den namen und die groesse des Snowboarders zurueck
	@Override
	public String toString() {
		return super.toString() + ", Groesse: " + groesse;
	}
}
