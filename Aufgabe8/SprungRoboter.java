
public class SprungRoboter extends Erkundungsroboter{
	private int spruenge;
	
	public SprungRoboter(int spruenge, int stunden, Einsatzart art) {
		super(stunden, art);
		this.spruenge = spruenge;
	}
	
	public SprungRoboter(Einsatzart art) {
		super(art);
		this.spruenge = 0;
	}

	public void erhoeheSpruenge() {
		this.spruenge++;
	}
	
	public int getSpruenge() {
		return this.spruenge;
	}
}
