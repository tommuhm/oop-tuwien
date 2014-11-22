public class HimmelskoerperStark extends HimmelskoerperSchwach {

	private boolean atmosphaere;
	
	//Vorbedingung: name darf nicht null sein
	public HimmelskoerperStark(String name, boolean atmosphaere) {
		super(name);
		this.atmosphaere = atmosphaere;
	}
	
	public boolean hasAtmosphaere() {
		return atmosphaere;
	}	
	
}
