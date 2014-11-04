public class ProfiSet extends Set {

	private boolean serviceAusgefuehrt;
	private boolean serviceImmerAusgefuehrt;

	// Vorbedingung: name darf nicht NULL sein.
	public ProfiSet(String name) {
		super(name);
		this.serviceAusgefuehrt = true;
		this.serviceImmerAusgefuehrt = true;
	}

	// Nachbedingung: service wurde ausgefuehrt.
	@Override
	public void service() {
		this.serviceAusgefuehrt = true;
	}

	// Gegenstand wird retourniert, Zustand wechselt auf verliehen.
	@Override
	public void retour() {
		if (zustand() != Zustand.verliehen)
			return;

		super.retour();

		if (!this.serviceAusgefuehrt)
			this.serviceImmerAusgefuehrt = false;
		this.serviceAusgefuehrt = false;
	}

	
	// siehe Artikelklasse, zusaetzlich wird abgeprueft ob das Service immer ausgefuehrt wurde.
	@Override
	public boolean kontrolle() {
		if (this.serviceImmerAusgefuehrt)
			return super.kontrolle();
		else
			return false;
	}
	//Vorbedingung: Der Zustand des Ggstd muss verleihbar sein, und es muss mindestens ein Gegenstand noch vorhanden sein.
	@Override
	public void verleihe(String kunde) {
		if (zustand() != Zustand.verleihbar)
			return;

		super.verleihe(kunde);
	}
}
