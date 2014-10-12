package at.tuwien.oopj4;

import java.util.Date;

public class SurfstoreTestMain {

	private static Surfstore surfstore;

	private static Person ulrich, david, tom;
	private static Surfarticle surf200, surf220, helmM;

	public static void main(String[] args)
	{
		System.out.println("Creating some Persons and Surfarticles:");
		initialize();
		
		System.out.println();
		System.out.println();
		
		System.out.println("Renting some articles:");
		borrowSurfarticleTest();
		
		System.out.println();
		System.out.println();
		
		System.out.println("Printing all rented articles:");
		surfstore.printSurfArticles();

		System.out.println();
		System.out.println();
		
		System.out.println("Returning some used articles:");
		returnSurfarticleTest();

		System.out.println();
		System.out.println();
		
		System.out.println("Printing all rented articles:");
		surfstore.printSurfArticles();

		System.out.println();
		System.out.println();
		
		System.out.println("Printing all persons:");
		surfstore.printPersons();
		
		
	}
	
	
	public static void initialize() {
		surfstore = new Surfstore();
		System.out.println("Surfstore was created.");		
		
		ulrich = surfstore.createPerson("Ulrich", "A");
		System.out.println(ulrich + " created.");
		
		david = surfstore.createPerson("David", "J");
		System.out.println(david + " created.");
		
		tom = surfstore.createPerson("Tom", "M");
		System.out.println(tom + " created.");
		
		surf200 = surfstore.createSurfarticle("Surfboard 200cm", 6.00f, 20);
		System.out.println(surf200 + " created.");
		
		surf220 = surfstore.createSurfarticle("Surfboard 220cm", 6.00f, 20);
		System.out.println(surf220 + " created.");
		
		helmM = surfstore.createSurfarticle("Helm M", 2.50f, 50);
		System.out.println(helmM + " created.");
	}

	public static void borrowSurfarticleTest() {
		Date d = new Date();
		
		d.setHours(8);
		System.out.println("Ulrich borrows 5 times surf200 at " + d);
		surfstore.borrowSurfarticle(ulrich, surf200, 5, d);
		
		d.setHours(9);
		System.out.println("David borrows 10 times surf200 at " + d);
		surfstore.borrowSurfarticle(david, surf200, 10, d);
		
		d.setHours(10);
		System.out.println("Tom borrows 7 times surf200 at " + d);
		surfstore.borrowSurfarticle(tom, surf200, 7, d);
	}

	public static void returnSurfarticleTest() {
		surfstore.returnSurfarticle(ulrich, surf200, 7);
		//System.out.println("Ulrich returned 5/5 of his surfboards.");
		
		surfstore.returnSurfarticle(david, surf200, 5);
		//System.out.println("David returned 5/10 of his surfboards.");
		
		surfstore.returnSurfarticle(tom, surf200, 5);
		//System.out.println("Tom tried to return 5/0 of his sufboards.");
		
		surfstore.returnSurfarticle(david, surf200, 2);
		//System.out.println("David returned 2/5 of his surfboards.");
	}


}
