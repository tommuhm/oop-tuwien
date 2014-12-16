
public class Quadrat extends Grundflaeche {

	private double seitenlaenge;

	public Quadrat(double seitenlaenge) {
		this.seitenlaenge = seitenlaenge;
	}

	@Override
	public double flaeche(double kartondicke) {
		return Math.pow(seitenlaenge + 2 * kartondicke, 2);
	}
	
	
	public boolean kannBeinhalten(Sechseck sechseck) {
		return false;		
	}
	
	public boolean kannBeinhalten(Rechteck rechteck) {
		return false;
	}
	
	public boolean kannBeinhalten(Kreis kreis) {
		if(this.getSeitenlaenge() >= kreis.getDurchmesser()) {
			return true;		
		}
		return false;
	}

	public boolean kannBeinhalten(Quadrat quadrat) {
		if(this.getSeitenlaenge() >= quadrat.getSeitenlaenge()) {
			return true;
		}
		return false;
	}

	public double getSeitenlaenge() {
		return seitenlaenge;
	}
}
