import java.util.Random;

public class Ameise extends Thread {

	private static final long stackSize = 16000;
	private static long ameiseNr = 0;

	private final int maxDosis;

	private Strategie strategie;
	private Feld[][] labyrinth;
	private Feld curFeld;
	private int dosis;

	public Ameise(Feld[][] labyrinth, Feld ameisenkolonie, Strategie strategie) {
		super(null, null, "Ameise-" + ameiseNr++, stackSize);
		this.labyrinth = labyrinth;
		this.strategie = strategie;
		this.curFeld = ameisenkolonie;
		this.maxDosis = labyrinth.length * labyrinth[0].length; // TODO calc dosis?
		this.dosis = maxDosis;
	}

	@Override
	public void run() {
		try {
			while (dosis > 0) {
				next();
			}
		} catch (InterruptedException e) {
			this.interrupt();
		}
	}

	protected void next() throws InterruptedException {
		pause();
		move();
	}

	private void pause() throws InterruptedException {
		Random rand = new Random();
		int waitTime = rand.nextInt(15) + 5;
		this.sleep(waitTime);
	}

	private void move() {
		boolean moved = false;
		while (!moved) {
			Feld feld = strategie.naechsteKammer(labyrinth, curFeld);
			if (feld == null) {
				break;
			}
			if (dosis > 0) {
				moved = feld.addAmeise(1);
			} else {
				moved = feld.addAmeise(0);
			}
			if (moved) {
				dosis--;
				curFeld.removeAmeise();
				curFeld = feld;

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
