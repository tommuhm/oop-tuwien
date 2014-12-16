public class Schuhe extends Geschenk {

	// Invariante: laenge muss groesser als breite sein
	// Invariante: hoehe muss groesser als 0 sein
	// Invariante: breite muss groesser als 0 sein
	public Schuhe(String name, double hoehe, double laenge, double breite) {
		super(name, hoehe, new Rechteck(laenge, breite));
	}

}
