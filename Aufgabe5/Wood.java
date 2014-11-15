
public class Wood<T> {

	private WoodyNode node;

	public LeveledIter<Wood> contains(Wood wood) {
		// TODO - gibt iterator ueber alle gleichen elemente zureck (nicht identisch)
		return null;
	}

	public LeveledIter<Wood> iterator() {
		WoodIter rootIterator = new WoodIter();

		WoodyNode current = node;
		while (current != null) {
			rootIterator.add(this);
			current = current.getNext();
		}

		// TODO - gibt die wurzeln aller baeume zurueck
		return rootIterator;
	}


}

class WoodIter implements LeveledIter<Wood> {

	WoodyNode node = null;

	@Override
	public LeveledIter<Wood> sub() {
		if (node != null) {
			return node.getSub();
		} else {
			return null;
		}
	}

	@Override
	public void add(Wood wood) {
		if (node == null) {
			node = new WoodyNode(wood);
		} else {
			// TODO
		}
	}

	@Override
	public void remove() {
		// TODO
	}

	@Override
	public boolean hasNext() {
		if (node != null && node.hasNext()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Wood next() {
		if (hasNext()) {
			return node.getNext();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasPrevious() {
		if (node != null && node.hasPrev()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Wood pervious() {
		if (hasPrevious()) {
			return node.getPrev();
		} else {
			return null;
		}
	}

}
