public class Bekleidung extends ArtikelKlasse implements KategorieBekleidung {

	private boolean desinfiziert;

	// Vorbedingung: Name darf nicht NULL sein
	// Nachbedingung: der Zustand des Artikels ist verleihbar
	// Nachbedingung: der Artikel ist desinfiziert
	public Bekleidung(String name) {
		super(name);
		this.desinfiziert = true;
	}

	// Nachbedingung: der Artikel ist definfiziert
	@Override
	public void desinfiziere() {
		this.desinfiziert = true;
	}

	// Vorbedingung: nur aufrufbar wenn Artikel verleihbar ist
	// Vorbedingung: Kunde darf nicht NULL sein.
	// Nachbedingung: Der Zustand des Artikels ist verliehen
	// Nachbedingung: Der Artikel ist nicht mehr desinfiziert
	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
			super.verleihe(kunde);
			this.desinfiziert = false;
		}
	}

	// Vorbedingung: nur aufrufbar wenn Artikel benutzt ist
	// Nachbedingung: Gibt False zureck wenn der Artikel nicht desinfiziert ist, Zustand bleibt unveraendert
	// Nachbedingung: Der Zustand des Artikels ist defekt wenn kontrolle fehlschlaegt - Wahrscheinlichkeit von 1/6
	// Nachbedingung: Der Zustand des Artikels ist verleihbar kontrolle erfolgreich - Wahrscheinlichkeit von 5/6
	// Nachbedingung: Gibt True zurueck die Kontrolle erfolgreich ist und False wenn sie fehlschlaegt
	@Override
	public boolean kontrolle() {
		if (zustand() != Zustand.benutzt)
			return false;

		if (desinfiziert != true)
			return false;

		if (!super.kontrolle())
			return false;

		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", desinfiziert " + desinfiziert;
	}

}
