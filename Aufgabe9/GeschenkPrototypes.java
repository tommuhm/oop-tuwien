import java.util.HashMap;

public class GeschenkPrototypes {

	HashMap<String, Geschenk> geschenkMap;

	// Nachbedingung: eine HashMap mit Geschenk-Prototypen wurde erstellt
	public GeschenkPrototypes() {
		geschenkMap = new HashMap<String, Geschenk>();

		geschenkMap.put("kerze1", new Kerze("Kerze 15x10", 15, 10));
		geschenkMap.put("kerze2", new Kerze("Kerze 20x05", 20, 05));
		geschenkMap.put("buch1", new Buch("Buch 2x10x4", 2, 10, 4));
		geschenkMap.put("buch2", new Buch("Buch 3x12x6", 3, 12, 6));
		geschenkMap.put("wuerfel1", new Wuerfel("Wuerfel 5x5x5", 5));
		geschenkMap.put("wuerfel2", new Wuerfel("Wuerfel 7x7x7", 7));
		geschenkMap.put("wein1", new Weinflasche("Weinfalsche 15x3", 15, 3));
		geschenkMap.put("wein2", new Weinflasche("Weinflasche 20x4", 20, 4));
		geschenkMap.put("vase1", new Vase("Vase 12x4", 12, 4));
		geschenkMap.put("vase2", new Vase("Vase 10x5", 10, 5));
		geschenkMap.put("bonboniere1", new Bonboniere("Bonboniere 7x7x10", 10, 7));
		geschenkMap.put("bonboniere2", new Bonboniere("Bonboniere 5x5x6", 6, 5));
		geschenkMap.put("schuhe1", new Schuhe("Schuhe 30x20x7", 7, 30, 20));
		geschenkMap.put("schuhe2", new Schuhe("Schuhe 40x30x12", 12, 40, 30));
		geschenkMap.put("artefakt1", new Artefakt("Artefakt 3x3x3", 3));
		geschenkMap.put("artefakt2", new Artefakt("Artefakt 9x9x9", 9));
	}

	// Nachbedingung: gibt eine neue instanz des angegeben prototyps zurueck
	// Nachbedingung: gibt null zurueck wenn der angegbene prototyp nicht existiert
	public Geschenk getGeschenk(String geschenk) {
		if (geschenkMap.containsKey(geschenk))
			return (Geschenk) geschenkMap.get(geschenk).clone();
		return null;
	}

}
