public abstract class ArtikelKlasse implements Artikel {

	private Zustand zustand;
	private String kunde;
	private String name;

	// Vorbedingung: Name darf nicht NULL sein
	// Nachbedingung: der Zustand des erzeugten Artikels ist verleihbar
	public ArtikelKlasse(String name) {
		this.zustand = Zustand.verleihbar;
		this.name = name;
	}

	@Override
	public Zustand zustand() {
		return this.zustand;
	}

	@Override
	public String kunde() {
		return this.kunde;
	}

	// Vorbedingung: nur aufrufbar wenn Artikel verleihbar ist
	// Vorbedingung: Kunde darf nicht NULL sein.
	// Nachbedingung: Der Zustand des Artikels ist verliehen
	@Override
	public void verleihe(String kunde) {
		if (this.zustand == Zustand.verleihbar) {
			this.zustand = Zustand.verliehen;
			this.kunde = kunde;
		}
	}

	// Vorbedingung: nur aufrufbar wenn Artikel verliehen ist
	// Nachbedingung: Der Zustand des Artikels ist benutzt
	@Override
	public void retour() {
		if (zustand() == Zustand.verliehen) {
			this.zustand = Zustand.benutzt;
		}
	}

	// Vorbedingung: nur aufrufbar wenn Artikel benutzt ist
	// Nachbedingung: Der Zustand des Artikels ist defekt wenn kontrolle fehlschlaegt - Wahrscheinlichkeit von 1/6
	// Nachbedingung: Der Zustand des Artikels ist verleihbar kontrolle erfolgreich - Wahrscheinlichkeit von 5/6
	// Nachbedingung: Gibt True zurueck die Kontrolle erfolgreich ist und False wenn sie fehlschlaegt
	@Override
	public boolean kontrolle() {
		if (zustand() == Zustand.benutzt) {
			// Prüfen. Artikel fällt 1:6 weg.
			if (Math.random() > (1 / 6)) {
				this.zustand = Zustand.verleihbar;
				return true;
			} else {
				this.zustand = Zustand.defekt;
				return false;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return this.name + " Zustand: " + this.zustand + " Kunde: " + this.kunde;
	}
}
