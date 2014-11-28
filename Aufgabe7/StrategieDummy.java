
public class StrategieDummy implements Strategie {

	@Override
	public static Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) {
		Kammer temp;

		//Eines nach links.
		if(p.getX() > 0 && labyrinth.length > 0 && labyrinth[0].length > 0) {
			temp = labyrinth[kammer.getY()][kammer.getX()-1];
			if(!temp.isMauerRechts()) {
				return temp;
			}
		}

		//Eines nach rechts.
		if(!labyrinth[kammer.getY()][kammer.getX()].isMauerRechts() && labyrinth.length > 0 && labyrinth[0].length > 0 && kammer.getX() < (labyrinth[0].length-1)) {
			temp = labyrinth[kammer.getY()][kammer.getX()+1];
			return temp;
		}

		//Eines nach oben.
		if(!labyrinth[kammer.getY()][kammer.getX()].isMauerOben() && kammer.getY() > 0 && labyrinth.length > 0) {
			temp = labyrinth[kammer.getY()-1][kammer.getX()];
			return temp;
		}

		if(p.getY() >= 0 && kammer.getY() < (labyrinth.length-1)) {
			temp = labyrinth[kammer.getY()+1][kammer.getX()];
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
