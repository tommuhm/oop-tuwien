public class Test {

	public static void main(String[] args) {
		
		/*
		 * Schreiben Sie eine Klasse Test, die das Lager, den Geschenkesack, 
		 * alle Klassen von Geschenken und Schachteln und alle Untertypbeziehungen testet.
		 * 
		 * 		//Vorbedingung: innere Verpackung/Geschenk verpacken nicht möglich, wenn äußere Verpackung vorhanden
		 */		
		
		Schachtellager schachtellager = Schachtellager.getInstance();
		Geschenkesack geschenkesack = Geschenkesack.getInstance();
		GeschenkPrototypeFactory geschenkprotoypefactory = new GeschenkPrototypeFactory();
		
		
		Geschenk kerze0 = geschenkprotoypefactory.getGeschenk("kerze0");
		Geschenk kerze1 = geschenkprotoypefactory.getGeschenk("kerze1");
		
		Schachtel schachtel0 = schachtellager.verpacke(kerze0);
		Schachtel schachtel8 = schachtellager.verpacke(schachtel0); //verpacke 2fach
		Schachtel schachtel1 = schachtellager.verpacke(kerze1);
		
		geschenkesack.addGeschenk(schachtel8);
		geschenkesack.addGeschenk(schachtel1);
		

		Geschenk buch0 = geschenkprotoypefactory.getGeschenk("buch0");
		Geschenk buch1 = geschenkprotoypefactory.getGeschenk("buch1");
		
		Schachtel schachtel2 = schachtellager.verpacke(buch0);
		Schachtel schachtel9 = schachtellager.verpacke(schachtel2);
		Schachtel schachtel10 = schachtellager.verpacke(schachtel9); //verpacke 3fach
		Schachtel schachtel3 = schachtellager.verpacke(buch1);
		
		geschenkesack.addGeschenk(schachtel10);
		geschenkesack.addGeschenk(schachtel3);
	
		
		Geschenk wuerfel0 = geschenkprotoypefactory.getGeschenk("wuerfel0");
		Geschenk wuerfel1 = geschenkprotoypefactory.getGeschenk("wuerfel1");
		
		Schachtel schachtel4 = schachtellager.verpacke(wuerfel0);
		Schachtel schachtel11 = schachtellager.verpacke(schachtel4); //verpacke 2fach
		Schachtel schachtel5 = schachtellager.verpacke(wuerfel1);
		
		geschenkesack.addGeschenk(schachtel11);
		geschenkesack.addGeschenk(schachtel5);
		
		
		Geschenk weinflasche0 = geschenkprotoypefactory.getGeschenk("wein0");
		Geschenk weinflasche1 = geschenkprotoypefactory.getGeschenk("wein1");
		
		Schachtel schachtel6 = schachtellager.verpacke(weinflasche0);
		Schachtel schachtel7 = schachtellager.verpacke(weinflasche1);
		Schachtel schachtel12 = schachtellager.verpacke(schachtel7);
		Schachtel schachtel13 = schachtellager.verpacke(schachtel12);
		Schachtel schachtel14 = schachtellager.verpacke(schachtel13); //verpacke 4fach
		
		geschenkesack.addGeschenk(schachtel6);
		geschenkesack.addGeschenk(schachtel14);
		
		
		Geschenk glas0 = geschenkprotoypefactory.getGeschenk("glas0");
		Geschenk glas1 = geschenkprotoypefactory.getGeschenk("glas1");

		Schachtel schachtel15 = schachtellager.verpacke(glas0);
		Schachtel schachtel16 = schachtellager.verpacke(glas1);
		
		geschenkesack.addGeschenk(schachtel16);
		geschenkesack.addGeschenk(schachtel15);
		
		
		Geschenk bonboniere0 = geschenkprotoypefactory.getGeschenk("bonboniere0");
		Geschenk bonboniere1 = geschenkprotoypefactory.getGeschenk("bonboniere1");

		Schachtel schachtel17 = schachtellager.verpacke(bonboniere0);
		Schachtel schachtel18 = schachtellager.verpacke(bonboniere1);
		
		geschenkesack.addGeschenk(schachtel17);
		geschenkesack.addGeschenk(schachtel18);
		
		
		Geschenk schuhe0 = geschenkprotoypefactory.getGeschenk("schuhe0");
		Geschenk schuhe1 = geschenkprotoypefactory.getGeschenk("schuhe1");

		Schachtel schachtel19 = schachtellager.verpacke(schuhe0);
		Schachtel schachtel20 = schachtellager.verpacke(schuhe1);
		
		geschenkesack.addGeschenk(schachtel19);
		geschenkesack.addGeschenk(schachtel20);
		
		
		Geschenk artefakt0 = geschenkprotoypefactory.getGeschenk("artefakt0");
		Geschenk artefakt1 = geschenkprotoypefactory.getGeschenk("artefakte1");

		Schachtel schachtel21 = schachtellager.verpacke(artefakt0);
		Schachtel schachtel22 = schachtellager.verpacke(artefakt1);
		
		geschenkesack.addGeschenk(schachtel21);
		geschenkesack.addGeschenk(schachtel22);
		
		/*
		 * Da in dem Programm viele Objekte erzeugt werden, 
		 * soll die Anzahl der dynamisch erzeugten Objekte gezählt werden. 
		 * Kapseln sie das Zählen der Objekte in einem Aspekt und
		 * geben Sie die Anzahl am Ende des Programms am Bildschirm aus.
		 */
		
		//TODO aspectj
		
		

	}
}
