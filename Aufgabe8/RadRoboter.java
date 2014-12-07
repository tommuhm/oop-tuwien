
@Author(name="Ulrich Aschl")
public class RadRoboter extends Erkundungsroboter{
	private double wegstrecke;

	public RadRoboter(String name, double wegstrecke, int stunden, Einsatzart art) {
		super(name, stunden, art);
		this.wegstrecke = wegstrecke;
	}
	
	public RadRoboter(String name, Einsatzart art) {
		super(name, art);
		this.wegstrecke = 0;
	}

	public void erhoeheWegstrecke() {
		this.wegstrecke++;
	}
	
	public double getWegstrecke() {
		return this.wegstrecke;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Wegstrecke: " + this.getWegstrecke() + " Einsatzart: " + this.getEinsatzart();
	}
}
