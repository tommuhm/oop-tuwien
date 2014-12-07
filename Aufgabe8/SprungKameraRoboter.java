
public class SprungKameraRoboter extends Erkundungsroboter{
	private int spruenge;
	private int pixel;
	
	public SprungKameraRoboter(int spruenge, int pixel, int stunden) {
		super(stunden);
		this.spruenge = spruenge;
		this.pixel = pixel;
	}
	
	public SprungKameraRoboter() {
		super();
		this.spruenge = 0;
		this.pixel = 0;
	}

	public void erhoeheSpruenge() {
		this.spruenge++;
	}
	
	public int getSpruenge() {
		return this.spruenge;
	}

	public int getPixel() {
		return this.pixel;
	}
}
