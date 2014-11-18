
public abstract class Person implements Prec<Person> {

	public String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public boolean prec(Person y) {

		String nameI = name.replaceAll("\\s+", "").toLowerCase();
		String nameY = y.name.replaceAll("\\s+", "").toLowerCase();

		return nameI.compareTo(nameY) <= 0; //Equals oder nameI ist alphabetisch kleiner 
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Person) {
			return ((Person) o).name.equals(this.name);
		}

		return false;
	}

	@Override
	public String toString() {
		return "Name: " + this.name;
	}
}
