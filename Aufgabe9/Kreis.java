
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
			Sechseck sechseck = (Sechseck) grundflaeche;
			if (sechseck.getSeitenlaenge() <= (this.durchmesser / 2))
				return true;
		}

		if (grundflaeche instanceof Kreis) {
			Kreis kreis = (Kreis) grundflaeche;
			if (kreis.getDurchmesser() <= (this.durchmesser / 2))
				return true;
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
