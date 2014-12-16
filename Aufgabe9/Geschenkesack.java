import java.util.ArrayList;

public class Geschenkesack {

	private static Geschenkesack instance = null;
	private ArrayList<Schachtel> schachtelList;

	private Geschenkesack() {
		schachtelList = new ArrayList<Schachtel>();
	}

	public static Geschenkesack getInstance() {
		if (instance == null) {
			instance = new Geschenkesack();
		}
		return instance;
	}

	public boolean addGeschenk(Schachtel schachtel) {
		if (!schachtel.hasGeschenk())
			return false;

		schachtelList.add(schachtel);
		return true;
	}

	public double volumen() {
		double volumen = 0;
		for (Schachtel schachtel : schachtelList) {
			volumen += schachtel.volumen();
		}
		return volumen;
	}

	public String inhalt() {
		String inhalt = "\n##########\nGeschenke im Sack:\n";
		for (Schachtel schachtel : schachtelList) {
			inhalt += schachtel.getName() + "\n";
		}
		return inhalt;
	}
}
