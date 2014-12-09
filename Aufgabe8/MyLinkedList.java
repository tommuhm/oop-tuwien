@Author(name = "Thomas Muhm")
public class MyLinkedList {

	private Node head;
	private int size;

	@Author(name = "Thomas Muhm")
	public MyLinkedList() {
		head = new Node(null, null);
		size = 0;
	}

	@Author(name = "Thomas Muhm")
	public boolean add(Object id, Object elem) {
		Node node = new Node(id, elem);
		Node prev = null;
		Node current = head;
		while (current != null) {
			if (current.id.equals(id)) {
				return false;
			}
			prev = current;
			current = current.next();
		}

		node.setNext(current.next());
		if (prev != null) {
			prev.setNext(node);
		} else {
			head = node;
		}

		size++;
		return true;
	}

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

	@Author(name = "Thomas Muhm")
	public int size() {
		return size;
	}

	@Author(name = "Thomas Muhm")
	public Object get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}

		Node current = head;
		for (int i = 0; i < size; i++) {
			current = current.next();
		}

		return current.getElem();
	}

	@Author(name = "Thomas Muhm")
	public Object getById(Object id) {
		Node current = head;
		while (current != null) {
			if (current.id.equals(id)) {
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

		@Author(name = "Thomas Muhm")
		public Node(Object id, Object elem) {
			this.id = id;
			this.elem = elem;
			next = null;
		}

		@Author(name = "Thomas Muhm")
		public Object getElem() {
			return elem;
		}

		@Author(name = "Thomas Muhm")
		public Node next() {
			return next;
		}

		@Author(name = "Thomas Muhm")
		private void setNext(Node next) {
			this.next = next;
		}

	}

}
