/**
 * Aufteilung der Arbeiten:
 * Tom Muhm: Wood, Test, Bugfixing, Zusicherungen
 * Ulrich Aschl: SortedWood, Test, Bugfixing
 * David Jaffry: Zusicherungen, Test, Bugfixing, Person, Skier, Snowboarder
 */


public class Test {

	private static SortedWood<Skier> woodSkier0;
	private static SortedWood<Snowboarder> woodSnowboarder0;

	public static void main(String[] args) {
		test1();
		test2();
//		test3();
//		test4();
//		test5();
	}

	private static void test1() {
		System.out.println("1. Test");
		System.out.println("------------------------------");

		System.out.println("erstellen eines String-Baumes:\n");

		Wood<String> test1 = new Wood<String>("Test1");

		LeveledIter<String> testLevel1 = test1.iterator();
		testLevel1.add("Test2");
		if (testLevel1.hasNext())
			testLevel1.next();
		testLevel1.add("Test9");
		LeveledIter<String> testLevel2 = testLevel1.sub();
		testLevel2.add("Test4");
		if (testLevel1.hasNext())
			testLevel1.next();
		if (testLevel1.hasNext())
			testLevel1.next();
		testLevel1.add("Test9");
		testLevel2 = testLevel1.sub();
		testLevel2.add("Test5");
		if (testLevel2.hasNext())
			testLevel2.next();
		testLevel2.add("Test6");
		if (testLevel2.hasPrevious())
			testLevel2.previous();
		LeveledIter<String> testLevel3 = testLevel2.sub();
		testLevel3.add("Test7");
		testLevel3.add("Test8");

		System.out.println(printifyIterator(testLevel1, false));
		System.out.println("------------------------------");

		System.out.println("erstellen eines Skier-Baumes:\n");

		Skier skier0 = new Skier("skier0", 0);
		Skier skier1 = new Skier("skier1", 10);
		Skier skier2 = new Skier("skier2", 20);
		Skier skier3 = new Skier("skier3", 30);
		Skier skier4 = new Skier("skier4", 40);
		Skier skier5 = new Skier("skier5", 50);
		Skier skier6 = new Skier("skier6", 60);
		Skier skier7 = new Skier("skier7", 70);
		Skier skier8 = new Skier("skier8", 80);

		woodSkier0 = new SortedWood<Skier>(skier0);

		LeveledIter<Skier> skierTestLevel1 = woodSkier0.iterator();
		skierTestLevel1.add(skier1);
		skierTestLevel1.add(skier2);
		if (skierTestLevel1.hasNext())
			skierTestLevel1.next();
		LeveledIter<Skier> skierTestLevel2 = skierTestLevel1.sub();
		skierTestLevel2.add(skier3);
		skierTestLevel2.add(skier4);
		skierTestLevel2.add(skier5);
		if (skierTestLevel2.hasNext())
			skierTestLevel2.next();
		LeveledIter<Skier> skierTestLevel3 = skierTestLevel2.sub();
		skierTestLevel3.add(skier6);
		skierTestLevel3.add(skier7);
		skierTestLevel3.add(skier8);

		System.out.println(printifyIterator(skierTestLevel1, false));
		System.out.println("------------------------------");

		System.out.println("erstellen eines Snowboarder-Baumes:\n");

		Snowboarder snowboarder0 = new Snowboarder("Snowboarder0", 150);
		Snowboarder snowboarder1 = new Snowboarder("Snowboarder1", 150);
		Snowboarder snowboarder2 = new Snowboarder("Snowboarder2", 150);
		Snowboarder snowboarder3 = new Snowboarder("Snowboarder3", 150);
		Snowboarder snowboarder4 = new Snowboarder("Snowboarder4", 150);
		Snowboarder snowboarder5 = new Snowboarder("Snowboarder5", 150);
		Snowboarder snowboarder6 = new Snowboarder("Snowboarder6", 150);
		Snowboarder snowboarder7 = new Snowboarder("Snowboarder7", 150);
		Snowboarder snowboarder8 = new Snowboarder("Snowboarder8", 150);

		woodSnowboarder0 = new SortedWood<Snowboarder>(snowboarder0);

		LeveledIter<Snowboarder> snowboarderTestLevel1 = woodSnowboarder0.iterator();
		if (snowboarderTestLevel1.hasNext())
			snowboarderTestLevel1.next();
		snowboarderTestLevel1.add(snowboarder1);
		snowboarderTestLevel1.add(snowboarder2);
		LeveledIter<Snowboarder> snowboarderTestLevel2 = snowboarderTestLevel1.sub();
		snowboarderTestLevel2.add(snowboarder3);
		snowboarderTestLevel2.add(snowboarder4);
		snowboarderTestLevel2.add(snowboarder5);
		if (snowboarderTestLevel2.hasNext())
			snowboarderTestLevel2.next();
		LeveledIter<Snowboarder> snowboarderTestLevel3 = snowboarderTestLevel2.sub();
		snowboarderTestLevel3.add(snowboarder6);
		snowboarderTestLevel3.add(snowboarder7);
		snowboarderTestLevel3.add(snowboarder8);
		snowboarderTestLevel3.add(snowboarder4);

		System.out.println(printifyIterator(snowboarderTestLevel1, false));
		System.out.println("------------------------------");

		System.out.println("Skier in sortierter Reihenfolge nach Name:\n");

		Iter<Skier> itSkier = woodSkier0.sorted();
		while (itSkier.hasNext()) {
			Skier skier = itSkier.next();
			System.out.println(skier);
		}

		System.out.println("\n------------------------------");

		System.out.println("Snowboarder in absteigend sortierter Reihenfolge nach Name:\n");

		Iter<Snowboarder> itSnow = woodSnowboarder0.sorted();
		while (itSnow.hasNext())
			itSnow.next();

		while (itSnow.hasPrevious()) {
			Snowboarder snowboarder = itSnow.previous();
			System.out.println(snowboarder);
		}

		System.out.println("\n------------------------------");
		System.out.println("Contains Test: Suche nach Snowboarder4, Ausgabe der Unterbaeume:\n");

		LeveledIter<Snowboarder> iterContainsSnow = woodSnowboarder0.contains(snowboarder4);
		System.out.println(printifyIterator(iterContainsSnow, false));

		System.out.println("\n------------------------------");
		System.out.println("Contains Test: Suche nach Test9, Ausgabe der Unterbaeume:\n");

		LeveledIter<String> iterContainsString = test1.contains("Test9");
		System.out.println(printifyIterator(iterContainsString, false));

		System.out.println("------------------------------");
		System.out.println("Remove Test: Ausgabe vor dem enfernen von Snowboarder7:\n");

		System.out.println(printifyIterator(snowboarderTestLevel1, false));

		System.out.println("------------------------------");
		System.out.println("Remove Test: Ausgabe nach dem enfernen von Snowboarder7:\n");

		if (snowboarderTestLevel3.hasPrevious())
			snowboarderTestLevel3.previous();
		snowboarderTestLevel3.remove();
		System.out.println(printifyIterator(snowboarderTestLevel1, false));

		System.out.println("------------------------------");

		System.out.println("Add Test: Ausgabe nach dem einfuegn von Snowboarder7 in Ebene2:\n");

		snowboarderTestLevel2.add(snowboarder7);
		System.out.println(printifyIterator(snowboarderTestLevel1, false));

		System.out.println("------------------------------");
	}

