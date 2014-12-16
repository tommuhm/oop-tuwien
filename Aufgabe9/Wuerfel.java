
public class Wuerfel extends Geschenk {

	public Wuerfel(String name, double hoehe, double seitenlaenge) {
		super(name, hoehe, new Quadrat(seitenlaenge));
	}

}
