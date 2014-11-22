
public class ModulDuesen extends ModulStark {

	//Vorbedingung: Parameter gewicht muss über 0 sein
	public ModulDuesen(int gewicht) {
		super(gewicht);
	}

	@Override
	//Vorbedingung: planet darf nicht null sein
	//Nachbedingung: überprüft ob ob das Modul für einen Gasplaneten funktioniert
	public boolean funktioniertFuer(Gasplanet planet) {
		return false;
	}

	@Override
	//Vorbedingung: planet darf nicht null sein
	//Nachbedingung: überprüft ob ob das Modul für einen HimmelskoerperSchwach funktioniert
	public boolean funktioniertFuer(HimmelskoerperSchwach planet) {
		return true;
	}

	@Override
	//Vorbedingung: planet darf nicht null sein
	//Nachbedingung: überprüft ob ob das Modul für einen HimmelskoerperStark funktioniert
	public boolean funktioniertFuer(HimmelskoerperStark planet) {
		return true;
	}

	@Override
	//Nachbedingung: result muss eine Kopie von Modul sein.
	public Modul clone() {
		return new ModulDuesen(this.getGewicht());
	}

	@Override
	public String toString() {
		return "Modul für starke Grav. mit Düsen: " + this.getGewicht() + " kg";
	}
}
