
public class Schuhe extends Geschenk{
	
	public Schuhe(String name, double hoehe, double laenge, double breite) {
		super(name, hoehe, new Rechteck(laenge, breite));
	}

}
