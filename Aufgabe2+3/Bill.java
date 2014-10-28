import java.util.Date;

public abstract class Bill {

	private static int maxBillID = 0;
	//INVARIANT: maxBillID >= 0, gets increment by 1 every Bill
	
	private final int billID;
	private final String service;
	private final float amountOfMoney;
	private final Date date;
	private final boolean inCash;
	//INVARIANT: billID >= 0, amountOfMoney >= 0, service != null, date != null

	//PRECONDITION: service =! null, date != null, amountOfMoney >= 0
	public Bill(String service, float amountOfMoney, Date date, boolean inCash) {
		this.billID = Bill.maxBillID++;
		this.service = service;
		this.amountOfMoney = amountOfMoney;
		this.date = date;
		this.inCash = inCash;
	}

	public int getBillID() {
		return this.billID;
	}

	public String getService() {
		return this.service;
	}

	public float getAmountOfMoney() {
		return this.amountOfMoney;
	}

	public Date getDate() {
		return this.date;
	}

	public boolean getInCash() {
		return inCash;
	}

	@Override
	public String toString() {
		return "\n ###################### \n # Surfstore Gruppe 4 # \n ###################### \n"
				+ "\n  BillID:         " + this.billID
				+ "\n  Date:           " + this.date
				+ "\n  Service:        " + this.service
				+ "\n  Amount:         " + this.amountOfMoney
				+ "\n ................."
				+ "\n paid:            " + (inCash ? "in Cash" : "with Card")
				+ "\n \n Thank you!";
	}
}

