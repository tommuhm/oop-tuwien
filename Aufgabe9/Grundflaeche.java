
public abstract class Grundflaeche {

	public double flaeche() {
		return flaeche(0);
	}

	public abstract boolean kannBeinhalten(Grundflaeche grundflaeche);

	public abstract boolean passtIn(Quadrat quadrat);

	public abstract boolean passtIn(Rechteck rechteck);

	public abstract boolean passtIn(Kreis kreis);

	public abstract boolean passtIn(Sechseck sechseck);

	public abstract double flaeche(double kartondicke);

}
