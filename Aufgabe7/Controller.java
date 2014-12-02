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
		Ameise leitameise = new Ameise(labyrinth, ameisenkolonie, new StrategieSuperiorRandom(), true);
		ameisenkolonie.addAmeise(leitameise);
		//ameisen.add(leitameise);
		
		synchronized (leitameise) {
			leitameise.start();
			
			
			while(true) {
				try {
						if(leitameise.getDosis() <= 0) {
							
							leitameise.interrupt();
							System.out.println("Leitameise: (" + leitameise.getCurKammer().getX() + "|" + leitameise.getCurKammer().getY() + ")");
							for(Ameise temp : ameisen) {
								temp.interrupt();
								System.out.println("Ameise: (" + temp.getCurKammer().getX() + "|" + temp.getCurKammer().getY() + ")");
							}
							return;
						} else {
							leitameise.wait();
						
							System.out.println(ameisen.size() + " < " + (groesse/10) + " = " + (ameisen.size() < (groesse/10)));
							if(ameisen.size() < (groesse/10)) {
								Ameise neueAmeise = new Ameise(this.labyrinth, this.ameisenkolonie, new StrategieSuperiorRandom());
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
