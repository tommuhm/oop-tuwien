public class SchutzBekleidung extends ArtikelKlasse implements KategorieSchutz, KategorieBekleidung {

	private boolean desinfiziert;
	private int anzVerleihbar;

	//Vorbedingung: name darf nicht NULL sein, anzVerleihbar muss groesser 0 sein.
	public SchutzBekleidung(String name, int anzVerleihbar) {
		super(name);
		this.anzVerleihbar = anzVerleihbar;
		this.desinfiziert = true;
	}

	//Nachbedingung: Bekleidung wird desinfiziert.
	@Override
	public void desinfiziere() {
		desinfiziert = true;
	}

	//Nachbedingung: Bekleidung wird verliehen, die Anzahl sinkt um 1, kleidung ist nicht mehr desinfiziert.
	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
			super.verleihe(kunde);
			anzVerleihbar--;
			this.desinfiziert = false;
		}
	}

	//siehe ArtikelKlasse, zusaetzlich wird geprueft ob eine gueltige Anzahl im Stock sind und die Kleidung desinfiziert ist.
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
