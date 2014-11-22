
public class ModulDuesen extends ModulStark {

	public ModulDuesen(int gewicht) {
		super(gewicht);
	}

	@Override
	public boolean funktioniertFuer(Gasplanet planet) {
		return false;
	}

	@Override
	public boolean funktioniertFuer(HimmelskoerperSchwach planet) {
		return true;
	}

	@Override
	public boolean funktioniertFuer(HimmelskoerperStark planet) {
		return true;
	}

}
