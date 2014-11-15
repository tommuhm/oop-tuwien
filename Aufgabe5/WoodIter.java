public class WoodIter implements LeveledIter<Wood> {

	WoodyNode prev = null;
	WoodyNode next = null;

	@Override
	public LeveledIter<Wood> sub() {
		LeveledIter<Wood> subIter = null;

		if (next != null) {
			Wood sub = next.getSub();

			if (sub != null) {
				subIter = sub.iterator();
			}
		}
		return subIter;
	}

	@Override
	public void add(Wood wood) {
		if (next == null) {
			next = wood.getNode();
		}
		if (prev != null) {
		}

		// TODO
	}

	@Override
	public void remove() {
		// TODO
	}

	@Override
	public boolean hasNext() {
		if (next != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Wood next() {
		if (hasNext()) {
			prev = next;
			next = next.next();
			return prev.getWood();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasPrevious() {
		if (prev != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Wood pervious() {
		if (hasPrevious()) {
			prev = prev.previous();
			next = prev;
			return next.getWood();
		} else {
			return null;
		}
	}
}
