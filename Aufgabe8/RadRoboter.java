
@Author(name="Ulrich Aschl")
public class RadRoboter extends Erkundungsroboter{
	private double wegstrecke;

	public RadRoboter(Einsatzart art,  int stunden, double wegstrecke) {
		super(art, stunden);
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
	
	@Override
	public String toString() {
		return super.toString() + " Wegstrecke: " + this.getWegstrecke() + " Einsatzart: " + this.getEinsatzart();
	}
}
