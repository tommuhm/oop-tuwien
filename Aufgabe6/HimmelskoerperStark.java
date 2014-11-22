public class HimmelskoerperStark extends HimmelskoerperSchwach {

	private boolean atmosphaere;
	
	//Vorbedingung: name darf nicht null sein
	public HimmelskoerperStark(String name, boolean atmosphaere) {
		super(name);
		this.atmosphaere = atmosphaere;
	}
	
	//Nachbedingung: true, wenn der Himmelskoerper eine Atmosphaere hat
	public boolean hasAtmosphaere() {
		return atmosphaere;
	}	
	
}
