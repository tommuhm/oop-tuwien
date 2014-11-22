public class HimmelskoerperStark extends HimmelskoerperSchwach {

	private boolean atmosphaere;
	
	public HimmelskoerperStark(String name, boolean atmosphaere) {
		super(name);
		this.atmosphaere = atmosphaere;
	}
	
	public boolean hasAtmosphaere() {
		return atmosphaere;
	}	
	
	public boolean passtModul(Modul modul) {
		return modul.funktioniertFuer(this);
	}
}
