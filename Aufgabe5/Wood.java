
public class Wood<T> {

	private WoodyNode node;

	public Wood(T wert) {
		this.node = new WoodyNode(this, wert);
	}

	// TODO - remove class - how to get node from wood without getter? we need it in the iterator
	public WoodyNode getNode() {
		return node;
	}

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

class WoodyNode<T> {

	private Wood<T> wood;
	private T wert;
	private Wood<T> sub;
	private WoodyNode<T> next;
	private WoodyNode<T> prev;

	public WoodyNode(Wood wood, T wert) {
		this.wood = wood;
		this.wert = wert;
	}

	public Wood<T> getWood() {
		return wood;
	}

	public Wood<T> getSub() {
		return sub;
	}

	public boolean hasNext() {
		if (next != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasPrev() {
		if (prev != null) {
			return true;
		} else {
			return false;
		}
	}

	public WoodyNode<T> getNext() {
		return next;
	}

	public WoodyNode<T> getPrev() {
		return prev;
	}
}

class WoodIter implements LeveledIter<Wood> {

	WoodyNode node = null;

	@Override
	public LeveledIter<Wood> sub() {
		Wood sub = node.getSub();

		LeveledIter<Wood> subIter;
		if (sub == null) {
			subIter = null;
		} else {
			subIter = sub.iterator();
		}

		return subIter;
	}

	@Override
	public void add(Wood wood) {
		if (node == null) {
			node = wood.getNode();
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
			return node.getNext().getWood();
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
			return node.getPrev().getWood();
		} else {
			return null;
		}
	}

}

