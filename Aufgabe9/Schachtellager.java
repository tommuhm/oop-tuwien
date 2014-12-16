import java.util.ArrayList;

public class Schachtellager {

	private static Schachtellager instance = null;
	private ArrayList<Schachtel> schachtelList;

	private Schachtellager() {
		schachtelList = new ArrayList<Schachtel>();
	}

	//Nachbedingung: gibt instance zurueck
	//Nachbedingung: falls noch keine instance vorhanden, dann wird sie hiermit initiert
	public static Schachtellager getInstance() {
		if (instance == null) {
			instance = new Schachtellager();
		}
		return instance;
	}

	//Vorbedingung: schachtel darf nicht null sein
	//Nachbedingung: eine schachtel kann nicht hinzugefuegt werden, wenn sie schon ein geschenk beinhaltet, gibt daher false zurueck
	//Nachbedingung: wenn eine schachtel hizugefuegt wird, dann wird true zurueckgegeben
	public boolean addSchachtel(Schachtel schachtel) {
		if (schachtel.hasGeschenk())
			return false;

		schachtelList.add(schachtel);
		return true;
	}

	//Vorbedingung: geschenk darf nicht null sein
	//Vorbedingung: innere Verpackung/Geschenk verpacken nicht möglich, wenn äußerere Verpackung vorhanden
	//Nachbedingung: falls eine passende schachtel in der schachtelList vorhanden ist, wird diese genommen, schachtel wird anschliessend aus der liste entfernt
	//Nachbedingung: falls keine passende schachtel in der schachtelList vorhanden ist, dann wird diese erstellt
	public Schachtel verpacke(Geschenk geschenk) {
		Schachtel schachtel = null;
		for (Schachtel s : schachtelList) {
			if (s.kannBeinhalten(geschenk)) {
				schachtel = s;
				break;
			}
		}

		if (schachtel == null) {
			schachtel = new Schachtel(geschenk.getHoehe(), geschenk.getGrundform());
		} else {
			schachtelList.remove(schachtel);
		}
		schachtel.addGeschenk(geschenk);
		return schachtel;
	}
}
