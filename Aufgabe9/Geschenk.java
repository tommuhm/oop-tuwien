
public abstract class Geschenk {

	private String name;
	private double hoehe;
	private Grundflaeche grundform;

	public Geschenk(String name, double hoehe, Grundflaeche grundform) {
		this.name = name;
		this.hoehe = hoehe;
		this.grundform = grundform;
	}

	public String getName() {
		return name;
	}

	public double getHoehe() {
		return hoehe;
	}

	public Grundflaeche getGrundform() {
		return grundform;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
}
