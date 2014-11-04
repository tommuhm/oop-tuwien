public abstract class ArtikelKlasse implements Artikel {

	private Zustand zustand;
	private String kunde;

	public ArtikelKlasse() {
		this.zustand = Zustand.verleihbar;
	}


	protected void setZustand(Zustand zustand) {
		this.zustand = zustand;
	}

	protected void setKunde(String kunde) {
		this.kunde = kunde;
	}

	@Override
	public Zustand zustand() {
		return this.zustand;
	}

	@Override
	public void verleihe(String kunde) {
		if (this.zustand == Zustand.verleihbar) {
			this.zustand = Zustand.verliehen;
			this.kunde = kunde;
		}
	}

	public void service() {
		if (zustand() == Zustand.benutzt) {
			//TODO nothing to do in set.
		}
	}

	@Override
	public String kunde() {
		return this.kunde;
	}

	@Override
	public void retour() {
		if (zustand() == Zustand.verliehen) {
			this.zustand = Zustand.benutzt;
		}
	}

	@Override
	public boolean kontrolle() {
		if (zustand() == Zustand.benutzt) {
			//Prüfen. Artikel fällt 1:6 weg.
			if(Math.random() > (1/6)) {
				this.setZustand(Zustand.verleihbar);				
				return true;
			}
			else
				return false;
		}
		return false;
	}

}
