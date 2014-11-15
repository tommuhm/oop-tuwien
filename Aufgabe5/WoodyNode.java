public class WoodyNode<T> {

	private Wood<T> wood;
	private T wert;
	private Wood<T> sub;
	private WoodyNode<T> next;
	private WoodyNode<T> prev;

	public WoodyNode(Wood<T> wood, T wert) {
		this.wood = wood;
		this.wert = wert;
	}

	public void add(Wood wood) {
		WoodyNode node = wood.getNode();

		node.prev = prev;
		prev.next = node;

		node.next = this;
		this.prev = node;
	}

	public Wood<T> getWood() {
		return wood;
	}

	public Wood<T> getSub() {
		return sub;
	}

	public WoodyNode<T> next() {
		return next;
	}

	public WoodyNode<T> previous() {
		return prev;
	}
}