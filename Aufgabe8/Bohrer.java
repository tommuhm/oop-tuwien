
@Author(name="Ulrich Aschl")
public class Bohrer implements Einsatzart {
	private double laenge;
	
	public Bohrer(double laenge) {
		this.laenge = laenge;
	}
	
	public double getWert() {
		return this.laenge;
	}
}
