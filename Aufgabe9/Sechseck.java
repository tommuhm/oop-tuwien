
public class Sechseck extends Grundflaeche {

	private double seitenlaenge;

	public Sechseck(double seitenlaenge) {
		this.seitenlaenge = seitenlaenge;
	}

	@Override
	public double flaeche(double kartondicke) {
		return 3 / 2 * Math.pow(seitenlaenge + kartondicke, 2) * Math.sqrt(3);
	}
}
