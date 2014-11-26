
public class ModulFallschirm extends ModulStark {

	// Vorbedingung: Parameter gewicht muss groesser als 0 sein
	public ModulFallschirm(int gewicht) {
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
	// Nachbedingung: gibt false zurueck
	public boolean funktioniertFuer(HimmelskoerperSchwach planet) {
		return false;
	}

	@Override
	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: true wenn planet eine atmosphaere besitzt, sonst false
	public boolean funktioniertFuer(HimmelskoerperStark planet) {
		if (planet.hasAtmosphaere()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	// Nachbedingung: gibt eine Object-Kopie des Moduls zurueck
	public Modul klonen() {
		return new ModulFallschirm(this.getGewicht());
	}

	// Nachbedingung: gibt eine String-Representation der Eigenschaften des Moduls zurueck
	@Override
	public String toString() {
		return "Modul fuer starke Grav. mit Fallschirm: " + super.toString();
	}
}
