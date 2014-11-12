/**
 * Aufgabe 1:
 * 	Die Klassen Rental.java und Person.java wurden von Ulrich Aschl geschrieben.
 * 	Die Klasse Article.java wurde von David Jaffry geschrieben.
 * 	Die Klasse Surfstore.java wurde von Thomas Muhm geschrieben.
 * 	Anschliessend wurde noch Test.java von Ulrich Aschl erstellt.
 *  Gemeinsame Planung der Programmarchitektur
 *  
 * Aufgabe 2:
 * 	SurfSchool, Course, Discount, Student, Teacher, Customer, Person, Test -> Ulrich Aschl
 * 	Accounting, Bill, IncomingBill, OutgoingBill, Order -> David Jaffry
 * 	Article, ArticleRent, ArticleSale, Rental, StockManagement, SurfStore, Test -> Tom Muhm 
 * 	Gemeinsame Planung der Programmarchitektur
 * 
 * Aufgabe 3:
 * 	COMMENTS wurden von allen Gruppenmitgliedern gemeinsam an einem einzelnem Geraet geschrieben.
 * 
 * 
 * Wieso nicht genuegend GOODs markiert wurden:
 *  Da wir unseren Klassenzusammenhalt im Allgemeinen als eher hoch einschaetzen (bis auf den Surfstore), wussten wir nicht genau, in welchen Dateien wir den
 *  Klassenzusammenhalt eher hervorheben sollten. Wir wollten ebenso nicht die Dateien nur mit GOOD-Kommentaren ueber Klassenzusammenhalt
 *  ueberfluten.
 * 
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Test {

	private static Surfstore surfstore;

	private static Customer ulrich, david, tom;
	private static Article surf200Rent, surf200Sale, surf220Rent, surf220Sale, helmMediumRent;
	private static ArrayList<Rental> ulrichRentals, davidRental, tomRentals;
	
	public static void main(String[] args) {
		System.out.println("Creating some Persons and Surfarticles:");
		createTestData();

		System.out.println("\n\nRenting some articles:");
		borrowSurfarticleTest();

		System.out.println("\n\nReturning some used articles:");
		returnSurfarticleTest();

		System.out.println("\n\nSelling some articles:");
		sellSurfarticleTest();

		System.out.println("\n\nDiscarding some articles:");
		discardSurfarticleTest();

		System.out.println("\n\nSurfschool:");
		surfschoolTest();

		System.out.println("\n\nPrinting all articles:");
		System.out.println(surfstore.printArticles());

		System.out.println("\n\nPrinting all persons:");
		System.out.println(surfstore.printPersons());

		System.out.println("\nStatistics:");
		statisticsTest();
	}

	// PRECONDITION: surfstore must not be null
	private static void statisticsTest() {
		System.out.println("Stock statistics:");
		System.out.println(surfstore.getStockingStatistics());

		System.out.println("Accounting statistics:");
		System.out.println(surfstore.getAccountingStatistics());
	}

	// POSTCONDITION: surfstore, surf200Rent, surf220Rent, surf200Sale, surf220Sale, helmMediumRent, ulrich, tom and david must not be null
	private static void createTestData() {
		surfstore = new Surfstore(50000, 3000);
		System.out.println("Surfstore was created.");

		ulrich = new Customer("Ulrich A");
		david = new Customer("David J");
		tom = new Customer("Tom M");

		surfstore.addCustomer(ulrich);
		surfstore.addCustomer(david);
		surfstore.addCustomer(tom);

		System.out.println("Customers ulrich, david and tom were created and added to the surfstore.");

		System.out.println("Buying some articles:");
		Article surfboard200Rent = new ArticleRent("Surfboard", "200cm", 3f, 20f, false);
		surf200Rent = surfstore.buyArticles(surfboard200Rent, 1200f, 10, true);
		System.out.println(surf200Rent + " bought.");

		Article surfboard220Rent = new ArticleRent("Surfboard", "220cm", 3f, 20f, false);
		surf220Rent = surfstore.buyArticles(surfboard220Rent, 1200f, 10, true);
		System.out.println(surf220Rent + " bought.");

		Article surfboard200Sale = new ArticleSale("Surfboard", "200cm", 250f, true);
		surf200Sale = surfstore.buyArticles(surfboard200Sale, 500f, 3, false);
		System.out.println(surf200Sale + " bought.");

		Article surfboard220Sale = new ArticleSale("Surfboard", "220cm", 250f, true);
		surf220Sale = surfstore.buyArticles(surfboard220Sale, 500f, 3, false);
		System.out.println(surf220Sale + " bought.");

		Article helmRent = new ArticleRent("Helm", "M", 2f, 10f, true);
		helmMediumRent = surfstore.buyArticles(helmRent, 150, 5, true);
		System.out.println(helmMediumRent + " bought.");

		System.out.println("Account/Cash: " + surfstore.getBalanceAccount() + "/" + surfstore.getBalanceCash());
	}
	
	// POSTCONDITION: surfstore, surf200Rent, surf220Rent, surf220Sale, helmMediumRent, ulrich, tom and david must not be null
	private static void borrowSurfarticleTest() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, -4);
		System.out.println("Ulrich borrows surf200Rent at " + c.getTime());
		ulrichRentals = surfstore.borrowArticle(ulrich, surf200Rent, c.getTime(), 3);

		c.add(Calendar.DAY_OF_MONTH, -10);
		c.add(Calendar.HOUR, -4);
		System.out.println("David borrows surf220Sale at " + c.getTime());
		System.out.println("Sale articles can't be borrowed");
		davidRental = surfstore.borrowArticle(david, surf220Sale, c.getTime(), 1);

		System.out.println("David borrows surf220Rent at " + c.getTime());
		davidRental = surfstore.borrowArticle(david, surf220Rent, c.getTime(), 1);

		c.add(Calendar.HOUR, -4);
		System.out.println("Tom borrows 7 times helmMediumRent at " + c.getTime());
		System.out.println("Tom couldn't borrow helmMediumRent - only 5 available - he borrowed 5");
		tomRentals = surfstore.borrowArticle(tom, helmMediumRent, c.getTime(), 7);
	}

	// PRECONDITION: ulrich, david, tom, ulrichRentals, davidRentals, tomRentals and surfstore must not be null
	private static void returnSurfarticleTest() {
		OutgoingBill oUlrich = surfstore.returnArticles(ulrich, ulrichRentals, true);
		System.out.println("Ulrich returns 7/5 of his surfboards. He returend 5/5:");
		System.out.println("\t" + oUlrich.toString());

		OutgoingBill oDavid = surfstore.returnArticles(david, davidRental, false);
		System.out.println("David returned 5/10 of his surfboards.");
		System.out.println("\t" + oDavid.toString());

		OutgoingBill oTom = surfstore.returnArticles(tom, tomRentals, true);
		System.out.println("Tom tried to return 5/5 of his sufboards. All were returned.");
		System.out.println("\t" + oTom.toString());

		System.out.println("Account/Cash: " + surfstore.getBalanceAccount() + "/" + surfstore.getBalanceCash());
	}

	// PRECONDITION: surfstore, helmMediumRent, surf200Sale and tom must not be null
	private static void sellSurfarticleTest() {
		surfstore.sellArticles(helmMediumRent, 3, true, tom);
		System.out.println("Rent-Articles can not be sold");

		surfstore.sellArticles(surf200Sale, 2, true, tom);
		System.out.println("Sold 2/3: " + surf200Sale);
	}
	
	// PRECONDITION: surfstore, helmMediumRent and surf200Sale must not be null
	private static void discardSurfarticleTest() {
		surfstore.discardArticles(surf200Sale, 1);
		System.out.println("discarded the last: " + surf200Sale);

		surfstore.discardArticles(helmMediumRent, 3);
		System.out.println("discarded 3/5 " + helmMediumRent);
	}

	// PRECONDITION: surfstore must not be null
	private static void surfschoolTest() {
		System.out.println("Creating some dummy students, teacher and dummy dates!");
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i < 15; i++) {
			students.add(new Student("Student Nr. " + (i + 1)));
		}
		Teacher teacher = new Teacher("Prof. Surf");
		ArrayList<Date> dates = new ArrayList<Date>();
		for (int i = 0; i < 6; i++) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.HOUR, 1);
			dates.add(c.getTime());
		}

		System.out.println("Creating the surf course.");
		Course newbies1Course = new Course("Newbies 1", 300f, teacher, students, dates);
		Course course = surfstore.addCourse(newbies1Course);

		System.out.println("Created bills for all students and add them to the accounting.");
		ArrayList<OutgoingBill> bills = surfstore.createBillsForSurfSchool(course);

		System.out.println("Account/Cash: " + surfstore.getBalanceAccount() + "/" + surfstore.getBalanceCash());
	}
}
