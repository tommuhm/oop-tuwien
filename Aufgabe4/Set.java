import java.util.HashSet;

public abstract class Set extends ArtikelKlasse {

	private HashSet<Artikel> artikelListe;

	public Set(String name) {
		super(name);
		this.artikelListe = new HashSet<Artikel>();
	}

	public HashSet<Artikel> getArtikelSet() {
		return this.artikelListe;
	}

	public void artikelHinzufuegen(Artikel a) {
		artikelListe.add(a);
	}

	public void service() {
		if (zustand() == Zustand.benutzt) {
			//TODO nothing to do in set.
		}
	}

}
