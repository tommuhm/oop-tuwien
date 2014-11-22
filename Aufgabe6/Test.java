
public class Test {

	public static void main(String[] args) {
		
		//Himmelskoerper

		
		Gasplanet gasplanet = new Gasplanet("gasplanet");
		HimmelskoerperSchwach himmelskoerperSchwach = new HimmelskoerperSchwach("himmelskoerperSchwach");
		HimmelskoerperStark himmelskoerperStarkmitAtmos = new HimmelskoerperStark("himmelskoerperStarkmitAtmos", true);
		HimmelskoerperStark himmelskoerperStarkohneAtmos = new HimmelskoerperStark("himmelskoerperStarkohneAtmos", false);
		
		System.out.println("Himmelskoerper wurden erstellt.\n");
		
		//Raumsonden
		
		Raumsonde raumsonde0 = new Raumsonde(900);
		Raumsonde raumsonde1 = new Raumsonde(600);
		
		System.out.println("Raumsonden wurden erstellt.\n");
		
		//Missionen
		
		Mission mission0 = new Mission("Mission0", raumsonde0);
		Mission mission1 = new Mission("Mission1", 600);
		Mission mission2 = new Mission("Mission2", 100);
		Mission mission3 = new Mission("Mission3", 800);
		Mission mission4 = new Mission("Mission4", raumsonde1);
		
		System.out.println("Missionen wurden erstellt.\n");
		
		//TODO toString
		
		//add Planets to Mission
		System.out.println("fuege Planeten zu Mission hinzu.\n");
		
		System.out.println("notwendige Module:");
		System.out.println(" Mission0, himmelskoerperStarkmitAtmos: " + mission0.add(himmelskoerperStarkmitAtmos));
		System.out.println(" Mission1, himmelskoerperStarkohneAtmos: " + mission1.add(himmelskoerperStarkohneAtmos));
		System.out.println(" Mission1, himmelskoerperStarkmitAtmos: " + mission1.add(himmelskoerperStarkmitAtmos));
		System.out.println(" Mission2, gasplanet: " + mission2.add(gasplanet));
		System.out.println(" Mission3, gasplanet: " + mission3.add(gasplanet));
		System.out.println(" Mission4, himmelskoerperSchwach: " + mission4.add(himmelskoerperSchwach));
		System.out.println(" Mission4, gasplanet: " + mission4.add(gasplanet));
		System.out.println(" Mission4, himmelskoerperStarkmitAtmos: " + mission4.add(himmelskoerperStarkmitAtmos));
		System.out.println(" Mission4, himmelskoerperStarkohneAtmos: " + mission4.add(himmelskoerperStarkohneAtmos));
		
		System.out.println("Himmelskoerper zu Mission hinzugefuegt.\n");
		
		// toString

		//remove Planets from Mission
		System.out.println("entferne Planeten von Mission.\n");
		
		System.out.println("entfernte Planeten:");
		System.out.println(" Mission2: " + mission2.remove("gasplanet"));
		System.out.println(" Mission4: " + mission4.remove("himmelskoerperStarkmitAtmos"));
		System.out.println(" Mission4: " + mission4.remove("gasplanet"));
		System.out.println(" Mission4: " + mission4.remove("Geonosis"));
		
		System.out.println("Himmelskoerper von Mission entfernt.\n");
		
		//missionlist
		System.out.println("zeige die Namen aller Himmelskoerper einer Mission an.\n");
		
		mission0.missionslist();
		mission1.missionslist();
		mission2.missionslist();
		mission3.missionslist();
		mission4.missionslist();
		
		System.out.println("Namen angezeigt.\n");
		
		//utilization
		System.out.println("zeige Grad der Auslastung der Nutzlastmasse an.\n");

		mission0.utilization();
		mission1.utilization();
		mission2.utilization();
		mission3.utilization();
		mission4.utilization();
		
		System.out.println("zeige Grad der Auslastung angezeigt.\n");
		
	}

}