
public class SortedWood<T extends Prec<? super T>> extends Wood<T> implements Prec<SortedWood<T>> {

	// Vorbedingung: wert darf nicht null sein
	public SortedWood(T wert) {
		super(wert);
	}

	// Nachbedingung: sortiert alle Nodes in sortedIter 
	public Iter<T> sorted() {
		LeveledIter<T> iter = this.iterator();
		LeveledIter<T> allIter = new LeveledIterImpl();
		LeveledIter<T> sortedIter = new LeveledIterImpl();

		getAllWoodyNodes(allIter, iter);

		sortWoodyNodes(sortedIter, allIter);

		return sortedIter;
	}

	//Nachbedingung: sortiert alle WoodyNodes in sortedIter mit Hilfe von instertSorted
	private void sortWoodyNodes(LeveledIter<T> sortedIter,
															LeveledIter<T> allIter) {
		T wood;

		// Nachbedingung: gibt an, ob es noch ein vorheriges Element gibt
		while (allIter.hasPrevious()) { //Zurücksetzen.
			// Nachbedingung: wechselt zum vorherigen Element
			allIter.previous();
		}
		// Nachbedingung: gibt an, ob es noch ein naechstes Element gibt
		while (allIter.hasNext()) {
			wood = allIter.next();
			// Nachbedingung: gibt an, ob es noch ein vorheriges Element gibt
			while (sortedIter.hasPrevious()) { //Zurücksetzen
				// Nachbedingung: wechselt zum vorherigen Element
				sortedIter.previous();
			}

			insertSorted(sortedIter, wood);
		}

		// Nachbedingung: gibt an, ob es noch ein vorheriges Element gibt
		while (sortedIter.hasPrevious()) {
			// Nachbedingung: wechselt zum vorherigen Element
			sortedIter.previous();
		}
	}

	//Nachbedingung: fuegt wood an der richtigen Stelle von sortedIter ein
	private void insertSorted(LeveledIter<T> sortedIter, T wood) {
		T temp = null;

		if (sortedIter.hasNext()) {
			while (sortedIter.hasNext()) {
				temp = sortedIter.next();
				if (wood.prec(temp)) {
					// Nachbedingung: wechselt zum vorherigen Element
					sortedIter.previous();
					// Nachbedingung: fuegt ein neues Element zum derzeitigen Wood hinzu
					sortedIter.add(wood);
					return;
				}
			}
			// Wenn ich hier ankomme wurde wood nirgends eingefügt => größer.
			// Nachbedingung: fuegt ein neues Element zum derzeitigen Wood hinzu
			sortedIter.add(wood); // Wird ganz zum schluss eingefügt.
		} else {
			// Nachbedingung: fuegt ein neues Element zum derzeitigen Wood hinzu
			sortedIter.add(wood);
		}
		// Zurücksetzen auf erstes Element
		// Nachbedingung: gibt an, ob es noch ein vorheriges Element gibt
		while (sortedIter.hasPrevious()) {
			// Nachbedingung: wechselt zum vorherigen Element
			sortedIter.previous();
		}
	}

	// Nachbedingung: alle Elemente von iter werden in einem Level von allIter eingefuegt
	private void getAllWoodyNodes(LeveledIter<T> allIter,
																LeveledIter<T> iter) {

		// Nachbedingung: gibt an, ob es noch ein vorheriges Element gibt
		while (iter.hasPrevious()) { //iter zurücksetzen auf erstes element
			// Nachbedingung: wechselt zum vorherigen Element
			iter.previous();
		}

		while (iter.hasNext()) {
			// Nachbedingung: wechselt in die Substruktur vom derzeitigen Wood
			getAllWoodyNodes(allIter, iter.sub());
			T node = iter.next();
			// Nachbedingung: fuegt ein neues Element zum derzeitigen Wood hinzu
			allIter.add(node);
		}
	}

	// Vorbedingung: x darf nicht null sein  
	// Nachbedingung: true, wenn für alle Elemente aus diesem Objekt und alle Elemente aus x auch this.prec(x) gilt
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
