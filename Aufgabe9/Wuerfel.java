
public class Wuerfel extends Geschenk {

	public Wuerfel(String name, double seitenlaenge) {
		super(name, seitenlaenge, new Quadrat(seitenlaenge));
	}

}
