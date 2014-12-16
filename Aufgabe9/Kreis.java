
public class Kreis extends Grundflaeche {

	private double durchmesser;

	public Kreis(double durchmesser) {
		this.durchmesser = durchmesser;
	}

	@Override
	public boolean kannBeinhalten(Grundflaeche grundflaeche) {
		if (grundflaeche instanceof Rechteck || grundflaeche instanceof Quadrat)
			return false;

		if (grundflaeche instanceof Sechseck) {

		}

		return false;
	}

	@Override
	public double flaeche(double kartondicke) {
		return Math.PI * Math.pow(durchmesser + 2 * kartondicke, 2) / 4;
	}

	public double getDurchmesser() {
		return durchmesser;
	}
}
