
public class StrategieRandom extends Strategie {

	// movement is completely random, choosen by dicing. may dice an invalid movement, if so it will dice again

	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) { // TODO synchronized?

		switch (dice()) {

		case 0: 
			if (checkOben(labyrinth, kammer) != null) 
				return checkOben(labyrinth, kammer);
			return naechsteKammer(labyrinth, kammer);

		case 1: 
			if (checkRechts(labyrinth, kammer) != null) 
				return checkRechts(labyrinth, kammer);
			return naechsteKammer(labyrinth, kammer);

		case 2: 
			if (checkUnten(labyrinth, kammer) != null)
				return checkUnten(labyrinth, kammer);
			return naechsteKammer(labyrinth, kammer);

		case 3:
			if (checkLinks(labyrinth, kammer) != null)		
				return checkLinks(labyrinth, kammer);
			return naechsteKammer(labyrinth, kammer);

		default: return null; //should never happen.
		}
	}


	public int dice() {

		return (int) (Math.random() * 4);
	}
}
