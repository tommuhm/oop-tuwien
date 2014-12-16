
public abstract class Geschenk {

	private String name;
	private double hoehe;
	private Grundform grundform;

	public Geschenk(String name, double hoehe, Grundform grundform) {
		this.name = name;
		this.hoehe = hoehe;
		this.grundform = grundform;
	}

}
