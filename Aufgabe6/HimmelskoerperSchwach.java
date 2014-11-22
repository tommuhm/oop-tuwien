public class HimmelskoerperSchwach extends Himmelskoerper {
	
	//Vorbedingung: name darf nicht null sein
	public HimmelskoerperSchwach(String name) {
		super(name);
	}
	
	//Vorbedingung: modul darf nicht null sein
	public boolean passtModul(Modul modul) {
		return modul.funktioniertFuer(this);
	}
	
	public String toString() {
		return getName();
	}
}