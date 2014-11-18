
// TODO remvoe hasPrevious, hasNext

import java.util.NoSuchElementException;

public class Wood<T> {

	private WoodyNode<Wood<T>> node;
	private T value;

	public Wood(T value) {
		this.value = value;
		this.node = new WoodyNode<Wood<T>>(this);
	}

	protected T getValue() {
		return value;
	}

	protected WoodyNode<Wood<T>> getNode() {
		return node;
	}

	// TODO - equals checks in person etc
	// TODO - immer erst zureck zum ersten element iterieren?
	public LeveledIter<Wood<T>> contains(T element) {
		LeveledIterImpl<Wood<T>> leveledIter = new LeveledIterImpl<Wood<T>>();

		LeveledIter<Wood<T>> rootIter = this.iterator();
		while (rootIter.hasNext()) {
			WoodyNode<Wood<T>> node = rootIter.next().getNode();

			if (node.getElement().getValue().equals(element)) {
				leveledIter.add(node.getElement());
			}

			LeveledIter<Wood<T>> subIter = node.getSub();
			if (node.getSub().hasNext()) {
				LeveledIter<Wood<T>> subElements = subIter.next().contains(element);
				while (subElements.hasNext()) {
					leveledIter.add(subElements.next());
				}
			}
		}

		return leveledIter;
	}

	// TODO - erstes element erst nach aufruf von next ! - testen sollte funken wenns richtig implementiert is !!! (denk i)
	// TODO - immer erst zureck zum ersten element iterieren?
	public LeveledIter<Wood<T>> iterator() {
		LeveledIterImpl<Wood<T>> rootIter = new LeveledIterImpl<Wood<T>>(node);

		while (rootIter.hasPrevious()) {
			rootIter.previous();
		}

		return rootIter;
	}


	protected class WoodyNode<F> {

		private F element;
		private WoodyNode<F> next;
		private WoodyNode<F> prev;
		private LeveledIter<F> subIter;

		protected WoodyNode(F element) {
			this.element = element;
		}

		protected F getElement() {
			return element;
		}

		protected LeveledIter<F> getSub() {
			return subIter;
		}

		// TODO needed?
		protected WoodyNode<F> getNext() {
			return next;
		}

		// TODO needed?
		protected WoodyNode<F> getPrev() {
			return prev;
		}

		// TODO concureent modif error? was passiert bei mehrere iteratoren gleichzeitig aenderungen?
		private void add(F element) {
			WoodyNode<F> node = new WoodyNode<F>(element);

			if (prev != null) {
				node.prev = getPrev();
				prev.next = node;
			}

			node.next = this;
			this.prev = node;

			subIter = new LeveledIterImpl<F>();
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
	protected class LeveledIterImpl<E> implements LeveledIter<E> {

		WoodyNode<E> prev = null;
		WoodyNode<E> next = null;

		protected LeveledIterImpl() {
		}

		protected LeveledIterImpl(WoodyNode<E> node) {
			next = node;
			prev = node.prev;
		}

		@Override
		public LeveledIter<E> sub() {
			// kein null
			LeveledIter<E> subIter = null;

			if (next != null) {
				// TODO - clone iter?
				subIter = next.subIter;
			}
			return subIter;
		}

		// TODO - ist das aktuelle element danach das neue?
		@Override
		public void add(E element) {
			if (next != null) {
				next.add(element);
				next = new WoodyNode<E>(element);
			} else if (next == null && prev != null) {
				prev.add(element);
			}
			next = new WoodyNode<E>(element);
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

		@Override
		public E next() {
			if (hasNext()) {
				prev = next;
				next = next.getNext();
			} else {
				throw new NoSuchElementException("no next element");
			}
			return prev.getElement();
		}

		@Override
		public E previous() {
			if (hasPrevious()) {
				next = prev;
				prev = prev.getPrev();
			} else {
				throw new NoSuchElementException("no previous element");
			}
			return next.getElement();
		}
	}

}