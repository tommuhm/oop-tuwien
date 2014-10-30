public abstract class Schutz extends Set implements ISchutz {

	private int anzVerleihbar;

	public Schutz(int anzVerleihbar) {
		this.anzVerleihbar = anzVerleihbar;
	}

	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
	  	setZustand(Zustand.verliehen);
			anzVerleihbar--;
		}
	}

	@Override
	public void retour() {

	}

	@Override
	public boolean kontrolle() {
		if (anz)


		return false;
	}

}
