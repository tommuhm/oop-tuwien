
public class ModulGas extends Modul {

	// Vorbedingung: Parameter gewicht muss groesser als 0 sein
	public ModulGas(int gewicht) {
		super(gewicht);
	}

	@Override
	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt true zurueck
	public boolean funktioniertFuer(Gasplanet planet) {
		return true;
	}

	@Override
	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt false zurueck
	public boolean funktioniertFuer(HimmelskoerperSchwach planet) {
		return false;
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
		return new ModulGas(this.getGewicht());
	}

	// TODO
	@Override
	public String toString() {
		return "Modul fuer Gasplaneten: " + super.toString();
	}
}
