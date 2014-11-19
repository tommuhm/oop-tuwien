
public interface LeveledIter<E> extends Iter<E> {

	// Nachbedingung: gibt den Sub-Baum des naechsten elements zureck
	public LeveledIter<E> sub();

	// Vorbedingung: element darf nicht null
	// Nachbedingung: fuegt ein element vor dem next element in den Iterator ein
	public void add(E e);

	// Nachbedingung: entfernt den aktuellen Node (element das von dem letzten next() call zurueckgegben wurde)
	// Nachbedingung: wirft eine illegal state exception wenn remove aufgerufen wird bevor next aufgerufen wurde
	public void remove();

}