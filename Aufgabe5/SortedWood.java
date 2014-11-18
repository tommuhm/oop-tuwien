
public class SortedWood<T extends Prec<T>> extends Wood<T> implements Prec<T> {

	public SortedWood(T wert) {
		super(wert);
		// TODO
	}

	public Iter<T> sorted() {
		LeveledIter<Wood<T>> iter = super.iterator();
		
		SortedWoodyNode<T> start = null;
		SortedWoodyNode<T> current = null;
		getAlleSortedWoodyNodes(start, current, iter);
		
		return null;
	}

	private void getAlleSortedWoodyNodes(
			SortedWood<T>.SortedWoodyNode<T> start,
			SortedWood<T>.SortedWoodyNode<T> current, LeveledIter<Wood<T>> iter) {
		
		//Wood<T>
		
		do {
			LeveledIter<Wood<T>> sub = iter.sub();
			if(sub != null) {
				getAlleSortedWoodyNodes(start, current, sub);
			}
			
			
			
		} while (iter.hasNext());
		
		
		
	}

	@Override
	public boolean prec(T x) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public class SortedIterator<T> implements Iter<T> {
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
		
		
	}
	
	private class SortedWoodyNode<E> {
		private E wert;
		private SortedWoodyNode<E> next;
		private SortedWoodyNode<E> prev;		
		
		public SortedWoodyNode(E wert) {
			this.wert = wert;
		}
		
		
		
	}
}
