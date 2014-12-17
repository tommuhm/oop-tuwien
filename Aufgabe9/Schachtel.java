import java.math.BigDecimal;

public class Schachtel extends Geschenk {

	private static final double KARTONDICKE = 0.5;

	private Geschenk geschenk;
	private Grundflaeche grundflaecheAussen;
	private double hoeheAussen;

	// Vorbedingung: hoehe muss groesser als 0 sein
	// Vorbedingung: grundflaeche darf nicht null sein
	public Schachtel(double hoeheInnen, Grundflaeche grundflaecheInnen) {
		super("", hoeheInnen, grundflaecheInnen.create());
		this.geschenk = null;
		this.grundflaecheAussen = grundflaecheInnen.create(KARTONDICKE);
		this.hoeheAussen = hoeheInnen + 2 * KARTONDICKE;
	}

	@Override
	// Nachbedingung: gibt das Volumen der Schachtel mit eingerechneter Kartondicke zurueck
	public double volumen() {
		return new BigDecimal(grundflaecheAussen.flaeche() * hoeheAussen).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	// Vorbedingung: geschenk darf nicht null sein
	// Nachbedingung: falls das Geschenk in diese Schachtel hineinpasst, dann wird true zurueckgegeben
	// Nachbedingung: falls das Geschenk nicht hineinpasst, dann wird false zurueckgegeben
	public boolean kannBeinhalten(Geschenk geschenk) {
		if (super.getHoehe() >= geschenk.getHoehe() && geschenk.getGrundflaeche().passtIn(super.getGrundflaeche()))
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

	@Override
	public Grundflaeche getGrundflaeche() {
		return grundflaecheAussen;
	}

	@Override
	public double getHoehe() {
		return hoeheAussen;
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
		return "Schachtel: " + getName() + ", Hoehe: " + getHoehe() + ", " + getGrundflaeche() + ", Volumen: " + volumen();
	}

}
