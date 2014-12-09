@Author(name = "Thomas Muhm")
public class MyLinkedList {

	private Node head;
	private int size;

	// Nachbedingung: eine leere liste wurde erstellt
	@Author(name = "Thomas Muhm")
	public MyLinkedList() {
		head = null;
		size = 0;
	}

	// Vorbedingung: id und elem duerfen nicht null sein
	// Nachbedingung: gibt false zurueck wenn id bereits in der liste vorhanden ist
	// Nachbedingung: gibt true zurueck wenn das element in die liste eingefuegt wurde wurde
	@Author(name = "Thomas Muhm")
	public boolean add(Object id, Object elem) {
		Node node = new Node(id, elem);
		Node prev = null;
		Node current = head;
		while (current != null) {
			if (id.equals(current.id)) {
				return false;
			}
			prev = current;
			current = current.next();
		}

		if (prev == null) {
			head = node;
		} else {
			prev.setNext(node);
		}

		size++;
		return true;
	}

	// Vorbedingung: id darf nicht null sein
	// Nachbedingung: gibt false zurueck wenn die id nicht in der liste vorhanden ist
	// Nachbedingung: gibt true zurueck wenn das element mit der id aus der liste entfernt wurde
	@Author(name = "Thomas Muhm")
	public boolean removeById(Object id) {
		Node current = head;
		Node prev = null;

		while (current != null) {
			if (id.equals(current.id)) {
				if (prev == null) {
					head = current.next();
				} else {
					prev.setNext(current.next());
				}
				size--;
				return true;
			} else {
				prev = current;
				current = current.next();
			}
		}

		return false;
	}

	// Vorbedingung: elem darf nicht null sein
	// Nachbedingung: gibt false zurueck wenn das element nicht in der liste vorhanden ist
	// Nachbedingung: gibt true zurueck wenn das element aus der liste entfernt wurde
	@Author(name = "Thomas Muhm")
	public boolean remove(Object elem) {
		Node current = head;
		Node prev = null;

		while (current != null) {
			if (elem.equals(current.elem)) {
				if (prev == null) {
					head = current.next();
				} else {
					prev.setNext(current.next());
				}
				size--;
				return true;
			} else {
				prev = current;
				current = current.next();
			}
		}

		return false;
	}

	// Nachbedingung: gibt die akutelle groesse der liste zurueck
	@Author(name = "Thomas Muhm")
	public int size() {
		return size;
	}

	// Nachbedingung: gibt das element an der index position zurueck
	// Nachbedingung: gibt null zurueck wenn der index nicht existiert
	@Author(name = "Thomas Muhm")
	public Object get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}

		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next();
		}

		return current.getElem();
	}

	// Vorbedingung: id darf nicht null sein
	// Nachbedingung: gibt das element mit der angegeben id zurueck
	// Nachbedingung: gibt null zurueck wenn die angebene id nicht in der liste ist
	@Author(name = "Thomas Muhm")
	public Object getById(Object id) {
		Node current = head;
		while (current != null) {
			if (id.equals(current.id)) {
				return current;
			}
			current = current.next();
		}
		return null;
	}

	@Author(name = "Thomas Muhm")
	private class Node {

		Node next;
		Object id;
		Object elem;

		// Vorbedingung: id und elem duerfen nicht null sein
		@Author(name = "Thomas Muhm")
		public Node(Object id, Object elem) {
			this.id = id;
			this.elem = elem;
			next = null;
		}

		// Nachbedingung: gibt das element in dem node zurueck
		@Author(name = "Thomas Muhm")
		private Object getElem() {
			return elem;
		}

		// Nachbedingung: gibt den naechsten node in der liste zurueck
		@Author(name = "Thomas Muhm")
		private Node next() {
			return next;
		}

		// Nachbedingung: der angebene node wurde auf das naechste element der gesetzt
		@Author(name = "Thomas Muhm")
		private void setNext(Node next) {
			this.next = next;
		}

	}

}
