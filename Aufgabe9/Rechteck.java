
public class Rechteck extends Grundflaeche {

	// Invariante: laenge muss groesser 0 sein.
	// Invariante: breite muss groesser 0 sein.
	// Invariante: laenge muss groesser breite sein.
	private double laenge;
	private double breite;
	
	// Nachbedingung: laenge ist zugewiesen.
	// Nachbedingung: breite ist zugewiesen.
	public Rechteck(double laenge, double breite) {
		this.laenge = laenge;
		this.breite = breite;
	}

	@Override
	// Vorbedingung: grundflaeche darf nicht null sein.
	// Nachbedingung: gibt true zurueck wenn das aktuelle object in die grundflaeche passt
	public boolean passtIn(Grundflaeche grundflaeche) {
		return grundflaeche.passtIn(this);
	}

	@Override
	// Nachbedingung: Rechtecke dürfen keine Quadrate aufnehmen -> false. 
	public boolean kannBeinhalten(Quadrat quadrat) {
		return false;
	}

	@Override
	// Vorbedingung: rechteck darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn rechteck in this passt, sonst false.
	public boolean kannBeinhalten(Rechteck rechteck) {
		if (this.getLaenge() >= rechteck.getLaenge() && this.getBreite() >= rechteck.getBreite())
			return true;
		return false;
	}

	@Override
	// Nachbedingung: Rechtecke dürfen keine Kreise aufnehmen -> false. 
	public boolean kannBeinhalten(Kreis kreis) {
		return false;
	}

	@Override
	// Vorbedingung: sechseck darf nicht null sein.
	// Nachbedingung: Gibt true zurueck wenn seckseck in this passt, sonst false.
	public boolean kannBeinhalten(Sechseck sechseck) {
		double radius = sechseck.getSeitenlaenge();
		double inkreis = radius * Math.sqrt(3) / 2;

		if (this.getLaenge() >= 2 * radius && this.getBreite() >= 2 * inkreis)
			return true;
		return false;
	}

	@Override
	// Vorbedingung: kartondicke darf nicht kleiner 0 sein.
	// Nachbedingung: Gibt die Flaeche des Rechtecks zurueck und berechnet die Kartondicke ein.
	public double flaeche(double kartondicke) {
		return (laenge + 2 * kartondicke) * (breite + 2 * kartondicke);
	}

	// Nachbedingung: Gibt den Laenge des Rechtecks zurueck.
	public double getLaenge() {
		return laenge;
	}

	// Nachbedingung: Gibt den Breite des Rechtecks zurueck.
	public double getBreite() {
		return breite;
	}
}
