public class Wuerfel extends Geschenk {

	// Vorbedingung: name darf nicht null sein
	// Invariante: seitenlaenge muss groesser als 0 sein
	public Wuerfel(String name, double seitenlaenge) {
		super(name, seitenlaenge, new Quadrat(seitenlaenge));
	}

}
