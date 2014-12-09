import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Author(name = "Ulrich Aschl")
public class Test {

	private static Raumsonde sonde1, sonde2, sonde3, sonde4;
	private static Einsatzart bohrer1, bohrer2, kamera1, kamera2, kamera3;
	private static Erkundungsroboter roboter1, roboter2, roboter3, roboter4, roboter5;
	private static Mission mission1;

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

		testC();


		printAlleStatistiken();

		printAuthors();
	}

	@Author(name = "Ulrich Aschl")
	private static void init() {
		sonde1 = new Raumsonde("sonde1");
		sonde2 = new Raumsonde("sonde2");
		sonde3 = new Raumsonde("sonde3");
		sonde4 = new Raumsonde("sonde4");

		bohrer1 = new Bohrer(82.28);
		bohrer2 = new Bohrer(82.28);

		kamera1 = new Kamera(200000);
		kamera2 = new Kamera(300000);
		kamera3 = new Kamera(10000);

		roboter1 = new SprungRoboter(bohrer1, 15, 20);
		roboter2 = new SprungRoboter(bohrer2, 10, 10);
		roboter3 = new RadRoboter(kamera1, 20, 10.20);
		roboter4 = new RadRoboter(kamera2, 30, 5.50);
		roboter5 = new RadRoboter(kamera3, 20, 5);

		mission1 = new Mission("Mission 1");
	}

	@Author(name = "Ulrich Aschl")
	private static void testA() {
		System.out.println("~~~ Test A: ~~~");

		sonde1.addRoboter(roboter1);
		sonde1.addRoboter(roboter2);
		sonde1.addRoboter(roboter3);
		sonde2.addRoboter(roboter4);
		sonde3.addRoboter(roboter5);

		Mission m1 = new Mission("Mission 1");

		m1.addRaumsonde(sonde1);
		m1.addRaumsonde(sonde2);

		System.out.println("Mission 1:");
		m1.printRaumsonden();
		System.out.println("Mission 1 - Füge Raumsonde hinzu.");
		m1.addRaumsonde(sonde3);
		m1.printRaumsonden();
		System.out.println("Mission 1 - Remove Raumsonde ueber eindeutigen Namen");
		m1.removeRaumsonde(sonde3.getName());
		m1.printRaumsonden();
	}

	@Author(name = "Ulrich Aschl")
	private static void testB() {
		System.out.println("\n~~~ Test B: ~~~");
		System.out.println("Erstelle Erkundungsroboter rB1.");
		Erkundungsroboter rB1 = new SprungRoboter(bohrer1, 30, 10);
		System.out.println("Füge rB1 zu sonde4 hinzu.");
		sonde4.addRoboter(rB1);
		System.out.println(sonde4);
		System.out.println(rB1);
		System.out.println("Aendern der Einsatzart von rB1 ueber Sonde4.");
		sonde4.modifyRoboter(rB1.getNummer(), kamera3);
		System.out.println(rB1);
		System.out.println("Lösche rB1 ueber eindeutige Nummer aus sonde4.");
		sonde4.removeRoboter(rB1.getNummer());
		System.out.println(sonde4);
	}

	@Author(name = "Thomas Muhm")
	private static void testC() {
		System.out.println("\n~~~ Test C: ~~~");
		System.out.println("Erstelle Radroboter rB2.");
		RadRoboter rB2 = new RadRoboter(bohrer1, 30, 10);
		System.out.println(rB2);
		System.out.println("Erhoehe Stunde.");
		rB2.erhoeheStunden();
		System.out.println(rB2);
		System.out.println("Erhoehe Wegstrecke.");
		rB2.erhoeheWegstrecke();
		System.out.println(rB2);
		System.out.println("Erstelle Sprungroboter rB3.");
		SprungRoboter rB3 = new SprungRoboter(kamera1, 40, 15);
		System.out.println(rB3);
		System.out.println("Erhoehe Spruenge.");
		rB3.erhoeheSpruenge();
		System.out.println(rB3);
		System.out.println("Aendern Einsatzart zu Kamera2.");
		rB3.setEinsatzart(kamera2);
		System.out.println(rB3);
		if (rB3.getEinsatzart() instanceof Kamera) {
			System.out.println("auslesen der Kamerapixel: " + ((Kamera) rB3.getEinsatzart()).getPixel());
		}
		System.out.println("Aendern Einsatzart zu Bohrer1.");
		rB3.setEinsatzart(bohrer1);
		System.out.println(rB3);
		if (rB3.getEinsatzart() instanceof Bohrer) {
			System.out.println("auslesen der Bohrerlaenge: " + ((Bohrer) rB3.getEinsatzart()).getLaenge());
		}
	}

	@Author(name = "Thomas Muhm")
	private static void printAlleStatistiken() {
		printStatistiken(sonde1);
		printStatistiken(sonde2);
		printStatistiken(sonde3);
		printStatistiken(sonde4);
	}


	@Author(name = "Ulrich Aschl")
	private static void printStatistiken(Raumsonde r) {
		System.out.println(r.getBetriebsstundenEinsatzartSchnitt());
		System.out.println(r.getBetriebsstundenBauartSchnitt());
		System.out.println(r.getWegstreckeSchnitt());
		System.out.println(r.getSpruengeSchnitt());
		System.out.println(r.getMinMaxPixel());
		System.out.println(r.getBohrerSchnitt());
	}

	@Author(name = "Thomas Muhm")
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
		for (Class<?> clazz : MyLinkedList.class.getDeclaredClasses()) {
			printAuthorsForClass(clazz);
		}
		printAuthorsForClass(Test.class);
		printAuthorsForClass(Author.class);
	}

	@Author(name = "Thomas Muhm")
	private static void printAuthorsForClass(Class<?> clazz) {
		try {
			Author author = clazz.getAnnotation(Author.class);
			System.out.println("\n~~~ " + clazz.getName() + ".class ~~~");
			System.out.println("Class: " + clazz.getName() + ", Author: " + author.name());
		} catch (NullPointerException ex) {
			System.out.println("missing Author for Class: " + clazz.getName());
		}

		for (Constructor constructor : clazz.getDeclaredConstructors()) {
			try {
				Author author = (Author) constructor.getAnnotation(Author.class);
				System.out.println("Constructor: " + constructor.getName() + ", Author: " + author.name());
			} catch (NullPointerException ex) {
				System.out.println("missing Author for Constructor: " + constructor.getName());
			}
		}

		for (Method method : clazz.getDeclaredMethods()) {
			try {
				Author author = method.getAnnotation(Author.class);
				System.out.println("Method: " + method.getName() + ", Author: " + author.name());
			} catch (NullPointerException ex) {
				System.out.println("missing Author for Method: " + method.getName());
			}
		}
	}

}
