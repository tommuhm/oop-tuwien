
public class Quadrat extends Grundflaeche {

	private double seitenlaenge;
	// Invariante: seitenlaenge muss groesser 0 sein.

	// Nachbedingung: seitenlaenge ist zugewiesen.
	public Quadrat(double seitenlaenge) {
		this.seitenlaenge = seitenlaenge;
	}

	@Override
	// Vorbedingung: kartondicke darf nicht kleiner 0 sein.
	// Nachbedingung: Gibt die Flaeche des Quadrats zurueck und berechnet die Kartondicke ein.
	public double flaeche(double kartondicke) {
		return Math.pow(seitenlaenge + 2 * kartondicke, 2);
	}

	@Override
	// Vorbedingung: grundflaeche darf nicht null sein.
	// Nachbedingung: gibt true zurueck wenn this das Objekt grundflaeche beinhalten kann.
	public boolean kannBeinhalten(Grundflaeche grundflaeche) {
		return grundflaeche.passtIn(this);
	}

	@Override
	// Nachbedingung: Quadrate dürfen keine Sechsecke aufnehmen -> false. 
	public boolean passtIn(Sechseck sechseck) {
		return false;
	}

	@Override
	// Nachbedingung: Quadrate dürfen keine Rechtecke aufnehmen -> false. 
	public boolean passtIn(Rechteck rechteck) {
		return false;
	}

	@Override
	// Vorbedingung: kreis darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn kreis in this passt, sonst false.
	public boolean passtIn(Kreis kreis) {
		if (this.getSeitenlaenge() >= kreis.getDurchmesser()) {
			return true;
		}
		return false;
	}

	@Override
	// Vorbedingung: quadrat darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn quadrat in this passt, sonst false.
	public boolean passtIn(Quadrat quadrat) {
		if (this.getSeitenlaenge() >= quadrat.getSeitenlaenge()) {
			return true;
		}
		return false;
	}

	// Nachbedingung: Gibt den Seitenlaenge des Rechtecks zurueck.
	public double getSeitenlaenge() {
		return seitenlaenge;
	}
}
