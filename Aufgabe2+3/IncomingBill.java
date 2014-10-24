import java.util.Date;

public class IncomingBill extends Bill {

	//PRECONDITION: service != null, amountOfMoney >= 0, date != null
	public IncomingBill(String service, float amountOfMoney, Date date, boolean inCash) {
		super(service, amountOfMoney, date, inCash);
	}

}
