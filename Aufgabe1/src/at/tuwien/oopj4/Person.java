package at.tuwien.oopj4;

/**
 * Created by tom, ulrich und david on 10/10/14.
 */
public class Person {
	private static int iMaxPersonID = 0;
	
	private String sPersonName;
	private int iPersonID;
	
	public Person(String sPersonName)
	{
		this.sPersonName = sPersonName;
		this.iPersonID = this.iMaxPersonID++; //Set PersonID and increment by 1
	}

	
	//===========GETTER AND SETTERS===============
	public String getsPersonName() {
		return sPersonName;
	}

	public int getiPersonID() {
		return iPersonID;
	}
	//============================================


	@Override
	public String toString() {
		return this.iPersonID + " " + this.sPersonName;
	}
}
