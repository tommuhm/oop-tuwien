
public class Test {

	public static void main(String[] args) {
		Kammer[][] laby = new Kammer[4][4];

		laby[0][0] = new Kammer(true, false);
		laby[0][1] = new Kammer(true, false);
		laby[0][2] = new Kammer(true, false);
		laby[0][3] = new Kammer(true, true);

		laby[1][0] = new Kammer(true, false);
		laby[1][1] = new Kammer(false, true);
		laby[1][2] = new Kammer(true, true);
		laby[1][3] = new Kammer(true, true, false, true); //Futterstelle

		laby[2][0] = new Kammer(false, true);
		laby[2][1] = new Kammer(false, false);
		laby[2][2] = new Kammer(false, false);
		laby[2][3] = new Kammer(false, true);

		laby[3][0] = new Kammer(false, true, true, false); //Startpunkt
		laby[3][1] = new Kammer(false, true);
		laby[3][2] = new Kammer(true, false);
		laby[3][3] = new Kammer(false, true);
		
		Controller c1 = new Controller(laby, laby[1][3], laby[3][0]);
		
		
	}

}
