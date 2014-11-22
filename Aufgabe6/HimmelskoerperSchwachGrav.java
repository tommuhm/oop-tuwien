public class HimmelskoerperSchwachGrav extends HimmelskoerperFest {
	
	public HimmelskoerperSchwachGrav(String name) {
		super(name);
	}
	
	public boolean passtModul(Modul modul) {
		return modul.funktioniertFuer(this);
	}
}