
public interface LeveledIter<E> extends Iter<E> {

	// Nachbedingung: wechselt in die Substruktur vom derzeitigen Wood
	public LeveledIter<E> sub();

	// Nachbedingung: fuegt ein neues Element zum derzeitigen Wood hinzu
	public void add(E e);

	// Nachbedingung: entfernt alle Elemente vom derzeitigen Wood
	public void remove();

}