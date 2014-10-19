import java.util.Date;

public class Order {

	private static int maxOrderID = 0;

	private final int orderID;
	private Person person;
	private Date orderDate;


	private String service;
	private float amountOfMoney;


	public Order( Person person, Date orderDate, String service, float amountOfMoney ) {
		this.person = person;
		this.orderDate = orderDate;
		this.service = service;
		this.amountOfMoney = amountOfMoney;
		this.orderID = Order.maxOrderID++;
	}

	public int getOrderID() {
		return orderID;
	}

	public Person getPerson() {
		return person;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public String getService() {
		return service;
	}

	public float getAmountOfMoney() {
		return amountOfMoney;
	}

	public Bill createOutgoingBill( boolean inCash ) {
		return new OutgoingBill(service, amountOfMoney, new Date() , inCash, person);
	}

}