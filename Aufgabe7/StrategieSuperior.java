
public class StrategieSuperior extends Strategie {

	// enhanced random algorithm

	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) { // TODO synchronized?

		int counter = 0;
		
		if (checkOben(labyrinth, kammer) != null) 
			counter++;
		if (checkRechts(labyrinth, kammer) != null)
			counter++;
		if (checkLinks(labyrinth, kammer) != null)
			counter++;
		if (checkUnten(labyrinth, kammer) != null)
			counter++;

		if (checkOben(labyrinth, kammer) != null)
			if (Math.random() * (counter--) <= 1)
				return checkOben(labyrinth, kammer);
		if (checkUnten(labyrinth, kammer) != null)
			if (Math.random() * (counter--) <= 1)
				return checkUnten(labyrinth, kammer);
		if (checkLinks(labyrinth, kammer) != null)
			if (Math.random() * (counter--) <= 1)
				return checkLinks(labyrinth, kammer);
		return checkRechts(labyrinth, kammer);
	}
}