import java.util.HashMap;

public class GeschenkPrototypeFactory {

	HashMap<String, Geschenk> geschenkMap;

	public GeschenkPrototypeFactory() {
		geschenkMap = new HashMap<String, Geschenk>();

		geschenkMap.put("kerze0", new Kerze("Kerze 15x10", 15, 10));
		geschenkMap.put("kerze1", new Kerze("Kerze 20x05", 20, 05));
		geschenkMap.put("buch0", new Buch("Buch 2x10x4", 2, 10, 4));
		geschenkMap.put("buch1", new Buch("Buch 3x12x6", 3, 12, 6));
		geschenkMap.put("wuerfel0", new Wuerfel("Wuerfel 5x5x5", 5, 5));
		geschenkMap.put("wuerfel1", new Wuerfel("Wuerfel 7x7x7", 7, 7));
		geschenkMap.put("wein0", new Weinflasche("Weinfalsche 20x3", 15, 3));
		geschenkMap.put("wein1", new Weinflasche("Weinflasche 20x4", 20, 4));

	}

	public Geschenk getGeschenk(String geschenk) {
		if (geschenkMap.containsKey(geschenk))
			return (Geschenk) geschenkMap.get(geschenk).clone();
		return null;
	}

}
