public class Bekleidung extends ArtikelKlasse implements KategorieBekleidung {

	private boolean desinfiziert;

	// Vorbedingung: Name darf nicht NULL sein
	// Nachbedingung: der Zustand des erzeugten Objektes ist verleihbar
	// Nachbedingung: das erzeugten Objekt ist desinfiziert
	public Bekleidung(String name) {
		super(name);
		this.desinfiziert = true;
	}

	// Nachbedingung: das Objekt ist definfiziert
	@Override
	public void desinfiziere() {
		this.desinfiziert = true;
	}

	// Vorbedingung: nur aufrufbar wenn Artikel verleihbar ist
	// Vorbedingung: Kunde darf nicht NULL sein.
	// Nachbedingung: Der Zustand des Objektes ist verliehen
	// Nachbedingung: Das Objekt ist nicht mehr desinfiziert
	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
			super.verleihe(kunde);
			this.desinfiziert = false;
		}
	}

	// Vorbedingung: nur aufrufbar wenn Artikel benutzt ist
	// Nachbedingung: Gibt False zureck wenn Objekt nicht desinfiziert ist, Zustand bleibt unveraendert
	// Nachbedingung: Der Zustand des Objektes ist defekt wenn kontrolle fehlschlaegt - Wahrscheinlichkeit von 1/6
	// Nachbedingung: Der Zustand des Objektes ist verleihbar kontrolle erfolgreich - Wahrscheinlichkeit von 5/6
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

}
