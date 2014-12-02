import java.util.ArrayList;


public class Controller {
	
	private Kammer[][] labyrinth;
	private Kammer ameisenkolonie;
	private Kammer futterstelle;
	private ArrayList<Ameise> ameisen;
	private int groesse;
	
	public Controller(Kammer[][] labyrinth, Kammer ameisenkolonie, Kammer futterstelle) {
		this.labyrinth = labyrinth;
		this.ameisenkolonie = ameisenkolonie;
		this.futterstelle = futterstelle;
		this.groesse = labyrinth.length * labyrinth[0].length; //Labyrinth != null!!!!!!
		this.ameisen = new ArrayList<Ameise>();
	}
	
	public void start() {

		Ameise leitameise = new Leitameise(labyrinth, ameisenkolonie, new StrategieRandom(), groesse*2);
		ameisenkolonie.addAmeise(leitameise);
		//ameisen.add(leitameise); // TODO ?

		synchronized (leitameise) {
			leitameise.start();

			while(true) {
				try {
						if(leitameise.getState() == Thread.State.TERMINATED) {
							
							leitameise.interrupt();
							System.out.println(leitameise.toString());
							for(Ameise ameise : ameisen) {
								ameise.interrupt();
								System.out.println(ameise.toString());
							}
							return;
						} else {
							leitameise.wait();
						
							System.out.println(ameisen.size() + " < " + (groesse/10) + " = " + (ameisen.size() < (groesse/10)));
							if(ameisen.size() < (groesse/10)) {
								Ameise neueAmeise = new Ameise(this.labyrinth, this.ameisenkolonie, Strategie.getNextStrategie());
								if(ameisenkolonie.addAmeise(neueAmeise)) {
									System.out.println("Neue Ameise hinzugefügt.");
								} else {
									System.out.println("Neue Ameise NICHT hinzugefügt.");
								}	
								
								ameisen.add(neueAmeise);
								neueAmeise.start();
							}
							
							System.out.println("Ameise hat genotified. >:^|");
							this.printLabyrinth();
							leitameise.notifyAll();
						}
						
				} catch (InterruptedException e) {
					System.err.println("Im Controller wurde eine Exception geworfen.");
					e.printStackTrace();
				};
			}
		}
	}
	
	public synchronized void printLabyrinth() {
	//synchronized (labyrinth) {
		int i = 0;
		for(int y = 0; y < labyrinth.length; y++) {
			//synchronized (labyrinth[y]) {
				for(int x = 0; x < labyrinth[y].length; x++) {
					if(y != 0) {
						if(labyrinth[y][x].isMauerOben()) {
							System.out.print("--");
						} else {
							System.out.print("  ");
						}
					}
				}
				System.out.println();
				
				for(int x = 0; x < labyrinth[y].length; x++) {
					System.out.print(labyrinth[y][x].getDosis());
					if(labyrinth[y][x].isMauerRechts()) {
						System.out.print("|");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
				}
			}				
		//}
	//}
	
}
