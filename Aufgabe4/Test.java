/*
 * Fehlende Untertypbeziehungen:
 * SchutzBekleidung hat variablen und Code für AnzahlVerleihbar und desinfiziert,
 * diese sollten jedoch eher geerbt werden von Schutz/Bekleidung; jedoch ist Mehrfach-
 * vererbung nicht möglich.
 * 
 * 
 */


import java.util.HashSet;

public class Test {

	static Artikel helm1, jacke1, lawinensuchgeraet1, schutzSet, funSet, profiSet, skiwachs;
	
	public static void main(String[] args) {
		helm1 = new SchutzBekleidung("Helm XL", 200);
		jacke1 = new Jacke("DaunenXL");
		lawinensuchgeraet1 = new Schutz("Lawinensuchgerät", 2);

		HashSet<Artikel> schutzArtikel = new HashSet<Artikel>();
		schutzArtikel.add(new SchutzBekleidung("Helm 2",1));
		schutzArtikel.add(new Jacke("DaunenXS"));
		schutzArtikel.add(new Schutz("Lawinengerät", 100));
		
		schutzSet = new Schutz("Schutzset 1A!", schutzArtikel);
		
		Artikel fSki = new DiverseArtikel("Superfunski 200");
		Artikel fSkistoecke = new DiverseArtikel("Funstöcke 200");
		Artikel fSkischuhe = new DiverseArtikel("Funboots 200");
		funSet = new FunSet("Superfunset", 200);
		((FunSet)funSet).artikelHinzufuegen(fSki);
		((FunSet)funSet).artikelHinzufuegen(fSkistoecke);
		((FunSet)funSet).artikelHinzufuegen(fSkischuhe);
		
		Artikel pSki = new DiverseArtikel("Profiski 3000");
		Artikel pSkistoecke = new DiverseArtikel("Profistöcke 3000");
		Artikel pSkischuhe = new DiverseArtikel("Profischuhe 3000");
		profiSet = new ProfiSet("Pro-Set 3000");
		((ProfiSet)profiSet).artikelHinzufuegen(pSkischuhe);
		((ProfiSet)profiSet).artikelHinzufuegen(pSkistoecke);
		((ProfiSet)profiSet).artikelHinzufuegen(pSki);
		
		skiwachs = new DiverseArtikel("Skiwachs");
		
		testUntertypen();
		testSchutzVerleih();
		testProfiSetVerleih();
	}

	private static void testUntertypen() {
		assert helm1 instanceof KategorieSchutz;
		assert helm1 instanceof KategorieBekleidung;
		assert helm1 instanceof SchutzBekleidung;

		assert !(jacke1 instanceof KategorieSchutz);
		assert jacke1 instanceof KategorieBekleidung;
		assert !(jacke1 instanceof SchutzBekleidung);

		assert lawinensuchgeraet1 instanceof KategorieSchutz;
		assert !(lawinensuchgeraet1 instanceof KategorieBekleidung);
		assert !(lawinensuchgeraet1 instanceof SchutzBekleidung);
		
		assert lawinensuchgeraet1 instanceof KategorieSchutz;
		assert !(lawinensuchgeraet1 instanceof KategorieBekleidung);
		assert !(lawinensuchgeraet1 instanceof SchutzBekleidung);
	
		assert schutzSet instanceof KategorieSchutz;
		assert !(schutzSet instanceof KategorieBekleidung);
		assert !(schutzSet instanceof SchutzBekleidung);
		
		assert funSet instanceof Set;
		assert funSet instanceof FunSet;
		assert !(funSet instanceof ProfiSet);
		
		assert profiSet instanceof Set;
		assert profiSet instanceof ProfiSet;
		assert !(profiSet instanceof FunSet);
		
		assert skiwachs instanceof Artikel;
		assert skiwachs instanceof DiverseArtikel;
		
		
	}

