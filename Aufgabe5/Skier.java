
public class Skier extends Person {

	private double gewicht;

	// Vorbedingung: name darf nicht null sein
	// Vorbedingung: gewicht darf nicht null sein
	public Skier(String name, double gewicht) {
		super(name);
		this.gewicht = gewicht;
	}
	
	// Vorbedingung: o darf nicht null sein
	// Nachbedingung: true, wenn Objekt o gleich dem aktuellen Objekt (aber nicht notwendigerweise identisch) ist
	@Override
	public boolean equals(Object o) {
		if (o instanceof Skier) {
			return super.equals(o) && ((Skier) o).gewicht == this.gewicht;
		} return false;
	}

	@Override
	public String toString() {
		return super.toString() + " Gewicht: " + gewicht;
	}

}
