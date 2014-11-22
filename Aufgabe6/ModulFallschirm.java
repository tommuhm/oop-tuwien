
public class ModulFallschirm extends ModulStark {

	//Vorbedingung: Parameter gewicht muss über 0 sein
	public ModulFallschirm(int gewicht) {
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
		return false;
	}

	@Override
	//Vorbedingung: planet darf nicht null sein
	//Nachbedingung: überprüft ob ob das Modul für einen HimmelskoerperStark funktioniert
	public boolean funktioniertFuer(HimmelskoerperStark planet) {
		if(planet.hasAtmosphaere()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	//Nachbedingung: result muss eine Kopie von Modul sein.
	public Modul clone() {
		return new ModulFallschirm(this.getGewicht());
	}

	@Override
	public String toString() {
		return "Modul für starke Grav. mit Fallschirm: " + this.getGewicht() + " kg";
	}
}
