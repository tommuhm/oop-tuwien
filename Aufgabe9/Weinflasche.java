public class Weinflasche extends Geschenk {

	// Vorbedingung: name soll nicht null sein
	// Invariante: hoehe muss groesser als 0 sein
	// Ivariante: radius muss groesser als 0 sein
	public Weinflasche(String name, double hoehe, double radius) {
		super(name, hoehe, new Kreis(radius));
	}

}
