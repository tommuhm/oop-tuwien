public class FeldAmeisenkolonie extends Feld {

	public FeldAmeisenkolonie(int x, int y) {
		super(x, y);
	}

	public FeldAmeisenkolonie(int x, int y, boolean mauerOben, boolean mauerRechts) {
		super(x, y, mauerOben, mauerRechts);
	}

	public FeldAmeisenkolonie(Feld feld) {
		super(feld.getX(), feld.getY(), feld.hatMauerOben(), feld.hatMauerRechts());
	}

}
