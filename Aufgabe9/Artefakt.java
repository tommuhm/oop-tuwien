public class Artefakt extends Geschenk {

	// Vorbedingung: name darf nicht null sein
	// Vorbedingung: radius muss groesser als 0 sein
	public Artefakt(String name, double radius) {
		super(name, radius, new Sechseck(radius));
	}

}
