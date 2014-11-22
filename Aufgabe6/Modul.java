
public abstract class Modul {
	
	//Invariante: gewicht darf nicht unter 0 fallen
	private int gewicht;
	
	//Vorbedingung: Parameter gewicht muss über 0 sein
	public Modul(int gewicht) {
		this.gewicht = gewicht;		
	}

	//Nachbedingung: Muss gewicht zurückgeben
	public int getGewicht() {
		return gewicht;
	}
	
	//Nachbedingung: result muss eine Kopie von Modul sein.
	public abstract Modul clone();

	//Vorbedingung: planet darf nicht null sein
	//Nachbedingung: überprüft ob ob das Modul für einen Gasplaneten funktioniert
	abstract public boolean funktioniertFuer(Gasplanet planet);

	//Vorbedingung: planet darf nicht null sein
	//Nachbedingung: überprüft ob ob das Modul für einen HimmelskoerperSchwach funktioniert
	abstract public boolean funktioniertFuer(HimmelskoerperSchwach planet);

	//Vorbedingung: planet darf nicht null sein
	//Nachbedingung: überprüft ob ob das Modul für einen HimmelskoerperStark funktioniert
	abstract public boolean funktioniertFuer(HimmelskoerperStark planet);
	
	public abstract String toString();
}
