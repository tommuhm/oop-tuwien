public class Test {

	public static void main(String[] args) {
		
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
		 * Thomas Muhm: Geschenk, GeschenkPrototypeFactory, Grundflaeche, Kreis, Sechseck, Quadrat, Rechteck, Zusicherungen
		 */

		Schachtellager schachtellager = Schachtellager.getInstance();
		Geschenkesack geschenkesack = Geschenkesack.getInstance();
		GeschenkPrototypes geschenkprotoypefactory = new GeschenkPrototypes();

		// zeigt nach mehreren Ausfuehrungen auch, dass die Schachteln im Lager wirklich genutzt werden, 
		// da die Anzahl der dynamisch erstellten Objekte davon abhaengt, 
		// wie sehr die zufaellig erstellten Schachteln fuer die Geschenke passen
		rdmSchachtelGenerator(10);
		System.out.println("\nSchachteln wurden erstellt und zum Schachtellager hinzugefuegt.\n");

		Geschenk kerze0 = geschenkprotoypefactory.getGeschenk("kerze0");
		Geschenk kerze1 = geschenkprotoypefactory.getGeschenk("kerze1");
		System.out.println("Kerzen wurden erfolgreich erstellt.");

		Schachtel schachtel0 = schachtellager.verpacke(kerze0);
		Schachtel schachtel8 = schachtellager.verpacke(schachtel0); //verpacke 2fach
		Schachtel schachtel1 = schachtellager.verpacke(kerze1);
		System.out.println("Kerzen wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel8);
		geschenkesack.addGeschenk(schachtel1);
		System.out.println("Kerzen wurden erfolgreich zum Geschenkesack hinzugefuegt.");


		Geschenk buch0 = geschenkprotoypefactory.getGeschenk("buch0");
		Geschenk buch1 = geschenkprotoypefactory.getGeschenk("buch1");
		System.out.println("Buecher wurden erfolgreich erstellt.");

		Schachtel schachtel2 = schachtellager.verpacke(buch0);
		Schachtel schachtel9 = schachtellager.verpacke(schachtel2);
		Schachtel schachtel10 = schachtellager.verpacke(schachtel9); //verpacke 3fach
		Schachtel schachtel3 = schachtellager.verpacke(buch1);
		System.out.println("Buecher wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel10);
		geschenkesack.addGeschenk(schachtel3);
		System.out.println("Buecher wurden erfolgreich zum Geschenkesack hinzugefuegt.");


		Geschenk wuerfel0 = geschenkprotoypefactory.getGeschenk("wuerfel0");
		Geschenk wuerfel1 = geschenkprotoypefactory.getGeschenk("wuerfel1");
		System.out.println("Wuerfel wurden erfolgreich erstellt.");

		Schachtel schachtel4 = schachtellager.verpacke(wuerfel0);
		Schachtel schachtel11 = schachtellager.verpacke(schachtel4); //verpacke 2fach
		Schachtel schachtel5 = schachtellager.verpacke(wuerfel1);
		System.out.println("Wuerfel wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel11);
		geschenkesack.addGeschenk(schachtel5);
		System.out.println("Wuerfel wurden erfolgreich zum Geschenkesack hinzugefuegt.");


		Geschenk weinflasche0 = geschenkprotoypefactory.getGeschenk("wein0");
		Geschenk weinflasche1 = geschenkprotoypefactory.getGeschenk("wein1");
		System.out.println("Weinflaschen wurden erfolgreich erstellt.");

		Schachtel schachtel6 = schachtellager.verpacke(weinflasche0);
		Schachtel schachtel7 = schachtellager.verpacke(weinflasche1);
		Schachtel schachtel12 = schachtellager.verpacke(schachtel7);
		Schachtel schachtel13 = schachtellager.verpacke(schachtel12);
		Schachtel schachtel14 = schachtellager.verpacke(schachtel13); //verpacke 4fach
		System.out.println("Weinflaschen wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel6);
		geschenkesack.addGeschenk(schachtel14);
		System.out.println("Weinflaschen wurden erfolgreich zum Geschenkesack hinzugefuegt.");


		Geschenk vase0 = geschenkprotoypefactory.getGeschenk("vase0");
		Geschenk vase1 = geschenkprotoypefactory.getGeschenk("vase1");
		System.out.println("Vasen wurden erfolgreich erstellt.");

		Schachtel schachtel15 = schachtellager.verpacke(vase0);
		Schachtel schachtel16 = schachtellager.verpacke(vase1);
		System.out.println("Vasen wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel16);
		geschenkesack.addGeschenk(schachtel15);
		System.out.println("Vasen wurden erfolgreich zum Geschenkesack hinzugefuegt.");


		Geschenk bonboniere0 = geschenkprotoypefactory.getGeschenk("bonboniere0");
		Geschenk bonboniere1 = geschenkprotoypefactory.getGeschenk("bonboniere1");
		System.out.println("Bonboniere wurde erfolgreich erstellt.");

		Schachtel schachtel17 = schachtellager.verpacke(bonboniere0);
		Schachtel schachtel18 = schachtellager.verpacke(bonboniere1);
		System.out.println("Bonboniere wurde erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel17);
		geschenkesack.addGeschenk(schachtel18);
		System.out.println("Bonboniere wurde erfolgreich zum Geschenkesack hinzugefuegt.");


		Geschenk schuhe0 = geschenkprotoypefactory.getGeschenk("schuhe0");
		Geschenk schuhe1 = geschenkprotoypefactory.getGeschenk("schuhe1");
		System.out.println("Schuhe wurden erfolgreich erstellt.");

		Schachtel schachtel19 = schachtellager.verpacke(schuhe0);
		Schachtel schachtel20 = schachtellager.verpacke(schuhe1);
		System.out.println("Schuhe wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel19);
		geschenkesack.addGeschenk(schachtel20);
		System.out.println("Schuhe wurden erfolgreich zum Geschenkesack hinzugefuegt.");


		Geschenk artefakt0 = geschenkprotoypefactory.getGeschenk("artefakt0");
		Geschenk artefakt1 = geschenkprotoypefactory.getGeschenk("artefakt1");
		System.out.println("Artefakte wurden erfolgreich erstellt.");

		Schachtel schachtel21 = schachtellager.verpacke(artefakt0);
		Schachtel schachtel22 = schachtellager.verpacke(artefakt1);
		System.out.println("Artefakte wurden erfolgreich verpackt.");

		geschenkesack.addGeschenk(schachtel21);
		geschenkesack.addGeschenk(schachtel22);
		System.out.println("Artefakte wurden erfolgreich zum Geschenkesack hinzugefuegt.");

		System.out.println("\nVolumen des Geschenkesacks: " + geschenkesack.volumen() + "cm³");
		System.out.println("\nInhalt des Geschenkesacks:\n\n" + geschenkesack.inhalt());

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
