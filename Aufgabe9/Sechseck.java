
public class Sechseck extends Grundflaeche {

	// Invariante: seitenlaenge muss groesser 0 sein.
	private double seitenlaenge;

	// Nachbedingung: seitenlaenge ist zugewiesen.
	public Sechseck(double seitenlaenge) {
		this.seitenlaenge = seitenlaenge;
	}

	@Override
	// Vorbedingung: grundflaeche darf nicht null sein.
	// Nachbedingung: gibt true zurueck wenn das aktuelle object in die grundflaeche passt
	public boolean passtIn(Grundflaeche grundflaeche) {
		return grundflaeche.passtIn(this);
	}

	@Override
	// Nachbedingung: Sechsecke dürfen keine Quadrate aufnehmen -> false. 
	public boolean kannBeinhalten(Quadrat quadrat) {
		return false;
	}

	@Override
	// Nachbedingung: Sechsecke dürfen keine Rechtecke aufnehmen -> false. 
	public boolean kannBeinhalten(Rechteck rechteck) {
		return false;
	}

	@Override
	// Vorbedingung: kreis darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn kreis in this passt, sonst false.
	public boolean kannBeinhalten(Kreis kreis) {
		if ((this.seitenlaenge * 2) >= kreis.getDurchmesser())
			return true;
		return false;
	}

	@Override
	// Vorbedingung: sechseck darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn sechseck in this passt, sonst false.
	public boolean kannBeinhalten(Sechseck sechseck) {
		if (this.seitenlaenge >= sechseck.getSeitenlaenge())
			return true;
		return false;
	}

	@Override
	// Vorbedingung: kartondicke darf nicht kleiner 0 sein.
	// Nachbedingung: Gibt die Flaeche des Sechsecks zurueck und berechnet die Kartondicke ein.
	public double flaeche(double kartondicke) {
		return 3 / 2 * Math.pow(seitenlaenge + kartondicke, 2) * Math.sqrt(3);
	}

	// Nachbedingung: Gibt die Seitenlänge des Sechsecks zurueck.
	public double getSeitenlaenge() {
		return seitenlaenge;
	}
}
