
public class SortedWood<T extends Prec<T>> extends Wood<T> implements Prec<T> {

	public SortedWood(T wert) {
		super(wert);
		// TODO
	}

	public Iter<T> sorted() {
		LeveledIter<Wood<T>> iter = super.iterator();
		WoodyNode<T> start = new WoodyNode<T>(null);
		WoodyNode<T> current = start;
		getAlleSortedWoodyNodes(current, iter);
		
		return null;
	}

	private void getAlleSortedWoodyNodes(WoodyNode<T> current, LeveledIter<Wood<T>> iter) {
		
		Wood<T> tempWood = null;
		while((tempWood = iter.next()) != null) {
			
			LeveledIter<Wood<T>> sub = iter.sub();
			if(sub != null) {
				getAlleSortedWoodyNodes(current, sub);
			}
			
			current.add(tempWood);
			
		} while (iter.hasNext());
	}

	@Override
	public boolean prec(T x) {
		// TODO Auto-generated method stub
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
