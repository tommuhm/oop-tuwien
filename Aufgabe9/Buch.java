public class Buch extends Geschenk {

	// Vorbedingung: name sollte nicht null sein
	// Invariante: hoehe muss groesser als 0 sein
	// Invariante: breite muss groesser als 0 sein
	// Invariante: laenge muss groesser als breite sein
	public Buch(String name, double hoehe, double laenge, double breite) {
		super(name, hoehe, new Rechteck(laenge, breite));
	}

}
