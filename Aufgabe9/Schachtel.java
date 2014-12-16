
public class Schachtel extends Geschenk {

	private static final double KARTONDICKE = 0.5;

	public Schachtel(double hoehe, Grundflaeche grundflaeche) {
		super("", hoehe, grundflaeche);
	}

	public double volumen() {
		double flaecheAussen = super.getGrundform().flaeche(KARTONDICKE);
		double hoeheAussen = super.getHoehe() + 2 * KARTONDICKE;
		return flaecheAussen * hoeheAussen;
	}

	public boolean kannBeinhalten(Schachtel schachtel) {
		if (this.getHoehe() >= schachtel.getHoehe() && this.getGrundform().kannBeinhalten(schachtel.getGrundform()))
			return true;

		return false;
	}

}
