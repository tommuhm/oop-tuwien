@Author(name = "Thomas Muhm")
public class MyLinkedList<A> {

	private Node head;
	private int size;

	public MyLinkedList() {
		head = new Node(null);
		size = 0;
	}

	public void add(A elem) {
		Node node = new Node(elem);
		Node current = head;
		while (current.next() != null) {
			current = current.next();
		}
		node.setNext(current.next());
		current.setNext(node);
		size++;
	}

	public boolean remove(A elem) {
		Node current = head;
		Node prev = null;
		while (!elem.equals(current.getElem()) && current.next() != null) {
			prev = current;
			current = current.next();
		}
		if (elem.equals(current.getElem())) {
			if (prev == null) {
				head = current.next();
			} else {
				prev.setNext(current.next());
			}
			size--;
			return true;
		} else {
			return false;
		}

	}

	public int size() {
		return size;
	}

	public A get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}

		Node current = head;
		for (int i = 0; i < size; i++) {
			current = current.next();
		}

		return current.getElem();
	}

	private class Node {

		Node next;
		A elem;

		public Node(A elem) {
			this.elem = elem;
			next = null;
		}

		public A getElem() {
			return elem;
		}

		public Node next() {
			return next;
		}

		private void setNext(Node next) {
			this.next = next;
		}

	}

}
