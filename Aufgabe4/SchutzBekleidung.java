public class SchutzBekleidung extends ArtikelKlasse implements KategorieSchutz, KategorieBekleidung {

	private boolean desinfiziert;
	private int anzVerleihbar;

	// Vorbedingung: Name darf nicht NULL sein
	// Vorbedingung: anzVerleihbar muss groeßer als 0 sein
	// Nachbedingung: der Zustand des Artikels ist verleihbar
	// Nachbedingung: der Artikel ist desinfiziert
	public SchutzBekleidung(String name, int anzVerleihbar) {
		super(name);
		this.anzVerleihbar = anzVerleihbar;
		this.desinfiziert = true;
	}

	// Nachbedingung: der Artikel ist definfiziert
	@Override
	public void desinfiziere() {
		desinfiziert = true;
	}

	// Vorbedingung: nur aufrufbar wenn Artikel verleihbar ist
	// Vorbedingung: Kunde darf nicht NULL sein.
	// Nachbedingung: Der Zustand des Artikels ist verliehen
	// Nachbedingung: die Anzahl der moeglichen Verleihungen wird um eins verringert.
	// Nachbedingung: Der Artikel ist nicht mehr desinfiziert
	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
			super.verleihe(kunde);
			anzVerleihbar--;
			this.desinfiziert = false;
		}
	}

	// Vorbedingung: nur aufrufbar wenn Artikel benutzt ist
	// Vorbedingung: die Anzahl an moeglichen Verleichungen muss groeser als 0 sein
	// Vorbedingung: Gibt False zureck wenn der Artikel nicht desinfiziert ist, Zustand bleibt unveraendert
	// Nachbedingung: Der Zustand des Artikels ist defekt wenn kontrolle fehlschlaegt - Wahrscheinlichkeit von 1/6
	// Nachbedingung: Der Zustand des Artikels ist verleihbar kontrolle erfolgreich - Wahrscheinlichkeit von 5/6
	// Nachbedingung: Gibt True zurueck die Kontrolle erfolgreich ist und False wenn sie fehlschlaegt
	@Override
	public boolean kontrolle() {
		if (zustand() != Zustand.benutzt)
			return false;

		if (anzVerleihbar <= 0)
			return false;

		if (desinfiziert != true)
			return false;

		if (!super.kontrolle())
			return false;

		return true;
	}

	// Nachbedinung: Gibt zuereck wie oft der Artikel noch verliehen werden kann
	@Override
	public int getAnzVerleihbar() {
		return anzVerleihbar;
	}

	@Override
	public String toString() {
		return super.toString() + ", moegliche Verleihungen: " + anzVerleihbar + ", desinfiziert " + desinfiziert;
	}
}
