public class FeldFutterstelle extends Feld {

	public FeldFutterstelle(int x, int y) {
		super(x, y);
	}

	public FeldFutterstelle(int x, int y, boolean mauerOben, boolean mauerRechts) {
		super(x, y, mauerOben, mauerRechts);
	}

	public FeldFutterstelle(Feld feld) {
		super(feld.getX(), feld.getY(), feld.hatMauerOben(), feld.hatMauerRechts());
	}
}
