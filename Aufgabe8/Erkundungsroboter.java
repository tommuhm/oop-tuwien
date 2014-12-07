import java.util.Date;



@Author(name="Ulrich Aschl")
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

	public Einsatzart getEinsatzart() {
		return art;
	}

	public void setEinsatzart(Einsatzart art) {
		this.art = art;
	}
}
