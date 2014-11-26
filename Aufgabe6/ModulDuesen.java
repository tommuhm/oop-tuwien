
public class ModulDuesen extends ModulStark {

	// Vorbedingung: Parameter gewicht muss groesser als 0 sein
	public ModulDuesen(int gewicht) {
		super(gewicht);
	}

	@Override
	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt false zurueck
	public boolean funktioniertFuer(HimmelskoerperStark planet) {
		return true;
	}

	// Nachbedingung: gibt eine Object-Kopie des Moduls zurueck
	@Override
	public Modul klonen() {
		return new ModulDuesen(this.getGewicht());
	}

	@Override
	// Nachbedingung: gibt eine String-Representation der Eigenschaften des Moduls zurueck
	public String toString() {
		return "Modul fuer starke Grav. mit Duesen: " + super.toString();
	}
}
