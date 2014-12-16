
public class Sechseck extends Grundflaeche {

	private double seitenlaenge;

	public Sechseck(double seitenlaenge) {
		this.seitenlaenge = seitenlaenge;
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
		return false;
	}

	@Override
	public boolean passtIn(Kreis kreis) {
		if ((this.seitenlaenge * 2) >= kreis.getDurchmesser())
			return true;
		return false;
	}

	@Override
	public boolean passtIn(Sechseck sechseck) {
		if (this.seitenlaenge >= sechseck.getSeitenlaenge())
			return true;
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
