
public class StrategieRandom extends Strategie {

	// enhanced random algorithm

	public Feld naechsteKammer(Feld[][] labyrinth, Feld feld) { // TODO synchronized?

		int counter = 0;

		if (checkOben(labyrinth, feld) != null)
			counter++;
		if (checkRechts(labyrinth, feld) != null)
			counter++;
		if (checkLinks(labyrinth, feld) != null)
			counter++;
		if (checkUnten(labyrinth, feld) != null)
			counter++;

		if (checkOben(labyrinth, feld) != null)
			if (Math.random() * (counter--) <= 1)
				return checkOben(labyrinth, feld);
		if (checkUnten(labyrinth, feld) != null)
			if (Math.random() * (counter--) <= 1)
				return checkUnten(labyrinth, feld);
		if (checkLinks(labyrinth, feld) != null)
			if (Math.random() * (counter--) <= 1)
				return checkLinks(labyrinth, feld);
		return checkRechts(labyrinth, feld);
	}
}
