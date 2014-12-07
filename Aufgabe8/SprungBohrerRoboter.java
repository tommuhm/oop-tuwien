
public class SprungBohrerRoboter extends Erkundungsroboter{
	private int spruenge;
	private double laenge;
	
	public SprungBohrerRoboter(int spruenge, double laenge, int stunden) {
		super(stunden);
		this.spruenge = spruenge;
		this.laenge = laenge;
	}
	
	public SprungBohrerRoboter() {
		super();
		this.spruenge = 0;
		this.laenge = 0;
	}

	public void erhoeheSpruenge() {
		this.spruenge++;
	}
	
	public int getSpruenge() {
		return this.spruenge;
	}

	public double getPixel() {
		return this.laenge;
	}
}
