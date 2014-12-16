import java.util.ArrayList;

public class Geschenkesack {
	private static Geschenkesack instance = null;
	private ArrayList<Schachtel> sacklist;

	public Geschenkesack(){
		sacklist = new ArrayList<Schachtel>();
	}

	public Geschenkesack(ArrayList geschenklist){
		sacklist = geschenklist;
	}
	
	public static Geschenkesack getInstance(){
		if(instance == null) {
			instance = new Geschenkesack();
		}
		return instance;
	}

	public void addGeschenk(Schachtel schachtel){
		sacklist.add(schachtel);
	}
	
	public double volumen(){
		double volumen;
		for (Schachtel schachtel : sacklist) {   
		    volumen += schachtel.volumen();
		}
		return volumen;
	}

	public String inhalt(){
		String inhalt = "\n ########## \n";
		for (Schachtel schachtel : sacklist) {   
		    schachtel.getName();
		}
	}
}
