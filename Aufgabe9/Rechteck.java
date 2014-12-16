
public class Rechteck extends Grundflaeche {

	private double laenge;
	private double breite;
	
	//invariante für laenge > breite setzen!

	public Rechteck(double laenge, double breite) {
		this.laenge = laenge;
		this.breite = breite;
	}

	@Override
	public boolean kannBeinhalten(Grundflaeche g) {
		if(g instanceof Kreis || g instanceof Quadrat) {
			return false;
		}
		
		if(g instanceof Sechseck && this.getLaenge() > 2*((Sechseck) g).getSeitenlaenge() && this.getBreite() > 2*((Sechseck) g).getSeitenlaenge()) {
			double radius = ((Sechseck) g).getSeitenlaenge();
			double inkreis = radius * Math.sqrt(3) / 2;

			if(this.getLaenge() >= 2*radius && this.getBreite() >= 2*inkreis) {
				return true;
			}
		}
		
		if(g instanceof Rechteck) {
			double gLaenge = ((Rechteck) g).getLaenge();
			double gBreite = ((Rechteck) g).getBreite();
			
			if(this.getLaenge() >= gLaenge && this.getBreite() >= gBreite) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public double flaeche(double kartondicke) {
		return (laenge + 2 * kartondicke) * (breite + 2 * kartondicke);
	}

	public double getLaenge() {
		return laenge;
	}

	public double getBreite() {
		return breite;
	}
}
