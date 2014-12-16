import java.util.ArrayList;

public class Geschenkesack {

	private static Geschenkesack instance = null;
	private ArrayList<Schachtel> schachtelList;

	private Geschenkesack() {
		schachtelList = new ArrayList<Schachtel>();
	}

	// singleton
	// Nachbedingung: falls es noch keine instance gab, wird diese hiermit erstellt
	// Nachbedingung: gibt diese instanz zurueck
	// Nachbedingung: versichert, dass es nur genau einen Geschenkesack gibt
	public static Geschenkesack getInstance() {
		if (instance == null) {
			instance = new Geschenkesack();
		}
		return instance;
	}

	// Vorbedingung: schachtel darf nicht null sein
	// Nachbedingung: gibt false zurueck, falls die schachtel noch kein geschenk enthaelt
	// Nachbedingung: gibt true zurueck, falls die schachtel erfolgreich zum sack hinzugefuegt wird
	public boolean addGeschenk(Schachtel schachtel) {
		if (!schachtel.hasGeschenk())
			return false;

		schachtelList.add(schachtel);
		return true;
	}

	// Nachbedingung: gibt das Volumen des Sacks zurueck
	// Invariante: volumen ist groesser gleich 0
	public double volumen() {
		double volumen = 0;
		for (Schachtel schachtel : schachtelList) {
			volumen += schachtel.volumen();
		}
		return volumen;
	}

	// Nachbedingung: gibt alle namen der geschenke des sacks zurueck
	// Invariante: counter ist groesser gleich 0
	public String inhalt() {
		int counter = 0;
		String inhalt = "\n";
		for (Schachtel schachtel : schachtelList) {
			inhalt += schachtel.getName() + "\n";
			counter++;
		}
		return (inhalt + "\nEs sind insgesamt " + counter + " Geschenke im Sack");
	}
}
