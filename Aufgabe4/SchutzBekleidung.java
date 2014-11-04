public class SchutzBekleidung extends Schutz implements KategorieSchutz, KategorieBekleidung {

	private boolean desfiniziert;

	public SchutzBekleidung(String name, int anzVerleihbar) {
		super(name, anzVerleihbar);
		this.desfiniziert = true;
	}

	@Override
	public void desinfiziere() {
		desfiniziert = true;
	}

}
