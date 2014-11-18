
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
	public LeveledIter<Wood<T>> contains(Wood<T> wood) {
		WoodIter woodIter = new WoodIter();

		LeveledIter<Wood<T>> rootIter = this.iterator();
		while (rootIter.hasNext()) {

		}


		// TODO - gibt iterator ueber alle gleichen elemente zureck (AUCH identisch)!!!!!
		return null;
	}

	// TODO - immer erst zureck zum ersten element iterieren?
	public LeveledIter<Wood<T>> iterator() {
		WoodIter rootIter = new WoodIter();

		WoodyNode<T> current = node;
		while (current != null) {
			rootIter.add(this);
			current = current.next;
		}

		return rootIter;
	}


	public class WoodyNode<R> {

		private Wood<R> wood;
		private WoodyNode<R> next;
		private WoodyNode<R> prev;
		private LeveledIter<Wood<R>> subIter;

		private WoodyNode(Wood<R> wood) {
			this.wood = wood;
		}

		private void add(Wood<R> wood) {
			// TODO HAEFTIG !! OIDA !! FETT
			WoodyNode<R> node = (WoodyNode<R>) wood.node;

			if (prev != null) {
				node.prev = prev;
				prev.next = node;
			}

			node.next = this;
			this.prev = node;

			subIter = new WoodIter<R>();
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
	public class WoodIter<E> implements LeveledIter<Wood<E>> {

		WoodyNode<E> prev = null;
		WoodyNode<E> next = null;

		@Override
		public LeveledIter<Wood<E>> sub() {
			LeveledIter<Wood<E>> subIter = null;

			if (next != null) {
				// TODO - clone iter?
				subIter = next.subIter;
			}
			return subIter;
		}

		// TODO - ist das aktuelle element danach das neue?
		@Override
		public void add(Wood<E> wood) {
			if (next != null) {
				next.add(wood);
				// TODO HAEFTIG !! OIDA !! FETT
				next = (WoodyNode<E>) wood.node;
			} else if (next == null && prev != null) {
				prev.add(wood);
			}
			// TODO HAEFTIG !! OIDA !! FETT
			next = (WoodyNode<E>) wood.node;
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
		public Wood<E> next() {
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
		public Wood<E> previous() {
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