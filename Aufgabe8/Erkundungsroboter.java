
@Author(name="Ulrich Aschl")
public class Erkundungsroboter {
	
	private final String name;
	private int stunden;
	private Einsatzart art;
	
	public Erkundungsroboter(String name, int stunden, Einsatzart art) {
		this.name = name;
		this.stunden = stunden;
		this.art = art;
	}
	
	public Erkundungsroboter(String name, Einsatzart art) {
		this.name = name;
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
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.getName() + " - Stunden: " + this.getStunden();
	}
}
