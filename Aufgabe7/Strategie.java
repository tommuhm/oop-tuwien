
public interface Strategie {

	public void sleep(int n) throws InterruptedException;

	public Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer) throws InterruptedException;

}
