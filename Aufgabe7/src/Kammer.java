
public class Kammer {
	
	private int dosis;
	private int ameisencounter;
	private boolean mauerOben;
	private boolean mauerRechts;
	
	public Kammer() {
		this.dosis = 0;
		this.ameisencounter = 0;
		this.mauerOben = randomBoolean();
		this.mauerRechts = randomBoolean();	
	}
	
	public Kammer(boolean mauerOben, boolean mauerRechts) {
		this.dosis = 0;
		this.ameisencounter = 0;
		this.mauerOben = mauerOben;
		this.mauerRechts = mauerRechts;
	}
	
	public synchronized boolean addAmeise(Ameise ameise) { //TODO addDosis.
		if(this.ameisencounter < 2) {
			this.ameisencounter++;
			this.addDosis(ameise.getDosis());
			return true;
		}
		return false;
	}
	
	private void addDosis (int dosis) {
		this.dosis += dosis;
	}
	
	public synchronized boolean removeAmeise() {
		if(this.ameisencounter > 0) {
			this.ameisencounter--;
			return true;
		}
		return false;
	}
	
	static boolean randomBoolean() {
		return Math.random() < 0.5;
	}
}
