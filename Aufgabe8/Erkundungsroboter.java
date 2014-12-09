
@Author(name = "Ulrich Aschl")
public abstract class Erkundungsroboter {

	private static int maxNummer = 0;

	private final int nummer;
	private int stunden;
	private Einsatzart art;

	// Invariante: maxNummer ist größer gleich 0, wächst bei jedem neuen Objekt vom Typ Erkundungsroboter um +1.
	// Invariante: nummer ist größer gleich 0, ist final und entspricht dem Wert von maxNummer zum Erstellungszeitpunkt.
	// Invariatne: stunden ist größer gleich 0.
	// Invariante: art darf nicht null sein.

	// Vorbedingung: art darf nicht null sein
	// Vorbedingung: stunden müssen größer gleich 0 sein.
	@Author(name = "Ulrich Aschl")
	public Erkundungsroboter(Einsatzart art, int stunden) {
		this(art);
		this.stunden = stunden;
	}

	// Vorbedingung: art darf nicht null sein
	@Author(name = "Ulrich Aschl")
	public Erkundungsroboter(Einsatzart art) {
		this.nummer = maxNummer++;

		this.stunden = 0;
		this.art = art;
	}

	// Nachbedingung: stunden werden um 1 erhoeht
	@Author(name = "Ulrich Aschl")
	public void erhoeheStunden() {
		this.stunden++;
	}

	// Nachbedingung: gibt stunden zurück
	@Author(name = "Ulrich Aschl")
	public int getStunden() {
		return this.stunden;
	}

	// Nachbedingung: gibt die einsatzart zurück
	@Author(name = "Ulrich Aschl")
	public Einsatzart getEinsatzart() {
		return art;
	}

	// Vorbedingung: art darf nicht null sein
	// Nachbedingung:  this.art ist nun art
	@Author(name = "Ulrich Aschl")
	public void setEinsatzart(Einsatzart art) {
		this.art = art;
	}

	// Nachbedingung: gibt die identifizierungs-nummer zurück
	@Author(name = "Ulrich Aschl")
	public int getNummer() {
		return this.nummer;
	}

	// Nachbedingung: gibt die Roboternummer, die Anzahl der Stunden, die der Roboter läuft und die Einsatzart als String zurück.
	@Override
	@Author(name = "Ulrich Aschl")
	public String toString() {
		return "Roboter #" + this.getNummer() + " - Stunden: " + this.getStunden() + " Einsatzart: " + this.getEinsatzart();
	}
}
