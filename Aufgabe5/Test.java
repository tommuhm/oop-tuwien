
public class Test {
	
	static int lvlcounter = 0;
	static int stagecounter = 0;

	public static void main(String[] args) {

		//1

		Wood<String> woodString0 = new Wood<String>("MorningWood");
		Wood<String> woodString1 = new Wood<String>("WoodyWood");
		Wood<String> woodString2 = new Wood<String>("ThisIsWood");
		Wood<String> woodString3 = new Wood<String>("iWood");
		Wood<String> woodString4 = new Wood<String>("noWood");
		Wood<String> woodString5 = new Wood<String>("coldWood");
		Wood<String> woodString6 = new Wood<String>("warmWood");
		Wood<String> woodString7 = new Wood<String>("hardWood");
		Wood<String> woodString8 = new Wood<String>("greatWood");
		Wood<String> woodString9 = new Wood<String>("megaWood");
		Wood<String> woodString10 = new Wood<String>("leftWood");
		Wood<String> woodString11 = new Wood<String>("softWood");
		Wood<String> woodString12 = new Wood<String>("rightWood");
		Wood<String> woodString13 = new Wood<String>("fooWood");							
		
		LeveledIter<Wood<String>> lvlItStr = woodString0.iterator();
		lvlItStr.next();
		lvlItStr.add(woodString1);
		lvlItStr.add(woodString8);
		lvlItStr.add(woodString9);
		lvlItStr.next();
		lvlItStr.add(woodString2);
		if (lvlItStr.hasPrevious()) lvlItStr.previous();
		if (lvlItStr.hasPrevious()) lvlItStr.previous(); //pointer jumps back to String0
		lvlItStr.add(woodString3);
		lvlItStr.add(woodString4);
		lvlItStr.add(woodString10);
		LeveledIter<Wood<String>> subLvlItStr1 = lvlItStr.sub(); //add Substructure
		subLvlItStr1.add(woodString5);
		subLvlItStr1.next();
		subLvlItStr1.add(woodString6);
		subLvlItStr1.next();
		if (subLvlItStr1.hasPrevious()) subLvlItStr1.previous();
		if (subLvlItStr1.hasPrevious()) subLvlItStr1.previous();
		if (subLvlItStr1.hasPrevious()) subLvlItStr1.previous(); //Nothing happens
		subLvlItStr1.add(woodString7);
		subLvlItStr1.add(woodString11);
		subLvlItStr1.add(woodString12);
		subLvlItStr1.add(woodString13);
				
		
		Skier finn = new Skier("Finn", 180);
		Skier jake = new Skier("Jake", 210);
		Skier bmo = new Skier("BMO", 110);
		Skier tiffany = new Skier("Tiffany", 180);
		Skier bubblegum = new Skier("Bubblegum", 130);
		Skier flameking = new Skier("Flameking", 200);
		Skier magicman = new Skier("Magicman", 195);
		Skier henriette = new Skier("Henriette", 70);
		Skier mo = new Skier("Mo", 160);
		Skier smo = new Skier("SMO", 160);
		Skier cmo = new Skier("CMO", 120);
		Skier zmo = new Skier("ZMO", 90);
		Skier tmo = new Skier("TMO", 80);
		Skier amo = new Skier("AMO", 10);
		
		SortedWood<Person> woodSkier0 = new SortedWood<Person>(finn);
		SortedWood<Person> woodSkier1 = new SortedWood<Person>(jake);
		SortedWood<Person> woodSkier2 = new SortedWood<Person>(bmo);
		SortedWood<Person> woodSkier3 = new SortedWood<Person>(tiffany);
		SortedWood<Person> woodSkier4 = new SortedWood<Person>(bubblegum);
		SortedWood<Person> woodSkier5 = new SortedWood<Person>(flameking);
		SortedWood<Person> woodSkier6 = new SortedWood<Person>(magicman);
		SortedWood<Person> woodSkier7 = new SortedWood<Person>(henriette);
		SortedWood<Person> woodSkier8 = new SortedWood<Person>(mo);
		SortedWood<Person> woodSkier9 = new SortedWood<Person>(smo);
		SortedWood<Person> woodSkier10 = new SortedWood<Person>(cmo);
		SortedWood<Person> woodSkier11 = new SortedWood<Person>(zmo);
		SortedWood<Person> woodSkier12 = new SortedWood<Person>(tmo);
		SortedWood<Person> woodSkier13 = new SortedWood<Person>(amo);
		
		LeveledIter<Wood<Person>> lvlItS = woodSkier0.iterator();
		lvlItS.next();
		lvlItS.add(woodSkier1);
		lvlItS.add(woodSkier9);
		lvlItS.add(woodSkier10);
		lvlItS.add(woodSkier11);
		LeveledIter<Wood<Person>> subLvlItS1 = lvlItS.sub(); //add Substructure
		subLvlItS1.next();
		subLvlItS1.add(woodSkier2);
		LeveledIter<Wood<Person>> subLvlItS2 = subLvlItS1.sub(); //add Substructure
		subLvlItS2.next();
		subLvlItS2.add(woodSkier3);
		subLvlItS2.add(woodSkier4);
		subLvlItS2.add(woodSkier13);
		subLvlItS2.add(woodSkier12);
		LeveledIter<Wood<Person>> subLvlItS3 = subLvlItS2.sub(); //add Substructure
		subLvlItS3.next();
		subLvlItS3.add(woodSkier5);
		subLvlItS3.next();
		subLvlItS3.add(woodSkier6);
		if (lvlItS.hasPrevious()) lvlItS.previous();
		if (lvlItS.hasPrevious()) lvlItS.previous();
		if (lvlItS.hasPrevious()) lvlItS.previous(); //Nothing happens
		subLvlItS3.next();
		LeveledIter<Wood<Person>> subLvlItS4 = subLvlItS3.sub(); //add Substructure
		subLvlItS4.next();
		subLvlItS3.add(woodSkier7);
		if (subLvlItS1.hasPrevious()) subLvlItS1.previous();
		subLvlItS1.add(woodSkier8);
		
		IttoString(lvlItS);
		
		
		Snowboarder iceking = new Snowboarder("Iceking", 170);
		Snowboarder gunter = new Snowboarder("Gunter", 80);
		Snowboarder ricardio = new Snowboarder("Ricardio", 60);
		Snowboarder rainicorn = new Snowboarder("Rainicorn", 300);
		Snowboarder cinnamonbun = new Snowboarder("Cinnamonbun", 180);
		Snowboarder starchy = new Snowboarder("Starchy", 70);
		Snowboarder lsp = new Snowboarder("LSP", 140);
		Snowboarder choosegoose = new Snowboarder("Choosegoose", 75);
		Snowboarder marcelline = new Snowboarder("Marcelline", 140);
		Snowboarder dmo = new Snowboarder("DMO", 40);
		Snowboarder rmo = new Snowboarder("RMO", 50);
		Snowboarder qmo = new Snowboarder("QMO", 60);
		Snowboarder mmo = new Snowboarder("MMO", 30);
		Snowboarder lmo = new Snowboarder("LMO", 190);
		Snowboarder kmo = new Snowboarder("KMO", 180);
		Snowboarder umo = new Snowboarder("UMO", 80);
		
		SortedWood<Person> woodBoarder0 = new SortedWood<Person>(iceking);
		SortedWood<Person> woodBoarder1 = new SortedWood<Person>(gunter);
		SortedWood<Person> woodBoarder2 = new SortedWood<Person>(ricardio);
		SortedWood<Person> woodBoarder3 = new SortedWood<Person>(rainicorn);
		SortedWood<Person> woodBoarder4 = new SortedWood<Person>(cinnamonbun);
		SortedWood<Person> woodBoarder5 = new SortedWood<Person>(starchy);	
		SortedWood<Person> woodBoarder6 = new SortedWood<Person>(lsp);
		SortedWood<Person> woodBoarder7 = new SortedWood<Person>(choosegoose);	
		SortedWood<Person> woodBoarder8 = new SortedWood<Person>(marcelline);
		SortedWood<Person> woodBoarder9 = new SortedWood<Person>(dmo);
		SortedWood<Person> woodBoarder10 = new SortedWood<Person>(rmo);
		SortedWood<Person> woodBoarder11 = new SortedWood<Person>(umo);
		SortedWood<Person> woodBoarder12 = new SortedWood<Person>(qmo);
		SortedWood<Person> woodBoarder13 = new SortedWood<Person>(kmo);
		SortedWood<Person> woodBoarder14 = new SortedWood<Person>(mmo);
		SortedWood<Person> woodBoarder15 = new SortedWood<Person>(lmo);
		
		LeveledIter<Wood<Person>> lvlItB = woodBoarder0.iterator();
		lvlItB.next();
		lvlItB.add(woodBoarder1);
		lvlItB.add(woodBoarder9);
		lvlItB.add(woodBoarder10);
		LeveledIter<Wood<Person>> subLvlItB1 = lvlItB.sub(); //add Substructure
		subLvlItB1.next();
		subLvlItB1.add(woodBoarder2);
		subLvlItB1.add(woodBoarder11);
		subLvlItB1.add(woodBoarder12);
		subLvlItB1.add(woodBoarder13);
		subLvlItB1.add(woodBoarder14);
		subLvlItB1.add(woodBoarder15);
		LeveledIter<Wood<Person>> subLvlItB2 = subLvlItB1.sub(); //add Substructure
		subLvlItB2.next();
		subLvlItB2.add(woodBoarder3);
		subLvlItB2.add(woodBoarder4);
		if (lvlItB.hasPrevious()) lvlItB.previous();
		LeveledIter<Wood<Person>> subLvlItB3 = subLvlItB2.sub(); //add Substructure
		subLvlItB3.next();
		subLvlItB3.add(woodBoarder5);
		subLvlItB2.next();
		LeveledIter<Wood<Person>> subLvlItB4 = subLvlItB2.sub(); //add Substructure
		subLvlItB4.next();
		subLvlItB4.add(woodBoarder6);
		LeveledIter<Wood<Person>> subLvlItB5 = subLvlItB4.sub(); //add Substructure
		subLvlItB5.next();
		subLvlItB5.add(woodBoarder7);
		if (subLvlItB5.hasPrevious()) subLvlItB5.previous();
		subLvlItB5.add(woodBoarder8);
		
		IttoString(lvlItB);
	
		//2
		
		/*
		Erzeugen Sie eine Datenstruktur vom Typ SortedWood<Person>.
		Lesen Sie über Iteratoren alle Elemente aus den in Punkt 1 erzeugten Datenstrukturen 
		der Typen SortedWood<Skier> und SortedWood<Snowboarder> aus 
		und fügen Sie diese in die neue Datenstruktur ein. 
		Überprüfen Sie die Funktionalität der Datenstruktur wie in Punkt 1,
		allerdings ohne Köpergewichte bzw. Körpergrößen auszugeben.
		*/
		
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
			
		}

		//3
		
		//4
		
		//5




*/
	}
	
	private static void IttoString(LeveledIter<Wood<Person>> it) {
		lvlcounter = 0;
		stagecounter = 0;
		skierAusgabe(it);	
	}
	
	private static void skierAusgabe(LeveledIter<Wood<Person>> it) {

		while (it.hasNext())  {
			stagecounter ++;
			System.out.print(lvlcounter + "-" + stagecounter + ": " + ((SortedWood<Person>) it.next()).sorted().toString() + "   ");
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
	}
}