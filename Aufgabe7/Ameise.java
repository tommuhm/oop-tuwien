import java.util.Random;

public class Ameise extends Thread {

	private static final long stackSize = 16000;
	private static long ameiseNr = 0;

	private final int maxDosis;

	private Strategie strategie;
	private Labyrinth labyrinth;
	private Feld curFeld;
	private int dosis;
	private int anzahlZuege;
	private boolean leitameise;

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

	private void pause() throws InterruptedException {
		Random rand = new Random();
		int waitTime = rand.nextInt(15) + 5;
		this.sleep(waitTime);
	}

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
	public String toString() {
		return getName() + " (x: " + curFeld.getX() + ", y: " + curFeld.getY() + ")";
	}

}
