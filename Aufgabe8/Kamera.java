
public class Kamera implements Einsatzart{
	private int pixel;
	
	public Kamera(int pixel) {
		this.pixel = pixel;
	}
	
	public int getWert() {
		return this.pixel;
	}
}
