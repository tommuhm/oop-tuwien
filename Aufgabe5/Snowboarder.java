
public class Snowboarder extends Person {

	private int groesse;

	public Snowboarder(String name, int groesse) {
		super(name);
		this.groesse = groesse;
	}
	
	public String toString() {
		return ( "Name: " + super.name + " Groesse: " + groesse);
	}
}
