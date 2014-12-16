
public class Bonboniere extends Geschenk{

	public Bonboniere(String name, double hoehe, double seitenlaenge) {
		super(name, hoehe, new Sechseck(seitenlaenge));
	}
}
