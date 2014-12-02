import java.util.concurrent.atomic.AtomicInteger;


public class Kammer {

	private final int x;
	private final int y;
	private AtomicInteger dosis;
	private AtomicInteger ameisencounter;
	private boolean mauerOben;
	private boolean mauerRechts;
	private boolean futterstelle;
	private boolean ameisenkolonie;
	
	public Kammer(int x, int y) {
		this.x = x;
		this.y = y;
		
		this.dosis = new AtomicInteger();
		this.ameisencounter = new AtomicInteger();
		this.dosis.set(0);
		this.ameisencounter.set(0);
		
		this.mauerOben = false;
		this.mauerRechts = false;	
		this.futterstelle = false;
		this.ameisenkolonie = false;
	}
	
	public Kammer(int x, int y, boolean mauerOben, boolean mauerRechts) {
		this(x, y);
		this.mauerOben = mauerOben;
		this.mauerRechts = mauerRechts;
	}
	
	public Kammer(int x, int y, boolean mauerOben, boolean mauerRechts, boolean ameisenkolonie, boolean futterstelle) {
		this(x, y, mauerOben, mauerRechts);
		this.ameisenkolonie = ameisenkolonie;
		this.futterstelle = futterstelle;
	}
	
	public synchronized boolean addAmeise(Ameise ameise) { //TODO addDosis.
		if(this.ameisencounter.get() < 2) {
			this.ameisencounter.incrementAndGet();
			if(this.dosis.get() < 9) {
				this.dosis.incrementAndGet();
			}
			return true;
		}
		return false;
	}
	
	public synchronized void reduziereDosis() {
		if(this.dosis.get() > 0) {
			this.dosis.decrementAndGet();
		}
	}
	
	public synchronized boolean removeAmeise() {
		if(this.ameisencounter.get() > 0) {
			this.ameisencounter.decrementAndGet();
			return true;
		}
		return false;
	}

	public boolean isFutterstelle() {
		return futterstelle;
	}

	public boolean isAmeisenkolonie() {
		return ameisenkolonie;
	}

	public boolean isMauerOben() {
		return mauerOben;
	}

	public boolean isMauerRechts() {
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

	public int getAmeisencounter() {
		return ameisencounter.get();
	}
	
	
}
