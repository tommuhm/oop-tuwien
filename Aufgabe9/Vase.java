public class Vase extends Geschenk {

	// Vorbedingung: name darf nicht null sein
	// Vorbedingung: hoehe muss groesser als 0 sein
	// Vorbedingung: radius muss groesser als 0 sein
	public Vase(String name, double hoehe, double radius) {
		super(name, hoehe, new Kreis(radius));
	}
}
