public abstract class ArtikelKlasse implements Artikel {

	private Zustand zustand;
	private String kunde;
	private String name;

	//String darf nicht NULL sein, der Zustand vom erzeugten Objekt wechselt auf verleihbar.
	public ArtikelKlasse(String name) {
		this.zustand = Zustand.verleihbar;
		this.name = name;
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
			if (Math.random() > (1 / 6)) {
				this.zustand = Zustand.verleihbar;
				return true;
			} else {
				this.zustand = Zustand.defekt;
				return false;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return this.name + " Zustand: " + this.zustand + " Kunde: " + this.kunde;
	}
}
