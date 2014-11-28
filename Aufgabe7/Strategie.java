
public interface Strategie {

	public void sleep(int n) throws InterruptedException;

	public static Kammer naechsteKammer(Kammer[][] labyrinth, Kammer kammer);

}
