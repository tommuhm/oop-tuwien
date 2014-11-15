
public abstract class Person implements Prec {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public boolean prec(Object y) {
		if (y instanceof Person) {
			return this.name == ((Person) y).name;
		}

		return false;
	}


}
