
@Author(name="Ulrich Aschl")
public class SprungRoboter extends Erkundungsroboter{
	private int spruenge;
	
	public SprungRoboter(Einsatzart art, int stunden, int spruenge) {
		super(art, stunden);
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
	
	@Override
	public String toString() {
		return super.toString() + " Spruenge: " + this.getSpruenge() + " Einsatzart: " + this.getEinsatzart();
	}
}
