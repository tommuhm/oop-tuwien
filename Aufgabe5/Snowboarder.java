
public class Snowboarder extends Person {

	private int groesse;

	public Snowboarder(String name, int groesse) {
		super(name);
		this.groesse = groesse;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Snowboarder) {
			return super.equals(o) && ((Snowboarder) o).groesse == this.groesse;
		}

		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " Groesse: " + groesse;
	}
}
