
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

	public LeveledIter<Wood> sub() {
		// TODO
		return null;
	}

	public LeveledIter<Wood> iterator() {
		WoodIter rootIterator = new WoodIter();

		WoodyNode current = node;
		while (current != null) {
			rootIterator.add(this);
			current = current.next();
		}

		return rootIterator;
	}
}
