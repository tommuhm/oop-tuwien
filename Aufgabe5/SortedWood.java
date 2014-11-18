
public class SortedWood<T extends Prec<T>> extends Wood<T> {

	public SortedWood(T wert) {
		super(wert);
		// TODO
	}

	public Iter<Wood<T>> sorted() {
		LeveledIter<Wood<T>> iter = this.iterator();
		LeveledIter<Wood<T>> allIter = new LeveledIterImpl<Wood<T>>();
		LeveledIter<Wood<T>> sortedIter = new LeveledIterImpl<Wood<T>>();

		getAllWoodyNodes(allIter, iter);

		sortWoodyNodes(sortedIter, allIter);

		return sortedIter;
	}

	private void sortWoodyNodes(LeveledIter<Wood<T>> sortedIter,
			LeveledIter<Wood<T>> allIter) {
		Wood<T> wood;

		while (allIter.hasNext()) {
			wood = allIter.next();
			insertSorted(sortedIter, wood);
		}

		while (sortedIter.hasPrevious()) {
			sortedIter.previous();
		}
	}

	private void insertSorted(LeveledIter<Wood<T>> sortedIter, Wood<T> wood) {
		Wood<T> temp = null;

		if (sortedIter.hasNext()) {
			while (sortedIter.hasNext()) {
				temp = sortedIter.next();
				if (wood.getElement().prec(temp.getElement())) {
					sortedIter.previous();
					sortedIter.add(wood);
					return;
				}
			}
			// Wenn ich hier ankomme wurde wood nirgends eingefügt => größer.
			sortedIter.add(wood); // Wird ganz zum schluss eingefügt.
		} else {
			sortedIter.add(wood);
		}
		// Zurücksetzen auf erstes Element.
		while (sortedIter.hasPrevious()) {
			sortedIter.previous();
		}
	}

	private void getAllWoodyNodes(LeveledIter<Wood<T>> allIter,
			LeveledIter<Wood<T>> iter) {
		while (iter.hasNext()) {
			getAllWoodyNodes(allIter, iter.sub());
			Wood<T> node = iter.next();
			allIter.add(node);
		}
	}

	public boolean prec(SortedWood<T> x) {
		Iter<Wood<T>> itThis = this.sorted();
		Iter<Wood<T>> itX = x.sorted();

		while (itThis.hasNext() && itX.hasNext()) {
			Wood<T> wThis = itThis.next();
			Wood<T> wX = itX.next();
			if (!wThis.getElement().prec(wX.getElement())) {
				return false;
			}
		}

		return true;
	}
}
