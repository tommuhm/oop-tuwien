import java.util.Iterator;


public interface Iter<E> extends Iterator<E> {

	// Nachbedingung: true, wenn es eine vorherige Node gibt
	boolean hasPrevious();

	// Nachbedingung: wechselt auf die vorherige Node
	// Nachbedingung: wirft eine NoSuchElementException wenn der anfang der liste erreicht wurde
	public E previous();

}
