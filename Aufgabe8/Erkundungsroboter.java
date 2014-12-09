
@Author(name="Ulrich Aschl")
public abstract class Erkundungsroboter {

	private static int maxNummer = 0;
	
	private final int nummer;
	private int stunden;
	private Einsatzart art;
	
	public Erkundungsroboter(Einsatzart art, int stunden) {
		this(art);
		this.stunden = stunden;
	}
	
	public Erkundungsroboter(Einsatzart art) {
		this.nummer = maxNummer++;
		
		this.stunden = 0;
		this.art = art;
	}
	
	public void erhoeheStunden() {
		this.stunden++;
	}

	public int getStunden() {
		return this.stunden;
	}

	public Einsatzart getEinsatzart() {
		return art;
	}

	public void setEinsatzart(Einsatzart art) {
		this.art = art;
	}
	
	public int getNummer() {
		return this.nummer;
	}

	@Override
	public String toString() {
		return "Roboter #" + this.getNummer() + " - Stunden: " + this.getStunden();
	}
}
