
public class Vase extends Geschenk{

	public Vase(String name, double hoehe, double radius) {
		super(name, hoehe, new Kreis(radius));
	}
}
