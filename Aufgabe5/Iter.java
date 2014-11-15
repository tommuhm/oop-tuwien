import java.util.Iterator;


public interface Iter<E> extends Iterator<E> {

	public E pervious();

	boolean hasPrevious();

}
