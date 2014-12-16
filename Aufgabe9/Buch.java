
public class Buch extends Geschenk {


	// laenge > breite
	public Buch(String name, double hoehe, double laenge, double breite) {
		super(name, hoehe, new Rechteck(laenge, breite));
	}

}
