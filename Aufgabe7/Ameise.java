import java.util.Random;

public class Ameise extends Thread {

	private static final long stackSize = 16000;
	private static long ameiseNr = 0;

	private final int maxDosis;

	private Strategie strategie;
	private Kammer[][] labyrinth;
	private Kammer curKammer;
	private int dosis;

	public Ameise(Kammer[][] labyrinth, Kammer ameisenkolonie, Strategie strategie) {
		super(null, null, "Ameise-" + ameiseNr++, stackSize);
		this.labyrinth = labyrinth;
		this.strategie = strategie;
		this.curKammer = ameisenkolonie;
		this.maxDosis = labyrinth.length * labyrinth[0].length; // TODO calc dosis?
		this.dosis = maxDosis;
	}

	@Override
	public void run() {
		try {
			while (dosis > 0) {
				pause();
				move();
			}
		} catch (InterruptedException e) {
			System.out.println(this.toString());
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
			Kammer kammer = strategie.naechsteKammer(labyrinth, curKammer);
			if (kammer == null) {
				break;
			}
			moved = kammer.addAmeise(this);
			if (moved) {
				dosis--;
				curKammer.removeAmeise();
				curKammer = kammer;

				if (curKammer.isFutterstelle() || curKammer.isAmeisenkolonie()) {
					dosis = maxDosis;
				}
			}
		}
	}

	public int getDosis() {
		return dosis;
	}

	public Kammer getCurKammer() {
		return curKammer;
	}

	@Override
	public String toString() {
		return getName() + ", X: " + curKammer.getX() + ", Y: " + curKammer.getY();
	}

}
