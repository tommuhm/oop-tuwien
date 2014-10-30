import java.util.ArrayList;

public abstract class Set implements Artikel {

	private ArrayList<Artikel> artikelListe;
	private Zustand zustand;
	private String kunde;

	public Set() {
		this.artikelListe = new ArrayList<Artikel>();
		this.zustand = Zustand.verleihbar;
	}

	public ArrayList<Artikel> getArtikelSet() {
		return this.artikelListe;
	}

	public void artikelHinzufuegen(Artikel a) {
		artikelListe.add(a);
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
