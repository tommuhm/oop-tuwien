
// TODO remvoe hasPrevious, hasNext

import java.util.NoSuchElementException;

public class Wood<T> {

	private WoodyNode<T> node;
	private T wert;

	public Wood(T wert) {
		this.wert = wert;
		this.node = new WoodyNode<T>(this);
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
		private WoodyNode<T> next;
		private WoodyNode<T> prev;
		private LeveledIter<Wood> subIter;

		private WoodyNode(Wood<T> wood) {
			this.wood = wood;
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
		// TODO      * @throws IllegalStateException if the {@code next} method has not
		//         yet been called, or the {@code remove} method has already
		//         been called after the last call to the {@code next}
		//         method
		@Override
		public void remove() {
			if (next != null) {
				next.remove(); // TODO is des jetzt is richtige element? oder sollt net eig prev entfernt werden?
				next = next.next;
			} else {
				throw new IllegalStateException("remove can only be called after next has been called");
			}
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public boolean hasPrevious() {
			return prev != null;
		}

		// TODO - NoSuchElementException
		@Override
		public Wood next() {
			if (hasNext()) {
				prev = next;
				next = next.next;
				return prev.wood;
			} else {
				throw new NoSuchElementException("no next element");
			}
		}

		// TODO - NoSuchElementException
		@Override
		public Wood previous() {
			if (hasPrevious()) {
				next = prev;
				prev = prev.prev;
				return next.wood;
			} else {
				throw new NoSuchElementException("no previous element");
			}
		}
	}

}