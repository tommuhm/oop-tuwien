public abstract class Geschenk implements Cloneable {

	private String name;
	private double hoehe;
	private Grundflaeche grundflaeche;

	// Vorbedingung: name darf nicht null sein
	// Vorbedingung: grundflaeche darf nicht null sein
	// Vorbedingung: hoehe muss groesser als 0 sein
	public Geschenk(String name, double hoehe, Grundflaeche grundflaeche) {
		this.name = name;
		this.hoehe = hoehe;
		this.grundflaeche = grundflaeche;
	}

	// Nachbedingung: gibt das Volumen der Schachtel mit eingerechneter Kartondicke zurueck
	public double volumen() {
		return grundflaeche.flaeche() * hoehe;
	}

	// Nachbedingung: gibt den namen des geschenks zurueck
	public String getName() {
		return name;
	}

	// Nachbedingung: gibt die hoehe des geschenks zurueck
	public double getHoehe() {
		return hoehe;
	}

	// Nachbedingung: gibt die grundflaeche des geschenks zurueck
	public Grundflaeche getGrundflaeche() {
		return grundflaeche;
	}

	// Vorbedingung: name darf nicht null sein
	// Nachbedingung: der name des geschneks wurde auf name gesetzt
	protected void setName(String name) {
		this.name = name;
	}

	@Override
	// Nachbedingung: gibt einen klon von diesem Geschenk zurueck
	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
		return clone;
	}

	@Override
	// Nachbedingung: gibt die Grundflaeche in lesbarer Form zurueck
	public String toString() {
		return "Geschenk: " + getName() + ", " + getGrundflaeche() + ", Volumen: " + volumen();
	}

}
