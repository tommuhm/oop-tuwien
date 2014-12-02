public class StrategieDummy extends Strategie {

	@Override
	public Feld naechstesFeld(Feld[][] labyrinth, Feld feld) {
		Feld temp;

		int i = (int) (Math.random() * 4);

		if (i == 0) {
			// Eines nach links.
			if (feld.getX() > 0 && labyrinth.length > 0
					&& labyrinth[0].length > 0) {
				temp = labyrinth[feld.getY()][feld.getX() - 1];
				if (!temp.hatMauerRechts() && temp.hatPlatz()) {
					return temp;
				}
			}
			i++;
		}

		if (i == 1) {
			// Eines nach rechts.
			if (!feld.hatMauerRechts()
					&& !labyrinth[feld.getY()][feld.getX()].hatMauerRechts()
					&& labyrinth.length > 0 && labyrinth[0].length > 0
					&& feld.getX() < (labyrinth[0].length - 1)) {
				temp = labyrinth[feld.getY()][feld.getX() + 1];
				if (temp.hatPlatz()) {
					return temp;
				}
			}
			i++;
		}

		if (i == 2) {
			// Eines nach oben.
			if (!feld.hatMauerOben()
					&& !labyrinth[feld.getY()][feld.getX()].hatMauerOben()
					&& feld.getY() > 0 && labyrinth.length > 0) {
				temp = labyrinth[feld.getY() - 1][feld.getX()];
				if (temp.hatPlatz()) {
					return temp;
				}
			}
			i++;
		}

		if (i == 3) {
			if (feld.getY() >= 0 && feld.getY() < (labyrinth.length - 1)) {
				temp = labyrinth[feld.getY() + 1][feld.getX()];
				if (!temp.hatMauerOben() && temp.hatPlatz()) {
					return temp;
				}
			}
		}

		return null;
	}
}
