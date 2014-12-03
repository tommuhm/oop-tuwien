import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;


public class Feld {

	private final int x;
	private final int y;
	private AtomicInteger dosis;
	private AtomicInteger ameisencounter;
	private boolean mauerOben;
	private boolean mauerRechts;
	private ReentrantLock lock;
	// Invariante: x muss zwischen 0 und der Breite von Feld[][] sein.
	// Invariante: y muss zwischen 0 und der Hoehe von Feld[][] sein.
	// Invariante: dosis darf nicht negativ werden.
	// Invariante: ameisencounter muss zwischen 0 und 2 sein.

	public Feld(int x, int y) {
		this.x = x;
		this.y = y;

		this.dosis = new AtomicInteger();
		this.ameisencounter = new AtomicInteger();
		this.dosis.set(0);
		this.ameisencounter.set(0);

		this.mauerOben = false;
		this.mauerRechts = false;

		this.lock = new ReentrantLock();
	}

	public Feld(int x, int y, boolean mauerOben, boolean mauerRechts) {
		this(x, y);
		this.mauerOben = mauerOben;
		this.mauerRechts = mauerRechts;
	}


	// Vorbedingung: Dosis ist true wenn eine Dosis hinzugefuegt werden soll; sonst false.
	// Nachbedingung: Gibt false zurueck wenn der Feld gelocket ist
	// Nachbedingung: ameisencounter wird um 1 erhoeht falls ameisencounter 0 oder 1 ist.
	// Nachbedingung: dosis wird um 1 erhoeht falls ameisencounter erhoeht wurde
	// Nachbedingung: Gibt true zurueck falls ameisencounter erhoeht wurde, sonst false.
	public synchronized boolean addAmeise(boolean dosis) {
		if (!lock.isLocked()) {
			if (this.hatPlatz()) {
				this.ameisencounter.incrementAndGet();
				if (dosis) {
					this.dosis.incrementAndGet();
				}
				return true;
			}
		}
		return false;
	}

	// Nachbedingung: Gibt false zurueck wenn der Feld gelocket ist
	// Nachbedingung: ameisencounter wird um 1 verringert, sollte ameisencounter 1 oder 2 sein.
	// Nachbedingung: Gibt true zurueck falls ameisencounter verringert wurde, sonst false.
	public synchronized boolean removeAmeise() {
		if (!lock.isLocked()) {
			if (this.ameisencounter.get() > 0) {
				this.ameisencounter.decrementAndGet();
				return true;
			}
		}
		return false;
	}

	// Nachbedingung: blockiert das Feld damit keine Aenderungen gemacht werden koennen
	public synchronized void lock() {
		lock.lock();
	}

	// Nachbedingung: gibt das aktuelle Feld wieder fuer Aenderungen frei
	public synchronized void unlock() {
		lock.unlock();
	}

	// Nachbedingung: Gibt an ob auf dem Feld noch Platz fuer weitere Ameisen ist (max 2 Ameisen pro Feld)
	public boolean hatPlatz() {
		return ameisencounter.intValue() < 2;
	}

	// Nachbedingung: Gibt an ob das Feld an der oberen Seite eine Mauer hat
	public boolean hatMauerOben() {
		return mauerOben;
	}

	// Nachbedingung: Gibt an ob das Feld an der rechten Seite eine Mauer hat
	public boolean hatMauerRechts() {
		return mauerRechts;
	}

	// Nachbedinung: Gibt die x Koordinate des Feldes zurueck
	public int getX() {
		return x;
	}

	// Nachbedinung: Gibt die x Koordinate des Feldes zurueck
	public int getY() {
		return y;
	}

	// Nachbedinung: Gibt die aktuelle Dosis des Feldes zureck
	public int getDosis() {
		return dosis.get();
	}

}
