
import java.util.NoSuchElementException;

public class Wood<T> {

	private WoodyNode node;

	// Vorbedingung: element darf nicht null sein
	public Wood(T element) {
		this.node = new WoodyNode(element);
	}

	// Vorbedingung: element darf nicht null sein
	// Nachbedingung: sucht alle Elemente in der Datenstruktur, die gleich element sind. Das Ergebnis ist leveledIter, der ueber alle gefundenen gleichen Elemente iteriert
	public LeveledIter<T> contains(T element) {
		LeveledIterImpl containsIter = new LeveledIterImpl();

		LeveledIter<T> rootLevel = this.iterator();
		containsHelper(containsIter, rootLevel, element);

		while (containsIter.hasPrevious()) {
			containsIter.previous();
		}

		return containsIter;
	}

	// Vorbedingung: containsIter, nextLevel, compareElement duerfen nicht Null sein
	// Nachbedingung: containsIter enthaelt alle elemment aus nextLevel die gleich dem compareElement sind
	private void containsHelper(LeveledIterImpl containsIter, LeveledIter<T> nextLevel, T compareElement) {
		while (nextLevel.hasNext()) {
			containsHelper(containsIter, nextLevel.sub(), compareElement);

			LeveledIterImpl sub = (LeveledIterImpl) nextLevel.sub();
			T element = nextLevel.next();
			if (element.equals(compareElement)) {
				containsIter.add(element, sub);
			}
		}
	}

	// Nachbedingung: gibt einen iterator fuer die komplette baumstruktur zureck, der pointer steht auf der ersten stelle der aktuelle ebene
	public LeveledIter<T> iterator() {
		LeveledIterImpl rootIter = new LeveledIterImpl(node);

		while (rootIter.hasPrevious()) {
			rootIter.previous();
		}

		return rootIter;
	}

	@Override
	public String toString() {
		LeveledIter<T> iter = this.iterator();
		StringBuilder out = new StringBuilder();

		while (iter.hasPrevious()) iter.previous();

		toStringHelper(out, "", iter);

		while (iter.hasPrevious()) iter.previous();

		return out.toString();
	}

	private void toStringHelper(StringBuilder out, String indent, LeveledIter<T> iter) {
		while (iter.hasNext()) {
			// Nachbedingung: wechselt in die Substruktur vom derzeitigen Wood
			LeveledIter sub = iter.sub();
			out.append(indent + iter.next() + "\n");
			toStringHelper(out, indent + "--", sub);
		}
	}

	protected class WoodyNode {

		private T element;
		private WoodyNode next;
		private WoodyNode prev;
		private LeveledIterImpl subIter;

		// Vorbedingung: element darf nicht null sein
		private WoodyNode(T element) {
			this.element = element;
			this.subIter = new LeveledIterImpl();
		}

		// Nachbedingung: gibt das element des nodes mit dem generischen type t zurueck
		private T getElement() {
			return element;
		}

		// Vorbedingung: element darf nicht null sein
		// Nachbedingung: fuegt element vor dem aktuellen Node ein
		private void addBefore(T element) {
			WoodyNode node = new WoodyNode(element);
			if (prev != null) {
				node.prev = prev;
				prev.next = node;
			}
			node.next = this;
			this.prev = node;
		}

		// Vorbedingung: element darf nicht null sein
		// Nachbedingung: fuegt element nach dem aktuellen Node ein
		private void addAfter(T element) {
			WoodyNode node = new WoodyNode(element);
			if (next != null) {
				node.next = next;
				next.prev = node;
			}
			node.prev = this;
			this.next = node;
		}

		// Nachbedingung: entfernt das aktuelle elemente aus der (verketteten) liste
		private void remove() {
			if (prev != null) {
				prev.next = next;
			}
			if (next != null) {
				next.prev = prev;
			}
		}
	}

	protected class LeveledIterImpl implements LeveledIter<T> {

		boolean removeDone = false;
		private WoodyNode prev = null;
		private WoodyNode next = null;

		// Nachbedingung: erstellt einen leeren Iterator
		protected LeveledIterImpl() {
		}

		// Vorbedingung: node darf nicht null sein
		// Nachbedingung: erstellt einen Iterator mit der Baum-Struktur des node elements
		private LeveledIterImpl(WoodyNode node) {
			next = node;
			prev = node.prev;
		}

		// Nachbedingung: gibt den Sub-Baum des naechsten elements zureck
		@Override
		public LeveledIter<T> sub() {
			LeveledIterImpl subIter = null;

			if (next != null) {
				subIter = next.subIter;

				if (subIter.hasNext()) {
					WoodyNode subElm = subIter.next;
					new LeveledIterImpl(subElm);
				} else if (subIter.hasPrevious()) {
					WoodyNode subElm = subIter.prev;
					new LeveledIterImpl(subElm);
				}

				while (subIter.hasPrevious()) {
					subIter.previous();
				}
			}
			return subIter;
		}

		// Vorbedingung: element darf nicht null
		// Nachbedingung: fuegt ein element vor dem next element in den Iterator ein
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

		// Vorbedingung: element und sub duerfen nicht null
		// Nachbedingung: fuegt ein element mit sub in den Iterator ein
		private void add(T element, LeveledIterImpl sub) {
			add(element);
			next.subIter = sub;
		}

		// Nachbedingung: entfernt den aktuellen Node (element das von dem letzten next() call zurueckgegben wurde)
		// Nachbedingung: wirft eine illegal state exception wenn remove aufgerufen wird bevor next aufgerufen wurde
		@Override
		public void remove() throws IllegalStateException {
			if (removeDone == false && prev != null) {
				removeDone = true;
				prev.remove();
				prev = prev.prev;
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
		// Nachbedingung: wirft eine NoSuchElementException wenn das ende der liste erreicht wurde
		@Override
		public T next() {
			if (hasNext()) {
				removeDone = false;
				prev = next;
				next = next.next;
			} else {
				throw new NoSuchElementException("no next element");
			}
			return prev.getElement();
		}

		// Nachbedingung: wechselt auf die vorherige Node
		// Nachbedingung: wirft eine NoSuchElementException wenn der anfang der liste erreicht wurde
		@Override
		public T previous() {
			if (hasPrevious()) {
				removeDone = false;
				next = prev;
				prev = prev.prev;
			} else {
				throw new NoSuchElementException("no previous element");
			}
			return next.getElement();
		}
	}

}