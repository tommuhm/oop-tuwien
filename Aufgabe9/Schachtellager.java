import java.util.ArrayList;

public class Schachtellager {
	private static Schachtellager instance = null;
	public ArrayList<Schachtel> lagerlist;

	public Schachtellager(){
		lagerlist = new ArrayList<Schachtel>();
	}

	public static Schachtellager getInstance(){
		if(instance == null) {
			instance = new Schachtellager();
		}
		return instance;
	}

	public void addSchachtel(Schachtel schachtel){
		lagerlist.add(schachtel);
	}

	public void verpacke(Geschenk geschenk){
		boolean stickybit = false;
		for (Schachtel schachtel : lagerlist) {   
			if (schachtel.addGeschenk(geschenk)) {
				stickybit = true;
				break;
			}
		}
		if (!(stickybit)) {
			Grundflaeche gflaeche = geschenk.getGrundform();
			//TODO
		}
	}

	public String inventar(){
		return null;	
	}
}