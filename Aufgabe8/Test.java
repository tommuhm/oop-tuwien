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

	private static void testB() {
		System.out.println("\n~~~ Test B: ~~~");
		System.out.println("Erstelle Erkundungsroboter rB1.");
		Erkundungsroboter rB1 = new SprungRoboter(art1, 30, 10);
		System.out.println("Füge rB1 zu raum1 hinzu.");
		raum1.addRoboter(rB1);
		System.out.println("Anzahl and Robotern in Raum1: " + raum1);
		System.out.println("Lösche rB1 aus raum1.");
		raum1.removeRoboter(rB1.getNummer());
		System.out.println("Anzahl and Robotern in Raum1: " + raum1);
	}

	private static void printAlleStatistiken(Raumsonde r) {
		System.out.println(r.getBetriebsstundenEinsatzartSchnitt());
		System.out.println(r.getBetriebsstundenBauartSchnitt());
		System.out.println(r.getWegstreckeSchnitt());
		System.out.println(r.getSpruengeSchnitt());
		System.out.println(r.getMinMaxPixel());
		System.out.println(r.getBohrerSchnitt());
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
