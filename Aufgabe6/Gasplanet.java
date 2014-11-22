public class Gasplanet extends Himmelskoerper { 

	public Gasplanet(String name) {
		super(name);
	}
	
	public boolean passtModul(Modul modul) {
		return modul.funktioniertFuer(this);
	}
	
	public String toString() {
		return getName();
	}
}