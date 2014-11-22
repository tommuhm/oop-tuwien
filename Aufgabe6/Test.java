
public class Test {

	public static void main(String[] args) {
		
		//Himmelskoerper

		
		Gasplanet saturn = new Gasplanet("Saturn");
		HimmelskoerperSchwach ceres = new HimmelskoerperSchwach("Ceres");
		HimmelskoerperStark mars = new HimmelskoerperStark("Mars", true);
		HimmelskoerperStark pluto = new HimmelskoerperStark("Pluto", false);
		
		System.out.println("Himmelskoerper wurden erstellt.\n");
		
		//TODO toString
		
		//Raumsonden
		
		RaumSonde curiosity = new RaumSonde(900);
		RaumSonde opportunity = new RaumSonde(600);
		
		System.out.println("Raumsonden wurden erstellt.\n");
		
		//TODO toString
		
		//Missionen
		
		Mission msl = new Mission("MSL", curiosity);
		Mission spirit = new Mission("spirit to pluto and mars", 600);
		Mission majortom = new Mission("major Tom to death", 100);
		Mission oddity = new Mission("oddity to saturn", 800);
		Mission possible = new Mission("opportunity to everywhere possible", opportunity);
		
		System.out.println("Missionen wurden erstellt.\n");
		
		//TODO toString
		
		//add Planets to Mission
		System.out.println("fuege Planeten zu Mission hinzu.\n");
		
		System.out.println("notwendige Module:");
		System.out.println(" MSL, Mars: " + msl.add(mars));
		System.out.println(" spirit, Pluto: " + spirit.add(pluto));
		System.out.println(" spirit, Mars: " + spirit.add(mars));
		System.out.println(" majortom, Saturn: " + majortom.add(saturn));
		System.out.println(" oddity, Saturn: " + oddity.add(saturn));
		System.out.println(" possible, Ceres: " + possible.add(ceres));
		System.out.println(" possible, Saturn: " + possible.add(saturn));
		System.out.println(" possible, Mars: " + possible.add(mars));
		System.out.println(" possible, Pluto: " + possible.add(pluto));
		
		System.out.println("Himmelskoerper zu Mission hinzugefuegt.\n");
		
		// toString

		//remove Planets from Mission
		System.out.println("entferne Planeten von Mission.\n");
		
		System.out.println("entfernte Planeten:");
		System.out.println(" majortom: " + majortom.remove("Saturn"));
		System.out.println(" possible: " + possible.remove("Ceres"));
		System.out.println(" possible: " + possible.remove("Saturn"));
		System.out.println(" possible: " + possible.remove("Geonosis"));
		
		System.out.println("Himmelskoerper von Mission entfernt.\n");
		
		//missionlist
		System.out.println("zeige die Namen aller Himmelskoerper einer Mission an.\n");
		
		msl.missionslist();
		spirit.missionslist();
		majortom.missionslist();
		oddity.missionslist();
		possible.missionslist();
		
		System.out.println("Namen angezeigt.\n");
		
		//utilization
		System.out.println("zeige Grad der Auslastung der Nutzlastmasse an.\n");

		msl.utilization();
		spirit.utilization();
		majortom.utilization();
		oddity.utilization();
		possible.utilization();
		
		System.out.println("zeige Grad der Auslastung angezeigt.\n");
		
	}

}