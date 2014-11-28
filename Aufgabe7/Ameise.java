import java.util.Random;

public class Ameise extends Thread {

	private static final long stackSize = 16000;
	private static long ameiseNr = 0;

	private Strategie strategie;
	private Kammer[][] labyrinth;
	private Kammer ameisenkolonie;
	private Kammer curKammer;
	private int dosis;

	public Ameise(Kammer[][] labyrinth, Kammer ameisenkolonie, Strategie strategie) {
		super(null, null, "Ameise-" + ameiseNr++, stackSize);
		this.labyrinth = labyrinth;
		this.strategie = strategie;
		this.ameisenkolonie = ameisenkolonie;
		this.curKammer = ameisenkolonie;
		this.dosis = labyrinth.length * labyrinth[0].length; // TODO calc dosis?
	}

	public void run() {

		try {

			while (dosis > 0) {
				pause();

				move();


			}

		} catch (InterruptedException e) {
			System.out.println("InterruptedException " + e.getMessage());
//			e.printStackTrace();
		}


		System.out.println("Test");
	}


	private void pause() throws InterruptedException {
		Random rand = new Random();
		int waitTime = rand.nextInt(15)+5;
		this.sleep(waitTime);
	}

	private void move() {
		boolean moved = false;
		while (!moved) {
			Kammer kammer = strategie.naechsteKammer(labyrinth, curKammer);
			moved = kammer.addAmeise(this);
			if (moved) {
				dosis--;
				curKammer.removeAmeise();
				curKammer = kammer;
			}
		}
	}

}
