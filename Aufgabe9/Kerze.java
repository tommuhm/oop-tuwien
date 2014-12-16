
public class Kerze extends Geschenk {

	public Kerze(String name, double hoehe, double radius) {
		super(name, hoehe, new Sechseck(radius));
	}
}
