
public class Skier extends Person {

	private double gewicht;

	public Skier(String name, double gewicht) {
		super(name);
		this.gewicht = gewicht;
	}
	
	public String toString() {
		return ( "Name: " + super.name + " Gewicht: " + gewicht);
	}

}
