
public class Test {

	public static void main(String[] args) {
		
		//1
		
		//TODO gib für person körpergewicht und grösse aus
		
		Skier finn = new Skier("Finn", 180);
		Skier jake = new Skier("Jake", 210);
		Skier bmo = new Skier("BMO", 110);
		Snowboarder iceking = new Snowboarder("Iceking", 170);
		Snowboarder gunter = new Snowboarder("Gunter", 80);
		Snowboarder ricardo = new Snowboarder("Ricardo", 60);
		
		
		Wood<String> woodString0 = new Wood<String>("MorningWood");
		Wood<String> woodString1 = new Wood<String>("WoodyWood");
		Wood<String> woodString2 = new Wood<String>("ThisIsWood");
		Wood<String> woodString3 = new Wood<String>("iWood");
		Wood<Skier> woodPerson0 = new SortedWood<Skier>(finn);
		Wood<Skier> woodPerson1 = new SortedWood<Skier>(jake);
		Wood<Skier> woodPerson2 = new SortedWood<Skier>(bmo);
		Wood<Snowboarder> woodBoarder0 = new SortedWood<Snowboarder>(ricardo);
		Wood<Snowboarder> woodBoarder1 = new SortedWood<Snowboarder>(iceking);
		Wood<Snowboarder> woodBoarder2 = new SortedWood<Snowboarder>(gunter);
		
		
		LeveledIter<Wood> lvlIt = woodString0.iterator();
		lvlIt.next();
		lvlIt.add(woodString1);
		lvlIt.next();
		
		lvlIt.add(woodString2);
		if (lvlIt.hasPrevious()) lvlIt.previous();
		if (lvlIt.hasPrevious()) lvlIt.previous(); //pointer jumps back to String0
		lvlIt.add(woodPerson0);
		lvlIt.next();
		
		LeveledIter<Wood> subLvlIt1 = lvlIt.sub();
		subLvlIt1.add(woodPerson1);
		subLvlIt1.next();
		subLvlIt1.add(woodPerson2);
		subLvlIt1.next();
		
		LeveledIter<Wood> subLvlIt2 = subLvlIt1.sub(); 
		if (subLvlIt2.hasPrevious()) subLvlIt2.previous(); //NOTE: nothing happens
		subLvlIt2.add(woodBoarder0);
		subLvlIt2.next();
		subLvlIt2.add(woodBoarder1);
		subLvlIt2.next();
		if (lvlIt.hasPrevious()) lvlIt.previous();
		subLvlIt2.add(woodBoarder2);
		subLvlIt2.next();
		
		if (subLvlIt1.hasPrevious()) subLvlIt1.previous();
		LeveledIter<Wood> subLvlIt1_1 = subLvlIt1.sub();
		subLvlIt1_1.add(woodString3);
		
		//Ausgabe
		int lvlcounter = 0;
		int stagecounter = 0;
		
		while (lvlIt.hasNext())  {
		
			= lvlIt.next();
	    
		//2
		
		/*
		Erzeugen Sie eine Datenstruktur vom Typ SortedWood<Person>.
		Lesen Sie über Iteratoren alle Elemente aus den in Punkt 1 erzeugten Datenstrukturen 
		der Typen SortedWood<Skier> und SortedWood<Snowboarder> aus 
		und fügen Sie diese in die neue Datenstruktur ein. 
		Überprüfen Sie die Funktionalität der Datenstruktur wie in Punkt 1,
		allerdings ohne Köpergewichte bzw. Körpergrößen auszugeben.
		*/
		
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

		

	}


}


/*

*/