
public interface LeveledIter<E> extends Iter<E> {

	public LeveledIter<E> sub();

	public void add(E e);

	public void remove();

}
