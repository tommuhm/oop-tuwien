import java.util.Date;

public class IncomingBill extends Bill {

	// PRECONDITION: service and date must not be null, amountOfMoney has to be greater or equal to zero
	public IncomingBill(String service, float amountOfMoney, Date date, boolean inCash) {
		super(service, amountOfMoney, date, inCash);
	}

}
