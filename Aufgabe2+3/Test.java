/**
 * @author: djaffry, uaschl, tmuhm
 *
 * Aufteilung der Arbeiten:
 * Geplant wurde von D. Jaffry, T. Muhm und U. Aschl gemeinsam.
 * Anschliessend wurden die Arbeiten aufgeteilt.
 *
 * Die Klassen Rental.java und Person.java wurde von Ulrich Aschl geschrieben.
 * Die Klasse Article.java wurde von David Jaffry geschrieben.
 * Die Klasse Surfstore.java wurde von Thomas Muhm geschrieben.
 * Anschliessend wurde noch Test.java von Ulrich Aschl erstellt.
 *
 * Zum Schluss wurden die Klassen nochmal von allen Gruppenmitgliedern gegenkontrolliert.
 *
 */

import java.util.Date;

public class Test {

	private static Surfstore surfstore;

	private static Person ulrich, david, tom;
	private static Article surf200, surf220, helmM;

	public static void main(String[] args) {
		System.out.println("Creating some Persons and Surfarticles:");
		initialize();

		System.out.println("\n\nRenting some articles:");
		borrowSurfarticleTest();

		System.out.println("\n\nPrinting all rented articles:");
		surfstore.printArticles();

		System.out.println("\n\nReturning some used articles:");
		returnSurfarticleTest();

		//Print-methods:
		//	Originally System.out.println was directly in Surfstore.java,
		//	but the description says, that methods in Surfstore.java must return values and mustn't do output.
		System.out.println("\n\nPrinting all rented articles:");
		System.out.println(surfstore.printArticles());

		System.out.println("\n\nPrinting all persons:");
		System.out.println(surfstore.printPersons());
	}


	public static void initialize() {
		surfstore = new Surfstore();
		System.out.println("Surfstore was created.");

		ulrich = surfstore.createCustomer("Ulrich", "A");
		System.out.println(ulrich + " created.");

		david = surfstore.createCustomer("David", "J");
		System.out.println(david + " created.");

		tom = surfstore.createCustomer("Tom", "M");
		System.out.println(tom + " created.");

		surf200 = surfstore.createSurfarticle("Surfboard 200cm", 6.00f, 20, 330);
		System.out.println(surf200 + " created.");

		surf220 = surfstore.createSurfarticle("Surfboard 220cm", 6.00f, 20, 330);
		System.out.println(surf220 + " created.");

		helmM = surfstore.createSurfarticle("Helm M", 2.50f, 50, 330);
		System.out.println(helmM + " created.");
	}

	public static void borrowSurfarticleTest() {
		Date d = new Date();

		d.setHours(4);
		System.out.println("Ulrich borrows 5 times surf200 at " + d);
		surfstore.borrowSurfarticle(ulrich, surf200, 5, d);

		d.setHours(5);
		System.out.println("David borrows 10 times surf200 at " + d);
		surfstore.borrowSurfarticle(david, surf200, 10, d);

		d.setHours(6);
		System.out.println("Tom borrows 7 times surf200 at " + d);
		System.out.println("Tom couldn't borrow surf200 - only 5 available");
		surfstore.borrowSurfarticle(tom, surf200, 7, d);
	}

	public static void returnSurfarticleTest() {
		surfstore.returnSurfarticle(ulrich, surf200, 7);
		System.out.println("Ulrich returns 7/5 of his surfboards. He returend 5/5.");

		surfstore.returnSurfarticle(david, surf200, 5);
		System.out.println("David returned 5/10 of his surfboards.");

		surfstore.returnSurfarticle(tom, surf200, 5);
		System.out.println("Tom tried to return 5/0 of his sufboards. None articles were returned.");

		surfstore.returnSurfarticle(david, surf200, 2);
		System.out.println("David returned 2/5 of his surfboards. 3 remaining.");
	}
}
