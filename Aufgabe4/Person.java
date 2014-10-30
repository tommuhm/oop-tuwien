public abstract class Person {

	private static int maxPersonID = 0;

	private String personName;
	private final int personID;
	// INVARIANT: maxPersonID gets incremented by one after each new person
	// INVARIANT: personID and maxPersonID are always greater or equal to zero

	// PRECONDITION: personName must not be null
	public Person(String personName) {
		this.personName = personName;
		this.personID = Person.maxPersonID++;
	}

	public String getPersonName() {
		return personName;
	}

	public int getPersonID() {
		return personID;
	}

	@Override
	public String toString() {
		return this.personID + " " + this.personName;
	}

}