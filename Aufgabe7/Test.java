public class Test {

	public static void main(String[] args) {

//		testLabyrinth1();

		testLabyrinth2();

	}

	private static void testLabyrinth1() {
		Feld[][] laby = new Feld[4][5];

		laby[0][0] = new Feld(0, 0, true, false);
		laby[0][1] = new Feld(1, 0, true, false);
		laby[0][2] = new Feld(2, 0, true, false);
		laby[0][3] = new Feld(3, 0, true, false);
		laby[0][4] = new Feld(4, 0, true, false);

		laby[1][0] = new Feld(0, 1, true, false);
		laby[1][1] = new Feld(1, 1, false, true);
		laby[1][2] = new Feld(2, 1, true, true);
		FeldFutterstelle futterstelle = new FeldFutterstelle(3, 1, true, true);
		laby[1][3] = new FeldFutterstelle(3, 1, true, true);
		laby[1][4] = new Feld(4, 1, true, true);

		laby[2][0] = new Feld(0, 2, false, true);
		laby[2][1] = new Feld(1, 2, false, false);
		laby[2][2] = new Feld(2, 2, false, false);
		laby[2][3] = new Feld(3, 2, false, false);
		laby[2][4] = new Feld(4, 2, false, true);

		FeldAmeisenkolonie ameisenkolonie = new FeldAmeisenkolonie(0, 3, false, true);
		laby[3][0] = ameisenkolonie;
		laby[3][1] = new Feld(1, 3, false, true);
		laby[3][2] = new Feld(2, 3, true, false);
		laby[3][3] = new Feld(3, 3, false, false);
		laby[3][4] = new Feld(4, 3, false, true);

		Controller c1 = new Controller(laby, ameisenkolonie, futterstelle);
		c1.printLabyrinth();
		c1.start();
	}

	private static void testLabyrinth2() {
		Feld[][] laby = new Feld[4][8];

		laby[0][0] = new Feld(0, 0, false, false);
		laby[0][1] = new Feld(1, 0, false, false);
		laby[0][2] = new Feld(2, 0, false, false);
		laby[0][3] = new Feld(3, 0, false, false);
		laby[0][4] = new Feld(4, 0, false, false);
		laby[0][5] = new Feld(5, 0, false, false);
		laby[0][6] = new Feld(6, 0, false, false);
		laby[0][7] = new Feld(7, 0, false, false);

		laby[1][0] = new Feld(0, 1, false, false);
		laby[1][1] = new Feld(1, 1, false, false);
		laby[1][2] = new Feld(2, 1, false, false);
		FeldFutterstelle futterstelle = new FeldFutterstelle(3, 1, false, false);
		laby[1][3] = futterstelle;
		laby[1][4] = new Feld(4, 1, false, false);
		laby[1][5] = new Feld(5, 1, false, false);
		laby[1][6] = new Feld(6, 1, false, false);
		laby[1][7] = new Feld(7, 1, false, false);

		laby[2][0] = new Feld(0, 2, false, false);
		laby[2][1] = new Feld(1, 2, false, false);
		laby[2][2] = new Feld(2, 2, false, false);
		laby[2][3] = new Feld(3, 2, false, false);
		laby[2][4] = new Feld(4, 2, false, false);
		laby[2][5] = new Feld(5, 2, false, false);
		laby[2][6] = new Feld(6, 2, false, false);
		laby[2][7] = new Feld(7, 2, false, false);

		FeldAmeisenkolonie ameisenkolonie = new FeldAmeisenkolonie(0, 3, false, false);
		laby[3][0] = ameisenkolonie;
		laby[3][1] = new Feld(1, 3, false, false);
		laby[3][2] = new Feld(2, 3, false, false);
		laby[3][3] = new Feld(3, 3, false, false);
		laby[3][4] = new Feld(4, 3, false, false);
		laby[3][5] = new Feld(5, 3, false, false);
		laby[3][6] = new Feld(6, 3, false, false);
		laby[3][7] = new Feld(7, 3, false, false);

		Controller c2 = new Controller(laby, ameisenkolonie, futterstelle);
		c2.printLabyrinth();
		c2.start();
	}

}
