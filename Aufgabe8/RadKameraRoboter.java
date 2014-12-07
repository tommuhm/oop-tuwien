
public class RadKameraRoboter extends Erkundungsroboter{
	private double wegstrecke;
	private int pixel;
	
	public RadKameraRoboter(double wegstrecke, int pixel, int stunden) {
		super(stunden);
		this.wegstrecke = wegstrecke;
		this.pixel = pixel;
	}
	
	public RadKameraRoboter() {
		super();
		this.wegstrecke = 0;
		this.pixel = 0;
	}

	public void erhoeheWegstrecke() {
		this.wegstrecke++;
	}
	
	public double getWegstrecke() {
		return wegstrecke;
	}

	public int getPixel() {
		return pixel;
	}
}
