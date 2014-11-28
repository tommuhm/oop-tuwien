public class Test {

	public static void main(String[] args) {
		Kammer[][] laby = new Kammer[4][5];

		laby[0][0] = new Kammer(0, 0, true, false);
		laby[0][1] = new Kammer(1, 0, true, false);
		laby[0][2] = new Kammer(2, 0, true, false);
		laby[0][3] = new Kammer(3, 0, true, false);
		laby[0][4] = new Kammer(4, 0, true, false);

		laby[1][0] = new Kammer(0, 1, true, false);
		laby[1][1] = new Kammer(1, 1, false, true);
		laby[1][2] = new Kammer(2, 1, true, true);
		laby[1][3] = new Kammer(3, 1, true, true, false, true); // Futterstelle
		laby[1][4] = new Kammer(4, 1, true, true); // Futterstelle

		laby[2][0] = new Kammer(0, 2, false, true);
		laby[2][1] = new Kammer(1, 2, false, false);
		laby[2][2] = new Kammer(2, 2, false, false);
		laby[2][3] = new Kammer(3, 2, false, false);
		laby[2][4] = new Kammer(4, 2, false, true);

		laby[3][0] = new Kammer(0, 3, false, true, true, false); // Startpunkt
		laby[3][1] = new Kammer(1, 3, false, true);
		laby[3][2] = new Kammer(2, 3, true, false);
		laby[3][3] = new Kammer(3, 3, false, false);
		laby[3][4] = new Kammer(4, 3, false, true);

		Controller c1 = new Controller(laby, laby[3][0], laby[1][3]);
		c1.printLabyrinth();
		c1.start();
	}

}
