import java.util.Iterator;


public interface Iter<E> extends Iterator<E> {
	
	// Nachbedingung: gibt an, ob es noch ein vorheriges Element gibt
	boolean hasPrevious();

	// Nachbedingung: wechselt zum vorherigen Element
	public E previous();

}
