
public class Rechteck extends Grundflaeche {

	private double laenge;
	private double breite;

	public Rechteck(double laenge, double breite) {
		this.laenge = laenge;
		this.breite = breite;
	}

	@Override
	public double flaeche(double kartondicke) {
		return (laenge + 2 * kartondicke) * (breite + 2 * kartondicke);
	}
}
