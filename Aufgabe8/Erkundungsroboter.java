import java.util.Date;


public class Erkundungsroboter {
	
	private int stunden;
	
	public Erkundungsroboter(int stunden) {
		this.stunden = stunden;
	}
	
	public Erkundungsroboter() {
		this.stunden = 0;
	}
	
	public void erhoeheStunden() {
		this.stunden++;
	}

	public int getStunden() {
		return this.stunden;
	}
	
}
