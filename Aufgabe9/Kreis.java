
public class Kreis extends Grundflaeche {

	// Invariante: durchmesser muss groesser 0 sein.
	private double durchmesser;

	// Nachbedingung: durchmesser ist zugewiesen.
	public Kreis(double durchmesser) {
		this.durchmesser = durchmesser;
	}

	@Override
	// Vorbedingung: grundflaeche darf nicht null sein.
	// Nachbedingung: gibt true zurueck wenn this das Objekt grundflaeche beinhalten kann.
	public boolean kannBeinhalten(Grundflaeche grundflaeche) {
		return grundflaeche.passtIn(this);
	}

	@Override
	// Nachbedingung: Kreise dürfen keine Rechtecke aufnehmen -> false. 
	public boolean passtIn(Rechteck rechteck) {
		return false;
	}

	@Override
	// Nachbedingung: Kreise dürfen keine Quadrate aufnehmen -> false.
	public boolean passtIn(Quadrat quadrat) {
		return false;
	}

	@Override
	// Vorbedingung: sechseck darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn sechseck in this passt, sonst false.
	public boolean passtIn(Sechseck sechseck) {
		if (2 * sechseck.getSeitenlaenge() <= this.durchmesser) {
			return true;
		}
		return false;
	}

	@Override
	// Vorbedingung: kreis darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn kreis in this passt, sonst false.
	public boolean passtIn(Kreis kreis) {
		if (this.durchmesser >= kreis.getDurchmesser()) {
			return true;
		}
		return false;
	}

	@Override
	// Vorbedingung: kartondicke darf nicht kleiner 0 sein.
	// Nachbedingung: Gibt die Flaeche des Kreises zurueck und berechnet die Kartondicke ein.
	public double flaeche(double kartondicke) {
		return Math.PI * Math.pow(durchmesser + 2 * kartondicke, 2) / 4;
	}

	// Nachbedingung: Gibt den Durchmesser des Kreises zurueck.
	public double getDurchmesser() {
		return durchmesser;
	}
}
