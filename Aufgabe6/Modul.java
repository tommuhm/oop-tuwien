
public abstract class Modul {

	// Invariante: gewicht darf nicht unter 0 fallen
	private int gewicht;

	// Vorbedingung: Parameter gewicht muss groesser als 0 sein
	public Modul(int gewicht) {
		this.gewicht = gewicht;
	}

	// Nachbedingung: gibt gewicht zurueckgeben
	public int getGewicht() {
		return gewicht;
	}

	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt true zurueck, wenn das Modul fuer Gasplaneten funktioniert
	abstract public boolean funktioniertFuer(Gasplanet planet);

	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt true zurueck, wenn das Modul fuer einen HimmelskoerperSchwach funktioniert
	abstract public boolean funktioniertFuer(HimmelskoerperSchwach planet);

	// Vorbedingung: planet darf nicht null sein
	// Nachbedingung: gibt true zurueck, wenn das Modul fuer einen HimmelskoerperStark funktioniert
	abstract public boolean funktioniertFuer(HimmelskoerperStark planet);

	// Nachbedingung: gibt eine Object-Kopie des Moduls zurueck
	public abstract Modul klonen();

	// TODO
	@Override
	public String toString() {
		return gewicht + " kg";
	}
}
