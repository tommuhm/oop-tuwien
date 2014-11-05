public class Jacke extends Bekleidung {

	// Vorbedingung: Name darf nicht NULL sein
	// Nachbedingung: der Zustand des Artikels ist verleihbar
	// Nachbedingung: der Artikel ist desinfiziert
	public Jacke(String name) {
		super("Jacke: " + name);
	}

}