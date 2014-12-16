import java.util.ArrayList;

public class Geschenkesack {
	private static Geschenkesack instance = null;
	private ArrayList<Schachtel> schachtellist;

	public Geschenkesack(){
		schachtellist = new ArrayList<Schachtel>();
	}

	public Geschenkesack(ArrayList geschenklist){
		schachtellist = geschenklist;
	}

	public static Geschenkesack getInstance(){
		if(instance == null) {
			instance = new Geschenkesack();
		}
		return instance;
	}

	public void addGeschenk(Schachtel schachtel){
		schachtellist.add(schachtel);
	}

	public double volumen(){
		double volumen = 0;
		for (Schachtel schachtel : schachtellist) {   
			volumen += schachtel.volumen();
		}
		return volumen;
	}

	public String inhalt(){
		String inhalt = "\n##########\nGeschenkenamen im Sack:\n";
		for (Schachtel schachtel : schachtellist) {   
			inhalt += schachtel.getName();
		}
		return inhalt;
	}
}
