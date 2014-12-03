import java.util.ArrayList;

public class Controller {

	private ArrayList<Ameise> ameisen;
	private final Labyrinth labyrinth;
	private final int anzahlZuege;
	private final int maxDosis;

	// Vorbedinung: labyrinth ist nicht null
	// Vorbedinung: maxDosis und anzahlZuege ist groesser als 0 und unabhaengig von der groesse des labyrinthes
	public Controller(Labyrinth labyrinth, int maxDosis, int anzahlZuege) {
		this.labyrinth = labyrinth;
		this.ameisen = new ArrayList<Ameise>();
		this.anzahlZuege = anzahlZuege;
		this.maxDosis = maxDosis;
	}

	// startet die Ameisenalgorithmen fuer das labyrinth
	// nach jedem Zug der leitameise wird das komplette labyrinth ausgegeben und wenn moeglich eine neue Ameise in das Labyrinth geschickt
	// sobald eine Ameise mit allen Zuegen fertig ist (Zeiten der Zuege sind zufaellig) wird der Algorithmus abgebrochen
	// und die Koordinaten der Ameisen ausgegeben
	public void start() {
		Ameise leitameise = new Ameise(labyrinth, new StrategieRandom(), maxDosis, anzahlZuege, true);
		ameisen.add(leitameise);

		synchronized (leitameise) {
			leitameise.start();

			while (true) {
				try {

					boolean zuegeDone = false;
					for (Ameise ameise : ameisen) {
						if (ameise.getState() == Thread.State.TERMINATED) {
							zuegeDone = true;
							break;
						}
					}

					if (zuegeDone) {
						for (Ameise ameise : ameisen) {
							ameise.interrupt();
							System.out.println(ameise);
						}
						break;
					} else {
						leitameise.wait();

						if (ameisen.size() < (labyrinth.getCols() * labyrinth.getCols() / 10) && labyrinth.getAmeisenkolonie().hatPlatz()) {
							Ameise neueAmeise = new Ameise(this.labyrinth, Strategie.getRndStrategie(), maxDosis, anzahlZuege, false);
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
