import java.util.HashSet;

public abstract class Set extends ArtikelKlasse {

	private HashSet<Artikel> artikelListe;

	//Vorbedingungen: name darf nicht NULL sein.
	public Set(String name) {
		super(name);
		this.artikelListe = new HashSet<Artikel>();
	}

	public HashSet<Artikel> getArtikelSet() {
		return this.artikelListe;
	}
	//Vorbedingung: Artikel a wird zum HashSet hinzugefuegt.
	public void artikelHinzufuegen(Artikel a) {
		artikelListe.add(a);
	}

	//NOTE: Service wird ausgefuehrt
	public void service() {
		if (zustand() == Zustand.benutzt) {
			//TODO nothing to do in set.
		}
	}

}
