public class Test {

	/*
	 * ausfuehren am g0:
	 *
	 * $ ajc -source 1.6 *.java *.aj
	 * $ java -cp .:/usr/share/java/aspectjrt.jar Test
	 *
	 * erster command ist compilen mit source level 1.6
	 * zweiter command ist beim ausfuehren auch die AspectJ-Runtime-Bibliothek in den Classpath aufnehmen
	 */

	/*
	 * Aufgabenaufteilung: Planung zu dritt.
	 * David Jaffry: Geschenkesack, Schachtellager, Test, GeschenkPrototypeFactory, Zusicherungen, Artefakt, Bonboniere, Buch, Kerze, Schuhe, Vase, Weinflasche, Wuerfel
	 * Ulrich Aschl: ZaehlerObj, Schachtel, Quadrat, Rechteck, Zusicherungen
	 * Thomas Muhm: Geschenk, GeschenkPrototypes, Grundflaeche, Kreis, Sechseck, Quadrat, Rechteck, Zusicherungen, Test
	 *
	 * Verwendete Design-Patterns:
	 * 		Singleton-Pattern: Geschenksack, Schachtellager
	 * 		Visitor-Pattern: Grundflaeche, Kreis, Sechseck, Quadrat, Rechteck
	 * 		Prototype-Pattern: GeschenkPrototypes
	 */

	private static Schachtellager schachtellager;
	private static Geschenkesack geschenkesack;
	private static GeschenkPrototypes geschenke;

	public static void main(String[] args) {

		init();

		testSingleton();

		testSchachtellager();

		printGeschensack();

		testGeschenke();

		testUntertypen();

		printGeschensack();
	}

	private static void init() {
		schachtellager = Schachtellager.getInstance();
		geschenkesack = Geschenkesack.getInstance();
		geschenke = new GeschenkPrototypes();
	}

	private static void testSingleton() {
		Schachtellager schachtellager1 = Schachtellager.getInstance();
		if (schachtellager1 != schachtellager) {
			System.out.println("Singelton Test fuer Schachtellager ist fehlgeschlagen!.");
		} else {
			System.out.println("Singelton Test fuer Schachtellager war erfolgreich.");
		}

		Geschenkesack geschenkesack1 = Geschenkesack.getInstance();
		if (geschenkesack1 != geschenkesack) {
			System.out.println("Singelton Test fuer Geschenkesack ist fehlgeschlagen!.");
		} else {
			System.out.println("Singelton Test fuer Geschenkesack war erfolgreich.");
		}
	}

	private static void testSchachtellager() {
		System.out.println("\n" + schachtellager + "\n");
		// zeigt nach mehreren Ausfuehrungen auch, dass die Schachteln im Lager wirklich genutzt werden,
		// da die Anzahl der dynamisch erstellten Objekte davon abhaengt,
		// wie sehr die zufaellig erstellten Schachteln fuer die Geschenke passen
		rdmSchachtelGenerator(10);
		System.out.println("\n" + schachtellager + "\n");
		System.out.println("Schachteln wurden erstellt und zum Schachtellager hinzugefuegt.");
	}

	private static void testGeschenke() {
		kerzenTest();
		buecherTest();
		wuerfelTest();
		weinTest();
		vasenTest();
		bonboniereTest();
		schuhTest();
		artefaktTest();
	}

	private static void testUntertypen() {

	}

