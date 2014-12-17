public class Schuhe extends Geschenk {

	// Vorbedingung: laenge muss groesser als breite sein
	// Vorbedingung: hoehe muss groesser als 0 sein
	// Vorbedingung: breite muss groesser als 0 sein
	public Schuhe(String name, double hoehe, double laenge, double breite) {
		super(name, hoehe, new Rechteck(laenge, breite));
	}

}
