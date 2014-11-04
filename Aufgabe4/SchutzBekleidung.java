public class SchutzBekleidung extends ArtikelKlasse implements KategorieSchutz, KategorieBekleidung {

	private int anzVerleihbar;
	private boolean desfiniziert;

	public SchutzBekleidung(String name, int anzVerleihbar) {
		super(name);
		this.anzVerleihbar = anzVerleihbar;
		this.desfiniziert = true;
	}

	@Override
	public void desinfiziere() {
		desfiniziert = true;
	}

	@Override
	public int getAnzVerleihbar() {
		return anzVerleihbar;
	}
}
