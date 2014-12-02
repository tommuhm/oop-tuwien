
public abstract class Strategie {

	private static int strategieCounter = 0;

	// Vorbedingungen: labyrinth darf nicht null sein, feld darf nicht null sein.
	// Nachbedingungen: gibt das nachste Feld zurueck, falls verfuegbar, ansonsten null.
	public abstract Feld naechstesFeld(Feld[][] labyrinth, Feld feld);

	
	// Nachbedingung: gibt die Strategien in einem Zyklus zurueck
	public static Strategie getNextStrategie() {
		Strategie strategie;
		switch (strategieCounter) {
		case 0:
			strategie = new StrategieImUhrzeigersinn();
			break;
		case 1:
			strategie = new StrategieGegenUhrzeigersinn();
			break;
		case 2:
			strategie = new StrategieRandom();
			break;
		default:
			strategie = new StrategieRandom();
			break;
		}
		strategieCounter = (strategieCounter + 1) % 3;
		return strategie;
	}

	
	// Vorbedingungen: labyrinth darf nicht null sein, feld darf nicht null sein.
	// Nachbedingungen: returned das obere Feld, falls es verfuegbar ist, ansonsten null.
	public Feld checkOben(Feld[][] labyrinth, Feld feld) {
		if ( 	feld.getY() > 0 && 									// there is actually a field above
				feld.getY() < (labyrinth.length) &&					// kammer still in borders
				!feld.hatMauerOben() && 							// check if there's a wall
				labyrinth[feld.getY() - 1][feld.getX()].hatPlatz()) // check if there are already two ants
			return labyrinth[feld.getY() - 1][feld.getX()];
		return null;
	}

	
	// same procedures and conditions as checkOben
	public Feld checkRechts(Feld[][] labyrinth, Feld feld) {
		if (	feld.getX() >= 0 &&
				feld.getX() < (labyrinth[0].length - 1) &&
				!feld.hatMauerRechts() &&
				labyrinth[feld.getY()][feld.getX() + 1].hatPlatz())
			return labyrinth[feld.getY()][feld.getX() + 1];
		return null;
	}

	
	// same procedures and conditions as checkOben
	public Feld checkLinks(Feld[][] labyrinth, Feld feld) {
		if (	feld.getX() > 0 &&
				feld.getX() < (labyrinth[0].length) &&
				!labyrinth[feld.getY()][feld.getX() - 1].hatMauerRechts() && // kammer.isMauerLinks
				labyrinth[feld.getY()][feld.getX() - 1].hatPlatz())
			return labyrinth[feld.getY()][feld.getX() - 1];
		return null;
	}

	
	// same procedures and conditions as checkOben
	public Feld checkUnten(Feld[][] labyrinth, Feld feld) {
		if (	feld.getY() >= 0 &&
				feld.getY() < (labyrinth.length - 1) &&
				!labyrinth[feld.getY() + 1][feld.getX()].hatMauerOben() && // kammer.isMauerUnten
				labyrinth[feld.getY() + 1][feld.getX()].hatPlatz())
			return labyrinth[feld.getY() + 1][feld.getX()];
		return null;
	}
}
