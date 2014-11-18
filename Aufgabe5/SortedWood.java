
//public class SortedWood<T extends Prec<T>> extends Wood<T> implements Prec<T> {
public class SortedWood<T extends Prec> extends Wood<T>{

	public SortedWood(T wert) {
		super(wert);
		// TODO
	}

	public Iter<Wood<T>> sorted() {
		LeveledIter<Wood<T>> iter = super.iterator();
		LeveledIter<Wood<T>> allIter = new LeveledIterImpl<Wood<T>>();
		LeveledIter<Wood<T>> sortedIter = new LeveledIterImpl<Wood<T>>();

		getAllWoodyNodes(allIter, iter);
		
		sortWoodyNodes(sortedIter, allIter);
		
		return sortedIter;
	}

	private void sortWoodyNodes(LeveledIter<Wood<T>> sortedIter, LeveledIter<Wood<T>> allIter) {
		Wood<T> wood;
		
		while(allIter.hasNext()) {
			wood = allIter.next();
			insertSorted(sortedIter, wood);
		}
	}
	
	private void insertSorted(LeveledIter<Wood<T>> sortedIter, Wood<T> wood) {
		// Zurücksetzen auf erstes Element.
		while(sortedIter.hasPrevious()) {
			sortedIter.previous();
		}
		
		sortedIter.previous(); //TODO Ist das richtig?
		
		Wood<T> temp = null;
		while(sortedIter.hasNext()) {
			temp = sortedIter.next();
			if(((Prec) temp).prec(wood)) {
				sortedIter.previous();
				sortedIter.add(wood);
				return;
			}
		}
	}
	
	private void swap (WoodyNode<T> x, WoodyNode<T> y) {
		WoodyNode<T> temp = x;
	}

	private void getAllWoodyNodes(LeveledIter<Wood<T>> allIter, LeveledIter<Wood<T>> iter) {
		while (iter.hasNext()) {
			Wood<T> node = iter.next();
			allIter.add(node);
			getAllWoodyNodes(allIter, iter.sub());
		}
	}

	public boolean prec(T x) {
		boolean b = true;
		
		//WTF IST MIT PUNTIGAM?!
		
		return false;
	}
	
	/*public class SortedIterator<T> implements Iter<T> {
		private WoodyNode<T> current;
		
		public SortedIterator(WoodyNode<T> current) {
			this.current = current;			
		}
		
		@Override
		public boolean hasNext() {
			return (this.current.getNext() != null);
		}

		@Override
		public T next() {
			this.current = this.current.getNext();
			return this.current.getWert();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}*/
}
