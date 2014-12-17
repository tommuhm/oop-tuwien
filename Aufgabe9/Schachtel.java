public class Schachtel extends Geschenk {

	private static final double KARTONDICKE = 0.5;

	private Geschenk geschenk;

	// Vorbedingung: hoehe muss groesser als 0 sein
	// Vorbedingung: grundflaeche darf nicht null sein
	public Schachtel(double hoehe, Grundflaeche grundflaeche) {
		super("", hoehe, grundflaeche);
		this.geschenk = null;
	}

	// Nachbedingung: gibt das Volumen der Schachtel mit eingerechneter Kartondicke zurueck
	public double volumen() {
		double flaecheAussen = super.getGrundflaeche().flaeche(KARTONDICKE);
		double hoeheAussen = super.getHoehe() + 2 * KARTONDICKE;
		return flaecheAussen * hoeheAussen;
	}

	// Vorbedingung: geschenk darf nicht null sein
	// Nachbedingung: falls das Geschenk in diese Schachtel hineinpasst, dann wird true zurueckgegeben
	// Nachbedingung: falls das Geschenk nicht hineinpasst, dann wird false zurueckgegeben
	public boolean kannBeinhalten(Geschenk geschenk) {
		if (this.getHoehe() >= geschenk.getHoehe() && geschenk.getGrundflaeche().passtIn(this.getGrundflaeche()))
			return true;

		return false;
	}

	// Vorbedingung: geschenk darf nicht null sein
	// Nachbedingung: falls das Geschenk in diese Schachtel hineinpasst, dann wird es in die Schachtel gepackt und true zurueckgegeben
	// Nachbedingung: falls das Geschenk nicht in die Schachtel passt, dann wird false zurueckgegeben
	public boolean addGeschenk(Geschenk geschenk) {
		if (!this.kannBeinhalten(geschenk))
			return false;

		this.geschenk = geschenk;
		this.setName(geschenk.getName());

		return true;
	}

	// Nachbedingung: falls diese Schachtel ein Geschenk enthaelt, dann wird true zurueckgegeben
	public boolean hasGeschenk() {
		if (geschenk == null)
			return false;
		return true;
	}

	@Override
	// Nachbedingung: gibt die Grundflaeche in lesbarer Form zurueck
	public String toString() {
		return "Schachtel: " + getName() + ", " + getGrundflaeche() + ", Volumen: " + volumen();
	}

}
