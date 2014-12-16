public class Test {

	public static void main(String[] args) {
		
		/*
		 * Schreiben Sie eine Klasse Test, die das Lager, den Geschenkesack, 
		 * alle Klassen von Geschenken und Schachteln und alle Untertypbeziehungen testet.
		 */
		
		Schachtellager schachtellager = Schachtellager.getInstance();
		Geschenkesack geschenkesack = Geschenkesack.getInstance();
		
		
		Geschenk kerze0 = new Kerze("Kerze0", 30, new Sechseck(5.5));
		Geschenk kerze1 = new Kerze("Kerze1", 25.5, new Sechseck(8.1));
		
		//Vorbedingung: innere Verpackung/Geschenk verpacken nicht möglich, wenn äußere Verpackung vorhanden
		Schachtel schachtel0 = schachtellager.verpacke(kerze0);
		Schachtel schachtel8 = schachtellager.verpacke(schachtel0); //verpacke 2fach
		Schachtel schachtel1 = schachtellager.verpacke(kerze1);
		
		//fuege Geschenke zu Sack hinzu
		geschenkesack.addGeschenk(schachtel8);
		geschenkesack.addGeschenk(schachtel1);
		

		Geschenk buch0 = new Buch("Buch0", 3.1, new Rechteck(12.4,9));
		Geschenk buch1 = new Buch("Buch1", 5.5, new Rechteck(24,15.9));
		
		//Vorbedingung: innere Verpackung/Geschenk verpacken nicht möglich, wenn äußere Verpackung vorhanden
		Schachtel schachtel2 = schachtellager.verpacke(buch0);
		Schachtel schachtel9 = schachtellager.verpacke(schachtel2);
		Schachtel schachtel10 = schachtellager.verpacke(schachtel9); //verpacke 3fach
		Schachtel schachtel3 = schachtellager.verpacke(buch1);
		
		geschenkesack.addGeschenk(schachtel10);
		geschenkesack.addGeschenk(schachtel3);
	
		
		Geschenk wuerfel0 = new Wuerfel("Wuerfel0", 5, new Quadrat(5));
		Geschenk wuerfel1 = new Wuerfel("Wuerfel1", 1.2, new Quadrat(1.2));
		
		//Vorbedingung: innere Verpackung/Geschenk verpacken nicht möglich, wenn äußere Verpackung vorhanden
		Schachtel schachtel4 = schachtellager.verpacke(wuerfel0);
		Schachtel schachtel11 = schachtellager.verpacke(schachtel4); //verpacke 2fach
		Schachtel schachtel5 = schachtellager.verpacke(wuerfel1);
		
		geschenkesack.addGeschenk(schachtel11);
		geschenkesack.addGeschenk(schachtel5);
		
		
		Geschenk weinflasche0 = new Weinflasche("Weinflasche0", 32.4, new Kreis(4.5));
		Geschenk weinflasche1 = new Weinflasche("Weinflasche1", 34.8, new Kreis(6.1));
		
		//Vorbedingung: innere Verpackung/Geschenk verpacken nicht möglich, wenn äußere Verpackung vorhanden
		Schachtel schachtel6 = schachtellager.verpacke(weinflasche0);
		Schachtel schachtel7 = schachtellager.verpacke(weinflasche1);
		Schachtel schachtel12 = schachtellager.verpacke(schachtel7);
		Schachtel schachtel13 = schachtellager.verpacke(schachtel12);
		Schachtel schachtel14 = schachtellager.verpacke(schachtel13); //verpacke 4fach
		
		geschenkesack.addGeschenk(schachtel6);
		geschenkesack.addGeschenk(schachtel14);
		
		/*
		 * Da in dem Programm viele Objekte erzeugt werden, 
		 * soll die Anzahl der dynamisch erzeugten Objekte gezählt werden. 
		 * Kapseln sie das Zählen der Objekte in einem Aspekt und
		 * geben Sie die Anzahl am Ende des Programms am Bildschirm aus.
		 */
		
		//TODO aspectj
		
		

	}
}
