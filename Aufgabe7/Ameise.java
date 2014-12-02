import java.util.Random;

public class Ameise extends Thread {

	private static final long stackSize = 16000;
	private static long ameiseNr = 0;

	private final int maxDosis;

	private Strategie strategie;
	private Kammer[][] labyrinth;
	private Kammer ameisenkolonie;
	private Kammer curKammer;
	private int dosis;
	private boolean leitameise;

	public Ameise(Kammer[][] labyrinth, Kammer ameisenkolonie, Strategie strategie) {
		super(null, null, "Ameise-" + ameiseNr++, stackSize);
		this.labyrinth = labyrinth;
		this.strategie = strategie;
		this.ameisenkolonie = ameisenkolonie;
		this.curKammer = ameisenkolonie;
		this.maxDosis = labyrinth.length * labyrinth[0].length; // TODO calc dosis?
		this.dosis = maxDosis;
		this.leitameise = false;
	}

	public Ameise(Kammer[][] labyrinth, Kammer ameisenkolonie, Strategie strategie, boolean leitameise) {
		this(labyrinth, ameisenkolonie, strategie);
		this.leitameise = leitameise;
	}

	@Override
	public void run() {
		try {
			while (dosis > 0) {
				pause();
				move();

				if (leitameise) {
					synchronized (this) {
						notify();
						wait();
					}
				}
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptedException " + e.getMessage());
			//e.printStackTrace();
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

	@Override
	public String toString() {
		return getName() + ", X: " + curKammer.getX() + ", Y: " + curKammer.getY();
	}

}
