
public class Snowboarder extends Person {

	private int groesse;

	// Vorbedingung: name darf nicht null sein
	// Vorbedingung: groesse darf nicht null sein
	public Snowboarder(String name, int groesse) {
		super(name);
		this.groesse = groesse;
	}

	// Vorbedingung: o darf nicht null sein
	// Nachbedingun: true, wenn o gleich dem aktuellen Objekt ist
	@Override
	public boolean equals(Object o) {
		if (o instanceof Snowboarder) {
			return super.equals(o) && ((Snowboarder) o).groesse == this.groesse;
		} return false;
	}

	@Override
	public String toString() {
		return super.toString() + " Groesse: " + groesse;
	}
}
