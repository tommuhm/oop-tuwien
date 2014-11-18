
public class Snowboarder extends Person {

	private int groesse;

	public Snowboarder(String name, int groesse) {
		super(name);
		this.groesse = groesse;
	}
	
	@Override
	public boolean equals(Person p) {
		if (p instanceof Skier) {
			return false;
		} else if ( p instanceof Snowboarder) {
			return p.name.equals(this.name);
		}
		return false;
	}
	
	public String toString() {
		return ( "Name: " + super.name + " Groesse: " + groesse);
	}
}
