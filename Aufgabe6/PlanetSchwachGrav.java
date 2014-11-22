public class PlanetSchwachGrav extends PlanetFest {
	
	public PlanetSchwachGrav(String name) {
		super(name);
	}
	
	public boolean passtModul(Modul modul) {
		return modul.funktioniertFuer(this);
	}

	
}