	private static void test2() {
		System.out.println("2. Test");
		System.out.println("------------------------------");

		System.out.println("erstellen eines Person-Baums mit Skier & Snowboardern:");

		Skier skier6 = new Skier("skier6", 54);
		SortedWood<Person> persWood = new SortedWood<Person>(skier6);
		LeveledIter<Person> persIter = persWood.iterator();

		Iter<Skier> skierIter = woodSkier0.sorted();
		Iter<Snowboarder> snowIter = woodSnowboarder0.sorted();

		while (skierIter.hasNext()) {
			persIter.add(skierIter.next());
		}
		persIter.add(skier6);
		while (snowIter.hasNext()) {
			persIter.add(snowIter.next());
		}
		persIter.add(skier6);

		System.out.println(printifyIterator(persIter, true));
		System.out.println("------------------------------");
		System.out.println("Contains Test: Suche nach skier6 mit gewicht 54, Ausgabe aller Element:\n");

		LeveledIter<Person> iterContainsString = persWood.contains(skier6);
		System.out.println(printifyIterator(iterContainsString, true));

		System.out.println("------------------------------");
		System.out.println("Remove Test: Ausgabe vor dem enfernen des ersten Elements:\n");

		System.out.println(printifyIterator(persIter, true));

		System.out.println("------------------------------");
		System.out.println("Remove Test: Ausgabe nach dem enfernen des ersten Elements:\n");

		while (persIter.hasPrevious())
			persIter.previous();
		persIter.next();
		persIter.remove();
		System.out.println(printifyIterator(persIter, true));

		System.out.println("------------------------------");

		System.out.println("Add Test: Ausgabe nach dem einfuegn von skier7 in Ebene1, 2 und 3:\n");

		persIter.add(skier6);
		persIter.sub().add(skier6);
		persIter.sub().sub().add(skier6);

		System.out.println(printifyIterator(persIter, true));

		System.out.println("------------------------------");
	}

