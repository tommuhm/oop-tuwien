
public class StrategieRandom extends Strategie {

	// movement is completely random, choosen by dicing. may dice an invalid movement, if so it will dice again

	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) { // TODO synchronized?

		if (!checkRichtung(labyrinth, kammer))
			return null;

		switch (dice()) {

		case 1: 
			if (checkOben(labyrinth, kammer) != null) 
				return checkOben(labyrinth, kammer);
			return naechsteKammer(labyrinth, kammer);

		case 2: 
			if (checkRechts(labyrinth, kammer) != null) 
				return checkRechts(labyrinth, kammer);
			return naechsteKammer(labyrinth, kammer);

		case 3: 
			if (checkUnten(labyrinth, kammer) != null)
				return checkUnten(labyrinth, kammer);
			return naechsteKammer(labyrinth, kammer);

		case 4:
			if (checkLinks(labyrinth, kammer) != null)		
				return checkLinks(labyrinth, kammer);
			return naechsteKammer(labyrinth, kammer);

		default: return null; //should never happen.
		}
	}


	public int dice() {

		double dice = (int) (Math.random() * 4);

		if ( dice == 0 ) 
			return 1;
		else if ( dice == 1 )
			return 2;
		else if ( dice == 2 )
			return 3;
		else if (dice == 3 )
			return 4;
		return 0; //should never happen.
	}
}
