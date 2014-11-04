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
		helm1 = new SchutzBekleidung("Helm XL", 20);
		jacke1 = new Jacke("DaunenXL");
		lawinensuchgeraet1 = new Schutz("Lawinensuchgerät", 100);

		HashSet<Artikel> schutzArtikel = new HashSet<Artikel>();
		schutzArtikel.add(helm1);
		schutzArtikel.add(jacke1);
		schutzArtikel.add(lawinensuchgeraet1);
		
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
		System.out.println("Verleihe Lawinensuchgerät an Peter:");
		lawinensuchgeraet1.verleihe("Peter");
		System.out.println(lawinensuchgeraet1);
	}

	private static void testBekleidungVerleih() {

	}

	private static void testSchutzBekleidungVerleih() {

	}

	private static void testFunSetVerleih() {

	}
	private static void testProfiSetVerleih() {

	}
}
