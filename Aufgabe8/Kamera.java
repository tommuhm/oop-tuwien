
@Author(name="Ulrich Aschl")
public class Kamera implements Einsatzart{
	
	private int pixel;
	// Invariante: pixel darf nicht kleiner 0 sein.

	// Vorbedingung: pixel darf nicht kleiner 0 sein.
	public Kamera(int pixel) {
		this.pixel = pixel;
	}

	// Nachbedingung: gibt die Anzahl an Pixel der Kamera zurück.
	public int getPixel() {
		return this.pixel;
	}

	// Nachbedingung: Gibt die Anzahl an Pixel der Kamera als String aus.
	@Override
	public String toString() {
		return "Kamera: " + this.pixel + " Pixel";
	}
}
