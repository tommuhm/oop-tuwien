public class Bekleidung extends ArtikelKlasse implements KategorieBekleidung {

	private boolean desinfiziert;

	//name darf nicht NULL sein. desinfiziert wird auf true gesetzt, da Bekleidung neu ist.
	public Bekleidung(String name) {
		super(name);
		this.desinfiziert = true;
	}

	//setzt desinfiziert auf TRUE, das Kleidungsstueck wird desinfiziert.
	@Override
	public void desinfiziere() {
		this.desinfiziert = true;
	}

	//Bekleidung wird verliehen, wenn der Zustand dies erlaubt.
	@Override
	public void verleihe(String kunde) {
		if (zustand() == Zustand.verleihbar) {
			super.verleihe(kunde);
			this.desinfiziert = false;
		}
	}


	// Fuehrt eine Kontrolle auf den Gegenstand aus. Returned FALSE, wenn der Ggstd unbrauchbar ist, 
	// d.h., wenn die Kontrolle negativ ausgefallen ist (wird bestimmt durch einen Zufallsgenerator,
	// welcher zu einem 1/6 Wahrscheinlichkeit die Kontrolle negativ ausfallen laesst.
	// ansonsten wird der Zustand des Ggstands auf verleihbar gesetzt.
	// Prueft zusaetzlich noch ob der Zustand desinfiziert ist oder gerade benutzt wird, 
	// letzteres impliziert, dass die Kontrolle nicht durchgefuehrt werden kann.
	@Override
	public boolean kontrolle() {
		if (zustand() != Zustand.benutzt)
			return false;

		if (desinfiziert != true)
			return false;

		if (!super.kontrolle())
			return false;

		setZustand(Zustand.verleihbar);
		return true;
	}

}
