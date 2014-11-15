
public class Wood<T> {

	private Wood<T> prev;
	private Wood<T> next;
	private Wood<T> sub;

	public LeveledIter<T> contains(T e) {
		// TODO - gibt iterator ueber alle gleichen elemente zureck (nicht identisch)
		return null;
	}

	public LeveledIter<T> iterator() {
		WoodIter<Wood> rootIterator = new WoodIter<Wood>();
		rootIterator.add(this);

		// TODO - gibt die wurzeln aller baeume zurueck
		return null;
	}


}

class WoodIter<Wood> implements LeveledIter {

	@Override
	public LeveledIter<Wood> sub() {
		return null;
	}

	@Override
	public void add(Object o) {

	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Wood next() {
		return null;
	}

	@Override
	public void remove() {

	}

	@Override
	public Wood pervious() {
		return null;
	}

	@Override
	public boolean hasPrevious() {
		return false;
	}
}
