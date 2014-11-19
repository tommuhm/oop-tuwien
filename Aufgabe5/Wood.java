
import java.util.NoSuchElementException;

public class Wood<T> {

	private WoodyNode node;
	private T element;

	// Vorbedingung: element darf nicht null sein
	// Nachbedingung: eine node mit this wurde erstellt
	public Wood(T element) {
		this.element = element;
		this.node = new WoodyNode(element);
	}
	
	protected T getElement() {
		return element;
	}

	// Vorbedingung: element darf nicht null sein
	// Nachbedingung: sucht alle Elemente in der Datenstruktur, die gleich element sind. Das Ergebnis ist leveledIter, der ueber alle gefundenen gleichen Elemente iteriert
	public LeveledIter<T> contains(T element) {
		LeveledIterImpl containsIter = new LeveledIterImpl();

		LeveledIter<T> rootLevel = this.iterator();
		containsHelper(containsIter, rootLevel, element);

		while (containsIter.hasPrevious()) {
			// Nachbedingung: wechselt zum vorherigen Element
			containsIter.previous();
		}

		return containsIter;
	}

	private void containsHelper(LeveledIterImpl containsIter, LeveledIter<T> nextLevel, T compareElement) {
		if (nextLevel.hasNext()) {
			containsHelper(containsIter, nextLevel.sub(), compareElement);

			LeveledIterImpl sub = (LeveledIterImpl) nextLevel.sub();
			T element = nextLevel.next();
			if (element.equals(compareElement)) {
				containsIter.add(element, sub);
			}
		}
	}

	// Nachbedingung: initialisiert einen Iterator und setzt den Pointer vor das erste Element
	public LeveledIter<T> iterator() {
		LeveledIterImpl rootIter = new LeveledIterImpl(node);

		// Nachbedingung: gibt an, ob es noch ein vorheriges Element gibt
		while (rootIter.hasPrevious()) {
			// Nachbedingung: wechselt zum vorherigen Element
			rootIter.previous();
		}

		return rootIter;
	}

	protected class WoodyNode {

		private T element;
		private WoodyNode next;
		private WoodyNode prev;
		private LeveledIterImpl subIter;

		// Vorbedingung: element darf nicht null sein
		// Nachbedingung: erstellt einen neuen Iterator
		protected WoodyNode(T element) {
			this.element = element;
			// Nachbedingung: wechselt in die Substruktur vom derzeitigen Wood
			this.subIter = new LeveledIterImpl();
		}

		protected T getElement() {
			return element;
		}

		// TODO concureent modif error? was passiert bei mehrere iteratoren gleichzeitig aenderungen?
		// Vorbedingung: element darf nicht null sein
		// Nachbedingung: fuegt element vor der aktuellen Node ein
		private void addBefore(T element) {
			WoodyNode node = new WoodyNode(element);

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
		private void addAfter(T element) {
			WoodyNode node = new WoodyNode(element);

			if (next != null) {
				node.next = next;
				next.prev = node;
			}

			node.prev = this;
			this.next = node;
		}
		
		// Nachbedingung: entfernt alle Elemente vom derzeitigen Wood
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
	protected class LeveledIterImpl implements LeveledIter<T> {

		private WoodyNode prev = null;
		private WoodyNode next = null;

		protected LeveledIterImpl() {
		}

		// Vorbedingung: node darf nicht null sein
		// Nachbedingung: fuegt eine node ein
		protected LeveledIterImpl(WoodyNode node) {
			next = node;
			prev = node.prev;
		}

		// Nachbedingung: gibt die Substruktur vom naesten node zurueck
		@Override
		public LeveledIter<T> sub() {
			LeveledIterImpl subIter = null;

			if (next != null) {
				// Nachbedingung: wechselt in die Substruktur vom derzeitigen Wood
				subIter = next.subIter;

				if (subIter.hasNext()) {
					WoodyNode subElm = subIter.next;
					new LeveledIterImpl(subElm);
					// Nachbedingung: gibt an, ob es noch ein vorheriges Element gibt
				} else if (subIter.hasPrevious()) {
					WoodyNode subElm = subIter.prev;
					new LeveledIterImpl(subElm);
				}

				// Nachbedingung: gibt an, ob es noch ein vorheriges Element gibt
				while (subIter.hasPrevious()) {
					// Nachbedingung: wechselt zum vorherigen Element
					subIter.previous();
				}
			}
			return subIter;
		}

		// Vorbedingung: element darf nicht null
		// Nachbedingung: fuegt ein element zu WoodyNode hinzu
		@Override
		public void add(T element) {
			if (next != null) {
				next.addBefore(element);
				next = next.prev;
			} else if (next == null && prev != null) {
				prev.addAfter(element);
				next = prev.next;
			} else {
				next = new WoodyNode(element);
			}
		}

		private void add(T element, LeveledIterImpl sub) {
			add(element);
			next.subIter = sub;
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
		public T next() {
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
		public T previous() {
			// Nachbedingung: gibt an, ob es noch ein vorheriges Element gibt
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