
public class Test {

	public static void main(String[] args) {

		Einsatzart art1 = new Bohrer(15.92);
		Einsatzart art2 = new Bohrer(82.28);
		Einsatzart art3 = new Bohrer(82.28);
		Einsatzart art4 = new Bohrer(82.28);
		Einsatzart art5 = new Kamera(200000);		
		Einsatzart art6 = new Kamera(300000);		
		Einsatzart art7 = new Kamera(400000);		
		Einsatzart art8 = new Kamera(400001);		
		
		Erkundungsroboter r1 = new SprungRoboter("r1", art1);
		Erkundungsroboter r2 = new SprungRoboter("r2", 10, 3, art2);
		Erkundungsroboter r3 = new SprungRoboter("r3", art3);
		Erkundungsroboter r4 = new SprungRoboter("r4", art4);
		Erkundungsroboter r5 = new RadRoboter("r5", art5);
		Erkundungsroboter r6 = new RadRoboter("r6", art6);
		Erkundungsroboter r7 = new RadRoboter("r7", art7);
		Erkundungsroboter r8 = new RadRoboter("r8", art8);
		
		System.out.println("Roboter r1 wird ausgegeben.");
		System.out.println(r1.toString());
		System.out.println("Stunden werden erhöht.");
		r1.erhoeheStunden();
		System.out.println(r1.toString());
		System.out.println("Einsatzart wird verändert.");
		Einsatzart artTest = new Kamera(123456);	
		r1.setEinsatzart(artTest);
		System.out.println(r1.toString());
		
	}
}
