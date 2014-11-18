
public class Skier extends Person {

	private double gewicht;

	public Skier(String name, double gewicht) {
		super(name);
		this.gewicht = gewicht;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Skier) {
			return super.equals(o) && ((Skier) o).gewicht == this.gewicht;
		}

		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " Gewicht: " + gewicht;
	}

}
