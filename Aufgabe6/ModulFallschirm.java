
public class ModulFallschirm extends ModulStark {

	public ModulFallschirm(int gewicht) {
		super(gewicht);
	}

	@Override
	public boolean funktioniertFuer(PlanetGas planet) {
		return false;
	}

	@Override
	public boolean funktioniertFuer(PlanetSchwachGrav planet) {
		return false;
	}

	@Override
	public boolean funktioniertFuer(PlanetStarkGrav planet) {
		if(planet.hasAtmosphaere()) {
			return true;
		}
		else {
			return false;
		}
	}

}
