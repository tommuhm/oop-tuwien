import java.util.Date;

public class Order {

	private static int maxOrderID = 0;
	//INVARIANT: maxOrderID >= 0, gets incremented by 1 every new Order.

	private final int orderID;
	private Person person;
	private Date orderDate;
	//INVARIANT: orderID >= 0, person != null, orderDate != null

	private String service;
	private float amountOfMoney;
	//INVARIANT: amountOfMoney >= 0, service != null

	//PRECONDITION: person != null, orderDate != null, service != null, amountOfMoney >= 0
	public Order(Person person, Date orderDate, String service, float amountOfMoney) {
		this.person = person;
		this.orderDate = orderDate;
		this.service = service;
		this.amountOfMoney = amountOfMoney;
		this.orderID = Order.maxOrderID++;
	}

	public int getOrderID() {
		return orderID;
	}

	//BAD: not used
	public Person getPerson() {
		return person;
	}
	
	//BAD: not used
	public Date getOrderDate() {
		return orderDate;
	}

	//BAD: not used
	public String getService() {
		return service;
	}

	//BAD: not used
	public float getAmountOfMoney() {
		return amountOfMoney;
	}

	public OutgoingBill createOutgoingBill(boolean inCash) {
		return new OutgoingBill(service, amountOfMoney, new Date(), inCash, person);
	}
}