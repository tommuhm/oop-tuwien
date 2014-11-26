
public abstract class ModulStark extends ModulFest {

	// Vorbedingung: Parameter gewicht muss groesser als 0 sein
	public ModulStark(int gewicht) {
		super(gewicht);
	}

	@Override
	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt true zurueck
	public boolean funktioniertFuer(HimmelskoerperSchwach planet) {
		return true;
	}

}
