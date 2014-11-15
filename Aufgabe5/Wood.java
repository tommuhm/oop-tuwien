
// TODO remvoe hasPrevious, hasNext

public class Wood<T> {

	private WoodyNode node;

	public Wood(T wert) {
		this.node = new WoodyNode(this, wert);
	}

	// TODO - immer erst zureck zum ersten element iterieren?
	public LeveledIter<Wood> contains(Wood wood) {
		WoodIter woodIter = new WoodIter();

		LeveledIter<Wood> rootIter = this.iterator();
		while (rootIter.hasNext()) {

		}



		// TODO - gibt iterator ueber alle gleichen elemente zureck (nicht identisch)
		return null;
	}

	// TODO - immer erst zureck zum ersten element iterieren?
	public LeveledIter<Wood> iterator() {
		WoodIter rootIter = new WoodIter();

		WoodyNode current = node;
		while (current != null) {
			rootIter.add(this);
			current = current.next;
		}

		return rootIter;
	}


	private class WoodyNode<T> {

		private Wood<T> wood;
		private T wert;
		private WoodyNode<T> next;
		private WoodyNode<T> prev;
		private LeveledIter<Wood> subIter;

		private WoodyNode(Wood<T> wood, T wert) {
			this.wood = wood;
			this.wert = wert;
		}

		private void add(Wood wood) {
			WoodyNode node = wood.node;

			if (prev != null) {
				node.prev = prev;
				prev.next = node;
			}

			node.next = this;
			this.prev = node;

			subIter = new WoodIter();
		}

		private void remove() {
			if (prev != null) {
				prev.next = next;
			}
			if (next != null) {
				next.prev = prev;
			}
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
				// TODO - clone iter?
				subIter = next.subIter;
			}
			return subIter;
		}

		// TODO - ist das aktuelle element danach das neue?
		@Override
		public void add(Wood wood) {
			if (next != null) {
				next.add(wood);
				next = wood.node;
			} else if (next == null && prev != null) {
				prev.add(wood);
			}
			next = wood.node;
		}


		// TODO - delete subtree?
		// TODO - NoSuchElementException
		@Override
		public void remove() {
			if (next != null) {
				next.remove();
				next = next.next;
			}
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
		public boolean hasPrevious() {
			if (prev != null) {
				return true;
			} else {
				return false;
			}
		}

		// TODO - NoSuchElementException
		@Override
		public Wood next() {
			if (hasNext()) {
				prev = next;
				next = next.next;
				return prev.wood;
			} else {
				return null;
			}
		}

		// TODO - NoSuchElementException
		@Override
		public Wood previous() {
			if (hasPrevious()) {
				prev = prev.prev;
				next = prev;
				return next.wood;
			} else {
				return null;
			}
		}
	}

}