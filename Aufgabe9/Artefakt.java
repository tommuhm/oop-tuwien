
public class Artefakt extends Geschenk{

	public Artefakt(String name, double radius) {
		super(name, radius, new Sechseck(radius));
	}

}
