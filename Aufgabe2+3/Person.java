//GOOD: Object linking is low. Class cohesion is high.
public abstract class Person {

	private static int maxPersonID = 0;
	//INVARIANT: maxPersonID >= 0, gets incremented by 1 every Article

	private String personName;
	private final int personID;
	//INVARIANT: personID >= 0

	//PRECONDITION: personName != null
	public Person(String personName) {
		this.personName = personName;
		this.personID = Person.maxPersonID++; // Set PersonID and increment by 1
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