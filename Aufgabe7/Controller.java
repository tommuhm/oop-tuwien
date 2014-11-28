
public class Controller {
	
	private Kammer[][] labyrinth;
	private Kammer ameisenkolonie;
	private Kammer futterstelle;
	private int groesse;
	
	public Controller(Kammer[][] labyrinth, Kammer ameisenkolonie, Kammer futterstelle) {
		this.labyrinth = labyrinth;
		this.ameisenkolonie = ameisenkolonie;
		this.futterstelle = futterstelle;
		this.groesse = labyrinth.length * labyrinth[0].length; //Labyrinth != null!!!!!!
	}
	
	public void start() {
		Ameise leitameise = new Ameise(labyrinth, ameisenkolonie, new StrategieDummy(), true);
		ameisenkolonie.addAmeise(leitameise);
		
		synchronized (leitameise) {
			leitameise.start();
			
			
			while(true) {
				try {
						leitameise.wait(); //Wait until leitameise says go!
						
						Ameise neueAmeise = new Ameise(this.labyrinth, this.ameisenkolonie, new StrategieDummy());
						if(ameisenkolonie.addAmeise(neueAmeise)) {
							System.out.println("Neue Ameise hinzugefügt.");
						} else {
							System.out.println("Neue Ameise NICHT hinzugefügt.");
						}	
						neueAmeise.start();
						
						System.out.println("Ameise hat genotified. >:^|");
						Thread.sleep(1000);
						leitameise.notifyAll();
						
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
		}
	}
	
}
