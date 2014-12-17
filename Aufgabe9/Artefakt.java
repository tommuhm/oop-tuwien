public class Artefakt extends Geschenk {

	// Vorbedingung: name darf nicht null sein
	// Vorbedingung: seitenlaenge muss groesser als 0 sein
	public Artefakt(String name, double seitelaenge) {
		super(name, seitelaenge, new Quadrat(seitelaenge));
	}

}
