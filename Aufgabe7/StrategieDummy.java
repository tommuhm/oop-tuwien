public class StrategieDummy implements Strategie {

	@Override
	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) {
		Kammer temp;

		int i = (int) (Math.random() * 4);

		if (i == 0) {
			// Eines nach links.
			if (kammer.getX() > 0 && labyrinth.length > 0
					&& labyrinth[0].length > 0) {
				temp = labyrinth[kammer.getY()][kammer.getX() - 1];
				if (!temp.isMauerRechts() && temp.getAmeisencounter() < 2) {
					return temp;
				}
			}
			i++;
		}

		if (i == 1) {
			// Eines nach rechts.
			if (!kammer.isMauerRechts()
					&& !labyrinth[kammer.getY()][kammer.getX()].isMauerRechts()
					&& labyrinth.length > 0 && labyrinth[0].length > 0
					&& kammer.getX() < (labyrinth[0].length - 1)) {
				temp = labyrinth[kammer.getY()][kammer.getX() + 1];
				if (temp.getAmeisencounter() < 2) {
					return temp;
				}
			}
			i++;
		}

		if (i == 2) {
			// Eines nach oben.
			if (!kammer.isMauerOben()
					&& !labyrinth[kammer.getY()][kammer.getX()].isMauerOben()
					&& kammer.getY() > 0 && labyrinth.length > 0) {
				temp = labyrinth[kammer.getY() - 1][kammer.getX()];
				if (temp.getAmeisencounter() < 2) {
					return temp;
				}
			}
			i++;
		}

		if (i == 3) {
			if (kammer.getY() >= 0 && kammer.getY() < (labyrinth.length - 1)) {
				temp = labyrinth[kammer.getY() + 1][kammer.getX()];
				if (!temp.isMauerOben() && temp.getAmeisencounter() < 2) {
					return temp;
				}
			}
		}

		return null;
	}

	public void sleep(int n) throws InterruptedException {
		try {
			Thread.sleep(n);
		} catch (InterruptedException ex) {
			System.out
					.println("InterruptedException occured in StrategieInferior");
		}
	}
}
