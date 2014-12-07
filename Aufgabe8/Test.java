
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
		
		// Test 1:
		System.out.println("Roboter r1 wird ausgegeben.");
		System.out.println(r1.toString());
		System.out.println("Stunden werden erhöht.");
		r1.erhoeheStunden();
		System.out.println(r1.toString());
		System.out.println("Einsatzart wird verändert.");
		Einsatzart artTest = new Kamera(123456);	
		r1.setEinsatzart(artTest);
		System.out.println(r1.toString());
		
		Raumsonde raum1 = new Raumsonde("Raumsonde 1");
		Raumsonde raum2 = new Raumsonde("Raumsonde 2");
		Raumsonde raum3 = new Raumsonde("Raumsonde 3");
		Raumsonde raum4 = new Raumsonde("Raumsonde 4");
		Raumsonde raum5 = new Raumsonde("Raumsonde 5");
		
		raum1.addRoboter(r1);
		raum1.addRoboter(r2);
		raum1.addRoboter(r5);
		raum2.addRoboter(r3);
		raum3.addRoboter(r4);
		raum3.addRoboter(r6);
		raum4.addRoboter(r7);
		raum4.addRoboter(r8);
		
		System.out.println(raum1);
		System.out.println(raum1.getSpruengeSchnitt());
		raum5.getSpruengeSchnitt();
	}
}
