
public abstract class Grundflaeche {

	// Nachbedingung: gibt die flaeche der Grundflaeche zurück
	public double flaeche() {
		return flaeche(0);
	}

	// Vorbedingung: grundflaeche darf nicht null sein
	// Nachbedingung: Gibt true zurueck wenn grundflaeche in this passt, sonst false.
	public abstract boolean kannBeinhalten(Grundflaeche grundflaeche);

	// Vorbedingung: quadrat darf nicht null sein
	// Nachbedingung: Gibt true zurueck wenn this in quadrat passt, sonst false.
	public abstract boolean passtIn(Quadrat quadrat);

	// Vorbedingung: rechteck darf nicht null sein
	// Nachbedingung: Gibt true zurueck wenn this in rechteck passt, sonst false.
	public abstract boolean passtIn(Rechteck rechteck);

	// Vorbedingung: kreis darf nicht null sein
	// Nachbedingung: Gibt true zurueck wenn this in kreis passt, sonst false.
	public abstract boolean passtIn(Kreis kreis);

	// Vorbedingung: sechseck darf nicht null sein
	// Nachbedingung: Gibt true zurueck wenn this in sechseck passt, sonst false.
	public abstract boolean passtIn(Sechseck sechseck);

	// Vorbedingung: kartondicke darf nicht kleiner 0 sein
	// Nachbedingung: gibt die berechnete Flaeche von this zurueck. Die kartondicke kann einbezogen werden.
	public abstract double flaeche(double kartondicke);

}
