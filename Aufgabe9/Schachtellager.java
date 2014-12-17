import java.util.ArrayList;

public class Schachtellager {

	private static Schachtellager instance = null;
	private ArrayList<Schachtel> schachtelList;

	// Invariante: instance muss eine referenz auf die singleton instanz sein, oder null wenn diese noch nicht existiert

	private Schachtellager() {
		schachtelList = new ArrayList<Schachtel>();
	}

	// Nachbedingung: falls es noch keine instance gab, wird diese hiermit erstellt
	// Nachbedingung: gibt die singleton instanz zurueck
	// Nachbedingung: versichert, dass es nur genau ein Schachtellager gibt
	public static Schachtellager getInstance() {
		if (instance == null) {
			instance = new Schachtellager();
		}
		return instance;
	}

	// Vorbedingung: schachtel darf nicht null sein
	// Nachbedingung: wenn eine schachtel ein geschenk beinhaltet, wird false zureckgeben und die schachtel wird nicht dem lager hinzugefuegt
	// Nachbedingung: wenn eine schachtel hizugefuegt wurde, dann wird true zurueckgegeben
	public boolean addSchachtel(Schachtel schachtel) {
		if (schachtel.hasGeschenk())
			return false;

		schachtelList.add(schachtel);
		return true;
	}

	// Vorbedingung: geschenk darf nicht null sein
	// Vorbedingung: geschenk darf noch nicht verpackt sein
	// Nachbedingung: falls eine passende schachtel in der schachtelList vorhanden ist, wird diese genommen, schachtel wird anschliessend aus der liste entfernt
	// Nachbedingung: falls keine passende schachtel in der schachtelList  vorhanden ist, dann wird das geschenk in einer neuen schachtel verpackt
	// Nachbedingung: gibt die schachtel in dem sich das geschenk befindet zurueck
	public Schachtel verpacke(Geschenk geschenk) {
		Schachtel schachtel = null;
		for (Schachtel s : schachtelList) {
			if (s.kannBeinhalten(geschenk)) {
				schachtel = s;
				break;
			}
		}

		if (schachtel == null) {
			schachtel = new Schachtel(geschenk.getHoehe(), geschenk.getGrundflaeche());
		} else {
			schachtelList.remove(schachtel);
		}
		schachtel.addGeschenk(geschenk);
		return schachtel;
	}
}
