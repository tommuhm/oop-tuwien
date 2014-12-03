import java.util.ArrayList;


public class Controller {

	private ArrayList<Ameise> ameisen;
	private final Labyrinth labyrinth;
	private final int anzahlZuege;
	private final int maxDosis;

	public Controller(Labyrinth labyrinth, int maxDosis, int anzahlZuege) {
		this.labyrinth = labyrinth;
		this.ameisen = new ArrayList<Ameise>();
		this.anzahlZuege = anzahlZuege;
		this.maxDosis = maxDosis;
	}

	public void start() {

		Ameise leitameise = new Ameise(labyrinth, new StrategieRandom(), maxDosis, anzahlZuege, true);

		synchronized (leitameise) {
			leitameise.start();

			while (true) {
				try {
					if (leitameise.getState() == Thread.State.TERMINATED) {

						for (Ameise ameise : ameisen) {
							ameise.interrupt();
						}

						System.out.println(leitameise);
						for (Ameise ameise : ameisen) {
							System.out.println(ameise);
						}

						break;
					} else {
						leitameise.wait();

						if (ameisen.size() < (labyrinth.getCols() * labyrinth.getCols() / 10) && labyrinth.getAmeisenkolonie().hatPlatz()) {
							Ameise neueAmeise = new Ameise(this.labyrinth, Strategie.getNextStrategie(), maxDosis, anzahlZuege, false);
							ameisen.add(neueAmeise);
							neueAmeise.start();
						}

						System.out.println("####################");
						System.out.println(labyrinth);
						leitameise.notify();
					}
				} catch (InterruptedException e) {
					System.err.println("Im Controller wurde eine Exception geworfen.");
					e.printStackTrace();
				}
			}
		}
	}

}
