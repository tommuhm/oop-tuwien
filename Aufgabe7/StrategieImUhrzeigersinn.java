
public class StrategieImUhrzeigersinn extends Strategie {

	@Override
	// Vorbedingungen: labyrinth darf nicht null sein, feld darf nicht null sein.
	// Nachbedingungen: gibt das nachste Feld im Uhrzeigersinn, falls verfuegbar, zurueck, ansonsten null.
	public Feld naechstesFeld(Labyrinth labyrinth, Feld feld) {

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
