
public class Sechseck extends Grundflaeche {

	private double seitenlaenge;

	public Sechseck(double seitenlaenge) {
		this.seitenlaenge = seitenlaenge;
	}

	@Override
	public boolean kannBeinhalten(Grundflaeche grundflaeche) {
		if (grundflaeche instanceof Rechteck || grundflaeche instanceof Quadrat)
			return false;

		if (grundflaeche instanceof Sechseck) {
			Sechseck sechseck = (Sechseck) grundflaeche;
			if (sechseck.getSeitenlaenge() <= (this.seitenlaenge / 2))
				return true;
		}

		if (grundflaeche instanceof Kreis ) {
			Kreis kreis = (Kreis) grundflaeche;
			if (kreis.getDurchmesser() <= (this.seitenlaenge / 2))
				return true;
		}

		return false;
	}

	@Override
	public double flaeche(double kartondicke) {
		return 3 / 2 * Math.pow(seitenlaenge + kartondicke, 2) * Math.sqrt(3);
	}

	public double getSeitenlaenge() {
		return seitenlaenge;
	}
}
