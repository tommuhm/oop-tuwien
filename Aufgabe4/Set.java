import java.util.ArrayList;

public abstract class Set extends ArtikelKlasse {

	private ArrayList<Artikel> artikelListe;

	public Set() {
		super();
		this.artikelListe = new ArrayList<Artikel>();
	}

	public ArrayList<Artikel> getArtikelSet() {
		return this.artikelListe;
	}

	public void artikelHinzufuegen(Artikel a) {
		artikelListe.add(a);
	}


}
