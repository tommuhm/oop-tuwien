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
		return null;
	}

	@Override
	public void retour() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean kontrolle() {
		// TODO Auto-generated method stub
		return false;
	}

}
