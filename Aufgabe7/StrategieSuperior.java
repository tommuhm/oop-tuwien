import java.util.Random;


public class StrategieSuperior implements Strategie {

	//random direction to start. if direction not available, use next direction clockwise instead of dicing again.

	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) throws InterruptedException { // TODO synchronized?
		Random random = new Random();

		while (labyrinth[kammer.getY()][kammer.getX() + 1].getAmeisencounter() < 2 // sleep zug lang bis feld frei ist. 
				&& labyrinth[kammer.getY()][kammer.getX() - 1].getAmeisencounter() < 2
				&& labyrinth[kammer.getY() - 1][kammer.getX()].getAmeisencounter() < 2
				&& labyrinth[kammer.getY()][kammer.getX() + 1].getAmeisencounter() < 2) {
			sleep(random.nextInt(15) + 5); // TODO do not execute in synchronized -> manual // TODO lock labyrinth maybe?
		}

		return getDirection(labyrinth,kammer, dice());
	}

	private Kammer getDirection(Kammer[][] labyrinth, Kammer kammer, AmeisenRichtung dir) throws InterruptedException {

		switch (dir) {

		case rechts: 
			if (!kammer.isMauerRechts()
					&& !labyrinth[kammer.getY()][kammer.getX()].isMauerRechts()
					&& labyrinth.length > 0
					&& labyrinth[0].length > 0
					&& kammer.getX() > 0 // TODO check that with teammates
					&& kammer.getX() < (labyrinth[0].length - 1)
					&& labyrinth[kammer.getY()][kammer.getX() + 1].getAmeisencounter() < 2) {
				return labyrinth[kammer.getY()][kammer.getX() + 1];

			} return getDirection(labyrinth, kammer, AmeisenRichtung.unten);

		case unten:
			if (!labyrinth[kammer.getY() - 1][kammer.getX()].isMauerOben() // kammer.isMauerUnten
					&& labyrinth.length > 0
					&& labyrinth[1].length > 0
					&& kammer.getY() > 0 // TODO check that with teammates
					&& kammer.getY() < (labyrinth[1].length - 1)
					&& labyrinth[kammer.getY() - 1][kammer.getX()].getAmeisencounter() < 2) {
				return labyrinth[kammer.getY() - 1][kammer.getX()];

			} return getDirection(labyrinth, kammer, AmeisenRichtung.links);

		case links: 
			if (!labyrinth[kammer.getY()][kammer.getX() - 1].isMauerRechts() // kammer.isMauerLinks
					&& labyrinth.length > 0
					&& labyrinth[0].length > 0
					&& kammer.getX() > 0 // TODO check that with teammates
					&& kammer.getX() < (labyrinth[0].length - 1)
					&& labyrinth[kammer.getY()][kammer.getX() - 1].getAmeisencounter() < 2) {
				return labyrinth[kammer.getY()][kammer.getX() - 1];

			} return getDirection(labyrinth, kammer, AmeisenRichtung.oben);

		case oben: 
			if (!kammer.isMauerOben()
					&& !labyrinth[kammer.getY()][kammer.getX()].isMauerOben()
					&& labyrinth.length > 0 
					&& labyrinth[1].length > 0
					&& kammer.getY() > 0 // TODO check that with teammates
					&& kammer.getY() < (labyrinth[1].length - 1)
					&& labyrinth[kammer.getY() + 1][kammer.getX()].getAmeisencounter() < 2) { //WTH? -1 @ Dummy?
				return labyrinth[kammer.getY() + 1][kammer.getX()]; //WTH? -1 @ Dummy?

			} return getDirection(labyrinth, kammer, AmeisenRichtung.rechts);

		default: return naechsteKammer(labyrinth, kammer); //should never happen. may cause a loop
		}
	}


	public AmeisenRichtung dice() {

		double dice = (int) (Math.random() * 4);

		if ( dice == 0 ) {
			return AmeisenRichtung.rechts;
		}
		else if ( dice == 1 ) {
			return AmeisenRichtung.links;
		}
		else if ( dice == 2 ) {
			return AmeisenRichtung.oben;
		}
		else if (dice == 3 ) {
			return AmeisenRichtung.unten;
		} 

		return AmeisenRichtung.rechts; //should never happen.
	}


	public void sleep(int n) throws InterruptedException {
		try {
			Thread.sleep(n);
		} catch(InterruptedException ex) {
			System.out.println("InterruptedException occured in StrategieSuperior");
		}
	}
}
