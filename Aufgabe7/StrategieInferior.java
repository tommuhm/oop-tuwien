
public class StrategieInferior extends Strategie {

	// >>zuerst nach oben, dann rechts, dann unten, dann links.<< loops may be included since this is inferior

	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) { // TODO synchronized?
		
		if (checkOben(labyrinth, kammer) != null) 
			return checkOben(labyrinth, kammer);
		else if (checkRechts(labyrinth, kammer) != null) 
			return checkRechts(labyrinth, kammer);
		else if (checkUnten(labyrinth, kammer) != null)
			return checkUnten(labyrinth, kammer);
		else if (checkLinks(labyrinth, kammer) != null)		
			return checkLinks(labyrinth, kammer);
		return null;
	}
}