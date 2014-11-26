public class HimmelskoerperStark extends Himmelskoerper {

	private boolean atmosphaere;

	// Vorbedingung: name darf nicht null sein
	public HimmelskoerperStark(String name, boolean atmosphaere) {
		super(name);
		this.atmosphaere = atmosphaere;
	}

	@Override
	// Vorbedingung: modul darf nicht null sein
	// Nachbedingung: true, wenn das Modul passt
	public boolean passtModul(Modul modul) {
		return modul.funktioniertFuer(this);
	}

	// Nachbedingung: true, wenn der Himmelskoerper eine Atmosphaere hat
	public boolean hasAtmosphaere() {
		return atmosphaere;
	}

}
