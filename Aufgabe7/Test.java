public class Test {

	public static void main(String[] args) {

		testLabyrinth1();

		testLabyrinth2();

	}

	private static void testLabyrinth1() {
		Feld[][] felder = new Feld[4][5];

		felder[0][0] = new Feld(0, 0, true, false);
		felder[0][1] = new Feld(1, 0, true, false);
		felder[0][2] = new Feld(2, 0, true, false);
		felder[0][3] = new Feld(3, 0, true, false);
		felder[0][4] = new Feld(4, 0, true, false);

		felder[1][0] = new Feld(0, 1, true, false);
		felder[1][1] = new Feld(1, 1, false, true);
		felder[1][2] = new Feld(2, 1, true, true);
		FeldFutterstelle futterstelle = new FeldFutterstelle(3, 1, true, true);
		felder[1][3] = new FeldFutterstelle(3, 1, true, true);
		felder[1][4] = new Feld(4, 1, true, true);

		felder[2][0] = new Feld(0, 2, false, true);
		felder[2][1] = new Feld(1, 2, false, false);
		felder[2][2] = new Feld(2, 2, false, false);
		felder[2][3] = new Feld(3, 2, false, false);
		felder[2][4] = new Feld(4, 2, false, true);

		FeldAmeisenkolonie ameisenkolonie = new FeldAmeisenkolonie(0, 3, false, true);
		felder[3][0] = ameisenkolonie;
		felder[3][1] = new Feld(1, 3, false, true);
		felder[3][2] = new Feld(2, 3, true, false);
		felder[3][3] = new Feld(3, 3, false, false);
		felder[3][4] = new Feld(4, 3, false, true);

		Labyrinth labyrinth = new Labyrinth(felder, ameisenkolonie, futterstelle);
		int maxDosis = labyrinth.getRows() * labyrinth.getCols();
		int anzahlZuege = labyrinth.getRows() * labyrinth.getCols() * 3;

		Controller c1 = new Controller(labyrinth, maxDosis, anzahlZuege);
		c1.start();
	}

	private static void testLabyrinth2() {
		Feld[][] felder = new Feld[4][8];

		felder[0][0] = new Feld(0, 0, false, false);
		felder[0][1] = new Feld(1, 0, false, false);
		felder[0][2] = new Feld(2, 0, false, false);
		felder[0][3] = new Feld(3, 0, false, false);
		felder[0][4] = new Feld(4, 0, false, false);
		felder[0][5] = new Feld(5, 0, false, false);
		felder[0][6] = new Feld(6, 0, false, false);
		felder[0][7] = new Feld(7, 0, false, false);

		felder[1][0] = new Feld(0, 1, false, false);
		felder[1][1] = new Feld(1, 1, false, false);
		felder[1][2] = new Feld(2, 1, false, false);
		FeldFutterstelle futterstelle = new FeldFutterstelle(3, 1, false, false);
		felder[1][3] = futterstelle;
		felder[1][4] = new Feld(4, 1, false, false);
		felder[1][5] = new Feld(5, 1, false, false);
		felder[1][6] = new Feld(6, 1, false, false);
		felder[1][7] = new Feld(7, 1, false, false);

		felder[2][0] = new Feld(0, 2, false, false);
		felder[2][1] = new Feld(1, 2, false, false);
		felder[2][2] = new Feld(2, 2, false, false);
		felder[2][3] = new Feld(3, 2, false, false);
		felder[2][4] = new Feld(4, 2, false, false);
		felder[2][5] = new Feld(5, 2, false, false);
		felder[2][6] = new Feld(6, 2, false, false);
		felder[2][7] = new Feld(7, 2, false, false);

		FeldAmeisenkolonie ameisenkolonie = new FeldAmeisenkolonie(0, 3, false, false);
		felder[3][0] = ameisenkolonie;
		felder[3][1] = new Feld(1, 3, false, false);
		felder[3][2] = new Feld(2, 3, false, false);
		felder[3][3] = new Feld(3, 3, false, false);
		felder[3][4] = new Feld(4, 3, false, false);
		felder[3][5] = new Feld(5, 3, false, false);
		felder[3][6] = new Feld(6, 3, false, false);
		felder[3][7] = new Feld(7, 3, false, false);

		Labyrinth labyrinth = new Labyrinth(felder, ameisenkolonie, futterstelle);
		int maxDosis = labyrinth.getRows();
		int anzahlZuege = labyrinth.getRows() * labyrinth.getCols();

		Controller c2 = new Controller(labyrinth, maxDosis, anzahlZuege);
		c2.start();
	}

}
