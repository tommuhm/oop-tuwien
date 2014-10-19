import java.util.Date;

public class OutgoingBill extends Bill {
	
	private Person person;
	
	public OutgoingBill(String service, float amountOfMoney, Date date,
			boolean inCash, Person person) {
		super(service, amountOfMoney, date, inCash);
		this.person = person;
		// TODO Auto-generated constructor stub
	}
	
	public Person getPerson() {
		return this.person;
	}
}
