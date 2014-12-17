public class Bonboniere extends Geschenk {

	// Vorbedingung: name darf nicht null sein
	// Vorbedingung: hoehe muss groesser als 0 sein
	// Vorbedingung: seitenlaenge muss groesser als 0 sein
	public Bonboniere(String name, double hoehe, double seitenlaenge) {
		super(name, hoehe, new Sechseck(seitenlaenge));
	}
}
