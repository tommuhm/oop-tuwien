
public class RadRoboter extends Erkundungsroboter{
	private double wegstrecke;

	public RadRoboter(double wegstrecke, int stunden, Einsatzart art) {
		super(stunden, art);
		this.wegstrecke = wegstrecke;
	}
	
	public RadRoboter(Einsatzart art) {
		super(art);
		this.wegstrecke = 0;
	}

	public void erhoeheWegstrecke() {
		this.wegstrecke++;
	}
	
	public double getWegstrecke() {
		return this.wegstrecke;
	}
}
