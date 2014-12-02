import java.util.concurrent.atomic.AtomicInteger;


public class Feld {

	private final int x;
	private final int y;
	private AtomicInteger dosis;
	private AtomicInteger ameisencounter;
	private boolean mauerOben;
	private boolean mauerRechts;

	public Feld(int x, int y) {
		this.x = x;
		this.y = y;

		this.dosis = new AtomicInteger();
		this.ameisencounter = new AtomicInteger();
		this.dosis.set(0);
		this.ameisencounter.set(0);

		this.mauerOben = false;
		this.mauerRechts = false;
	}

	public Feld(int x, int y, boolean mauerOben, boolean mauerRechts) {
		this(x, y);
		this.mauerOben = mauerOben;
		this.mauerRechts = mauerRechts;
	}

	public synchronized boolean addAmeise(int dosis) { //TODO addDosis.
		if (this.ameisencounter.get() < 2) {
			this.ameisencounter.incrementAndGet();
			this.dosis.set(this.dosis.get() + dosis);
			return true;
		}
		return false;
	}

	public synchronized boolean removeAmeise() {
		if (this.ameisencounter.get() > 0) {
			this.ameisencounter.decrementAndGet();
			return true;
		}
		return false;
	}

	public boolean hatPlatz() {
		return ameisencounter.intValue() < 2;
	}

	public boolean hatMauerOben() {
		return mauerOben;
	}

	public boolean hatMauerRechts() {
		return mauerRechts;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDosis() {
		return dosis.get();
	}

}
