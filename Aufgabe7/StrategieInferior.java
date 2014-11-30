import java.util.Random;


public class StrategieInferior implements Strategie {

	//>>zuerst nach oben, dann rechts, dann unten, dann links.<< loops may be included since this is inferior

	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) throws InterruptedException { // TODO synchronized?
		Random random = new Random();

		while (labyrinth[kammer.getY()][kammer.getX() + 1].getAmeisencounter() < 2 // sleep zug lang bis feld frei ist. 
				&& labyrinth[kammer.getY()][kammer.getX() - 1].getAmeisencounter() < 2
				&& labyrinth[kammer.getY() - 1][kammer.getX()].getAmeisencounter() < 2
				&& labyrinth[kammer.getY()][kammer.getX() + 1].getAmeisencounter() < 2) {
			sleep(random.nextInt(15) + 5); // TODO do not execute in synchronized -> manual // TODO lock labyrinth maybe?
		}

		if (!kammer.isMauerOben()
				&& !labyrinth[kammer.getY()][kammer.getX()].isMauerOben()
				&& labyrinth.length > 0 
				&& labyrinth[1].length > 0
				&& kammer.getY() > 0 // TODO check that with teammates
				&& kammer.getY() < (labyrinth[1].length - 1)
				&& labyrinth[kammer.getY() + 1][kammer.getX()].getAmeisencounter() < 2) { //WTH? -1 @ Dummy?
			return labyrinth[kammer.getY() + 1][kammer.getX()]; //WTH? -1 @ Dummy?

		} else if (!kammer.isMauerRechts()
				&& !labyrinth[kammer.getY()][kammer.getX()].isMauerRechts()
				&& labyrinth.length > 0
				&& labyrinth[0].length > 0
				&& kammer.getX() > 0 // TODO check that with teammates
				&& kammer.getX() < (labyrinth[0].length - 1)
				&& labyrinth[kammer.getY()][kammer.getX() + 1].getAmeisencounter() < 2) {
			return labyrinth[kammer.getY()][kammer.getX() + 1];

		} else if (!labyrinth[kammer.getY() - 1][kammer.getX()].isMauerOben() // kammer.isMauerUnten
				&& labyrinth.length > 0
				&& labyrinth[1].length > 0
				&& kammer.getY() > 0 // TODO check that with teammates
				&& kammer.getY() < (labyrinth[1].length - 1)
				&& labyrinth[kammer.getY() - 1][kammer.getX()].getAmeisencounter() < 2) {
			return labyrinth[kammer.getY() - 1][kammer.getX()];

		} else if (!labyrinth[kammer.getY()][kammer.getX() - 1].isMauerRechts() // kammer.isMauerLinks
				&& labyrinth.length > 0
				&& labyrinth[0].length > 0
				&& kammer.getX() > 0 // TODO check that with teammates
				&& kammer.getX() < (labyrinth[0].length - 1)
				&& labyrinth[kammer.getY()][kammer.getX() - 1].getAmeisencounter() < 2) {
			return labyrinth[kammer.getY()][kammer.getX() - 1];

		} return naechsteKammer(labyrinth, kammer); //should never happen
	}


	public void sleep(int n) throws InterruptedException {
		try {
			Thread.sleep(n);
		} catch(InterruptedException ex) {
			System.out.println("InterruptedException occured in StrategieInferior");
		}
	}
}
