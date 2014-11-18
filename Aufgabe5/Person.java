
public abstract class Person implements Prec<Person> {

	public String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public boolean prec(Person y) {

		String nameI = name.replaceAll("\\s+","").toLowerCase();
		String nameY = y.name.replaceAll("\\s+","").toLowerCase();

		return nameI.compareTo(nameY) <= 0; //Equals oder nameI ist alphabetisch kleiner 
	}
}
