/**
 * Aufteilung der Arbeiten:
 * Tom Muhm: Wood, Test, generelle Arbeiten, Bugfixing
 * Ulrich Aschl: SortedWood, Test, Bugfixing
 * David Jaffry: Bedingungen, Test, Bugfixing, Person, Skier, Snowboarder
 */


public class Test {

	private static SortedWood<Skier> woodSkier0;
	private static SortedWood<Snowboarder> woodSnowboarder0;

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	private static void test1() {
		System.out.println("1. Test");

		System.out.println("erstellen eines String-Baumes:");

		Wood<String> test1 = new Wood<String>("Test1");

		LeveledIter<String> testLevel1 = test1.iterator();
		testLevel1.add("Test2");
		testLevel1.next();
		testLevel1.add("Test9");
		LeveledIter<String> testLevel2 = testLevel1.sub();
		testLevel2.add("Test4");
		testLevel1.next();
		testLevel1.next();
		testLevel1.add("Test9");
		testLevel2 = testLevel1.sub();
		testLevel2.add("Test5");
		testLevel2.next();
		testLevel2.add("Test6");
		testLevel2.previous();
		LeveledIter<String> testLevel3 = testLevel2.sub();
		testLevel3.add("Test7");
		testLevel3.add("Test8");

		System.out.println(printifyIterator(testLevel1));

		System.out.println("erstellen eines Skier-Baumes:");

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
		skierTestLevel1.next();
		LeveledIter<Skier> skierTestLevel2 = skierTestLevel1.sub();
		skierTestLevel2.add(skier3);
		skierTestLevel2.add(skier4);
		skierTestLevel2.add(skier5);
		skierTestLevel2.next();
		LeveledIter<Skier> skierTestLevel3 = skierTestLevel2.sub();
		skierTestLevel3.add(skier6);
		skierTestLevel3.add(skier7);
		skierTestLevel3.add(skier8);

		System.out.println(printifyIterator(skierTestLevel1));

		System.out.println("erstellen eines Snowboarder-Baumes:");

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
		snowboarderTestLevel1.next();
		snowboarderTestLevel1.add(snowboarder1);
		snowboarderTestLevel1.add(snowboarder2);
		LeveledIter<Snowboarder> snowboarderTestLevel2 = snowboarderTestLevel1.sub();
		snowboarderTestLevel2.add(snowboarder3);
		snowboarderTestLevel2.add(snowboarder4);
		snowboarderTestLevel2.add(snowboarder5);
		snowboarderTestLevel2.next();
		LeveledIter<Snowboarder> snowboarderTestLevel3 = snowboarderTestLevel2.sub();
		snowboarderTestLevel3.add(snowboarder6);
		snowboarderTestLevel3.add(snowboarder7);
		snowboarderTestLevel3.add(snowboarder8);
		snowboarderTestLevel3.add(snowboarder4);

		System.out.println(printifyIterator(snowboarderTestLevel1));

		System.out.println("Ausgabe der sortierten Skier in aufsteigender Reihenfolge");

		Iter<Skier> itSkier = woodSkier0.sorted();
		while (itSkier.hasNext()) {
			Skier skier = itSkier.next();
			System.out.println(skier);
		}

		System.out.println();
		System.out.println("Ausgabe der sortierten Snowboarder in absteigender Reihenfolge");

		Iter<Snowboarder> itSnow = woodSnowboarder0.sorted();
		while (itSnow.hasNext()) itSnow.next();
		while (itSnow.hasPrevious()) {
			Snowboarder snowboarder = itSnow.previous();
			System.out.println(snowboarder);
		}

		System.out.println();
		System.out.println("Contains Test - Ausgabe aller Teilbaeume der gefunden Snowboarder: \n");

		LeveledIter<Snowboarder> iterContainsSnow = woodSnowboarder0.contains(snowboarder4);

		System.out.println(printifyIterator(iterContainsSnow));

		LeveledIter<String> iterContainsString = test1.contains("Test9");

		System.out.println(printifyIterator(iterContainsString));

		System.out.println("Contains Test");

		System.out.println("Datenstruktur vor dem entfernen von Snowboarder6");

		System.out.println(printifyIterator(snowboarderTestLevel1));
		snowboarderTestLevel3.previous();
		snowboarderTestLevel3.remove();
		System.out.println(printifyIterator(snowboarderTestLevel1));

		System.out.println("Datenstruktur nach dem entfernen von Snowboarder6");

		System.out.println("Datenstruktur nach dem einfuegen von Snowboarder6 in Ebene2");

		snowboarderTestLevel2.add(snowboarder6);
		System.out.println(printifyIterator(snowboarderTestLevel1));
		System.out.println();
	}

	private static void test2() {
		System.out.println("2. Test");

		System.out.println("Erstellen eines Person-Baums mit Skier und Snowboardern:");

		Person person = new Skier("Test", 12);
		SortedWood<Person> persWood = new SortedWood<Person>(person);
		LeveledIter<Person> iterPers = persWood.iterator();

		Iter<Skier> skierIter = woodSkier0.sorted();
		Iter<Snowboarder> snowIter = woodSnowboarder0.sorted();

		while (skierIter.hasNext()) {
			iterPers.add(skierIter.next());
		}
		while (snowIter.hasNext()) {
			iterPers.add(snowIter.next());
		}

		System.out.println(printifyIterator(iterPers));

		System.out.println("Contains Test von Sorted-Person-Tree:");
		LeveledIter<Person> containsTest = persWood.contains(person);
		System.out.println(printifyIterator(containsTest));
		System.out.println();
	}

	private static void test3() {
		System.out.println("3. Test");

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

		System.out.println(printifyIterator(sw_sw_iter));
		System.out.println();
	}

	private static void test4() {
		System.out.println("4. Test");
		System.out.println("Erstellen eines Person-Baums mit Skier und Snowboardern:");

		Person person = new Skier("Test", 12);
		Wood<Person> persWood = new Wood<Person>(person);
		LeveledIter<Person> iterPers = persWood.iterator();

		Iter<Skier> skierIter = woodSkier0.iterator();
		Iter<Snowboarder> snowIter = woodSnowboarder0.iterator();

		while (skierIter.hasNext()) {
			iterPers.add(skierIter.next());
		}
		while (snowIter.hasNext()) {
			iterPers.add(snowIter.next());
		}

		System.out.println(printifyIterator(iterPers));

		System.out.println("Contains Test von Sorted-Person-Tree:");
		LeveledIter<Person> containsTest = persWood.contains(person);
		System.out.println(printifyIterator(containsTest));
		System.out.println();
		
	}

	private static void test5() {
		System.out.println("5. Test");
		System.out.println();

		//prec
		//sortedWood methoden
		
	}

	private static String printifyIterator(LeveledIter iter) {
		while (iter.hasPrevious()) iter.previous();

		StringBuilder out = new StringBuilder();
		toStringHelper(out, "", iter);

		while (iter.hasPrevious()) iter.previous();

		return out.toString();
	}

	private static void toStringHelper(StringBuilder out, String indent, LeveledIter iter) {
		while (iter.hasNext()) {
			// Nachbedingung: wechselt in die Substruktur vom derzeitigen Wood
			LeveledIter sub = iter.sub();
			out.append(indent + iter.next() + "\n");
			toStringHelper(out, indent + "--", sub);
		}
	}
}