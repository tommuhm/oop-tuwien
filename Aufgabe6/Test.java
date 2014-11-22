
public class Test {

	public static void main(String[] args) {
		
		//Himmelskoerper
		Gasplanet gasplanet = new Gasplanet("gasplanet");
		HimmelskoerperSchwach hkSchwach = new HimmelskoerperSchwach("hkSchwach");
		HimmelskoerperStark hkStarkAtmosphaere = new HimmelskoerperStark("hkStarkAtmosphaere", true);
		HimmelskoerperStark hkStark = new HimmelskoerperStark("hkStark", false);
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
		System.out.println("Fuege Himmelskoerper zu Mission hinzu:");		
		System.out.println("Folgende Himmelskoerper wurden hinzuegfügt:");
		System.out.println(" Mission0, hkStarkAtmosphaere: " + mission0.add(hkStarkAtmosphaere));
		System.out.println(" Mission1, hkStark: " + mission1.add(hkStark));
		System.out.println(" Mission1, hkStarkAtmosphaere: " + mission1.add(hkStarkAtmosphaere));
		System.out.println(" Mission2, gasplanet: " + mission2.add(gasplanet));
		System.out.println(" Mission3, gasplanet: " + mission3.add(gasplanet));
		System.out.println(" Mission4, hkSchwach: " + mission4.add(hkSchwach));
		System.out.println(" Mission4, gasplanet: " + mission4.add(gasplanet));
		System.out.println(" Mission4, hkStarkAtmosphaere: " + mission4.add(hkStarkAtmosphaere));
		System.out.println(" Mission4, hkStark: " + mission4.add(hkStark));
		
		System.out.println("Himmelskoerper zu Mission hinzugefuegt.\n");
		
		//utilization
		System.out.println("Zeige aktuellen Grad der Auslastung der Nutzlastmasse an.");
		System.out.print("Mission0: ");
		mission0.utilization();
		System.out.print("Mission1: ");
		mission1.utilization();
		System.out.print("Mission2: ");
		mission2.utilization();
		System.out.print("Mission3: ");
		mission3.utilization();
		System.out.print("Mission4: ");
		mission4.utilization();
		System.out.println();
		
		//missionlist
		System.out.println("Zeige die Namen aller Himmelskoerper der Missionen an:");
		System.out.println("Mission0:");
		mission0.missionslist();
		System.out.println("Mission1:");
		mission1.missionslist();
		System.out.println("Mission2:");
		mission2.missionslist();
		System.out.println("Mission3:");
		mission3.missionslist();
		System.out.println("Mission4:");
		mission4.missionslist();
		System.out.println();
		

		//remove Planets from Mission
		System.out.println("Entferne Planeten von Mission:");
		System.out.println(" Mission1: " + mission1.remove("hkStarkAtmosphaere"));
		System.out.println(" Mission2: " + mission2.remove("gasplanet"));
		System.out.println(" Mission4: " + mission4.remove("hkStarkAtmosphaere"));
		System.out.println(" Mission4: " + mission4.remove("gasplanet"));
		System.out.println(" Mission4: " + mission4.remove("Geonosis"));
		System.out.println();
		
		//utilization
		System.out.println("Zeige endgültigen Grad der Auslastung der Nutzlastmasse an:");
		System.out.print("Mission0: ");
		mission0.utilization();
		System.out.print("Mission1: ");
		mission1.utilization();
		System.out.print("Mission2: ");
		mission2.utilization();
		System.out.print("Mission3: ");
		mission3.utilization();
		System.out.print("Mission4: ");
		mission4.utilization();
		System.out.println();
		
		//missionlist
		System.out.println("Zeige die Namen aller Himmelskoerper der Missionen an:");
		System.out.println("Mission0:");
		mission0.missionslist();
		System.out.println("Mission1:");
		mission1.missionslist();
		System.out.println("Mission2:");
		mission2.missionslist();
		System.out.println("Mission3:");
		mission3.missionslist();
		System.out.println("Mission4:");
		mission4.missionslist();
		System.out.println();
		
	}

}