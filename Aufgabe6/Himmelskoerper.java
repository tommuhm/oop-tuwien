public abstract class Himmelskoerper {

	private String name;

	// Vorbedingung: name darf nicht null sein.
	public Himmelskoerper(String name) {
		this.name = name;
	}

	// Nachbedingung: gibt name zurueck
	public String getName() {
		return name;
	}

	// Vorbedingung: modul darf nicht null sein!
	abstract public boolean passtModul(Modul modul);

	// Nachbedingung: gibt den namen des himmelskoerpers zurueck
	@Override
	public String toString() {
		return getName();
	}
}
