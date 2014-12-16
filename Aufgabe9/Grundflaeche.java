
public abstract class Grundflaeche {

	public double flaeche() {
		return flaeche(0);
	}

	public abstract boolean kannBeinhalten(Quadrat quadrat);
	
	public abstract boolean kannBeinhalten(Rechteck rechteck);
	
	public abstract boolean kannBeinhalten(Kreis kreis);
	
	public abstract boolean kannBeinhalten(Sechseck sechseck);

	public abstract double flaeche(double kartondicke);

}
