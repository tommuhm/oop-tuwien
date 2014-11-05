import java.util.HashSet;

public class Schutz extends ArtikelKlasse implements KategorieSchutz {

	private int anzVerleihbar;
	private boolean isSet;

	private HashSet<Artikel> artikelSet;

	// Vorbedingung: Name darf nicht NULL sein
	// Vorbedingung: anzVerleihbar muss groeßer als 0 sein
	// Nachbedingung: der Zustand des Artikels ist verleihbar
	public Schutz(String name, int anzVerleihbar) {
		super(name);
		this.isSet = false;
		this.artikelSet = null;
		this.anzVerleihbar = anzVerleihbar;
	}

	// Vorbedingung: Name darf nicht NULL sein
	// Vorbedingung: artikelSet darf nicht NULL sein
	// Vorbedingung: artikelSet muss mindestens einen Artikel aus der Kategory Schutz enhalten
	// Nachbedingung: der Zustand des Artikels ist verleihbar
	// Nachbedingung: Die Anzahl der Verleihungen des Sets wird vom Artikel mit der kleinsten Anzahl an moeglichen Verleihungen verwendet
	public Schutz(String name, HashSet<Artikel> artikelSet) {
		super(name);
		boolean hatSchutzArtikel = false;
		int anzVerleihbar = Integer.MAX_VALUE;
		for (Artikel artikel : artikelSet) {
			if (artikel instanceof KategorieSchutz) {
				hatSchutzArtikel = true;
				KategorieSchutz schutzArtikle = (KategorieSchutz) artikel;
				if (anzVerleihbar > schutzArtikle.getAnzVerleihbar()) {
					anzVerleihbar = schutzArtikle.getAnzVerleihbar();
				}
			}
		}
		assert hatSchutzArtikel;
		this.isSet = true;
		this.artikelSet = artikelSet;
		this.anzVerleihbar = anzVerleihbar;
	}

	// Vorbedingung: nur aufrufbar wenn Artikel verleihbar ist
	// Vorbedingung: Kunde darf nicht NULL sein.
	// Nachbedingung: Der Zustand des Artikels ist verliehen
	// Nachbedingung: die Anzahl der moeglichen Verleihungen wird um eins verringert.
	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
			super.verleihe(kunde);
			anzVerleihbar--;
		}
	}

	// Vorbedingung: nur aufrufbar wenn Artikel benutzt ist
	// Vorbedingung: die Anzahl an moeglichen Verleichungen muss groeser als 0 sein
	// Nachbedingung: Der Zustand des Artikels ist defekt wenn kontrolle fehlschlaegt - Wahrscheinlichkeit von 1/6
	// Nachbedingung: Der Zustand des Artikels ist verleihbar kontrolle erfolgreich - Wahrscheinlichkeit von 5/6
	// Nachbedingung: Gibt True zurueck die Kontrolle erfolgreich ist und False wenn sie fehlschlaegt
	@Override
	public boolean kontrolle() {
		if (zustand() != Zustand.benutzt)
			return false;

		if (anzVerleihbar <= 0)
			return false;

		if (!super.kontrolle())
			return false;

		return true;
	}

	public HashSet<Artikel> getArtikelSet() {
		return artikelSet;
	}

	// Nachbedinung: Gibt zuereck wie oft der Artikel noch verliehen werden kann
	@Override
	public int getAnzVerleihbar() {
		return anzVerleihbar;
	}

	public boolean istSchutzSet() {
		return isSet;
	}
}