	private static void test3() {
		System.out.println("3. Test");
		System.out.println("------------------------------");

		Skier sk0 = new Skier("Sk00", 100);
		Skier sk1 = new Skier("Sk01", 100);
		Skier sk2 = new Skier("Sk02", 100);
		Skier sk3 = new Skier("Sk03", 100);
		Snowboarder sb0 = new Snowboarder("Sn00", 120);
		Snowboarder sb1 = new Snowboarder("Sn01", 120);
		Snowboarder sb2 = new Snowboarder("Sn02", 120);

		SortedWood<Person> sw0 = new SortedWood<Person>(sk0);
		LeveledIter<Person> iterTemp = sw0.iterator();
		iterTemp.add(sk1);
		iterTemp.add(sb0);
		iterTemp.add(sb1);

		SortedWood<Person> sw1 = new SortedWood<Person>(sk2);
		iterTemp = sw1.iterator();
		iterTemp.add(sk2);
		iterTemp.add(sk3);
		iterTemp.add(sb2);

		SortedWood<SortedWood<Person>> sw_sw_pers = new SortedWood<SortedWood<Person>>(sw0);
		LeveledIter<SortedWood<Person>> sw_sw_iter = sw_sw_pers.iterator();
		sw_sw_iter.add(sw1);

		System.out.println(printifyIterator(sw_sw_iter, false));
		System.out.println("------------------------------");
	}

	private static void test4() {
		System.out.println("4. Test");
		System.out.println("------------------------------");

		System.out.println("Erstellen eines Person-Baums mit Skier und Snowboardern:");

		Person person = new Skier("Test", 12);
		Wood<Person> persWood = new Wood<Person>(person);
		LeveledIter<Person> iterPers = persWood.iterator();

		Iter<Skier> skierIter = woodSkier0.iterator();
		Iter<Snowboarder> snowIter = woodSnowboarder0.iterator();

		while (skierIter.hasNext()) {
			iterPers.add(skierIter.next()); // change to iterPers and '\n' skierIter.next(); ?
		}
		while (snowIter.hasNext()) {
			iterPers.add(snowIter.next()); // change to iterPers and '\n' snowIter.next(); ?
		}

		System.out.println(printifyIterator(iterPers, false));

		System.out.println("Contains Test von Person-Tree:");
		LeveledIter<Person> containsTest = persWood.contains(person); // cast?
		System.out.println(printifyIterator(containsTest, false));
		System.out.println();

		// TODO: http://pastebin.com/jx2cZDA3 might help?
		System.out.println("------------------------------");
	}

	private static void test5() {
		System.out.println("5. Test");
		System.out.println("------------------------------");

		System.out.println("Testen der Prec Methode von Sorted Wood");

		//prec
		//sortedWood methoden
		System.out.println("------------------------------");
	}

	private static String printifyIterator(LeveledIter<?> iter, boolean concat) {
		while (iter.hasPrevious()) iter.previous();

		StringBuilder out = new StringBuilder();
		toStringHelper(out, "", iter, concat);

		while (iter.hasPrevious()) iter.previous();

		return out.toString();
	}

	private static void toStringHelper(StringBuilder out, String indent, LeveledIter<?> iter, boolean concat) {
		while (iter.hasNext()) {
			// Nachbedingung: wechselt in die Substruktur vom derzeitigen Wood
			LeveledIter sub = iter.sub();
			String elem = iter.next().toString();
			if (concat) {
				elem = elem.substring(0, elem.indexOf(","));
			}
			out.append(indent + elem + "\n");
			toStringHelper(out, indent + "--", sub, concat);
		}
	}
}