
public class RadBohrerRoboter extends Erkundungsroboter{
	private double wegstrecke;
	private double laenge;
	
	public RadBohrerRoboter(double wegstrecke, double laenge, int stunden) {
		super(stunden);
		this.wegstrecke = wegstrecke;
		this.laenge = laenge;
	}
	
	public RadBohrerRoboter() {
		super();
		this.wegstrecke = 0;
		this.laenge = 0;
	}

	public void erhoeheWegstrecke() {
		this.wegstrecke++;
	}
	
	public double getWegstrecke() {
		return wegstrecke;
	}

	public double getLaenge() {
		return this.laenge;
	}
}
