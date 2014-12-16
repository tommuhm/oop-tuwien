
public class Kreis extends Grundflaeche {

	private double durchmesser;

	public Kreis(double durchmesser) {
		this.durchmesser = durchmesser;
	}

	@Override
	public boolean kannBeinhalten(Rechteck rechteck) {
		return false;
	}
	
	public boolean kannBeinhalten(Quadrat quadrat) {
		return false;
	}
	
	public boolean kannBeinhalten(Sechseck sechseck) {
		if (2*sechseck.getSeitenlaenge() <= this.durchmesser) {
			return true;
		}
		return false;
	}
	
	public boolean kannBeinhalten(Kreis kreis) {
		if (this.durchmesser >= kreis.getDurchmesser()) {
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
