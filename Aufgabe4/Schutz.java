import java.util.HashSet;

public class Schutz extends ArtikelKlasse implements KategorieSchutz {

	private int anzVerleihbar;

	private HashSet<Artikel> artikelSet;

	public Schutz(String name, int anzVerleihbar) {
		super(name);
		this.artikelSet = null;
		this.anzVerleihbar = anzVerleihbar;
	}

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
		this.artikelSet = artikelSet;
		this.anzVerleihbar = anzVerleihbar;
	}

	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
			super.verleihe(kunde);
			anzVerleihbar--;
		}
	}

	@Override
	public void retour() {
		if (zustand() == Zustand.verliehen) {
			super.retour();
			anzVerleihbar++;
		}
	}

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

	@Override
	public int getAnzVerleihbar() {
		return anzVerleihbar;
	}
}
