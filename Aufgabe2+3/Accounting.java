import java.util.HashMap;

public class Accounting {

	private HashMap<Integer, Order> orderMap;
	private HashMap<Integer, OutgoingBill> outgoingBillMap;
	private HashMap<Integer, IncomingBill> incomingBillMap;
	private float balanceAccount;
	private float balanceCash;

	public Accounting(float balanceAccount, float balanceCash) {
		this.orderMap = new HashMap<Integer, Order>();
		this.outgoingBillMap = new HashMap<Integer, OutgoingBill>();
		this.incomingBillMap = new HashMap<Integer, IncomingBill>();
		this.balanceAccount = balanceAccount;
		this.balanceCash = balanceCash;
	}
	
	public Order getOrder(int orderID) {
		return orderMap.get(orderID);
	}

	public IncomingBill getIncomingBill(int billID) {
		return incomingBillMap.get(billID);
	}

	public OutgoingBill getOutgoingBill(int billID) {
		return outgoingBillMap.get(billID);
	}
	
	public void addOrder(Order order) {
		orderMap.put(order.getOrderID(), order);
	}

	public void addIncomingBill(IncomingBill bill) {
		incomingBillMap.put(bill.getBillID(), bill);
		if (bill.getInCash()) {
			balanceCash -= bill.getAmountOfMoney();
		} else {
			balanceAccount -= bill.getAmountOfMoney();
		}
	}

	public void addOutgoingBill(OutgoingBill bill) {
		outgoingBillMap.put(bill.getBillID(), bill);
		if (bill.getInCash()) {
			balanceCash += bill.getAmountOfMoney();
		} else {
			balanceAccount += bill.getAmountOfMoney();
		}
	}

	public float getBalanceAccount() {
		return balanceAccount;
	}

	public float getBalanceCash() {
		return balanceCash;
	}
/*
	public String toString() {
		String s = "";
		Bill bill = null;
		for ( i = 0; i < billMap.size(); i++ ) {
			bill = getBill( i );
			s = bill.toString()
					s += "\n ########## \n";
		}
		s += " current Account Balance: " + this.balanceAccount + "\n current Cash Balance: " + this.balanceCash
				s += "\n total ammount: " + (this.balanceAccount + this.balanceCash);
		s += "\n \n End of Accounting \n ";
	}
	*/
}
