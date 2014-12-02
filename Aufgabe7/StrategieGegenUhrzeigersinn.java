
public class StrategieGegenUhrzeigersinn extends Strategie {

	public Feld naechsteKammer(Feld[][] labyrinth, Feld feld) { // TODO synchronized?

		if (checkUnten(labyrinth, feld) != null)
			return checkUnten(labyrinth, feld);
		else if (checkRechts(labyrinth, feld) != null)
			return checkRechts(labyrinth, feld);
		else if (checkOben(labyrinth, feld) != null)
			return checkOben(labyrinth, feld);
		else if (checkLinks(labyrinth, feld) != null)
			return checkLinks(labyrinth, feld);
		return null;
	}
}
