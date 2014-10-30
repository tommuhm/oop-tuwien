public abstract class Schutz extends Set implements KategorieSchutz {

	private int anzVerleihbar;

	public Schutz(int anzVerleihbar) {
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

}
