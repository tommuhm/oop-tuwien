/*
 * Fehlende Untertypbeziehungen:
 * SchutzBekleidung hat Variablen und Methoden für Anzahl-Verleihbar und desinfiziert,
 * diese sollten jedoch eher geerbt werden von Schutz/Bekleidung; jedoch ist Mehrfach-
 * vererbung in Java nicht möglich.
 *
 * Aufgabe 4:
 *  Die Programmarchitekur wurde gemeinsam auf Papier ausgearbeitet.
 *
 *  Set, FunSet, ProfiSet, DiverseArtikel, Test -> Ulrich Aschl
 *  Artikel, Zustand, KategorieSchutz, Schutz, SchutzBekleidung, Test -> Thomas Muhm
 *  ArtikelKlasse, KategorieBekleidung, Bekleidung, Jacke -> David Jaffry
 *
 *  Die TestCases wurden von Ulrich Aschl und Thomas Muhm geschrieben.
 *  Die Zusicherungen wurden von David Jaffry und Thomas Muhm geschrieben.
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
		schutzArtikel.add(new SchutzBekleidung("Helm 2", 1));
		schutzArtikel.add(new Jacke("DaunenXS"));
		schutzArtikel.add(new Schutz("Lawinengerät", 100));

		schutzSet = new Schutz("Schutzset 1A!", schutzArtikel);

		Artikel fSki = new DiverseArtikel("Superfunski 200");
		Artikel fSkistoecke = new DiverseArtikel("Funstöcke 200");
		Artikel fSkischuhe = new DiverseArtikel("Funboots 200");
		funSet = new FunSet("Superfunset", 1);
		((FunSet) funSet).artikelHinzufuegen(fSki);
		((FunSet) funSet).artikelHinzufuegen(fSkistoecke);
		((FunSet) funSet).artikelHinzufuegen(fSkischuhe);

		Artikel pSki = new DiverseArtikel("Profiski 3000");
		Artikel pSkistoecke = new DiverseArtikel("Profistöcke 3000");
		Artikel pSkischuhe = new DiverseArtikel("Profischuhe 3000");
		profiSet = new ProfiSet("Pro-Set 3000");
		((ProfiSet) profiSet).artikelHinzufuegen(pSkischuhe);
		((ProfiSet) profiSet).artikelHinzufuegen(pSkistoecke);
		((ProfiSet) profiSet).artikelHinzufuegen(pSki);

		skiwachs = new DiverseArtikel("Skiwachs");

		testUntertypen();
		System.out.print("\n\n");
		testProfiSetVerleih();
		System.out.print("\n\n");
		testFunSetVerleih();
		System.out.print("\n\n");
		testSchutzVerleih();
		System.out.print("\n\n");
		testBekleidungVerleih();
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

	private static void testProfiSetVerleih() {
		if (profiSet.zustand() == Zustand.verleihbar) {
			System.out.println("Verleihe profiSet an Hermann Maier.");
			profiSet.verleihe("Hermann Maier");
			System.out.println(profiSet);
		}
		if (profiSet.zustand() == Zustand.verliehen) {
			System.out.println("Hermann Maier gibt das Set zurück");
			profiSet.retour();
			System.out.println(profiSet);
		}
		if (profiSet.zustand() == Zustand.benutzt) {
			System.out.println("Kontrolle wird ausgefuehrt.");
			boolean kontrolle = profiSet.kontrolle();
			assert kontrolle == false;
			System.out.println("Kontrolle ist fehlgeschlagen da Service noch nicht ausgefuehrt wurde: ");
			System.out.println(profiSet);
			System.out.println("Service wird ausgefuehrt.");
			((Set) profiSet).service();
			System.out.println("Kontrolle wird ausgefuehrt.");
			kontrolle = profiSet.kontrolle();
			assert kontrolle == true;
			System.out.println("Kontrolle wurde ausgefuehrt Zustand ist defekt oder verleihbar:");
			System.out.println(profiSet);
		}
	}

	private static void testFunSetVerleih() {
		if (funSet.zustand() == Zustand.verleihbar) {
			System.out.println("Verleihe Funset an Hans:");
			funSet.verleihe("Hans");
			System.out.println(funSet);
		}
		if (funSet.zustand() == Zustand.verliehen) {
			System.out.println("Hans gibt das Funset zurück:");
			funSet.retour();
			System.out.println(funSet);
		}
		if (funSet.zustand() == Zustand.benutzt) {
			System.out.println("Funset wird kontrolliert:");
			funSet.kontrolle();
			System.out.println(funSet);
			assert funSet.zustand() == Zustand.benutzt;
			System.out.println("Funset ist immer noch im benutzt Zustand da die Anzahl der moeglichen Verleihungen 0 ist:");
			System.out.println(funSet);
		}
	}

	private static void testSchutzVerleih() {
		if (lawinensuchgeraet1.zustand() == Zustand.verleihbar) {
			System.out.println("Verleihe Lawinensuchgerät an Hans:");
			lawinensuchgeraet1.verleihe("Hans");
			System.out.println(lawinensuchgeraet1);
		}
		if (lawinensuchgeraet1.zustand() == Zustand.verliehen) {
			System.out.println("Hans gibt das Lawinensuchgerät zurück:");
			lawinensuchgeraet1.retour();
			System.out.println(lawinensuchgeraet1);
		}
		if (lawinensuchgeraet1.zustand() == Zustand.benutzt) {
			System.out.println("Lawinensuchgerät wird kontrolliert:");
			lawinensuchgeraet1.kontrolle();
			System.out.println(lawinensuchgeraet1);
		}
		if (lawinensuchgeraet1.zustand() == Zustand.verleihbar) {
			System.out.println("Verleihe Lawinensuchgerät an Peter: (nun ist die restliche Verleihanzahl bei 0)");
			lawinensuchgeraet1.verleihe("Peter");
			System.out.println(lawinensuchgeraet1);
		}
		if (lawinensuchgeraet1.zustand() == Zustand.verliehen) {
			System.out.println("Nun wird retouniert von Peter: ");
			lawinensuchgeraet1.retour();
			System.out.println(lawinensuchgeraet1);
		}
		if (lawinensuchgeraet1.zustand() == Zustand.benutzt) {
			System.out.println("Lawinensuchgerät wird kontrolliert:");
			lawinensuchgeraet1.kontrolle();
			System.out.println(lawinensuchgeraet1);
			assert lawinensuchgeraet1.zustand() == Zustand.benutzt;
			System.out.println("Zustand ist noch immer auf \"benutzt\", weil Verleihanzahl == 0.");
		}
	}

	private static void testBekleidungVerleih() {
		if (jacke1.zustand() == Zustand.verleihbar) {
			System.out.println("Verleihe Jacke an Hans:");
			jacke1.verleihe("Hans");
			System.out.println(jacke1);
		}
		if (jacke1.zustand() == Zustand.verliehen) {
			System.out.println("Hans gibt das Jacke zurück:");
			jacke1.retour();
			System.out.println(jacke1);
		}
		if (jacke1.zustand() == Zustand.benutzt) {
			System.out.println("Jacke wird kontrolliert:");
			boolean kontrolle = jacke1.kontrolle();
			assert kontrolle == false;
			System.out.println("Jacke ist immer noch im benutzt Zustand sie nicht desinfiziert ist:");
			System.out.println(jacke1);
			System.out.println("Jacke wird desinfiziert:");
			((KategorieBekleidung)jacke1).desinfiziere();
			System.out.println(jacke1);
			System.out.println("Jacke kann nun kontrolliert werden:");
			jacke1.kontrolle();
			System.out.println("Zustand der Jacke ist nun defekt oder verleihbar:");
			System.out.println(jacke1);
		}
	}

}
