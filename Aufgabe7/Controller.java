import java.util.ArrayList;


public class Controller {

	private Feld[][] labyrinth;
	private Feld ameisenkolonie;
	private Feld futterstelle;
	private ArrayList<Ameise> ameisen;
	private int groesse;

	public Controller(Feld[][] labyrinth, FeldAmeisenkolonie ameisenkolonie, FeldFutterstelle futterstelle) {
		this.labyrinth = labyrinth;
		this.ameisenkolonie = ameisenkolonie;
		this.futterstelle = futterstelle;
		this.groesse = labyrinth.length * labyrinth[0].length; //Labyrinth != null!!!!!!
		this.ameisen = new ArrayList<Ameise>();
	}

	public void start() {

		Ameise leitameise = new Leitameise(labyrinth, ameisenkolonie, new StrategieRandom(), groesse * 2);
		ameisenkolonie.addAmeise(1);

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

						if (ameisen.size() < (groesse / 10) && ameisenkolonie.hatPlatz()) {
							Ameise neueAmeise = new Ameise(this.labyrinth, this.ameisenkolonie, Strategie.getNextStrategie());
							ameisen.add(neueAmeise);
							ameisenkolonie.addAmeise(1);
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

	// TODO how to sync???!
	public synchronized void printLabyrinth() {
		//synchronized (labyrinth) {

		for (int y = 0; y < labyrinth.length; y++) {
			//synchronized (labyrinth[y]) {
			for (int x = 0; x < labyrinth[y].length; x++) {
				if (y != 0) {
					if (labyrinth[y][x].hatMauerOben()) {
						System.out.print("--");
					} else {
						System.out.print("  ");
					}
				}
			}
			System.out.println();

			for (int x = 0; x < labyrinth[y].length; x++) {
				System.out.print(labyrinth[y][x].getDosis());
				if (labyrinth[y][x].hatMauerRechts()) {
					System.out.print("|");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		System.out.println("##############################################");
	}
}
