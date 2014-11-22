
public class ModulSchwach extends ModulFest {

	public ModulSchwach(int gewicht) {
		super(gewicht);
	}

	@Override
	public boolean funktioniertFuer(PlanetGas planet) {
		return false;
	}

	@Override
	public boolean funktioniertFuer(PlanetSchwachGrav planet) {
		return true;
	}

	@Override
	public boolean funktioniertFuer(PlanetStarkGrav planet) {
		return false;
	}

}
