/**
 * @author: djaffry, uaschl, tmuhm
 */

public class Person {
	private static int maxPersonID = 0;

	private String personName;
	private final int personID;

	public Person(String personName) {
		this.personName = personName;
		this.personID = Person.maxPersonID++; // Set PersonID and increment by 1
	}

	// ===========GETTER AND SETTERS===============
	public String getPersonName() {
		return personName;
	}

	public int getPersonID() {
		return personID;
	}
	// ============================================

	@Override
	public String toString() {
		return this.personID + " " + this.personName;
	}
}