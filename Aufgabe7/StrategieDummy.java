
public class StrategieDummy implements Strategie {

	
	public static Kammer naechsteKammer(Kammer[][] labyrinth, Position p) {
		Kammer temp;

		//Eines nach links.
		if(p.getX() > 0 && labyrinth.length > 0 && labyrinth[0].length > 0) {
			temp = labyrinth[p.getY()][p.getX()-1];
			if(!temp.isMauerRechts()) {
				return temp;
			}
		}

		//Eines nach rechts.
		if(!labyrinth[p.getY()][p.getX()].isMauerRechts() && labyrinth.length > 0 && labyrinth[0].length > 0 && p.getX() < (labyrinth[0].length-1)) {
			temp = labyrinth[p.getY()][p.getX()+1];
			return temp;
		}

		//Eines nach oben.
		if(!labyrinth[p.getY()][p.getX()].isMauerOben() && p.getY() > 0 && labyrinth.length > 0) {
			temp = labyrinth[p.getY()-1][p.getX()];
			return temp;
		}

		if(p.getY() >= 0 &&  p.getY() < (labyrinth.length-1)) {
			temp = labyrinth[p.getY()+1][p.getX()];
			if(!temp.isMauerOben()) {
				return temp;
			}
		}
		
		return null;
	}
	
	
	
	
	public void sleep(int n) throws InterruptedException {
		try {
		Thread.sleep(n);
		} catch(InterruptedException ex) {
			System.out.println("InterruptedException occured in StrategieInferior");
		}
	}
}
