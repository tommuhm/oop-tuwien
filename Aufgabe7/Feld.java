import java.util.concurrent.atomic.AtomicInteger;


public class Feld {

	private final int x;
	private final int y;
	private AtomicInteger dosis;
	private AtomicInteger ameisencounter;
	private boolean mauerOben;
	private boolean mauerRechts;
	//Invariante: x muss zwischen 0 und der Breite von Feld[][] sein.
	//Invariante: y muss zwischen 0 und der Höhe von Feld[][] sein.
	//Invariante: dosis darf nicht negativ werden.
	//Invariante: ameisencounter muss zwischen 0 und 2 sein.

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

	//Vorbedingung: Dosis ist true wenn eine Dosis hinzugefügt werden soll; sonst false.
	//Nachbedingung: ameisencounter wird um 1 erhöht falls ameisencounter 0 oder 1 ist.
	//Nachbedingung: dosis wird um 1 erhöht falls ameisencounter erhöht wurde
	//Nachbedingung: Gibt true zurück falls dosis und ameisencounter erhöht wurden, sonst false.
	public synchronized boolean addAmeise(boolean dosis) { //TODO addDosis.
		if (this.ameisencounter.get() < 2) {
			this.ameisencounter.incrementAndGet();
			if(dosis) {
				this.dosis.incrementAndGet();
			}
			return true;
		}
		return false;
	}

	//Nachbedingung: ameisencounter wird um 1 verringert, sollte ameisencounter 1 oder 2 sein.
	//Nachbedingung: Gibt true zurück falls ameisencounter verringert wurde, sonst false.
	public synchronized boolean removeAmeise() {
		if (this.ameisencounter.get() > 0) {
			this.ameisencounter.decrementAndGet();
			return true;
		}
		return false;
	}

	//Nachbedingung: Gibt true zurück wenn ameisencounter kleiner als 2 ist, sonst false.
	public boolean hatPlatz() {
		return ameisencounter.intValue() < 2;
	}

	//Nachbedingung: Gibt mauerOben zurück.
	public boolean hatMauerOben() {
		return mauerOben;
	}

	//Nachbedingung: Gibt mauerRechts zurück.
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
