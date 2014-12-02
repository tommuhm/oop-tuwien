
public abstract class Strategie {

	private static int strategieCounter = 0;

	public static Strategie getNextStrategie() {
		Strategie strategie;
		switch (strategieCounter) {
			case 0:
				strategie = new StrategieImUhrzeigersinn();
				break;
			case 1:
				strategie = new StrategieGegenUhrzeigersinn();
				break;
			case 2:
				strategie = new StrategieRandom();
				break;
			default:
				strategie = new StrategieRandom();
				break;
		}
		strategieCounter = (strategieCounter + 1) % 3;
		return strategie;
	}

	//rm Conditions: kammer.getY() >= 0 			 		&& labyrinth.length > 0  			&& labyrinth[0].length > 0 // x length > 0

	public abstract Feld naechsteKammer(Feld[][] labyrinth, Feld feld);

	public Feld checkOben(Feld[][] labyrinth, Feld feld) {
		if (  //stepOne: check if kammer in borders
				feld.getY() > 0 && // there is actually a field above
						feld.getY() < (labyrinth.length) &&// kammer still in borders

						//stepTwo: check if there's a wall
						!feld.hatMauerOben() &&

						//stepThree: check if there are already two ants
						labyrinth[feld.getY() - 1][feld.getX()].hatPlatz())
			return labyrinth[feld.getY() - 1][feld.getX()];
		return null;
	}

	public Feld checkRechts(Feld[][] labyrinth, Feld feld) {
		if (  //stepOne: check if kammer in borders
				feld.getX() >= 0 &&
						feld.getX() < (labyrinth[0].length - 1) &&

						//stepTwo: check if there's a wall
						!feld.hatMauerRechts() &&

						//stepThree: check if there are already two ants
						labyrinth[feld.getY()][feld.getX() + 1].hatPlatz())
			return labyrinth[feld.getY()][feld.getX() + 1];
		return null;
	}

	public Feld checkLinks(Feld[][] labyrinth, Feld feld) {
		if (  //stepOne: check if kammer in borders
				feld.getX() > 0 &&
						feld.getX() < (labyrinth[0].length) &&

						//stepTwo: check if there's a wall
						!labyrinth[feld.getY()][feld.getX() - 1].hatMauerRechts() && // kammer.isMauerLinks

						//stepThree: check if there are already two ants
						labyrinth[feld.getY()][feld.getX() - 1].hatPlatz())
			return labyrinth[feld.getY()][feld.getX() - 1];
		return null;
	}

	public Feld checkUnten(Feld[][] labyrinth, Feld feld) {
		if (  //stepOne: check if kammer in borders
				feld.getY() >= 0 &&
						feld.getY() < (labyrinth.length - 1) &&

						//stepTwo: check if there's a wall
						!labyrinth[feld.getY() + 1][feld.getX()].hatMauerOben() && // kammer.isMauerUnten

						//stepThree: check if there are already two ants
						labyrinth[feld.getY() + 1][feld.getX()].hatPlatz())
			return labyrinth[feld.getY() + 1][feld.getX()];
		return null;
	}
}
