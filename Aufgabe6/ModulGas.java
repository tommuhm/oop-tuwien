
public class ModulGas extends Modul {

	public ModulGas(int gewicht) {
		super(gewicht);
	}

	@Override
	public boolean funktioniertFuer(PlanetGas planet) {
		return true;
	}
	
	@Override
	public boolean funktioniertFuer(PlanetSchwachGrav planet) {
		return false;
	}
	
	@Override
	public boolean funktioniertFuer(PlanetStarkGrav planet) {
		return false;
	}

}
