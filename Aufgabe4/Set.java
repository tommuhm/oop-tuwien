import java.util.HashSet;

public abstract class Set extends ArtikelKlasse {

	private HashSet<Artikel> artikelListe;

	// Vorbedingung: Name darf nicht NULL sein
	// Nachbedingung: der Zustand des Sets ist verleihbar
	// Nachbedingung: das Set beinhaltet keine Artikel
	public Set(String name) {
		super(name);
		this.artikelListe = new HashSet<Artikel>();
	}

	public HashSet<Artikel> getArtikelSet() {
		return this.artikelListe;
	}

	// Nachbedingung: Artikel wurde dem Set hinzugefuegt.
	public void artikelHinzufuegen(Artikel a) {
		artikelListe.add(a);
	}

	// Vorbedingung: nur aufrufbar wenn Artikel benutzt ist
	public void service() {
		if (zustand() == Zustand.benutzt) {
			//TODO nothing to do in set.
		}
	}

}
