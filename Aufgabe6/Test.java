/*
 * Aufgabenaufteilung:
 * David Jaffry: Himmelskoerper, Gasplanet, HimmelskoerperSchwach, HimmelskoerperStark, Test, Bedingungen
 * Ulrich Aschl: Modul, ModulDuesen, ModulFallschirm, ModulFest, ModulGas, ModulStark, ModulSchwach, Raumsonde, Mission
 * Tom Muhm: allgemeine arbeiten, Zusicherungen, Mission, Test
 * 
 * 
 */

public class Test {

	public static void main(String[] args) {

		// Himmelskoerper
		Himmelskoerper gasplanet = new Gasplanet("gasplanet");
		Himmelskoerper hkSchwach = new HimmelskoerperSchwach("hkSchwach");
		Himmelskoerper hkStarkAtmosphaere = new HimmelskoerperStark("hkStarkAtmosphaere", true);
		Himmelskoerper hkStark = new HimmelskoerperStark("hkStark", false);
		System.out.println("Himmelskoerper wurden erstellt.\n");

		// Raumsonden
		Raumsonde raumsonde0 = new Raumsonde(900);
		Raumsonde raumsonde1 = new Raumsonde(700);
		System.out.println("Raumsonden wurden erstellt.\n");

		// Missionen
		Mission mission0 = new Mission("Mission0", raumsonde0);
		Mission mission1 = new Mission("Mission1", 600);
		Mission mission2 = new Mission("Mission2", 100);
		Mission mission3 = new Mission("Mission3", 800);
		Mission mission4 = new Mission("Mission4", raumsonde1);
		System.out.println("Missionen wurden erstellt.\n");

		// add Planets to Mission
		System.out.println("Fuege Himmelskoerper zu Mission hinzu:");
		System.out.println("Folgende Himmelskoerper wurden hinzuegfuegt:");
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

		// utilization
		System.out.println("Zeige aktuellen Grad der Auslastung der Nutzlastmasse an.");
		System.out.println("Mission0: 1xFallschirm fuer StarkAtmos- Himmelskoerper");
		mission0.utilization();
		System.out.println("Mission1: 2xDuesen fuer Stark- & StarkAtmos- Himmelskoerper");
		mission1.utilization();
		System.out.println("Mission2: kein Platz");
		mission2.utilization();
		System.out.println("Mission3: 1xGas fuer Gasplanet");
		mission3.utilization();
		System.out.println("Mission4: 1xGas & 2xFallschirm fuer Gas-, Schwach- & StarkAtmos- Himmelskoerper");
		mission4.utilization();
		System.out.println();

		// missionlist
		System.out.println("Zeige die Namen aller Himmelskoerper der Missionen an:");
		System.out.println("Mission0: ");
		mission0.missionlist();
		System.out.println("Mission1: ");
		mission1.missionlist();
		System.out.println("Mission2: ");
		mission2.missionlist();
		System.out.println("Mission3: ");
		mission3.missionlist();
		System.out.println("Mission4:");
		mission4.missionlist();
		System.out.println();


		// remove Planets from Mission
		System.out.println("Entferne Planeten von Mission: (kein umschlichten)");
		System.out.println(" Mission1: " + mission1.remove("hkStarkAtmosphaere"));
		System.out.println(" Mission2: " + mission2.remove("gasplanet"));
		System.out.println(" Mission4: " + mission4.remove("hkStarkAtmosphaere"));
		System.out.println(" Mission4: " + mission4.remove("gasplanet"));
		System.out.println(" Mission4: " + mission4.remove("Geonosis"));
		System.out.println();

		// utilization
		System.out.println("Zeige endgueltigen Grad der Auslastung der Nutzlastmasse an:");
		System.out.println("Mission0: 1xFallschirm fuer StarkAtmos- Himmelskoerper");
		mission0.utilization();
		System.out.println("Mission1: 1xDuesen fuer Stark- Himmelskoerper");
		mission1.utilization();
		System.out.println("Mission2: kein Platz");
		mission2.utilization();
		System.out.println("Mission3: 1xGas fuer Gasplanet");
		mission3.utilization();
		System.out.println("Mission4: 1xFallschirm fuer Schwach- Himmelskoerper");
		mission4.utilization();
		System.out.println();

		// missionlist
		System.out.println("Zeige die Namen aller Himmelskoerper der Missionen an:");
		System.out.println("Mission0:");
		mission0.missionlist();
		System.out.println("Mission1:");
		mission1.missionlist();
		System.out.println("Mission2:");
		mission2.missionlist();
		System.out.println("Mission3:");
		mission3.missionlist();
		System.out.println("Mission4:");
		mission4.missionlist();
		System.out.println();

	}

}
