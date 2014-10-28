import java.util.Date;

public class OutgoingBill extends Bill {

	private Person person;
	//INVARIANT: person != null

	//PRECONDITION: amountOfMoney >= 0, person != null, date != null, service != null
	public OutgoingBill(String service, float amountOfMoney, Date date, boolean inCash, Person person) {
		super(service, amountOfMoney, date, inCash);
		this.person = person;
	}

	public Person getPerson() {
		return this.person;
	}

	@Override
	public String toString() {
		return "\n ###################### \n # Surfstore Gruppe 4 # \n ###################### \n"
				+ "\n  Name:           " + person.toString()
				+ "\n  BillID:         " + getBillID()
				+ "\n  Date:           " + getDate()
				+ "\n  Service:        " + getService()
				+ "\n  Amount:         " + getAmountOfMoney()
				+ "\n ................."
				+ "\n paid:            " + (getInCash() ? "in Cash" : "with Card")
				+ "\n \n Thank you!";
	}
}
