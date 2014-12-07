import java.util.Date;


public class Erkundungsroboter {
	
	private int stunden;
	private Einsatzart art;
	
	public Erkundungsroboter(int stunden, Einsatzart art) {
		this.stunden = stunden;
		this.art = art;
	}
	
	public Erkundungsroboter(Einsatzart art) {
		this.stunden = 0;
		this.art = art;
	}
	
	public void erhoeheStunden() {
		this.stunden++;
	}

	public int getStunden() {
		return this.stunden;
	}

	public Einsatzart getArt() {
		return art;
	}

	public void setArt(Einsatzart art) {
		this.art = art;
	}
}
