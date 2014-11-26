
public class ModulSchwach extends ModulFest {

	// Vorbedingung: Parameter gewicht muss groesser als 0 sein
	public ModulSchwach(int gewicht) {
		super(gewicht);
	}

	@Override
	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt false zurueck
	public boolean funktioniertFuer(Gasplanet planet) {
		return false;
	}

	@Override
	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt true zurueck
	public boolean funktioniertFuer(HimmelskoerperSchwach planet) {
		return true;
	}

	@Override
	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt false zurueck
	public boolean funktioniertFuer(HimmelskoerperStark planet) {
		return false;
	}

	@Override
	// Nachbedingung: gibt eine Object-Kopie des Moduls zurueck
	public Modul klonen() {
		return new ModulSchwach(this.getGewicht());
	}

	@Override
	// Nachbedingung: gibt eine String-Representation der Eigenschaften des Moduls zurueck
	public String toString() {
		return "Modul fuer schwache Gravitation: " + super.toString();
	}
}
