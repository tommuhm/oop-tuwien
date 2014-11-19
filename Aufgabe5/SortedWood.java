
public class SortedWood<T extends Prec<? super T>> extends Wood<T> implements Prec<SortedWood<T>> {

	// Vorbedingung: wert darf nicht null sein
	public SortedWood(T wert) {
		super(wert);
	}

	// Nachbedingung: sortiert alle Nodes des Baumes in einem neuen Iterator in aufsteigender Reihenfolge
	public Iter<T> sorted() {
		LeveledIter<T> iter = this.iterator();
		LeveledIter<T> allIter = new LeveledIterImpl();
		LeveledIter<T> sortedIter = new LeveledIterImpl();

		getAllWoodyNodes(allIter, iter);

		sortWoodyNodes(sortedIter, allIter);

		return sortedIter;
	}

	//Nachbedingung: sortiert alle WoodyNodes in sortedIter mit Hilfe von instertSorted
	private void sortWoodyNodes(LeveledIter<T> sortedIter, LeveledIter<T> allIter) {
		T wood;

		while (allIter.hasPrevious()) {
			allIter.previous();
		}
		while (allIter.hasNext()) {
			wood = allIter.next();
			while (sortedIter.hasPrevious()) {
				sortedIter.previous();
			}
			insertSorted(sortedIter, wood);
		}
		while (sortedIter.hasPrevious()) {
			sortedIter.previous();
		}
	}

	//Nachbedingung: fuegt element an der richtigen Stelle von sortedIter ein
	private void insertSorted(LeveledIter<T> sortedIter, T element) {
		if (sortedIter.hasNext()) {
			while (sortedIter.hasNext()) {
				T temp = sortedIter.next();
				if (element.prec(temp)) {
					sortedIter.previous();
					sortedIter.add(element);
					return;
				}
			}
			sortedIter.add(element);
		} else {
			sortedIter.add(element);
		}
		while (sortedIter.hasPrevious()) {
			sortedIter.previous();
		}
	}

	// Nachbedingung: alle Elemente von iter werden in einem Level von allIter eingefuegt
	private void getAllWoodyNodes(LeveledIter<T> allIter, LeveledIter<T> iter) {

		while (iter.hasPrevious()) {
			iter.previous();
		}

		while (iter.hasNext()) {
			getAllWoodyNodes(allIter, iter.sub());
			T node = iter.next();
			allIter.add(node);
		}
	}

	// Vorbedingung: x darf nicht null sein  
	// Nachbedingung: true, wenn fuer alle Elemente aus diesem Objekt und alle Elemente aus x auch this.prec(x) gilt
	@Override
	public boolean prec(SortedWood<T> x) {
		Iter<T> itThis = this.sorted();
		Iter<T> itX = x.sorted();

		while (itThis.hasNext() && itX.hasNext()) {
			T wThis = itThis.next();
			T wX = itX.next();
			if (!wThis.prec(wX)) {
				return false;
			}
		}

		return true;
	}
}
