import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


public class Test {

	private static Raumsonde raum1, raum2, raum3;
	private static Einsatzart art1, art2, art3, art4, art5;
	private static Erkundungsroboter r1, r2, r3, r4, r5;
	private static Mission m1;

	@Author(name = "Ulrich Aschl")
	public static void main(String[] args) {
		init();
		
		/*
		 * • Erstellen und ändern Sie mehrere Missionen mit mehreren Raumsonden mit jeweils einigen
		 *	Erkundungsrobotern. Jede Raumsonde einer Mission soll über ihren eindeutigen Namen
		 *	angesprochen werden, und jeder Erkundungsroboter einer Raumsonde über seine eindeutige
		 *	Nummer.
		 *	• Fügen Sie zu Missionen einzelne Raumsonden hinzu, entfernen Sie einzelne Raumsonden,
		 *	wobei Sie Raumsonden nur über deren Namen ansprechen.
		 */
		testA();
		
		/*
		 * Fügen Sie zu einigen Raumsonden einzelne Erkundungsroboter hinzu, entfernen Sie
		 *	einzelne Erkundungsroboter, und ändern Sie die Informationen zu einzelnen
		 *	Erkundungsrobotern, wobei Sie Erkundungsroboter und Raumsonden nur über deren
		 *	Nummern und Namen ansprechen.
		 */
		testB();


		printAuthors();
	}

	private static void testB() {
		System.out.println("\n~~~ Test B: ~~~");
		System.out.println("Erstelle Erkundungsroboter rB1.");
		Erkundungsroboter rB1 = new SprungRoboter(art1, 30, 10);
		System.out.println("Füge rB1 zu raum1 hinzu.");
		raum1.addRoboter(rB1);
	}

	private static void init() {
		raum1 = new Raumsonde("raum1");
		raum2 = new Raumsonde("raum2");
		raum3 = new Raumsonde("raum3");

		art1 = new Bohrer(82.28);
		art2 = new Bohrer(82.28);
		art3 = new Kamera(200000);
		art4 = new Kamera(300000);
		art5 = new Kamera(10000);

		r1 = new SprungRoboter(art1, 15, 20);
		r2 = new SprungRoboter(art2, 10, 10);
		r3 = new RadRoboter(art3, 20, 10.20);
		r4 = new RadRoboter(art4, 30, 5.50);
		r5 = new RadRoboter(art5, 20, 5);

		m1 = new Mission("Mission 1");
	}

	private static void printAlleStatistiken(Raumsonde r) {
		System.out.println(r.getBetriebsstundenEinsatzartSchnitt());
		System.out.println(r.getBetriebsstundenBauartSchnitt());
		System.out.println(r.getWegstreckeSchnitt());
		System.out.println(r.getSpruengeSchnitt());
		System.out.println(r.getMinMaxPixel());
		System.out.println(r.getBohrerSchnitt());
	}

	private static void testA() {
		System.out.println("~~~ Test A: ~~~");

		raum1.addRoboter(r1);
		raum1.addRoboter(r2);
		raum1.addRoboter(r3);
		raum2.addRoboter(r4);
		raum3.addRoboter(r5);

		Mission m1 = new Mission("Mission 1");

		m1.addRaumsonde(raum1);
		m1.addRaumsonde(raum2);

		System.out.println("Mission 1:");
		m1.printRaumsonden();
		System.out.println("Mission 1 - Füge Raumsonde hinzu.");
		m1.addRaumsonde(raum3);
		m1.printRaumsonden();
		System.out.println("Mission 1 - Remove Raumsonde.");
		m1.removeRaumsonde(raum3.getName());
		m1.printRaumsonden();
	}

	private static void test1() {

		Einsatzart art1 = new Bohrer(15.92);
		Einsatzart art2 = new Bohrer(82.28);
		Einsatzart art3 = new Bohrer(82.28);
		Einsatzart art4 = new Bohrer(82.28);
		Einsatzart art5 = new Kamera(200000);
		Einsatzart art6 = new Kamera(300000);
		Einsatzart art7 = new Kamera(400000);
		Einsatzart art8 = new Kamera(400001);

		Erkundungsroboter r1 = new SprungRoboter(art1);
		Erkundungsroboter r2 = new SprungRoboter(art2, 10, 3);
		Erkundungsroboter r3 = new SprungRoboter(art3, 15, 20);
		Erkundungsroboter r4 = new SprungRoboter(art4, 10, 0);
		Erkundungsroboter r5 = new RadRoboter(art5, 20, 10);
		Erkundungsroboter r6 = new RadRoboter(art6, 10, 5.50);
		Erkundungsroboter r7 = new RadRoboter(art7, 20, 10.90);
		Erkundungsroboter r8 = new RadRoboter(art8);

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
		System.out.println(raum1.getWegstreckeSchnitt());
		System.out.println("Einsatzart in Raumsonde raum1 wird für r5 verändert.");
		Einsatzart artTest2 = new Bohrer(120.90);
		raum1.modifyRoboter(2, artTest2);
		System.out.println(raum1.getSpruengeSchnitt());
		System.out.println(raum1.getWegstreckeSchnitt());

		System.out.println("Testen der Division durch 0.");
		printAlleStatistiken(raum5);

		Mission m1 = new Mission("Mission 1");
		Mission m2 = new Mission("Mission 2");

		m1.addRaumsonde(raum1);
		m1.addRaumsonde(raum2);
		m1.addRaumsonde(raum3);
		m2.addRaumsonde(raum4);
		m2.addRaumsonde(raum5);

		System.out.println("Mission 1 - Raumsonden:");
		m1.printRaumsonden();
		System.out.println("Mission 1 - Entferne Raumsonde 1.");
		m1.removeRaumsonde(raum1.getName());
		System.out.println("Mission 1 - Raumsonde entfernt.");
		m1.printRaumsonden();
	}

	private static void printAuthors() {
		printAuthorsForClass(Mission.class);
		printAuthorsForClass(Raumsonde.class);
		printAuthorsForClass(Erkundungsroboter.class);
		printAuthorsForClass(RadRoboter.class);
		printAuthorsForClass(SprungRoboter.class);
		printAuthorsForClass(Bohrer.class);
		printAuthorsForClass(Kamera.class);
		printAuthorsForClass(Einsatzart.class);
		printAuthorsForClass(MyLinkedList.class);
	}

	private static void printAuthorsForClass(Class clazz) {
		Author author = (Author) clazz.getAnnotation(Author.class);

		System.out.println("Class: " + clazz.getName() + ", Author: " + author.name());

		for (Method method : clazz.getMethods()) {
			author = method.getAnnotation(Author.class);
			System.out.println("Method: " + clazz.getName() + ", Author: " + author.name());
		}
	}

}
