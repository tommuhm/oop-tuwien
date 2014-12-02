
public abstract class Strategie {

	private static int strategieCounter = 0;
	// Invariante: strategieCounter darf nicht kleiner 0 sein.

	// Vorbedingung: labyrinth darf nicht null sein.
	// Vorbedingung: feld darf nicht null sein.
	// Nachbedingung: gibt das nachste Feld zurueck, falls verfuegbar, ansonsten null.
	public abstract Feld naechstesFeld(Feld[][] labyrinth, Feld feld);

	
	// Nachbedingung: strategieCounter wird um 1 erhöht.
	// Nachbedingung: gibt ein neues Objekt vom Typ Strategie zurück, abhängig vom aktuellen Stand von strategieCounter.
	public static Strategie getNextStrategie() {
		strategieCounter++;
		switch (strategieCounter % 3) {
		case 0:
			return new StrategieImUhrzeigersinn();
		case 1:
			return new StrategieGegenUhrzeigersinn();
		case 2:
			return new StrategieRandom();
		default:
			return new StrategieRandom();
		}
	}

	// Vorbedingung: labyrinth darf nicht null sein.
	// Vorbedingung: feld darf nicht null sein.
	// Nachbedingung: gibt das obere Feld zurück falls vorhanden und nicht blockiert, sonst null.
	public Feld checkOben(Feld[][] labyrinth, Feld feld) {
		if ( 	feld.getY() > 0 && 									// there is actually a field above
				feld.getY() < (labyrinth.length) &&					// kammer still in borders
				!feld.hatMauerOben() && 							// check if there's a wall
				labyrinth[feld.getY() - 1][feld.getX()].hatPlatz()) // check if there are already two ants
			return labyrinth[feld.getY() - 1][feld.getX()];
		return null;
	}

	// Vorbedingung: labyrinth darf nicht null sein.
	// Vorbedingung: feld darf nicht null sein.
	// Nachbedingung: gibt das rechte Feld zurück falls vorhanden und nicht blockiert, sonst null.
	public Feld checkRechts(Feld[][] labyrinth, Feld feld) {
		if (	feld.getX() >= 0 &&
				feld.getX() < (labyrinth[0].length - 1) &&
				!feld.hatMauerRechts() &&
				labyrinth[feld.getY()][feld.getX() + 1].hatPlatz())
			return labyrinth[feld.getY()][feld.getX() + 1];
		return null;
	}

	// Vorbedingung: labyrinth darf nicht null sein.
	// Vorbedingung: feld darf nicht null sein.
	// Nachbedingung: gibt das linke Feld zurück falls vorhanden und nicht blockiert, sonst null.
	public Feld checkLinks(Feld[][] labyrinth, Feld feld) {
		if (	feld.getX() > 0 &&
				feld.getX() < (labyrinth[0].length) &&
				!labyrinth[feld.getY()][feld.getX() - 1].hatMauerRechts() && // kammer.isMauerLinks
				labyrinth[feld.getY()][feld.getX() - 1].hatPlatz())
			return labyrinth[feld.getY()][feld.getX() - 1];
		return null;
	}

	// Vorbedingung: labyrinth darf nicht null sein.
	// Vorbedingung: feld darf nicht null sein.
	// Nachbedingung: gibt das untere Feld zurück falls vorhanden und nicht blockiert, sonst null.
	public Feld checkUnten(Feld[][] labyrinth, Feld feld) {
		if (	feld.getY() >= 0 &&
				feld.getY() < (labyrinth.length - 1) &&
				!labyrinth[feld.getY() + 1][feld.getX()].hatMauerOben() && // kammer.isMauerUnten
				labyrinth[feld.getY() + 1][feld.getX()].hatPlatz())
			return labyrinth[feld.getY() + 1][feld.getX()];
		return null;
	}
}
