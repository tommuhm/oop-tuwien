
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
		Wood<String> woodString5 = new Wood<String>("coldWood", "greatWood", "megaWood", "leftWood");
		Wood<String> woodString6 = new Wood<String>("warmWood", "softWood", "rightWood");
		Wood<String> woodString7 = new Wood<String>("hardWood", "fooWood");
		
		LeveledIter<Wood<String>> lvlItStr = woodString0.iterator();
		lvlItStr.next();
		lvlItStr.add(woodString1);
		lvlItStr.next();
		lvlItStr.add(woodString2);
		if (lvlItStr.hasPrevious()) lvlItStr.previous();
		if (lvlItStr.hasPrevious()) lvlItStr.previous(); //pointer jumps back to String0
		lvlItStr.add(woodString3);
		lvlItStr.add(woodString4);
		LeveledIter<Wood<String>> subLvlItStr1 = lvlItStr.sub(); //add Substructure
		subLvlItStr1.add(woodString5);
		subLvlItStr1.next();
		subLvlItStr1.add(woodString6);
		subLvlItStr1.next();
		if (subLvlItStr1.hasPrevious()) subLvlItStr1.previous();
		if (subLvlItStr1.hasPrevious()) subLvlItStr1.previous();
		if (subLvlItStr1.hasPrevious()) subLvlItStr1.previous(); //Nothing happens
		subLvlItStr1.add(woodString7);
				
		
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
		
		
		SortedWood<Skier> woodSkier0 = new SortedWood<Skier>(finn);
		SortedWood<Skier> woodSkier1 = new SortedWood<Skier>(jake,cmo);
		SortedWood<Skier> woodSkier2 = new SortedWood<Skier>(bmo, amo, tmo);
		SortedWood<Skier> woodSkier3 = new SortedWood<Skier>(tiffany);
		SortedWood<Skier> woodSkier4 = new SortedWood<Skier>(bubblegum);
		SortedWood<Skier> woodSkier5 = new SortedWood<Skier>(flameking, zmo);
		SortedWood<Skier> woodSkier6 = new SortedWood<Skier>(magicman);
		SortedWood<Skier> woodSkier7 = new SortedWood<Skier>(henriette);
		SortedWood<Skier> woodSkier8 = new SortedWood<Skier>(mo, smo);
		
		LeveledIter<Wood<Skier>> lvlItS = woodSkier0.iterator();
		lvlItS.next();
		lvlItS.add(woodSkier1);
		LeveledIter<Wood<Skier>> subLvlItS1 = lvlItS.sub(); //add Substructure
		subLvlItS1.next();
		subLvlItS1.add(woodSkier2);
		LeveledIter<Wood<Skier>> subLvlItS2 = subLvlItS1.sub(); //add Substructure
		subLvlItS2.next();
		lvlItS.add(woodSkier3);
		lvlItS.add(woodSkier4);
		LeveledIter<Wood<Skier>> subLvlItS3 = subLvlItS2.sub(); //add Substructure
		subLvlItS3.next();
		subLvlItS3.add(woodSkier5);
		subLvlItS3.next();
		subLvlItS3.add(woodSkier6);
		if (lvlItS.hasPrevious()) lvlItS.previous();
		if (lvlItS.hasPrevious()) lvlItS.previous();
		if (lvlItS.hasPrevious()) lvlItS.previous(); //Nothing happens
		subLvlItS3.next();
		LeveledIter<Wood<Skier>> subLvlItS4 = subLvlItS3.sub(); //add Substructure
		subLvlItS4.next();
		subLvlItS3.add(woodSkier7);
		if (subLvlItS1.hasPrevious()) subLvlItS1.previous();
		subLvlItS1.add(woodSkier8);
		
		ItStoString(lvlItS);
		
		
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
		
		
		SortedWood<Snowboarder> woodBoarder0 = new SortedWood<Snowboarder>(iceking);
		SortedWood<Snowboarder> woodBoarder1 = new SortedWood<Snowboarder>(gunter);
		SortedWood<Snowboarder> woodBoarder2 = new SortedWood<Snowboarder>(ricardio);
		SortedWood<Snowboarder> woodBoarder3 = new SortedWood<Snowboarder>(rainicorn);
		SortedWood<Snowboarder> woodBoarder4 = new SortedWood<Snowboarder>(cinnamonbun);
		SortedWood<Snowboarder> woodBoarder5 = new SortedWood<Snowboarder>(starchy);	
		SortedWood<Snowboarder> woodBoarder6 = new SortedWood<Snowboarder>(lsp);
		SortedWood<Snowboarder> woodBoarder7 = new SortedWood<Snowboarder>(choosegoose);	
		SortedWood<Snowboarder> woodBoarder8 = new SortedWood<Snowboarder>(marcelline);
		SortedWood<Snowboarder> woodBoarder9 = new SortedWood<Snowboarder>(dmo);
		SortedWood<Snowboarder> woodBoarder10 = new SortedWood<Snowboarder>(rmo);
		SortedWood<Snowboarder> woodBoarder11 = new SortedWood<Snowboarder>(umo);
		SortedWood<Snowboarder> woodBoarder12 = new SortedWood<Snowboarder>(qmo);
		SortedWood<Snowboarder> woodBoarder13= new SortedWood<Snowboarder>(kmo);
		SortedWood<Snowboarder> woodBoarder14 = new SortedWood<Snowboarder>(mmo);
		SortedWood<Snowboarder> woodBoarder15 = new SortedWood<Snowboarder>(lmo);
		
		

		LeveledIter<Wood<Snowboarder>> lvlItB = woodBoarder0.iterator();
		lvlItB.next();
		lvlItB.add(woodBoarder1, woodBoarder9, woodBoarder10);
		LeveledIter<Wood<Snowboarder>> subLvlItB1 = lvlItB.sub(); //add Substructure
		subLvlItB1.next();
		subLvlItB1.add(woodBoarder2);
		LeveledIter<Wood<Snowboarder>> subLvlItB2 = subLvlItB1.sub(); //add Substructure
		subLvlItB2.next();
		subLvlItB2.add(woodBoarder3);
		lvlItB.add(woodBoarder4);
		if (lvlItB.hasPrevious()) lvlItB.previous();
		LeveledIter<Wood<Snowboarder>> subLvlItB3 = subLvlItB2.sub(); //add Substructure
		subLvlItB3.next();
		subLvlItB3.add(woodBoarder5);
		subLvlItB2.next();
		LeveledIter<Wood<Snowboarder>> subLvlItB4 = subLvlItB2.sub(); //add Substructure
		subLvlItB4.next();
		subLvlItB4.add(woodBoarder6);
		LeveledIter<Wood<Snowboarder>> subLvlItB5 = subLvlItB4.sub(); //add Substructure
		subLvlItB5.next();
		subLvlItB5.add(woodBoarder7);
		if (subLvlItB5.hasPrevious()) subLvlItB5.previous();
		subLvlItB5.add(woodBoarder8);
		
		ItBtoString(lvlItB);
	
		//2
		
		/*
		Erzeugen Sie eine Datenstruktur vom Typ SortedWood<Person>.
		Lesen Sie über Iteratoren alle Elemente aus den in Punkt 1 erzeugten Datenstrukturen 
		der Typen SortedWood<Skier> und SortedWood<Snowboarder> aus 
		und fügen Sie diese in die neue Datenstruktur ein. 
		Überprüfen Sie die Funktionalität der Datenstruktur wie in Punkt 1,
		allerdings ohne Köpergewichte bzw. Körpergrößen auszugeben.
		*/
		/*
		Wood<Skier> woodPerson = new SortedWood<Skier>(woodPerson0);
		Wood<Skier> woodPerson7 = new SortedWood<Skier>();
		Wood<Skier> woodPerson8 = new SortedWood<Skier>(finn);




		//3

		Wood<Skier> woodPerson3 = new SortedWood<Skier>(woodPerson0);
		Wood<Skier> woodPerson7 = new SortedWood<Skier>();
		Wood<Skier> woodPerson8 = new SortedWood<Skier>(finn);

		Wood<Snowboarder> woodPerson4 = new SortedWood<Snowboarder>(finn);
		Wood<Snowboarder> woodPerson5 = new SortedWood<Snowboarder>(finn);
		Wood<Snowboarder> woodPerson6 = new SortedWood<Snowboarder>(finn);
*/
	}
	
	private static void ItStoString(LeveledIter<SortedWood<Skier>> it) {
		lvlcounter = 0;
		stagecounter = 0;
		skierAusgabe(it);	
	}
	
	private static void skierAusgabe(LeveledIter<SortedWood<Skier>> it) {

		while (it.hasNext())  {
			stagecounter ++;
			System.out.print(lvlcounter + "-" + stagecounter + ": " + it.next().sorted().toString() + "   ");
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
	
	private static void ItBtoString(LeveledIter<SortedWood<Snowboarder>> it) {
		lvlcounter = 0;
		stagecounter = 0;
		boarderAusgabe(it);	
	}
	
	private static void boarderAusgabe(LeveledIter<SortedWood<Snowboarder>> it) {

		while (it.hasNext())  {
			stagecounter ++;
			System.out.print(lvlcounter + "-" + stagecounter + ": " + it.next().sorted().toString() + "   "); //TODO: absteigend
			if (it.sub().hasNext()) {
				lvlcounter ++;
				System.out.print('\n');
				boarderAusgabe(it.sub());
				lvlcounter --;
			} else if (it.hasNext()) {
				boarderAusgabe(it);
				stagecounter --;
			}
		}
	}
}
