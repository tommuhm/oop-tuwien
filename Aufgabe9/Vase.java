public class Vase extends Geschenk {

	// VOrbedingung: name soll nicht null sein
	// Invariante: hoehe muss groesser als 0 sein
	// Invariante: radius muss groesser als 0 sein
	public Vase(String name, double hoehe, double radius) {
		super(name, hoehe, new Kreis(radius));
	}
}
