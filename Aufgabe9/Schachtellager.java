import java.util.ArrayList;

public class Schachtellager {

	private static Schachtellager instance = null;
	private ArrayList<Schachtel> schachtelList;

	private Schachtellager() {
		schachtelList = new ArrayList<Schachtel>();
	}

	public static Schachtellager getInstance() {
		if (instance == null) {
			instance = new Schachtellager();
		}
		return instance;
	}

	public boolean addSchachtel(Schachtel schachtel) {
		if (schachtel.hasGeschenk())
			return false;

		schachtelList.add(schachtel);
		return true;
	}

	public Schachtel verpacke(Geschenk geschenk) {
		Schachtel schachtel = null;
		for (Schachtel s : schachtelList) {
			if (s.addGeschenk(geschenk)) {
				schachtel = s;
				break;
			}
		}

		if (schachtel != null) {
			schachtel = new Schachtel(geschenk.getHoehe(), geschenk.getGrundform());
			schachtel.addGeschenk(geschenk);
		} else {
			schachtelList.remove(schachtel);
		}
		return schachtel;
	}
}
