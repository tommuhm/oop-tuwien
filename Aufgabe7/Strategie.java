
public interface Strategie {
	
	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) throws InterruptedException;

	public void sleep(int n) throws InterruptedException;
}
