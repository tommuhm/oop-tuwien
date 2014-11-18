
public class Skier extends Person {

	private double gewicht;

	public Skier(String name, double gewicht) {
		super(name);
		this.gewicht = gewicht;
	}

	@Override
	public boolean equals(Person p) {
		if (p instanceof Skier) {
			return p.name.equals(this.name);
		} else if ( p instanceof Snowboarder) {
			return false;
		}
		return false;
	}

	public String toString() {
		return ( "Name: " + super.name + " Gewicht: " + gewicht);
	}

}
