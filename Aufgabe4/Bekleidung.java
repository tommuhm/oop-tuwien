public abstract class Bekleidung extends ArtikelKlasse implements KategorieBekleidung {

	private boolean desinfiziert;

	public Bekleidung(String name) {
		super(name);
		this.desinfiziert = true;
	}

	public void desinfiziere() {
		this.desinfiziert = true;
	}

	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
			super.verleihe(kunde);
			this.desinfiziert = false;
		}
	}

	@Override
	public boolean kontrolle() {
		if (zustand() != Zustand.benutzt)
			return false;

		if (desinfiziert != true)
			return false;

		if (!super.kontrolle())
			return false;

		setZustand(Zustand.verleihbar);
		return true;
	}
}
