
public class Kreis extends Grundflaeche {

	// Invariante: durchmesser muss groesser 0 sein.
	private double durchmesser;

	// Nachbedingung: durchmesser ist zugewiesen.
	public Kreis(double durchmesser) {
		this.durchmesser = durchmesser;
	}

	@Override
	// Vorbedingung: grundflaeche darf nicht null sein.
	// Nachbedingung: gibt true zurueck wenn das aktuelle object in die grundflaeche passt
	public boolean passtIn(Grundflaeche grundflaeche) {
		return grundflaeche.kannBeinhalten(this);
	}

	@Override
	// Nachbedingung: Kreise duerfen keine Rechtecke aufnehmen -> false.
	public boolean kannBeinhalten(Rechteck rechteck) {
		return false;
	}

	@Override
	// Nachbedingung: Kreise duerfen keine Quadrate aufnehmen -> false.
	public boolean kannBeinhalten(Quadrat quadrat) {
		return false;
	}

	@Override
	// Vorbedingung: sechseck darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn sechseck in this passt, sonst false.
	public boolean kannBeinhalten(Sechseck sechseck) {
		if (this.durchmesser >= 2 * sechseck.getSeitenlaenge()) {
			return true;
		}
		return false;
	}

	@Override
	// Vorbedingung: kreis darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn kreis in this passt, sonst false.
	public boolean kannBeinhalten(Kreis kreis) {
		if (this.durchmesser >= kreis.getDurchmesser()) {
			return true;
		}
		return false;
	}

	@Override
	// Nachbedingung: Gibt die Flaeche des Kreises zurueck
	public double flaeche() {
		return Math.PI * Math.pow(durchmesser, 2) / 4;
	}

	@Override
	// Vorbedingung: kartondicke darf nicht kleiner 0 sein.
	// Nachbedingung: gibt einen neuen Kreis mit zusatzlicher kartondicke zurueck
	public Kreis create(double kartondicke) {
		return new Kreis(durchmesser + 2 * kartondicke);
	}

	// Nachbedingung: Gibt den Durchmesser des Kreises zurueck.
	public double getDurchmesser() {
		return durchmesser;
	}

	@Override
	// Nachbedingung: gibt die Grundflaeche in lesbarer Form zurueck
	public String toString() {
		return "Kreis: " + durchmesser;
	}
}
