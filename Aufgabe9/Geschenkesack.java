import java.util.ArrayList;

public class Geschenkesack {

	private static Geschenkesack instance = null;
	private ArrayList<Schachtel> schachtelList;

	private Geschenkesack() {
		schachtelList = new ArrayList<Schachtel>();
	}

	public static Geschenkesack getInstance() {
		if (instance == null) {
			instance = new Geschenkesack();
		}
		return instance;
	}

	//Vorbedingung: schachtel darf nicht null sein
	//Nachbedingung: gibt false zurueck, falls die schachtel schon noch kein geschenk enthaelt
	//Nachbedingung: gibt true zurueck, falls die schachtel erfolgreich zum sack hinzugefuegt wird
	public boolean addGeschenk(Schachtel schachtel) {
		if (!schachtel.hasGeschenk())
			return false;

		schachtelList.add(schachtel);
		return true;
	}

	//Nachbedingung: gibt das volumen des Sacks zurueck
	public double volumen() {
		double volumen = 0;
		for (Schachtel schachtel : schachtelList) {
			volumen += schachtel.volumen();
		}
		return volumen;
	}

	//Nachbedingung: gibt alle namen der geschenke des sacks zurueck
	public String inhalt() {
		String inhalt = "\n##########\nGeschenke im Sack:\n";
		for (Schachtel schachtel : schachtelList) {
			inhalt += schachtel.getName() + "\n";
		}
		return inhalt;
	}
}
