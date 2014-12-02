public class StrategieDummy extends Strategie {

	public Feld naechsteKammer(Feld[][] labyrinth, Feld feld) {
		Feld temp;

		int i = (int) (Math.random() * 4);

		if (i == 0) {
			// Eines nach links.
			if (feld.getX() > 0 && labyrinth.length > 0
					&& labyrinth[0].length > 0) {
				temp = labyrinth[feld.getY()][feld.getX() - 1];
				if (!temp.isMauerRechts() && temp.getAmeisencounter() < 2) {
					return temp;
				}
			}
			i++;
		}

		if (i == 1) {
			// Eines nach rechts.
			if (!feld.isMauerRechts()
					&& !labyrinth[feld.getY()][feld.getX()].isMauerRechts()
					&& labyrinth.length > 0 && labyrinth[0].length > 0
					&& feld.getX() < (labyrinth[0].length - 1)) {
				temp = labyrinth[feld.getY()][feld.getX() + 1];
				if (temp.getAmeisencounter() < 2) {
					return temp;
				}
			}
			i++;
		}

		if (i == 2) {
			// Eines nach oben.
			if (!feld.isMauerOben()
					&& !labyrinth[feld.getY()][feld.getX()].isMauerOben()
					&& feld.getY() > 0 && labyrinth.length > 0) {
				temp = labyrinth[feld.getY() - 1][feld.getX()];
				if (temp.getAmeisencounter() < 2) {
					return temp;
				}
			}
			i++;
		}

		if (i == 3) {
			if (feld.getY() >= 0 && feld.getY() < (labyrinth.length - 1)) {
				temp = labyrinth[feld.getY() + 1][feld.getX()];
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
