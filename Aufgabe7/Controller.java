
public class Controller {
	
	private Kammer[][] labyrinth;
	private Kammer startpunkt;
	private Kammer futterstelle;
	private int groesse;
	
	public Controller(Kammer[][] labyrinth, Kammer startpunkt, Kammer futterstelle) {
		this.labyrinth = labyrinth;
		this.startpunkt = startpunkt;
		this.futterstelle = futterstelle;
		this.groesse = labyrinth.length * labyrinth[0].length; //Labyrinth != null!!!!!!
	}
	
	public void start() {
		//Ameise leitameise = new Ameise();
	}
	
}
