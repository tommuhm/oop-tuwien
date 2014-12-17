public class Buch extends Geschenk {

	// Vorbedingung: name darf nicht null sein
	// Vorbedingung: hoehe muss groesser als 0 sein
	// Vorbedingung: breite muss groesser als 0 sein
	// Vorbedingung: laenge muss groesser als breite sein
	public Buch(String name, double hoehe, double laenge, double breite) {
		super(name, hoehe, new Rechteck(laenge, breite));
	}

}
