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

import java.util.ArrayList;
import java.util.Date;

public class Test {

	private static Surfstore surfstore;

	private static Person ulrich, david, tom;
	private static Article surf200Rent, surf220Sale, helmMediumRent;
	private static Rental davidRental;
	private static ArrayList<Rental> ulrichRentals, tomRentals;

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


		Article surfboard200Rent = new ArticleRent("Surfboard", "200cm", 3f, 20f, false);
		surf200Rent = surfstore.buyArticles(surfboard200Rent, 1200f, 10);
		System.out.println(surf200Rent + " created.");

		Article surfboard220Sale = new ArticleSale("Surfboard", "220cm", 250f, true);
		surf220Sale = surfstore.buyArticles(surfboard220Sale, 500f, 3);
		System.out.println(surf220Sale + " created.");

		Article helmRent = new ArticleRent("Helm", "M", 2f, 10f, true);
		helmMediumRent = surfstore.buyArticles(helmRent, 150, 5);
		System.out.println(helmMediumRent + " created.");
	}

	public static void borrowSurfarticleTest() {
		Date d = new Date();

		d.setHours(4);
		System.out.println("Ulrich borrows surf200Rent at " + d);
		ulrichRentals = surfstore.borrowArticles(ulrich, surf200Rent, d, 3);

		d.setHours(5);
		System.out.println("David borrows surf220Sale at " + d);
		System.out.println("Sale articles can't be borrowed");
		davidRental = surfstore.borrowArticle(david, surf220Sale, d);

		d.setHours(6);
		System.out.println("Tom borrows 7 times helmMediumRent at " + d);
		System.out.println("Tom couldn't borrow helmMediumRent - only 5 available");
		tomRentals = surfstore.borrowArticles(tom, helmMediumRent, d, 7);
	}

	public static void returnSurfarticleTest() {
		surfstore.returnArticles(ulrich, ulrichRentals);
		System.out.println("Ulrich returns 7/5 of his surfboards. He returend 5/5.");

		surfstore.returnArticle(david, davidRental);
		System.out.println("David returned 5/10 of his surfboards.");

		surfstore.returnArticles(tom, tomRentals);
		System.out.println("Tom tried to return 5/0 of his sufboards. None articles were returned.");
	}
}
