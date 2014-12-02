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
/*
		Controller c1 = new Controller(laby, laby[3][0], laby[1][3]);
		c1.printLabyrinth();
		c1.start();
		*/
		Kammer[][] laby1 = new Kammer[4][8];

		laby1[0][0] = new Kammer(0, 0, false, false);
		laby1[0][1] = new Kammer(1, 0, false, false);
		laby1[0][2] = new Kammer(2, 0, false, false);
		laby1[0][3] = new Kammer(3, 0, false, false);
		laby1[0][4] = new Kammer(4, 0, false, false);
		laby1[0][5] = new Kammer(5, 0, false, false);
		laby1[0][6] = new Kammer(6, 0, false, false);
		laby1[0][7] = new Kammer(7, 0, false, false);

		laby1[1][0] = new Kammer(0, 1, false, false);
		laby1[1][1] = new Kammer(1, 1, false, false);
		laby1[1][2] = new Kammer(2, 1, false, false);
		laby1[1][3] = new Kammer(3, 1, false, false, false, true); // Futterstelle
		laby1[1][4] = new Kammer(4, 1, false, false); // Futterstelle
		laby1[1][5] = new Kammer(5, 1, false, false);
		laby1[1][6] = new Kammer(6, 1, false, false);
		laby1[1][7] = new Kammer(7, 1, false, false);

		laby1[2][0] = new Kammer(0, 2, false, false);
		laby1[2][1] = new Kammer(1, 2, false, false);
		laby1[2][2] = new Kammer(2, 2, false, false);
		laby1[2][3] = new Kammer(3, 2, false, false);
		laby1[2][4] = new Kammer(4, 2, false, false);
		laby1[2][5] = new Kammer(5, 2, false, false);
		laby1[2][6] = new Kammer(6, 2, false, false);
		laby1[2][7] = new Kammer(7, 2, false, false);

		laby1[3][0] = new Kammer(0, 3, false, false, true, false); // Startpunkt
		laby1[3][1] = new Kammer(1, 3, false, false);
		laby1[3][2] = new Kammer(2, 3, false, false);
		laby1[3][3] = new Kammer(3, 3, false, false);
		laby1[3][4] = new Kammer(4, 3, false, false);
		laby1[3][5] = new Kammer(5, 3, false, false);
		laby1[3][6] = new Kammer(6, 3, false, false);
		laby1[3][7] = new Kammer(7, 3, false, false);

		Controller c2 = new Controller(laby1, laby1[3][0], laby1[1][3]);
		c2.printLabyrinth();
		c2.start();
	}

}
