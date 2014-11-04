public class SchutzBekleidung extends ArtikelKlasse implements KategorieSchutz, KategorieBekleidung {

	private boolean desinfiziert;
	private int anzVerleihbar;

	public SchutzBekleidung(String name, int anzVerleihbar) {
		super(name);
		this.anzVerleihbar = anzVerleihbar;
		this.desinfiziert = true;
	}

	@Override
	public void desinfiziere() {
		desinfiziert = true;
	}

	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
			super.verleihe(kunde);
			anzVerleihbar--;
			this.desinfiziert = false;
		}
	}

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

	@Override
	public int getAnzVerleihbar() {
		return anzVerleihbar;
	}
}
