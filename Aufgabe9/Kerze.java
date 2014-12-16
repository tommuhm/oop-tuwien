public class Kerze extends Geschenk {

	// Vorbedingung: name soll nicht null sein
	// Invariante: hoehe muss groesser als 0 sein
	// Invariante: radius muss groesser als 0 sein
	public Kerze(String name, double hoehe, double radius) {
		super(name, hoehe, new Sechseck(radius));
	}
}
