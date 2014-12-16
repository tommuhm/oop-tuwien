
public class Kreis extends Grundflaeche {

	private double durchmesser;

	public Kreis(double durchmesser) {
		this.durchmesser = durchmesser;
	}

	@Override
	public double flaeche(double kartondicke) {
		return Math.PI * Math.pow(durchmesser + 2 * kartondicke, 2) / 4;
	}
}
