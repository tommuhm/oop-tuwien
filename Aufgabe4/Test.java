public class Test {

	public static void main(String[] args) {
		testUntertypen();
	}

	private static void testUntertypen() {
		Artikel helm1 = new SchutzBekleidung("Helm XL");;
		Artikel jacke1 = new Jacke("DaunenXL");
		
		Artikel lawinensuchgeraet1 = new Schutz("Lawinensuchgerät", 100);
		
		

		assert helm1 instanceof KategorieSchutz;
		assert !(helm1 instanceof KategorieBekleidung);
		assert helm1 instanceof SchutzBekleidung;

		assert !(jacke1 instanceof KategorieSchutz);
		assert jacke1 instanceof KategorieBekleidung;
		assert !(jacke1 instanceof SchutzBekleidung);

		assert lawinensuchgeraet1 instanceof KategorieSchutz;
		assert !(lawinensuchgeraet1 instanceof KategorieBekleidung);
		assert !(lawinensuchgeraet1 instanceof SchutzBekleidung);
	}

	private static void testSchutzVerleih() {
		
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
