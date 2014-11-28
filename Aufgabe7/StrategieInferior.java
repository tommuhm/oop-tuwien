
public class StrategieInferior implements Strategie {

	
	
	
	
	
	
	public void sleep(int n) throws InterruptedException {
		try {
		Thread.sleep(n);
		} catch(InterruptedException ex) {
			System.out.println("InterruptedException occured in StrategieInferior");
		}
	}
}
