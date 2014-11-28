import java.util.Random;

public class Ameise extends Thread {

	private static final long stackSize = 16000;
	private static long ameiseNr = 0;

	private Kammer[][] labyrinth;
	private Kammer ameisenkolonie;
	private Strategie strategie;

	public Ameise(Kammer[][] labyrinth, Kammer ameisenkolonie, Strategie strategie) {
		super(null, null, "Ameise-" + ameiseNr++, stackSize);
		this.labyrinth = labyrinth;
		this.ameisenkolonie = ameisenkolonie;
		this.strategie = strategie;
	}

	public void run() {
		System.out.println("Test");
	}


	public void pause() throws InterruptedException {
		Random rand = new Random();
		int waitTime = rand.nextInt(15)+5;
		this.sleep(waitTime);
	}

}
