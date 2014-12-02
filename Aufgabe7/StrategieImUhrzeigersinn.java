
public class StrategieImUhrzeigersinn extends Strategie {

	// >>zuerst nach oben, dann rechts, dann unten, dann links.<< loops may be included since this is inferior

	public Feld naechsteKammer(Feld[][] labyrinth, Feld feld) { // TODO synchronized?
		
		if (checkOben(labyrinth, feld) != null)
			return checkOben(labyrinth, feld);
		else if (checkRechts(labyrinth, feld) != null)
			return checkRechts(labyrinth, feld);
		else if (checkUnten(labyrinth, feld) != null)
			return checkUnten(labyrinth, feld);
		else if (checkLinks(labyrinth, feld) != null)
			return checkLinks(labyrinth, feld);
		return null;
	}
}
