public class FunSet extends Set {

	private int maxVerleihungen;
	private int serviceCount;

	// Vorbedingung: Name darf nicht NULL sein
	// Vorbedingung: maxVerleihungen muss groeßer als 0 sein
	// Nachbedingung: der Zustand des Sets ist verleihbar
	// Nachbedingung: das Set beinhaltet keine Artikel
	// Nachbedingung: Service Zaehler ist auf 0 gesetzt
	public FunSet(String name, int maxVerleihungen) {
		super(name);
		this.maxVerleihungen = maxVerleihungen;
		this.serviceCount = 0;
	}

	// Vorbedingung: nur aufrufbar wenn Artikel benutzt ist
	// Nachbedingung: ServiceCount wird auf 0 gesetzt, falls der serviceCount noch kleiner als 3 ist.
	public void service() {
		if (zustand() == Zustand.benutzt) {
			super.service();
			if (this.serviceCount <= 3) // Note: Angabe unklar - wissen nicht was passiert, falls der Artikel 4 mal gebraucht wurde, ohne dass ein Service durchgefuehrt worden ist.
				this.serviceCount = 0;
		}
	}

	// Vorbedingung: nur aufrufbar wenn Artikel verliehen ist
	// Nachbedingung: Der Zustand des Artikels ist benutzt
	// Nachbedingung: Service Zaehler wurde um eins erhoeht
	@Override
	public void retour() {
		if (zustand() != Zustand.verliehen)
			return;

		super.retour();
		this.serviceCount++;
	}

	// Vorbedingung: nur aufrufbar wenn Artikel verleihbar ist
	// Vorbedingung: die maximale Anzahl an Verleihungen darf nicht ueberschritten sein
	// Vorbedingung: Kunde darf nicht NULL sein.
	// Nachbedingung: Der Zustand des Artikels ist verliehen
	// Nachbedingung: Die Anzahl der moeglichen Verleihungen wurde um eins verringert.
	@Override
	public void verleihe(String kunde) {
		if (zustand() != Zustand.verleihbar || maxVerleihungen <= 0)
			return;

		maxVerleihungen--;
		super.verleihe(kunde);
	}

	// Vorbedingung: nur aufrufbar wenn Artikel benutzt ist
	// Nachbedingung: Gibt False zureck wenn mehr als 3 mal kein Service gemacht wurde
	// Nachbedingung: Gibt False zureck wenn der Artikel die Anzahk an moeglichen Verleihungen ueberschritten hat
	// Nachbedingung: Der Zustand des Artikels ist defekt wenn kontrolle fehlschlaegt - Wahrscheinlichkeit von 1/6
	// Nachbedingung: Der Zustand des Artikels ist verleihbar kontrolle erfolgreich - Wahrscheinlichkeit von 5/6
	// Nachbedingung: Gibt True zurueck die Kontrolle erfolgreich ist und False wenn sie fehlschlaegt
	@Override
	public boolean kontrolle() {
		if (zustand() != Zustand.benutzt)
			return false;

		if (serviceCount >= 4 || maxVerleihungen <= 0)
			return false;

		return super.kontrolle();
	}

	@Override
	public String toString() {
		return super.toString() + ", moegliche Verleihungen: " + maxVerleihungen;
	}
}
