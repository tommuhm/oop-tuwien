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
	private static Article surf200Rent, surf200Sale, surf220Rent, surf220Sale, helmMediumRent;
	private static Rental davidRental;
	private static ArrayList<Rental> ulrichRentals, tomRentals;

	public static void main(String[] args) {
		System.out.println("Creating some Persons and Surfarticles:");
		initialize();

		System.out.println("\n\nRenting some articles:");
		borrowSurfarticleTest();
		
		System.out.println("\n\nReturning some used articles:");
		returnSurfarticleTest();

		System.out.println("\n\nSurfschool:");
		surfschool();
		
		System.out.println("\n\nPrinting all articles:");
		System.out.println(surfstore.printArticles());

		System.out.println("\n\nPrinting all persons:");
		System.out.println(surfstore.printPersons());
		
		System.out.println("\nStatistics:");
		statistics();
	}




	private static void statistics() {
		System.out.println("Stock statistics:");
		System.out.println(surfstore.getStockingStatistics());
		
		System.out.println("Accounting statistics:");
		System.out.println(surfstore.getAccountingStatistics());
	}




	public static void initialize() {
		surfstore = new Surfstore(50000, 3000);
		System.out.println("Surfstore was created.");

		ulrich = surfstore.createCustomer("Ulrich", "A");
		System.out.println(ulrich + " created.");

		david = surfstore.createCustomer("David", "J");
		System.out.println(david + " created.");

		tom = surfstore.createCustomer("Tom", "M");
		System.out.println(tom + " created.");

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

	public static void borrowSurfarticleTest() {
		Date d = new Date();

		d.setHours(4);
		System.out.println("Ulrich borrows surf200Rent at " + d);
		ulrichRentals = surfstore.borrowArticles(ulrich, surf200Rent, d, 3);

		d.setDate(10);
		d.setHours(5);
		System.out.println("David borrows surf220Sale at " + d);
		System.out.println("Sale articles can't be borrowed");
		davidRental = surfstore.borrowArticle(david, surf220Sale, d);
		
		System.out.println("David borrows surf220Rent at " + d);
		davidRental = surfstore.borrowArticle(david, surf220Rent, d);

		d.setHours(6);
		System.out.println("Tom borrows 7 times helmMediumRent at " + d);
		System.out.println("Tom couldn't borrow helmMediumRent - only 5 available - he borrowed 5");
		tomRentals = surfstore.borrowArticles(tom, helmMediumRent, d, 7);
	}

	public static void returnSurfarticleTest() {
		OutgoingBill oUlrich = surfstore.returnArticles(ulrich, ulrichRentals, true);
		System.out.println("Ulrich returns 7/5 of his surfboards. He returend 5/5:");
		System.out.println("\t" + oUlrich.toString());

		ArrayList<Rental> davidRentals = new ArrayList<Rental>();
		davidRentals.add(davidRental);
		OutgoingBill oDavid = surfstore.returnArticles(david, davidRentals, false);
		System.out.println("David returned 5/10 of his surfboards.");
		System.out.println("\t" + oDavid.toString());
		
		OutgoingBill oTom = surfstore.returnArticles(tom, tomRentals, true);
		System.out.println("Tom tried to return 5/5 of his sufboards. All were returned.");
		System.out.println("\t" + oTom.toString());
		
		System.out.println("Account/Cash: " + surfstore.getBalanceAccount() + "/" + surfstore.getBalanceCash());
		
	}
	

	private static void surfschool() {
		
		System.out.println("Creating some dummy students, teacher and dummy dates!");
		ArrayList<Student> students = new ArrayList<Student>();
		for(int i = 0; i < 15; i++)
		{
			students.add(new Student("Student Nr. " + (i+1)));
		}
		Teacher teacher = new Teacher("Prof. Surf");
		ArrayList<Date> dates = new ArrayList<Date>();
		for(int i = 0; i < 6; i++)
		{
			Date d = new Date();
			d.setDate(i+1); //In our test.java we use some deprecated methods to relieve some complexity.
			dates.add(d);
		}
		
		System.out.println("Creating the surf course.");
		Course course = surfstore.addCourse("Newbies 1", 300f, teacher, students, dates);
		
		System.out.println("Created bills for all students and added them to the accounting.");
		ArrayList<OutgoingBill> bills = surfstore.createOutgoingBillsSurfSchool(course);
		
		System.out.println("Account/Cash: " + surfstore.getBalanceAccount() + "/" + surfstore.getBalanceCash());
		
	}
}
