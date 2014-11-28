import java.util.concurrent.atomic.AtomicInteger;


public class Kammer {
	
	private AtomicInteger dosis;
	private AtomicInteger ameisencounter;
	private boolean mauerOben;
	private boolean mauerRechts;
	private boolean futterstelle;
	private boolean startpunkt;
	
	public Kammer() {
		this.dosis = new AtomicInteger();
		this.ameisencounter = new AtomicInteger();
		this.dosis.set(0);
		this.ameisencounter.set(0);
		
		this.mauerOben = false;
		this.mauerRechts = false;	
		this.futterstelle = false;
		this.startpunkt = false;
	}
	
	public Kammer(boolean mauerOben, boolean mauerRechts) {
		this();
		this.mauerOben = mauerOben;
		this.mauerRechts = mauerRechts;
	}
	
	public Kammer(boolean mauerOben, boolean mauerRechts, boolean startpunkt, boolean futterstelle) {
		this(mauerOben, mauerRechts);
		this.startpunkt = startpunkt;
		this.futterstelle = futterstelle;
	}
	
	public synchronized boolean addAmeise(Ameise ameise) { //TODO addDosis.
		if(this.ameisencounter.get() < 2) {
			this.ameisencounter.incrementAndGet();
			this.addDosis(ameise.getDosis());
			return true;
		}
		return false;
	}
	
	private void addDosis (int dosis) {
		this.dosis.addAndGet(dosis);
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

	public boolean isStartpunkt() {
		return startpunkt;
	}
	
	
}
