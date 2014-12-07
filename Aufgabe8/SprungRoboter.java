
@Author(name="Ulrich Aschl")
public class SprungRoboter extends Erkundungsroboter{
	private int spruenge;
	
	public SprungRoboter(String name, int spruenge, int stunden, Einsatzart art) {
		super(name, stunden, art);
		this.spruenge = spruenge;
	}
	
	public SprungRoboter(String name, Einsatzart art) {
		super(name, art);
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
