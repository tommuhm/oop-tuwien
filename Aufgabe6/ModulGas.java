
public class ModulGas extends Modul {

	//Vorbedingung: Parameter gewicht muss über 0 sein
	public ModulGas(int gewicht) {
		super(gewicht);
	}

	@Override
	//Vorbedingung: planet darf nicht null sein
	//Nachbedingung: überprüft ob ob das Modul für einen Gasplaneten funktioniert
	public boolean funktioniertFuer(Gasplanet planet) {
		return true;
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
		return false;
	}
	
	@Override
	//Nachbedingung: result muss eine Kopie von Modul sein.
	public Modul clone() {
		return new ModulGas(this.getGewicht());
	}

	@Override
	public String toString() {
		return "Modul für Gasplaneten: " + this.getGewicht() + " kg";
	}
}
