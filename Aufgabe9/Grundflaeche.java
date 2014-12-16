
public abstract class Grundflaeche {

	public double flaeche() {
		return flaeche(0);
	}

	public abstract boolean kannBeinhalten(Grundflaeche grundflaeche);

	public abstract double flaeche(double kartondicke);

}
