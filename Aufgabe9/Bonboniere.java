public class Bonboniere extends Geschenk {

	// Vorbedingung: name sollte nicht null sein
	// Invariante: hoehe muss groesser als 0 sein
	// Invariante: seitenlaenge muss groesser als 0 sein
	public Bonboniere(String name, double hoehe, double seitenlaenge) {
		super(name, hoehe, new Sechseck(seitenlaenge));
	}
}
