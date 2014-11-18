
public class Test {
	
	static int lvlcounter = 0;
	static int stagecounter = 0;

	public static void main(String[] args) {

		//1
		Wood<String> test1 = new Wood<String>("Test1");
		Wood<String> test2 = new Wood<String>("Test2");
		Wood<String> test3 = new Wood<String>("Test3");
		Wood<String> test4 = new Wood<String>("Test4");
		Wood<String> test5 = new Wood<String>("Test5");
		Wood<String> test6 = new Wood<String>("Test6");
		Wood<String> test7 = new Wood<String>("Test7");
		Wood<String> test8 = new Wood<String>("Test8");
		Wood<String> test9 = new Wood<String>("Test9");
		
		LeveledIter<Wood<String>> testLevel1 = test1.iterator();
		testLevel1.add(test2);
		testLevel1.next();
		testLevel1.add(test3);
		LeveledIter<Wood<String>> testLevel2 = testLevel1.sub();
		testLevel2.add(test4);
		testLevel1.next();
		testLevel1.next();
		testLevel1.add(test9);
		testLevel2 = testLevel1.sub();
		testLevel2.add(test5);
		testLevel2.next();
		testLevel2.add(test6);
		testLevel2.previous();
		LeveledIter<Wood<String>> testLevel3 = testLevel2.sub();
		testLevel3.add(test7);
		testLevel3.add(test8);
		
		System.out.println(test1.toString());
				

		Skier skier0 = new Skier("skier0", 0);
		Skier skier1 = new Skier("skier1", 10);
		Skier skier2 = new Skier("skier2", 20);
		Skier skier3 = new Skier("skier3", 30);
		Skier skier4 = new Skier("skier4", 40);
		Skier skier5 = new Skier("skier5", 50);
		Skier skier6 = new Skier("skier6", 60);
		Skier skier7 = new Skier("skier7", 70);
		Skier skier8 = new Skier("skier8", 80);
		
		SortedWood<Skier> woodSkier0 = new SortedWood<Skier>(skier0);
		SortedWood<Skier> woodSkier1 = new SortedWood<Skier>(skier1);
		SortedWood<Skier> woodSkier2 = new SortedWood<Skier>(skier2);
		SortedWood<Skier> woodSkier3 = new SortedWood<Skier>(skier3);
		SortedWood<Skier> woodSkier4 = new SortedWood<Skier>(skier4);
		SortedWood<Skier> woodSkier5 = new SortedWood<Skier>(skier5);
		SortedWood<Skier> woodSkier6 = new SortedWood<Skier>(skier6);
		SortedWood<Skier> woodSkier7 = new SortedWood<Skier>(skier7);
		SortedWood<Skier> woodSkier8 = new SortedWood<Skier>(skier8);
		
		LeveledIter<Wood<Skier>> skierTestLevel1 = woodSkier0.iterator();
		skierTestLevel1.add(woodSkier1);
		skierTestLevel1.add(woodSkier2);
		skierTestLevel1.next();
		LeveledIter<Wood<Skier>> skierTestLevel2 = skierTestLevel1.sub();
		skierTestLevel2.add(woodSkier3);
		skierTestLevel2.add(woodSkier4);
		skierTestLevel2.add(woodSkier5);
		skierTestLevel2.next();
		LeveledIter<Wood<Skier>> skierTestLevel3 = skierTestLevel2.sub();
		skierTestLevel3.add(woodSkier6);
		skierTestLevel3.add(woodSkier7);
		skierTestLevel3.add(woodSkier8);
		
		System.out.println(woodSkier0);

		Snowboarder snowboarder0 = new Snowboarder("Snowboarder0", 150);
		Snowboarder snowboarder1 = new Snowboarder("Snowboarder1", 150);
		Snowboarder snowboarder2 = new Snowboarder("Snowboarder2", 150);
		Snowboarder snowboarder3 = new Snowboarder("Snowboarder3", 150);
		Snowboarder snowboarder4 = new Snowboarder("Snowboarder4", 150);
		Snowboarder snowboarder5 = new Snowboarder("Snowboarder5", 150);
		Snowboarder snowboarder6 = new Snowboarder("Snowboarder6", 150);
		Snowboarder snowboarder7 = new Snowboarder("Snowboarder7", 150);
		Snowboarder snowboarder8 = new Snowboarder("Snowboarder8", 150);
		
		
		SortedWood<Snowboarder> woodSnowboarder0 = new SortedWood<Snowboarder>(snowboarder0);
		SortedWood<Snowboarder> woodSnowboarder1 = new SortedWood<Snowboarder>(snowboarder1);
		SortedWood<Snowboarder> woodSnowboarder2 = new SortedWood<Snowboarder>(snowboarder2);
		SortedWood<Snowboarder> woodSnowboarder3 = new SortedWood<Snowboarder>(snowboarder3);
		SortedWood<Snowboarder> woodSnowboarder4 = new SortedWood<Snowboarder>(snowboarder4);
		SortedWood<Snowboarder> woodSnowboarder5 = new SortedWood<Snowboarder>(snowboarder5);
		SortedWood<Snowboarder> woodSnowboarder6 = new SortedWood<Snowboarder>(snowboarder6);
		SortedWood<Snowboarder> woodSnowboarder7 = new SortedWood<Snowboarder>(snowboarder7);
		SortedWood<Snowboarder> woodSnowboarder8 = new SortedWood<Snowboarder>(snowboarder8);
		
		LeveledIter<Wood<Snowboarder>> snowboarderTestLevel1 = woodSnowboarder0.iterator();
		snowboarderTestLevel1.next();
		snowboarderTestLevel1.add(woodSnowboarder1);
		snowboarderTestLevel1.add(woodSnowboarder2);
		LeveledIter<Wood<Snowboarder>> snowboarderTestLevel2 = snowboarderTestLevel1.sub();
		snowboarderTestLevel2.add(woodSnowboarder3);
		snowboarderTestLevel2.add(woodSnowboarder4);
		snowboarderTestLevel2.add(woodSnowboarder5);
		snowboarderTestLevel2.next();
		LeveledIter<Wood<Snowboarder>> snowboarderTestLevel3 = snowboarderTestLevel2.sub();
		snowboarderTestLevel3.add(woodSnowboarder6);
		snowboarderTestLevel3.add(woodSnowboarder7);
		snowboarderTestLevel3.add(woodSnowboarder8);
		
		System.out.println(woodSnowboarder0);
		
		
		Iter<Wood<Snowboarder>> itSnow = woodSnowboarder0.sorted();
		Snowboarder snowboarder = null;
		while(itSnow.hasNext()) itSnow.next();
		while(itSnow.hasPrevious()) {
			snowboarder = itSnow.previous().getElement();
			System.out.println(snowboarder);
		}

		System.out.println();
		
		Iter<Wood<Skier>> itSkier = woodSkier0.sorted();
		Skier skier = null;
		while(itSkier.hasNext()) {
			skier = itSkier.next().getElement();
			System.out.println(skier);
		}

		System.out.println();
		
		LeveledIter<Wood<Snowboarder>> iter_cont_snow = woodSnowboarder0.contains(snowboarder4);
		Wood<Snowboarder> tempWood = null;
		while(iter_cont_snow.hasNext()) {
			tempWood = iter_cont_snow.next();
			System.out.println(tempWood.toString());
		}

		System.out.println();
		
		//Lets remove snowboarder6 (he is next on snowboarderTestLevel 3)
		snowboarderTestLevel3.previous();
		snowboarderTestLevel3.remove();
		System.out.println(woodSnowboarder0.toString());
		
		//Now lets add him/her again, but this time on level2.
		snowboarderTestLevel2.add(woodSnowboarder6);
		System.out.println(woodSnowboarder0.toString());
		
		
	
		//2
		SortedWood<Person> woodPerson = null;
		
		LeveledIter<Wood<Person>> it_pers = null;
		Iter<Wood<Skier>> it_skier = woodSkier0.sorted(); 
		Iter<Wood<Snowboarder>> it_snowboarder = woodSnowboarder0.sorted(); 

		Wood<Skier> ski_temp;
		Wood<Snowboarder> sb_temp;
		
		while(it_skier.hasNext()) {
			ski_temp = it_skier.next();
			if(woodPerson == null) {
				woodPerson = new SortedWood<Person>(ski_temp.getElement());
				it_pers = woodPerson.iterator();
			} else {
				it_pers.add(ski_temp);
			}
		}
		
		/*
		Erzeugen Sie eine Datenstruktur vom Typ SortedWood<Person>.
		Lesen Sie über Iteratoren alle Elemente aus den in Punkt 1 erzeugten Datenstrukturen 
		der Typen SortedWood<Skier> und SortedWood<Snowboarder> aus 
		und fügen Sie diese in die neue Datenstruktur ein. 
		Überprüfen Sie die Funktionalität der Datenstruktur wie in Punkt 1,
		allerdings ohne Köpergewichte bzw. Körpergrößen auszugeben.
		*/
		/*
		for (lvlItS.hasPrevious()) {
			lvlItS.previous();
		}
		
		for (lvlItB.hasPrevious()) {
			lvlItB.previous();
		}
		
		
		if (lvlItS.hasPrevious()) lvlItS.previous();
		LeveledIter<Wood<Person>> lvlIt = woodBoarder0.iterator();
		lvlIt.next();
		while (lvlItS.hasNext()) {
			
		}*/

		//3
		
		//4
		
		//5



	}
	/*
	private static void IttoString(LeveledIter<Wood<Person>> it) {
		lvlcounter = 0;
		stagecounter = 0;
		skierAusgabe(it);	
	}
	
	private static void skierAusgabe(LeveledIter<Wood<Person>> it) {

		while (it.hasNext()){
			stagecounter ++;
			System.out.print(lvlcounter + "-" + stagecounter + ": " + ((SortedWood<Person>) it.next()).sorted().toString() + " ");
			if (it.sub().hasNext()) {
				lvlcounter ++;
				System.out.print('\n');
				skierAusgabe(it.sub());
				lvlcounter --;
			} else if (it.hasNext()) {
				skierAusgabe(it);
				stagecounter --;
			}
		}
	}*/
}