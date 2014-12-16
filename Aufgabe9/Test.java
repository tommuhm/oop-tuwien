public class Test {

	public static void main(String[] args) {
		Schachtellager schachtellager = Schachtellager.getInstance();
		Geschenkesack geschenkesack = Geschenkesack.getInstance();
		
		Geschenk kerze0 = new Kerze("Kerze0", 30, new Sechseck(5.5));
		Geschenk kerze1 = new Kerze("Kerze1", 25.5, new Sechseck(8.1));
		
		Schachtel schachtel0 = schachtellager.verpacke(kerze0);
		Schachtel schachtel1 = schachtellager.verpacke(kerze1);
		

		Geschenk buch0 = new Buch("Buch0", 3.1, new Rechteck(12.4,9));
		Geschenk buch1 = new Buch("Buch1", 5.5, new Rechteck(24,15.9));
		
		Schachtel schachtel2 = schachtellager.verpacke(buch0);
		Schachtel schachtel3 = schachtellager.verpacke(buch1);

		
		Geschenk wuerfel0 = new Wuerfel("Wuerfel0", 5, new Quadrat(5));
		Geschenk wuerfel1 = new Wuerfel("Wuerfel1", 1.2, new Quadrat(1.2));

		Schachtel schachtel4 = schachtellager.verpacke(wuerfel0);
		Schachtel schachtel5 = schachtellager.verpacke(wuerfel1);
		
		
		Geschenk weinflasche0 = new Weinflasche("Weinflasche0", 32.4, new Kreis(4.5));
		Geschenk weinflasche1 = new Weinflasche("Weinflasche1", 34.8, new Kreis(6.1));
		
		Schachtel schachtel6 = schachtellager.verpacke(weinflasche0);
		Schachtel schachtel7 = schachtellager.verpacke(weinflasche1);
		
		

		

	}
}
