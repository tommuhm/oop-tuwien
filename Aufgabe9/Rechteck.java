
public class Rechteck extends Grundflaeche {

	private double laenge;
	private double breite;

	//invariante für laenge > breite setzen!

	public Rechteck(double laenge, double breite) {
		this.laenge = laenge;
		this.breite = breite;
	}

	@Override
	public boolean kannBeinhalten(Grundflaeche grundflaeche) {
		return grundflaeche.passtIn(this);
	}

	@Override
	public boolean passtIn(Quadrat quadrat) {
		return false;
	}

	@Override
	public boolean passtIn(Rechteck rechteck) {
		if (this.getLaenge() >= rechteck.getLaenge() && this.getBreite() >= rechteck.getBreite())
			return true;
		return false;
	}

	@Override
	public boolean passtIn(Kreis kreis) {
		return false;
	}

	@Override
	public boolean passtIn(Sechseck sechseck) {
		double radius = sechseck.getSeitenlaenge();
		double inkreis = radius * Math.sqrt(3) / 2;

		if (this.getLaenge() >= 2 * radius && this.getBreite() >= 2 * inkreis)
			return true;
		return false;
	}

	@Override
	public double flaeche(double kartondicke) {
		return (laenge + 2 * kartondicke) * (breite + 2 * kartondicke);
	}

	public double getLaenge() {
		return laenge;
	}

	public double getBreite() {
		return breite;
	}
}
