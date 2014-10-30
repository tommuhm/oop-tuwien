public abstract class Bekleidung extends Set implements KategorieBekleidung {

	private Zustand zustand;
	private boolean desinfiziert;
	private int anzVerleihbar;

	public Bekleidung(int anzVerleihbar) {
		this.anzVerleihbar = anzVerleihbar;
		this.zustand = Zustand.verleihbar;
		this.desinfiziert = true;
		this.inOrdnung = true;
	}
	public void desinfiziere() {
		this.desinfiziert = true;
	}

	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
			this.desinfiziert = false;
			super.verleihe(kunde);
			if (anzVerleihbar > 1) {
				anzVerleihbar--;
			}
		}
	}

	@Override
	public void retour() {
		if (zustand() == Zustand.verliehen) {
			anzVerleihbar++;
			zustand = Zustand.benutzt;
		}		
	}

	@Override
	public boolean kontrolle() {

		if (this.desinfiziert != true ) { 
			return false;
		} 	
		else if (!super.kontrolle()) {
			return false;
		}
		return false;
	}
}
