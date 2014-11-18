
import java.util.NoSuchElementException;

public class Wood<T> {

	private WoodyNode<Wood<T>> node;
	private T element;

	public Wood(T element) {
		this.element = element;
		this.node = new WoodyNode<Wood<T>>(this);
	}

	protected T getElement() {
		return element;
	}

	public LeveledIter<Wood<T>> contains(T element) {
		LeveledIterImpl<Wood<T>> leveledIter = new LeveledIterImpl<Wood<T>>();

		LeveledIter<Wood<T>> rootIter = this.iterator();
		while (rootIter.hasNext()) {
			Wood<T> node = rootIter.next();

			if (node.getElement().equals(element)) {
				leveledIter.add(node);
			}

			LeveledIter<Wood<T>> subIter = rootIter.sub();
			if (subIter.hasNext()) {
				LeveledIter<Wood<T>> subElements = subIter.next().contains(element);
				while (subElements.hasNext()) {
					leveledIter.add(subElements.next());
				}
			}
		}

		return leveledIter;
	}

	// TODO - erstes element erst nach aufruf von next ! - testen sollte funken wenns richtig implementiert is !!! (denk i)
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

		// TODO concureent modif error? was passiert bei mehrere iteratoren gleichzeitig aenderungen?
		private void add(F element) {
			WoodyNode<F> node = new WoodyNode<F>(element);

			if (prev != null) {
				node.prev = prev;
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
				next = next.next;
			} else {
				throw new NoSuchElementException("no next element");
			}
			return prev.getElement();
		}

		@Override
		public E previous() {
			if (hasPrevious()) {
				next = prev;
				prev = prev.prev;
			} else {
				throw new NoSuchElementException("no previous element");
			}
			return next.getElement();
		}
	}

}