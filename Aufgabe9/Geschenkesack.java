import java.math.BigDecimal;
import java.util.ArrayList;

public class Geschenkesack {

	private static Geschenkesack instance = null;
	private ArrayList<Schachtel> schachtelList;

	// Invariante: instance muss eine referenz auf die singleton instanz sein, oder null wenn diese noch nicht existiert

	private Geschenkesack() {
		schachtelList = new ArrayList<Schachtel>();
	}

	// Nachbedingung: falls es noch keine instance gab, wird diese hiermit erstellt
	// Nachbedingung: gibt die singleton instanz zurueck
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

	// Nachbedingung: gibt das Gesamtvolumen aller Geschenke in dem Sack zurueck
	public double volumen() {
		double volumen = 0;
		for (Schachtel schachtel : schachtelList) {
			volumen += schachtel.volumen();
		}
		return new BigDecimal(volumen).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	// Nachbedingung: gibt alle namen der geschenke des sacks aus
	public void inhalt() {
		System.out.println("### Inhalt des Geschenkesacks: ###");
		for (Schachtel schachtel : schachtelList) {
			System.out.println(schachtel.getName());
		}
		System.out.println("### Es sind insgesamt " + schachtelList.size() + " Geschenke im Sack ###");
	}
}
