
public class StrategieInferior implements Strategie {

	//zuerst nach oben, dann rechts, dann unten, dann links
	
	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) throws InterruptedException {
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
