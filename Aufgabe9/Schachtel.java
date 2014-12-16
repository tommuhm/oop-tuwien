
public class Schachtel extends Geschenk {

	private static final double KARTONDICKE = 0.5;

	private Geschenk geschenk;

	public Schachtel(double hoehe, Grundflaeche grundflaeche) {
		super("", hoehe, grundflaeche);
		this.geschenk = null;
	}

	public double volumen() {
		double flaecheAussen = super.getGrundform().flaeche(KARTONDICKE);
		double hoeheAussen = super.getHoehe() + 2 * KARTONDICKE;
		return flaecheAussen * hoeheAussen;
	}

	public boolean kannBeinhalten(Geschenk geschenk) {
		if (this.getHoehe() >= geschenk.getHoehe() && this.getGrundform().kannBeinhalten(geschenk.getGrundform()))
			return true;

		return false;
	}

	public boolean addGeschenk(Geschenk geschenk) {
		if (!this.kannBeinhalten(geschenk))
			return false;

		this.geschenk = geschenk;
		this.setName(geschenk.getName());

		return true;
	}

	public boolean hasGeschenk() {
		if (geschenk == null)
			return false;
		return true;
	}

}
