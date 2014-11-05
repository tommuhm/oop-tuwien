public class ProfiSet extends Set {

	private boolean serviceAusgefuehrt;
	private boolean serviceImmerAusgefuehrt;

	// Vorbedingung: Name darf nicht NULL sein
	// Nachbedingung: der Zustand des Sets ist verleihbar
	// Nachbedingung: das Set beinhaltet keine Artikel
	public ProfiSet(String name) {
		super(name);
		this.serviceAusgefuehrt = true;
		this.serviceImmerAusgefuehrt = true;
	}

	// Vorbedingung: nur aufrufbar wenn Artikel benutzt ist
	// Nachbedingung: service wurde ausgefuehrt.
	@Override
	public void service() {
		if (zustand() == Zustand.benutzt) {
			this.serviceAusgefuehrt = true;
		}
	}

	// Vorbedingung: nur aufrufbar wenn Artikel verliehen ist
	// Nachbedingung: Der Zustand des Artikels ist benutzt
	@Override
	public void retour() {
		if (zustand() != Zustand.verliehen)
			return;

		super.retour();

		if (!this.serviceAusgefuehrt)
			this.serviceImmerAusgefuehrt = false;
		this.serviceAusgefuehrt = false;
	}

	// Vorbedingung: nur aufrufbar wenn Artikel benutzt ist
	// Nachbedingung: Gibt False zureck wenn das Service nicht jedem ausleihen ausgefuehrt wurde
	// Nachbedingung: Der Zustand des Artikels ist defekt wenn kontrolle fehlschlaegt - Wahrscheinlichkeit von 1/6
	// Nachbedingung: Der Zustand des Artikels ist verleihbar kontrolle erfolgreich - Wahrscheinlichkeit von 5/6
	// Nachbedingung: Gibt True zurueck die Kontrolle erfolgreich ist und False wenn sie fehlschlaegt
	@Override
	public boolean kontrolle() {
		if (this.serviceImmerAusgefuehrt)
			return super.kontrolle();
		else
			return false;
	}

}
