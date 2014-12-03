import java.util.Random;

public class Ameise extends Thread {

	private static final long stackSize = 16000;
	private static long ameiseNr = 0;

	private final int maxDosis;
	private final Strategie strategie;
	private final Labyrinth labyrinth;

	private Feld curFeld;
	private int dosis;
	private int anzahlZuege;
	private boolean leitameise;
	// Invariante: anzahlZuege ist groesser gleich 0
	// Invariante: dosis ist ein wert zwischen 0 und maxDosis
	// Invariante: curFeld ist immer das Feld auf dem sich die Ameise zur Zeit befindet

	// Vorbedinung: labyrinth und strategie darf nicht null sein
	// Vorbedinung: maxDosis und anzahlZuege muessen groesser als 0 sein
	public Ameise(Labyrinth labyrinth, Strategie strategie, int maxDosis, int anzahlZuege, boolean isLeitameise) {
		super(null, null, (isLeitameise ? "Leit" : "") + "Ameise-" + ameiseNr++, stackSize);
		this.labyrinth = labyrinth;
		this.strategie = strategie;
		this.curFeld = labyrinth.getAmeisenkolonie();
		this.maxDosis = maxDosis;
		this.dosis = maxDosis;
		this.anzahlZuege = anzahlZuege;
		this.leitameise = isLeitameise;
		this.curFeld.addAmeise(dosis > 0 ? true : false);
	}

	@Override
	// Nachbedinung: Ameise bewegt sich im labyrinth bis sie keine Zuege mehr zur verfuegen hat, nach jedem Zug ist eine Pause von 5-20ms
	// die Leitameise schickt nach jedem Zug ein Notify an den wartenden Master-Thread
	public void run() {
		try {
			while (anzahlZuege > 0) {
				pause();
				move();

				if (leitameise) {
					synchronized (this) {
						anzahlZuege--;
						notify();
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			this.interrupt();
		}
	}

	// Nachbedinung: der Thread wurde fuer 5-20ms pausiert
	private void pause() throws InterruptedException {
		Random rand = new Random();
		int waitTime = rand.nextInt(15) + 5;
		this.sleep(waitTime);
	}

	// Nachbedinung: die Ameise hat einen Schritt im Labyrinth gemacht und wenn vorhanden einen Duft hinterlassen
	// Die Ameise versucht solange einen Zug zu machen bis, dieser Erfolgreich war oder kein Zug moeglich ist
	// Nach jedem Zug wird die Dosis (falls vorhanden) um 1 reduziert.
	// Sollte das ZielFeld eine Futterstelle oder eine Ameisenkolonie sein, wird die Dosis wieder auf den Maximalwert gesetzt
	private void move() {
		boolean moved = false;
		while (!moved) {
			Feld feldAvailable = strategie.naechstesFeld(labyrinth, curFeld);
			if (feldAvailable == null) {
				break;
			}
			boolean tempDosis = this.dosis > 0 ? true : false;
			moved = feldAvailable.addAmeise(tempDosis);
			if (moved) {
				dosis = dosis - (tempDosis ? 1 : 0);
				curFeld.removeAmeise();
				curFeld = feldAvailable;

				if (curFeld instanceof FeldFutterstelle || curFeld instanceof FeldAmeisenkolonie) {
					dosis = maxDosis;
				}
			}
		}
	}

	@Override
	// Nachbedinung: gibt den Namen des Threads und die Kooridnaten in leserlicher Form zurueck
	public String toString() {
		return getName() + " (x: " + curFeld.getX() + ", y: " + curFeld.getY() + ")";
	}

}
