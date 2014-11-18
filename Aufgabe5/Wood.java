
import java.util.NoSuchElementException;

public class Wood<T> {

	private WoodyNode<Wood<T>> node;
	private T element;

	// Vorbedingung: element darf nicht null sein
	// Nachbedingung: eine node mit this wurde erstellt
	public Wood(T element) {
		this.element = element;
		this.node = new WoodyNode<Wood<T>>(this);
	}
	
	protected T getElement() {
		return element;
	}

	// Vorbedingung: element darf nicht null sein
	// Nachbedingung: sucht alle Elemente in der Datenstruktur, die gleich element sind. Das Ergebnis ist leveledIter, der ueber alle gefundenen gleichen Elemente iteriert
	public LeveledIter<Wood<T>> contains(T element) {
		LeveledIterImpl<Wood<T>> leveledIter = new LeveledIterImpl<Wood<T>>();

		LeveledIter<Wood<T>> rootIter = this.iterator();
		while (rootIter.hasNext()) {

			LeveledIter<Wood<T>> subIter = rootIter.sub();
			Wood<T> node = rootIter.next();
			if (node.getElement().equals(element)) {
				leveledIter.add(node);
			}

			if (subIter.hasNext()) {
				LeveledIter<Wood<T>> subElements = subIter.next().contains(element);
				while (subElements.hasNext()) {
					leveledIter.add(subElements.next());
				}
			}
		}

		return leveledIter;
	}

	// Nachbedingung: initialisiert einen Iterator und setzt den Pointer vor das erste Element
	public LeveledIter<Wood<T>> iterator() {
		LeveledIterImpl<Wood<T>> rootIter = new LeveledIterImpl<Wood<T>>(node);

		while (rootIter.hasPrevious()) {
			rootIter.previous();
		}

		return rootIter;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		toStringHelper(out, "", iterator());
		return out.toString();
	}

	private void toStringHelper(StringBuilder out, String indent, LeveledIter<Wood<T>> iter) {
		while (iter.hasNext()) {
			LeveledIter<Wood<T>> sub = iter.sub();
			out.append(indent + iter.next().getElement() + "\n");
			toStringHelper(out, indent + "-", sub);
		}
	}

	protected class WoodyNode<F> {

		private F element;
		private WoodyNode<F> next;
		private WoodyNode<F> prev;
		private LeveledIterImpl<F> subIter;

		// Vorbedingung: element darf nicht null sein
		// Nachbedingung: erstellt einen neuen Iterator
		protected WoodyNode(F element) {
			this.element = element;
			this.subIter = new LeveledIterImpl<F>();
		}

		protected F getElement() {
			return element;
		}

		// TODO concureent modif error? was passiert bei mehrere iteratoren gleichzeitig aenderungen?
		// Vorbedingung: element darf nicht null sein
		// Nachbedingung: fuegt element vor der aktuellen Node ein
		private void addBefore(F element) {
			WoodyNode<F> node = new WoodyNode<F>(element);

			if (prev != null) {
				node.prev = prev;
				prev.next = node;
			}

			node.next = this;
			this.prev = node;
		}

		// TODO concureent modif error? was passiert bei mehrere iteratoren gleichzeitig aenderungen?
		// Vorbedingung: element darf nicht null sein
		// Nachbedingung: fuegt element nach der aktuellen Node ein
		private void addAfter(F element) {
			WoodyNode<F> node = new WoodyNode<F>(element);

			if (next != null) {
				node.next = next;
				next.prev = node;
			}

			node.prev = this;
			this.next = node;
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

		private WoodyNode<E> prev = null;
		private WoodyNode<E> next = null;

		protected LeveledIterImpl() {
		}

		// Vorbedingung: node darf nicht null sein
		// Nachbedingung: fuegt eine node ein
		protected LeveledIterImpl(WoodyNode<E> node) {
			next = node;
			prev = node.prev;
		}

		// Nachbedingung: gibt die Substruktur vom naesten node zurueck
		@Override
		public LeveledIter<E> sub() {
			LeveledIterImpl<E> subIter = null;

			if (next != null) {
				subIter = next.subIter;

				if (subIter.hasNext()) {
					WoodyNode<E> subElm = subIter.next;
					new LeveledIterImpl<E>(subElm);
				} else if (subIter.hasPrevious()) {
					WoodyNode<E> subElm = subIter.prev;
					new LeveledIterImpl<E>(subElm);
				}

				while (subIter.hasPrevious()) {
					subIter.previous();
				}
			}
			return subIter;
		}

		// Vorbedingung: element darf nicht null
		// Nachbedingung: fuegt ein element zu WoodyNode hinzu
		@Override
		public void add(E element) {
			if (next != null) {
				next.addBefore(element);
				next = next.prev;
			} else if (next == null && prev != null) {
				prev.addAfter(element);
				next = prev.next;
			} else {
				next = new WoodyNode<E>(element);
			}
		}

		// TODO - delete subtree?
		// TODO - NoSuchElementException
		// TODO      * @throws IllegalStateException if the {@code next} method has not
		//         yet been called, or the {@code remove} method has already
		//         been called after the last call to the {@code next}
		//         method
		// Nachbedingung: entfernt die Node
		@Override
		public void remove() {
			if (next != null) {
				next.remove(); // TODO is des jetzt is richtige element? oder sollt net eig prev entfernt werden?
				next = next.next;
			} else {
				throw new IllegalStateException("remove can only be called after next has been called");
			}
		}

		// Nachbedingung: true, wenn es eine naechste Node gibt
		@Override
		public boolean hasNext() {
			return next != null;
		}

		// Nachbedingung: true, wenn es eine vorherige Node gibt
		@Override
		public boolean hasPrevious() {
			return prev != null;
		}

		// Nachbedingung: wechselt auf die naechste Node
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

		// Nachbedingung: wechselt auf die vorherige Node
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