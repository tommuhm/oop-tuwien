
public abstract class Strategie {

	//rm Conditions: kammer.getY() >= 0 			 		&& labyrinth.length > 0  			&& labyrinth[0].length > 0 // x length > 0

	public abstract Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer);
	
	public boolean checkRichtung(Kammer[][] labyrinth, Kammer kammer) {
		if (	// check ob min ein zug frei ist
				kammer.getX() > 0
				&& kammer.getY() > 0
				&& kammer.getX() < labyrinth[0].length
				&& kammer.getY() < labyrinth.length
				&& labyrinth[kammer.getY()][kammer.getX() - 1].getAmeisencounter() == 2
				&& labyrinth[kammer.getY()][kammer.getX() + 1].getAmeisencounter() == 2
				&& labyrinth[kammer.getY() - 1][kammer.getX()].getAmeisencounter() == 2
				&& labyrinth[kammer.getY() + 1][kammer.getX()].getAmeisencounter() == 2) 
			return true;
		return false;
	}

	public Kammer checkOben(Kammer[][] labyrinth, Kammer kammer) {
		if (	//stepOne: check if kammer in borders
				kammer.getY() > 0 // there is actually a field above
				&& kammer.getY() < (labyrinth.length - 1) // kammer still in borders

				//stepTwo: check if there's a wall
				&& !kammer.isMauerOben() //%
				&& !labyrinth[kammer.getY()][kammer.getX()].isMauerOben() //% should be the same

				//stepThree: check if there are already two ants
				&& labyrinth[kammer.getY() - 1][kammer.getX()].getAmeisencounter() < 2) 
			return labyrinth[kammer.getY() - 1][kammer.getX()];
		return null;
	}

	public Kammer checkRechts(Kammer[][] labyrinth, Kammer kammer) {
		if (	//stepOne: check if kammer in borders
				kammer.getX() >= 0
				&& kammer.getX() < (labyrinth[0].length - 2)

				//stepTwo: check if there's a wall
				&& !kammer.isMauerRechts() //%
				&& !labyrinth[kammer.getY()][kammer.getX()].isMauerRechts() //% should be the same

				//stepThree: check if there are already two ants
				&& labyrinth[kammer.getY()][kammer.getX() + 1].getAmeisencounter() < 2)
			return labyrinth[kammer.getY()][kammer.getX() + 1];
		return null;
	}

	public Kammer checkLinks(Kammer[][] labyrinth, Kammer kammer) {
		if (	//stepOne: check if kammer in borders
				kammer.getX() > 0
				&& kammer.getX() < (labyrinth[0].length - 1)

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
				&& kammer.getY() < (labyrinth.length - 2)

				//stepTwo: check if there's a wall
				&& !labyrinth[kammer.getY() + 1][kammer.getX()].isMauerOben() // kammer.isMauerUnten

				//stepThree: check if there are already two ants
				&& labyrinth[kammer.getY() + 1][kammer.getX()].getAmeisencounter() < 2) 
			return labyrinth[kammer.getY() + 1][kammer.getX()];
		return null;
	}
}
