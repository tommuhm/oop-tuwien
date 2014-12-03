import java.util.Random;

public abstract class Strategie {

	// Vorbedingung: labyrinth darf nicht null sein.
	// Vorbedingung: feld darf nicht null sein.
	// Nachbedingung: gibt das nachste Feld zurueck, falls verfuegbar, ansonsten null.
	public abstract Feld naechstesFeld(Labyrinth labyrinth, Feld feld);


	// Nachbedingung: gibt eine zufaellige Strategie zurueck
	public static Strategie getNextStrategie() {
		Random rnd = new Random();

		switch (rnd.nextInt(3)) {
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
	public Feld checkOben(Labyrinth labyrinth, Feld feld) {
		if (feld.getY() > 0 &&                  // there is actually a field above
				feld.getY() < (labyrinth.getRows()) &&          // kammer still in borders
				!feld.hatMauerOben() &&              // check if there's a wall
				labyrinth.get(feld.getX(), feld.getY() - 1).hatPlatz()) // check if there are already two ants
			return labyrinth.get(feld.getX(), feld.getY() - 1);
		return null;
	}

	// Vorbedingung: labyrinth darf nicht null sein.
	// Vorbedingung: feld darf nicht null sein.
	// Nachbedingung: gibt das rechte Feld zurück falls vorhanden und nicht blockiert, sonst null.
	public Feld checkRechts(Labyrinth labyrinth, Feld feld) {
		if (feld.getX() >= 0 &&
				feld.getX() < (labyrinth.getCols() - 1) &&
				!feld.hatMauerRechts() &&
				labyrinth.get(feld.getX() + 1, feld.getY()).hatPlatz())
			return labyrinth.get(feld.getX() + 1, feld.getY());
		return null;
	}

	// Vorbedingung: labyrinth darf nicht null sein.
	// Vorbedingung: feld darf nicht null sein.
	// Nachbedingung: gibt das linke Feld zurück falls vorhanden und nicht blockiert, sonst null.
	public Feld checkLinks(Labyrinth labyrinth, Feld feld) {
		if (feld.getX() > 0 &&
				feld.getX() < (labyrinth.getCols()) &&
				!labyrinth.get(feld.getX() - 1, feld.getY()).hatMauerRechts() && // kammer.isMauerLinks
				labyrinth.get(feld.getX() - 1, feld.getY()).hatPlatz())
			return labyrinth.get(feld.getX() - 1, feld.getY());
		return null;
	}

	// Vorbedingung: labyrinth darf nicht null sein.
	// Vorbedingung: feld darf nicht null sein.
	// Nachbedingung: gibt das untere Feld zurück falls vorhanden und nicht blockiert, sonst null.
	public Feld checkUnten(Labyrinth labyrinth, Feld feld) {
		if (feld.getY() >= 0 &&
				feld.getY() < (labyrinth.getRows() - 1) &&
				!labyrinth.get(feld.getX(), feld.getY() + 1).hatMauerOben() && // kammer.isMauerUnten
				labyrinth.get(feld.getX(), feld.getY() + 1).hatPlatz())
			return labyrinth.get(feld.getX(), feld.getY() + 1);
		return null;
	}
}
