
public class Quadrat extends Grundflaeche {

	private double seitenlaenge;

	public Quadrat(double seitenlaenge) {
		this.seitenlaenge = seitenlaenge;
	}

	@Override
	public double flaeche(double kartondicke) {
		return Math.pow(seitenlaenge + 2 * kartondicke, 2);
	}
	
	//Quadrat kann haben: Kreis, Quadrat, 
	public boolean kannBeinhalten(Grundflaeche g) {
		if(g instanceof Sechseck || g instanceof Rechteck) {
			return false;
		}
		
		if(g instanceof Kreis) {
			Kreis k = (Kreis) g;
			
		}
		if(g instanceof Quadrat && this.getSeitenlaenge() > ((Quadrat) g).getSeitenlaenge()) {
			return true;
		}
		
		return false;
	}

	public double getSeitenlaenge() {
		return seitenlaenge;
	}
}