	private static void testSchutzVerleih() {
		System.out.println("Verleihe Lawinensuchgerät an Hans:");
		lawinensuchgeraet1.verleihe("Hans");
		System.out.println(lawinensuchgeraet1);
		System.out.println("Verleihe Lawinensuchgerät an Peter:");
		lawinensuchgeraet1.verleihe("Peter");
		System.out.println(lawinensuchgeraet1);
		System.out.println("Konnte also von Peter nicht geborgt werden, da bereits verborgt.");
		System.out.println("Hans gibt das Gerät zurück:");
		lawinensuchgeraet1.retour();
		System.out.println(lawinensuchgeraet1);
		System.out.println("Lawinensuchgerät wird kontrolliert:");
		lawinensuchgeraet1.kontrolle();
		System.out.println(lawinensuchgeraet1);
		System.out.println("Verleihe Lawinensuchgerät an Peter: (nun ist die restliche Verleihanzahl bei 0)");
		lawinensuchgeraet1.verleihe("Peter");
		System.out.println(lawinensuchgeraet1);
		System.out.println("Nun wird retouniert von Peter: ");
		lawinensuchgeraet1.retour();
		System.out.println("Lawinensuchgerät wird kontrolliert:");
		lawinensuchgeraet1.kontrolle();
		System.out.println(lawinensuchgeraet1);
		System.out.println("Zustand ist noch immer auf \"benutzt\", weil Verleihanzahl == 0.\n\n");
		
		
		System.out.println("Verleihe SchutzSet an Hans:");
		schutzSet.verleihe("Hans");
		System.out.println(schutzSet);
		System.out.println("Hans gibt das Set zurück: (Verleihanzahl von Helm 2 ist bei 0)");
		schutzSet.retour();
		System.out.println(schutzSet);
		System.out.println("SchutzSet wird kontrolliert: (Der Zustand wird gebraucht bleibe, da Verleihanzahl = 0)");
		schutzSet.kontrolle();
		System.out.println(schutzSet);
		System.out.println("Verleihe SchutzSet an Peter:");
		schutzSet.verleihe("Peter");
		System.out.println(schutzSet);
		System.out.println("Konnte nicht geborgt werden, da verbraucht. \n\n");
	}

	private static void testBekleidungVerleih() {

	}

	private static void testSchutzBekleidungVerleih() {

	}

	private static void testFunSetVerleih() {

	}
	private static void testProfiSetVerleih() {
		System.out.println("Verleihe profiSet an Hermann Maier.");
		profiSet.verleihe("Hermann Maier");
		System.out.println(profiSet);
		System.out.println("Hermann Maier gibt das Set zurück");
		profiSet.retour();
		System.out.println(profiSet);
		System.out.println("Bode Miller borgt nun das Set: ");
		profiSet.verleihe("Bode Miller");
		System.out.println(profiSet);
		System.out.println("Nicht möglich: Zustand ist noch gebraucht. -> Jetzt wird erst Kontrolle ausgeführt. Anschließend gleich Service.");
		profiSet.kontrolle();
		System.out.println(profiSet);
		((Set) profiSet).service();
		System.out.println(profiSet);
		System.out.println("Nun borgt Bode Miller das Set aus:");
		profiSet.verleihe("Bode Miller");
		System.out.println(profiSet);
		System.out.println("Bode Miller gibt das Set zurück.");
		profiSet.retour();
		System.out.println(profiSet);
		System.out.println("Das ProfiSet wird nun kontrolliert, aber kein Service.");
		profiSet.kontrolle();
		System.out.println(profiSet);
		System.out.println("Nun borgt Michaela Kirchgasserer das Set aus");
		profiSet.verleihe("Michaela Kirchgasserer");
		System.out.println(profiSet);
		System.out.println("Jetzt gibt sie es zurück. Es wird kontrolliert, durch den fehlenden Service ist es aber nicht brauchbar:");
		profiSet.retour();
		profiSet.kontrolle();
		System.out.println(profiSet);
		System.out.println("Das Profiset, kann durch fehlenden Service nicht mehr repariert werden.\n\n");
	}
}
