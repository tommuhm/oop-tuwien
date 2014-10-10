package at.tuwien.oopj4;

/**
 * Created by tom, ulrich und david on 10/10/14.
 */
public class Person {
	private static int maxPersonID = 0;
	
	private String personName;
	private int personID;
	
	public Person(String personName)
	{
		this.personName = personName;
		this.personID = this.maxPersonID++; //Set PersonID and increment by 1
	}

	//===========GETTER AND SETTERS===============
	public String getPersonName() {
		return personName;
	}


	public int getPersonID() {
		return personID;
	}
	//============================================

	@Override
	public String toString() {
		return this.personID + " " + this.personName;
	}
}
