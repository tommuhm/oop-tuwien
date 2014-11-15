
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


	private class WoodyNode<T> {

		private Wood<T> wood;
		private T wert;
		private Wood<T> sub;
		private WoodyNode<T> next;
		private WoodyNode<T> prev;

		public WoodyNode(Wood<T> wood, T wert) {
			this.wood = wood;
			this.wert = wert;
		}

		public void add(Wood wood) {
			WoodyNode node = wood.getNode();

			node.prev = prev;
			prev.next = node;

			node.next = this;
			this.prev = node;
		}

		public Wood<T> getWood() {
			return wood;
		}

		public Wood<T> getSub() {
			return sub;
		}

		public WoodyNode<T> next() {
			return next;
		}

		public WoodyNode<T> previous() {
			return prev;
		}
	}

	// LevelIter implementation
	private class WoodIter implements LeveledIter<Wood> {

		WoodyNode prev = null;
		WoodyNode next = null;

		@Override
		public LeveledIter<Wood> sub() {
			LeveledIter<Wood> subIter = null;

			if (next != null) {
				Wood sub = next.getSub();

				if (sub != null) {
					subIter = sub.iterator();
				}
			}
			return subIter;
		}

		@Override
		public void add(Wood wood) {
			if (next == null) {
				next = wood.getNode();
			}
			if (prev != null) {
			}

			// TODO
		}

		@Override
		public void remove() {
			// TODO
		}

		@Override
		public boolean hasNext() {
			if (next != null) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Wood next() {
			if (hasNext()) {
				prev = next;
				next = next.next();
				return prev.getWood();
			} else {
				return null;
			}
		}

		@Override
		public boolean hasPrevious() {
			if (prev != null) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Wood previous() {
			if (hasPrevious()) {
				prev = prev.previous();
				next = prev;
				return next.getWood();
			} else {
				return null;
			}
		}
	}

}