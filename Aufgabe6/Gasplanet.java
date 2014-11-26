public class Gasplanet extends Himmelskoerper {

	// Vorbedingung: name darf nicht null sein
	public Gasplanet(String name) {
		super(name);
	}

	@Override
	// Vorbedingung: modul darf nicht null sein
	// Nachbedingung: true, wenn das Modul passt
	public boolean passtModul(Modul modul) {
		return modul.funktioniertFuer(this);
	}

}
