import java.util.Random;

public class Ameise extends Thread {

	private static final long stackSize = 16000;
	private static long ameiseNr = 0;

	private final int maxDosis;

	private Strategie strategie;
	private Feld[][] labyrinth;
	private Feld curFeld;
	private int dosis;
	private int anzahlZuege;
	private boolean leitameise;

	public Ameise(Feld[][] labyrinth, Feld ameisenkolonie, Strategie strategie, int anzahlZuege, boolean isLeitameise) {
		super(null, null, (isLeitameise ? "Leit" : "") + "Ameise-" + ameiseNr++, stackSize);
		this.labyrinth = labyrinth;
		this.strategie = strategie;
		this.curFeld = ameisenkolonie;
		this.maxDosis = labyrinth.length * labyrinth[0].length; // TODO calc dosis?
		this.dosis = maxDosis;
		this.anzahlZuege = anzahlZuege;
		this.leitameise = isLeitameise;
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
			int tempDosis = this.dosis == 0 ? 0 : 1;
			moved = feldAvailable.addAmeise(dosis);
			if (moved) {
				dosis = dosis - tempDosis;
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
		return getName() + ": (" + curFeld.getX() + "|" + curFeld.getY() + ")";
	}

}
