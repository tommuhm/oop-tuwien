public abstract class SchutzBekleidung extends Schutz implements KategorieSchutz, KategorieBekleidung {

	@Override
	public void verleihe(String kunde) {

	}

	@Override
	public void retour() {

	}

	@Override
	public boolean kontrolle() {
		return false;
	}
}
