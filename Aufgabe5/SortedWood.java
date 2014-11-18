
public class SortedWood<T extends Prec> extends Wood<T> implements Prec {

	public SortedWood(T wert) {
		super(wert);
		// TODO
	}

	@Override
	public boolean prec(Object x) {
		// TODO
		return false;
	}

	public LeveledIter<T> sorted() {
		// TODO
		return null;
	}
}
