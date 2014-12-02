import java.util.ArrayList;


public class Controller {

	private Feld[][] labyrinth;
	private Feld ameisenkolonie;
	private Feld futterstelle;
	private ArrayList<Ameise> ameisen;
	private int groesse;

	public Controller(Feld[][] labyrinth, Feld ameisenkolonie, Feld futterstelle) {
		this.labyrinth = labyrinth;
		this.ameisenkolonie = ameisenkolonie;
		this.futterstelle = futterstelle;
		this.groesse = labyrinth.length * labyrinth[0].length; //Labyrinth != null!!!!!!
		this.ameisen = new ArrayList<Ameise>();
	}

	public void start() {

		Ameise leitameise = new Leitameise(labyrinth, ameisenkolonie, new StrategieRandom(), groesse * 2);
		ameisenkolonie.addAmeise(leitameise);
		ameisen.add(leitameise); // TODO ?

		synchronized (leitameise) {
			leitameise.start();

			while (true) {
				try {
					if (leitameise.getState() == Thread.State.TERMINATED) {

						System.out.println(leitameise.toString());
						for (Ameise ameise : ameisen) {
							ameise.interrupt();
							System.out.println(ameise.toString());
						}

						return;
					} else {
						leitameise.wait();

						if (ameisen.size() < (groesse / 10)) {
							Ameise neueAmeise = new Ameise(this.labyrinth, this.ameisenkolonie, Strategie.getNextStrategie());
							ameisen.add(neueAmeise);
							neueAmeise.start();
						}

						this.printLabyrinth();
						leitameise.notify();
					}

				} catch (InterruptedException e) {
					System.err.println("Im Controller wurde eine Exception geworfen.");
					e.printStackTrace();
				}
			}
		}
	}

	private void printAmeisen() {
		for (Ameise ameise : ameisen) {
			ameise.interrupt();
			System.out.println(ameise.toString());
		}
	}

	// TODO how to sync???!
	public synchronized void printLabyrinth() {
		//synchronized (labyrinth) {
		for (int y = 0; y < labyrinth.length; y++) {
			//synchronized (labyrinth[y]) {
			for (int x = 0; x < labyrinth[y].length; x++) {
				if (y != 0) {
					if (labyrinth[y][x].isMauerOben()) {
						System.out.print("--");
					} else {
						System.out.print("  ");
					}
				}
			}
			System.out.println();

			for (int x = 0; x < labyrinth[y].length; x++) {
				System.out.print(labyrinth[y][x].getDosis());
				if (labyrinth[y][x].isMauerRechts()) {
					System.out.print("|");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
