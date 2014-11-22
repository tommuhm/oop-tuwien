public class HimmelskoerperSchwach extends Himmelskoerper {
	
	public HimmelskoerperSchwach(String name) {
		super(name);
	}
	
	public boolean passtModul(Modul modul) {
		return modul.funktioniertFuer(this);
	}
	
	public String toString() {
		return getName();
	}
}