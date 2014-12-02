
public abstract class Strategie {

	private static int strategieCounter = 0;

	public static Strategie getNextStrategie() {
		Strategie strategie;
		switch (strategieCounter) {
			case 0:
				strategie = new StrategieInferiorUhrzeigersinn();
				break;
			case 1:
				strategie = new StrategieInferiorGegenUhrzeigersinn();
				break;
			case 2:
				strategie = new StrategieSuperiorRandom();
				break;
			default:
				strategie = new StrategieSuperiorRandom();
				break;
		}
		strategieCounter = (strategieCounter+1) % 4;
		return strategie;
	}

	//rm Conditions: kammer.getY() >= 0 			 		&& labyrinth.length > 0  			&& labyrinth[0].length > 0 // x length > 0

	public abstract Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer);

	public Kammer checkOben(Kammer[][] labyrinth, Kammer kammer) {
		if (	//stepOne: check if kammer in borders
				kammer.getY() > 0 // there is actually a field above
				&& kammer.getY() < (labyrinth.length) // kammer still in borders

				//stepTwo: check if there's a wall
				&& !kammer.isMauerOben()

				//stepThree: check if there are already two ants
				&& labyrinth[kammer.getY() - 1][kammer.getX()].getAmeisencounter() < 2) 
			return labyrinth[kammer.getY() - 1][kammer.getX()];
		return null;
	}

	public Kammer checkRechts(Kammer[][] labyrinth, Kammer kammer) {
		if (	//stepOne: check if kammer in borders
				kammer.getX() >= 0
				&& kammer.getX() < (labyrinth[0].length - 1)

				//stepTwo: check if there's a wall
				&& !kammer.isMauerRechts()
				
				//stepThree: check if there are already two ants
				&& labyrinth[kammer.getY()][kammer.getX() + 1].getAmeisencounter() < 2)
			return labyrinth[kammer.getY()][kammer.getX() + 1];
		return null;
	}

	public Kammer checkLinks(Kammer[][] labyrinth, Kammer kammer) {
		if (	//stepOne: check if kammer in borders
				kammer.getX() > 0
				&& kammer.getX() < (labyrinth[0].length)

				//stepTwo: check if there's a wall
				&& !labyrinth[kammer.getY()][kammer.getX() - 1].isMauerRechts() // kammer.isMauerLinks

				//stepThree: check if there are already two ants
				&& labyrinth[kammer.getY()][kammer.getX() - 1].getAmeisencounter() < 2) 
			return labyrinth[kammer.getY()][kammer.getX() - 1];
		return null;
	}

	public Kammer checkUnten(Kammer[][] labyrinth, Kammer kammer) {
		if (	//stepOne: check if kammer in borders
				kammer.getY() >= 0
				&& kammer.getY() < (labyrinth.length - 1)

				//stepTwo: check if there's a wall
				&& !labyrinth[kammer.getY() + 1][kammer.getX()].isMauerOben() // kammer.isMauerUnten

				//stepThree: check if there are already two ants
				&& labyrinth[kammer.getY() + 1][kammer.getX()].getAmeisencounter() < 2) 
			return labyrinth[kammer.getY() + 1][kammer.getX()];
		return null;
	}
}
