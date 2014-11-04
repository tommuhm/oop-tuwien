import java.util.HashSet;

public class Schutz extends ArtikelKlasse implements KategorieSchutz {

	private int anzVerleihbar;

	private boolean hasSet;
	private HashSet<Artikel> articleSet;

	public Schutz(String name, int anzVerleihbar) {
		super(name);
		this.articleSet = null;
		this.anzVerleihbar = anzVerleihbar;
	}

	public Schutz(String name, HashSet<Artikel> articleSet, int anzVerleihbar) {
		super(name);
		boolean hasSchutzArticle = false;
		for (Artikel artikel : articleSet) {
			if (artikel instanceof KategorieSchutz) {
				hasSchutzArticle = true;
			}
		}
		assert hasSchutzArticle;
		this.articleSet = articleSet;
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

		setZustand(Zustand.verleihbar);
		return true;
	}
	
	public HashSet<Artikel> getArticleSet() {
		return articleSet;
	}
}