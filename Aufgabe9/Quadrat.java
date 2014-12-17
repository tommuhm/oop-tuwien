
public class Quadrat extends Grundflaeche {

	// Invariante: seitenlaenge muss groesser 0 sein.
	private double seitenlaenge;

	// Nachbedingung: seitenlaenge ist zugewiesen.
	public Quadrat(double seitenlaenge) {
		this.seitenlaenge = seitenlaenge;
	}

	@Override
	// Vorbedingung: grundflaeche darf nicht null sein.
	// Nachbedingung: gibt true zurueck wenn das aktuelle object in die grundflaeche passt
	public boolean passtIn(Grundflaeche grundflaeche) {
		return grundflaeche.kannBeinhalten(this);
	}

	@Override
	// Nachbedingung: Quadrate dürfen keine Sechsecke aufnehmen -> false. 
	public boolean kannBeinhalten(Sechseck sechseck) {
		return false;
	}

	@Override
	// Nachbedingung: Quadrate dürfen keine Rechtecke aufnehmen -> false. 
	public boolean kannBeinhalten(Rechteck rechteck) {
		return false;
	}

	@Override
	// Vorbedingung: kreis darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn kreis in this passt, sonst false.
	public boolean kannBeinhalten(Kreis kreis) {
		if (this.getSeitenlaenge() >= kreis.getDurchmesser()) {
			return true;
		}
		return false;
	}

	@Override
	// Vorbedingung: quadrat darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn quadrat in this passt, sonst false.
	public boolean kannBeinhalten(Quadrat quadrat) {
		if (this.getSeitenlaenge() >= quadrat.getSeitenlaenge()) {
			return true;
		}
		return false;
	}

	@Override
	// Vorbedingung: kartondicke darf nicht kleiner 0 sein.
	// Nachbedingung: gibt ein neues Quadrat mit zusatzlicher kartondicke zurueck
	public Quadrat create(double kartondicke) {
		return new Quadrat(seitenlaenge + 2 * kartondicke);
	}

	@Override
	// Nachbedingung: Gibt die Flaeche des Quadrats zurueck
	public double flaeche() {
		return Math.pow(seitenlaenge, 2);
	}

	// Nachbedingung: Gibt den Seitenlaenge des Rechtecks zurueck.
	public double getSeitenlaenge() {
		return seitenlaenge;
	}

	@Override
	// Nachbedingung: gibt die Grundflaeche in lesbarer Form zurueck
	public String toString() {
		return "Quadrat: " + seitenlaenge + "x" + seitenlaenge;
	}
}
