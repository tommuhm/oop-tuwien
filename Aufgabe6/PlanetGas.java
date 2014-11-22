public class PlanetGas extends Himmelskoerper { 

	public PlanetGas(String name) {
		super(name);
	}
	
	public boolean passtModul(Modul modul) {
		return modul.funktioniertFuer(this);
	}
	
}