
public class Weinflasche extends Geschenk {

	public Weinflasche(String name, double hoehe, double radius) {
		super(name, hoehe, new Kreis(radius));
	}
}
