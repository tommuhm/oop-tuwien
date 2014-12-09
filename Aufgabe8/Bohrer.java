
@Author(name="Ulrich Aschl")
public class Bohrer implements Einsatzart {
	private double laenge;
	
	public Bohrer(double laenge) {
		this.laenge = laenge;
	}
	
	public double getLaenge() {
		return this.laenge;
	}
	
	@Override
	public String toString() {
		return "Bohrer: " + this.laenge + " cm";
	}
}