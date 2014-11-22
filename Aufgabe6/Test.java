
public class Test {

	public static void main(String[] args) {
		
		//Himmelskoerper
		System.out.println('\n' + " erstelle Planeten");
		
		Gasplanet saturn = new Gasplanet("Saturn");
		HimmelskoerperSchwach ceres = new HimmelskoerperSchwach("Ceres");
		HimmelskoerperStark mars = new HimmelskoerperStark("Mars", true);
		HimmelskoerperStark pluto = new HimmelskoerperStark("Pluto", false);
		
		//TODO toString
		
		//Raumsonden
		System.out.println('\n' + " erstelle Raumsonden");
		
		RaumSonde curiosity = new RaumSonde(900);
		RaumSonde opportunity = new RaumSonde(600);
		
		//TODO toString
		
		//Missionen
		System.out.println('\n' + " erstelle Missionen");
		
		Mission msl = new Mission("MSL", curiosity);
		Mission spirit = new Mission("spirit to pluto and mars", 600);
		Mission majortom = new Mission("major Tom to death", 100);
		Mission oddity = new Mission("oddity to saturn", 800);
		Mission possible = new Mission("opportunity to everywhere possible", opportunity);
		
		//TODO toString
		
		//add Planets to Mission
		System.out.println('\n' + " fuege Planeten zu Mission hinzu");
		
		System.out.println(msl.add(mars));
		System.out.println(spirit.add(pluto));
		System.out.println(spirit.add(mars));
		System.out.println(majortom.add(saturn));
		System.out.println(oddity.add(saturn));
		System.out.println(possible.add(ceres));
		System.out.println(possible.add(saturn));
		System.out.println(possible.add(mars));
		System.out.println(possible.add(pluto));
		
		// toString

		//remove Planets from Mission
		System.out.println('\n' + " entferne Planeten von Mission");
		
		System.out.println(majortom.remove("Saturn"));
		System.out.println(possible.remove("Ceres"));
		System.out.println(possible.remove("Saturn"));
		System.out.println(possible.remove("Geonosis"));
		
		//missionlist
		System.out.println('\n' + " zeige die Namen aller Himmelskoerper einer Mission an");
		
		msl.missionslist();
		spirit.missionslist();
		majortom.missionslist();
		oddity.missionslist();
		possible.missionslist();
		
		//utilization
		System.out.println('\n' + " zeige Grad der Auslastung der Nutzlastmasse an");

		msl.utilization();
		spirit.utilization();
		majortom.utilization();
		oddity.utilization();
		possible.utilization();
		
	}

}