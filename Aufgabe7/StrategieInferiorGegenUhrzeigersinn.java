
public class StrategieInferiorGegenUhrzeigersinn extends Strategie {

	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) { // TODO synchronized?

		if (checkUnten(labyrinth, kammer) != null)
			return checkUnten(labyrinth, kammer);
		else if (checkRechts(labyrinth, kammer) != null) 
			return checkRechts(labyrinth, kammer);
		else if (checkOben(labyrinth, kammer) != null) 
			return checkOben(labyrinth, kammer);
		else if (checkLinks(labyrinth, kammer) != null)		
			return checkLinks(labyrinth, kammer);
		return null;
	}
}