	private static void kerzenTest() {
		Geschenk kerze0 = geschenke.getGeschenk("kerze0");
		System.out.println("Kerze0 wurde erfolgreich erstellt - " + kerze0);

		Schachtel schachtel0 = schachtellager.verpacke(kerze0);
		System.out.println("Kerze0 wurde in Sachtel0 verpackt - " + schachtel0);

		Schachtel schachtel8 = schachtellager.verpacke(schachtel0); //verpacke 2fach
		System.out.println("Sachtel0 wurde in Sachtel8 verpackt - " + schachtel8);

		Geschenk kerze1 = geschenke.getGeschenk("kerze1");
		System.out.println("Kerze1 wurde erfolgreich erstellt - " + kerze1);

		Schachtel schachtel1 = schachtellager.verpacke(kerze1);
		System.out.println("Kerzen wurden erfolgreich verpackt - " + schachtel1);

		geschenkesack.addGeschenk(schachtel8);
		geschenkesack.addGeschenk(schachtel1);
		System.out.println("Kerzen wurden erfolgreich zum Geschenkesack hinzugefuegt.");

		printGeschensack();
	}

	private static void buecherTest() {
		Geschenk buch0 = geschenke.getGeschenk("buch0");
		Geschenk buch1 = geschenke.getGeschenk("buch1");
		if (buch0 != null && buch1 != null) {
			System.out.println("Buecher wurden erfolgreich erstellt.");
		} else {
			System.out.println("Buecher konnten nicht erstellt werden.");
		}

		Schachtel schachtel2 = schachtellager.verpacke(buch0);
		Schachtel schachtel9 = schachtellager.verpacke(schachtel2);
		Schachtel schachtel10 = schachtellager.verpacke(schachtel9); //verpacke 3fach
		Schachtel schachtel3 = schachtellager.verpacke(buch1);
		System.out.println("Buecher wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel10);
		geschenkesack.addGeschenk(schachtel3);
		System.out.println("Buecher wurden erfolgreich zum Geschenkesack hinzugefuegt.");
	}

	private static void wuerfelTest() {
		Geschenk wuerfel0 = geschenke.getGeschenk("wuerfel0");
		Geschenk wuerfel1 = geschenke.getGeschenk("wuerfel1");
		if (wuerfel0 != null && wuerfel1 != null) {
			System.out.println("Wuerfel wurden erfolgreich erstellt.");
		} else {
			System.out.println("Wuerfel konnten nicht erstellt werden.");
		}

		Schachtel schachtel4 = schachtellager.verpacke(wuerfel0);
		Schachtel schachtel11 = schachtellager.verpacke(schachtel4); //verpacke 2fach
		Schachtel schachtel5 = schachtellager.verpacke(wuerfel1);
		System.out.println("Wuerfel wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel11);
		geschenkesack.addGeschenk(schachtel5);
		System.out.println("Wuerfel wurden erfolgreich zum Geschenkesack hinzugefuegt.");


	}

	private static void weinTest() {
		Geschenk weinflasche0 = geschenke.getGeschenk("wein0");
		Geschenk weinflasche1 = geschenke.getGeschenk("wein1");
		if (weinflasche0 != null && weinflasche1 != null) {
			System.out.println("Weinflaschen wurden erfolgreich erstellt.");
		} else {
			System.out.println("Weinflaschen konnten nicht erstellt werden.");
		}

		Schachtel schachtel6 = schachtellager.verpacke(weinflasche0);
		Schachtel schachtel7 = schachtellager.verpacke(weinflasche1);
		Schachtel schachtel12 = schachtellager.verpacke(schachtel7);
		Schachtel schachtel13 = schachtellager.verpacke(schachtel12);
		Schachtel schachtel14 = schachtellager.verpacke(schachtel13); //verpacke 4fach
		System.out.println("Weinflaschen wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel6);
		geschenkesack.addGeschenk(schachtel14);
		System.out.println("Weinflaschen wurden erfolgreich zum Geschenkesack hinzugefuegt.");

	}

	private static void vasenTest() {
		Geschenk vase0 = geschenke.getGeschenk("vase0");
		Geschenk vase1 = geschenke.getGeschenk("vase1");
		if (vase0 != null && vase1 != null) {
			System.out.println("Vasen wurden erfolgreich erstellt.");
		} else {
			System.out.println("Vasen konnten nicht erstellt werden.");
		}

		Schachtel schachtel15 = schachtellager.verpacke(vase0);
		Schachtel schachtel16 = schachtellager.verpacke(vase1);
		System.out.println("Vasen wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel16);
		geschenkesack.addGeschenk(schachtel15);
		System.out.println("Vasen wurden erfolgreich zum Geschenkesack hinzugefuegt.");
	}

	private static void bonboniereTest() {
		Geschenk bonboniere0 = geschenke.getGeschenk("bonboniere0");
		Geschenk bonboniere1 = geschenke.getGeschenk("bonboniere1");
		if (bonboniere0 != null && bonboniere1 != null) {
			System.out.println("Bonboniere wurden erfolgreich erstellt.");
		} else {
			System.out.println("Bonboniere konnten nicht erstellt werden.");
		}

		Schachtel schachtel17 = schachtellager.verpacke(bonboniere0);
		Schachtel schachtel18 = schachtellager.verpacke(bonboniere1);
		System.out.println("Bonboniere wurde erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel17);
		geschenkesack.addGeschenk(schachtel18);
		System.out.println("Bonboniere wurde erfolgreich zum Geschenkesack hinzugefuegt.");
	}

	private static void schuhTest() {
		Geschenk schuhe0 = geschenke.getGeschenk("schuhe0");
		Geschenk schuhe1 = geschenke.getGeschenk("schuhe1");
		if (schuhe0 != null && schuhe1 != null) {
			System.out.println("Schuhe wurden erfolgreich erstellt.");
		} else {
			System.out.println("Schuhe konnten nicht erstellt werden.");
		}

		Schachtel schachtel19 = schachtellager.verpacke(schuhe0);
		Schachtel schachtel20 = schachtellager.verpacke(schuhe1);
		System.out.println("Schuhe wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel19);
		geschenkesack.addGeschenk(schachtel20);
		System.out.println("Schuhe wurden erfolgreich zum Geschenkesack hinzugefuegt.");
	}

	private static void artefaktTest() {
		Geschenk artefakt0 = geschenke.getGeschenk("artefakt0");
		Geschenk artefakt1 = geschenke.getGeschenk("artefakt1");
		if (artefakt0 != null && artefakt1 != null) {
			System.out.println("Artefakte wurden erfolgreich erstellt.");
		} else {
			System.out.println("Artefakte konnten nicht erstellt werden.");
		}

		Schachtel schachtel21 = schachtellager.verpacke(artefakt0);
		Schachtel schachtel22 = schachtellager.verpacke(artefakt1);
		System.out.println("Artefakte wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel21);
		geschenkesack.addGeschenk(schachtel22);
		System.out.println("Artefakte wurden erfolgreich zum Geschenkesack hinzugefuegt.");
	}

	private static void printGeschensack() {
		System.out.println();
		geschenkesack.inhalt();
		System.out.println("\n### Volumen des Geschenkesacks: " + geschenkesack.volumen() + "cm³ ###\n");
	}

	private static void rdmSchachtelGenerator(int anzahl) {
		Schachtellager schachtellager = Schachtellager.getInstance();

		for (int i = 0; i < anzahl; i++) {
			int rdm = (int) (Math.random() * 4);
			switch (rdm) {
				case 0:
					schachtellager.addSchachtel(new Schachtel(rdmWithRange(9, 18), new Kreis(rdmWithRange(5, 10))));
					break;
				case 1:
					schachtellager.addSchachtel(new Schachtel(rdmWithRange(3, 15), new Quadrat(rdmWithRange(3, 9))));
					break;
				case 2:
					schachtellager.addSchachtel(new Schachtel(rdmWithRange(3, 20), new Sechseck(rdmWithRange(4, 12))));
					break;
				default:
					schachtellager.addSchachtel(new Schachtel(rdmWithRange(3, 20), new Rechteck(rdmWithRange(2, 6), rdmWithRange(6, 12))));
					break;
			}
		}
	}

	private static int rdmWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}
}
