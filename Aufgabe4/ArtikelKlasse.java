public abstract class ArtikelKlasse implements Artikel {

	private Zustand zustand;
	private String kunde;
	private String name;

	//String darf nicht NULL sein, der Zustand vom erzeugten Objekt wechselt auf verleihbar.
	public ArtikelKlasse(String name) {
		this.zustand = Zustand.verleihbar;
		this.name = name;
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
	//kunde darf nicht NULL sein.
	//ein Gegenstand wird an einem Kunden verliehen. Der Zustand des Ggstd wechselt in verliehen. 
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

	//Ggstd wird zurueckgegeben. Zustand wechselt auf benutzt.
	@Override
	public void retour() {
		if (zustand() == Zustand.verliehen) {
			this.zustand = Zustand.benutzt;
		}
	}

	// Fuehrt eine Kontrolle auf den Gegenstand aus. Returned FALSE, wenn der Ggstd unbrauchbar ist, 
	// d.h., wenn die Kontrolle negativ ausgefallen ist (wird bestimmt durch einen Zufallsgenerator,
	// welcher zu einem 1/6 Wahrscheinlichkeit die Kontrolle negativ ausfallen laesst.
	// ansonsten wird der Zustand des Ggstands auf verleihbar gesetzt.
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
