
public class Rechteck extends Grundflaeche {

	private double laenge;
	private double breite;

	public Rechteck(double laenge, double breite) {
		this.laenge = laenge;
		this.breite = breite;
	}

	@Override
	public boolean kannBeinhalten(Grundflaeche grundflaeche) {
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
