
public class Quadrat extends Grundflaeche {

	private double seitenlaenge;

	public Quadrat(double seitenlaenge) {
		this.seitenlaenge = seitenlaenge;
	}

	@Override
	public double flaeche(double kartondicke) {
		return Math.pow(seitenlaenge + 2 * kartondicke, 2);
	}

	@Override
	public boolean kannBeinhalten(Grundflaeche grundflaeche) {
		return grundflaeche.passtIn(this);
	}

	@Override
	public boolean passtIn(Sechseck sechseck) {
		return false;
	}

	@Override
	public boolean passtIn(Rechteck rechteck) {
		return false;
	}

	@Override
	public boolean passtIn(Kreis kreis) {
		if (this.getSeitenlaenge() >= kreis.getDurchmesser()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean passtIn(Quadrat quadrat) {
		if (this.getSeitenlaenge() >= quadrat.getSeitenlaenge()) {
			return true;
		}
		return false;
	}

	public double getSeitenlaenge() {
		return seitenlaenge;
	}
}
