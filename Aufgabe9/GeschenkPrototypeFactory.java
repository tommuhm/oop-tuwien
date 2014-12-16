import java.util.HashMap;

public class GeschenkPrototypeFactory {

	HashMap<String, Geschenk> geschenkMap;

	//Nachbedingung: erstellt eine HashMap von Prototypen
	public GeschenkPrototypeFactory() {
		geschenkMap = new HashMap<String, Geschenk>();

		geschenkMap.put("kerze0", new Kerze("Kerze 15x10", 15, 10));
		geschenkMap.put("kerze1", new Kerze("Kerze 20x05", 20, 05));
		geschenkMap.put("buch0", new Buch("Buch 2x10x4", 2, 10, 4));
		geschenkMap.put("buch1", new Buch("Buch 3x12x6", 3, 12, 6));
		geschenkMap.put("wuerfel0", new Wuerfel("Wuerfel 5x5x5", 5));
		geschenkMap.put("wuerfel1", new Wuerfel("Wuerfel 7x7x7", 7));
		geschenkMap.put("wein0", new Weinflasche("Weinfalsche 15x3", 15, 3));
		geschenkMap.put("wein1", new Weinflasche("Weinflasche 20x4", 20, 4));
		geschenkMap.put("vase0",new Vase("Vase 12x4", 12, 4));
		geschenkMap.put("vase1",new Vase("Vase 10x5", 10, 5));
		geschenkMap.put("bonboniere0", new Bonboniere("Bonboniere 7x7x10", 10, 7));
		geschenkMap.put("bonboniere1", new Bonboniere("Bonboniere 5x5x6", 6, 5));
		geschenkMap.put("schuhe0", new Schuhe("Schuhe 30x20x7", 7, 30, 20));
		geschenkMap.put("schuhe1", new Schuhe("Schuhe 40x30x12", 12, 40, 30));
		geschenkMap.put("artefakt0", new Artefakt("Artefakt 3x3x3", 3));
		geschenkMap.put("artefakt1", new Artefakt("Artefakt 9x9x9", 9));

	}

	//Vorbedingung: geschenk soll ein gueltiger key sein
	//Nachbedingung: gibt einen prototyp, passend zum key, zurueck
	public Geschenk getGeschenk(String geschenk) {
		if (geschenkMap.containsKey(geschenk))
			return (Geschenk) geschenkMap.get(geschenk).clone();
		return null;
	}

}
