public class HimmelskoerperStarkGrav extends HimmelskoerperFest {

	private boolean atmosphaere;
	
	public HimmelskoerperStarkGrav(String name, boolean atmosphaere) {
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
