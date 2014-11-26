
public abstract class ModulFest extends Modul {

	// Vorbedingung: Parameter gewicht muss groesser als 0 sein
	public ModulFest(int gewicht) {
		super(gewicht);
	}

	@Override
	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt false zurueck
	public boolean funktioniertFuer(Gasplanet planet) {
		return false;
	}

}
