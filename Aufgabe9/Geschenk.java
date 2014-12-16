
public abstract class Geschenk {

	private String name;
	private double hoehe;
	private Grundflaeche grundform;

	public Geschenk(String name, double hoehe, Grundflaeche grundform) {
		this.name = name;
		this.hoehe = hoehe;
		this.grundform = grundform;
	}

}
