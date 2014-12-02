
public class StrategieRandom extends Strategie {

	// enhanced random algorithm

	@Override
	// Vorbedingungen: labyrinth darf nicht null sein, feld darf nicht null sein.
	// Nachbedingungen: gibt das nachste Feld, ausgesucht durch einen randomizer, zurueck. falls nicht verfuegbar dann null.
	public Feld naechstesFeld(Feld[][] labyrinth, Feld feld) {
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
