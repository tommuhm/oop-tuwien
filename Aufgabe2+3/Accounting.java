import java.util.HashMap;

public class Accounting {

	private HashMap<Integer, Order> orderMap;
	private HashMap<Integer, OutgoingBill> outgoingBillMap;
	private HashMap<Integer, IncomingBill> incomingBillMap;
	private float balanceAccount;
	private float balanceCash;
	// INVARIANT: orderMap, outgoingBillMap and incomingBillMap are never null
	// BAD: We should have used whole numbered objects for money like big decimal or long. (like in the script [Page 82])

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

	// GOOD: this method is a good example for dynamic binding: We decide of what type the bill is and put it in the right map. -> Less duplicate code.
	// POSTCONDITION: adds Bill to the right Map
	public void addBill(Bill bill) {
		float amountOfMoney = bill.getAmountOfMoney();
		if (bill instanceof OutgoingBill) {
			outgoingBillMap.put(bill.getBillID(), (OutgoingBill) bill);
		}
		if (bill instanceof IncomingBill) {
			incomingBillMap.put(bill.getBillID(), (IncomingBill) bill);
			amountOfMoney *= -1;
		}
		if (bill.getInCash()) {
			balanceCash += amountOfMoney;
		} else {
			balanceAccount += amountOfMoney;
		}
	}

	public float getBalanceAccount() {
		return balanceAccount;
	}

	public float getBalanceCash() {
		return balanceCash;
	}

	public String getAccountStatistics() {
		String s = "";
		float spent = 0;
		float income = 0;
		for (OutgoingBill bill : outgoingBillMap.values()) {
			income += bill.getAmountOfMoney();
		}
		for (IncomingBill bill : incomingBillMap.values()) {
			spent += bill.getAmountOfMoney();
		}

		s += "Account/Cash: " + this.balanceAccount + "/" + this.balanceCash + "\n" +
				"Money spent: " + spent + "\n" +
				"Money income: " + income + "\n" +
				"Bills outgoing: " + outgoingBillMap.size() + "\n" +
				"Bills incoming: " + incomingBillMap.size() + "\n";

		return s;
	}

	@Override
	public String toString() {
		String s = "";
		for (OutgoingBill bill : outgoingBillMap.values()) {
			s += bill.toString();
			s += "\n ########## \n";
		}
		for (IncomingBill bill : incomingBillMap.values()) {
			s += bill.toString();
			s += "\n ########## \n";
		}
		s += " current Account Balance: " + this.balanceAccount
				+ "\n current Cash Balance: " + this.balanceCash;
		s += "\n total ammount: " + (this.balanceAccount + this.balanceCash);
		s += "\n\n End of Accounting \n ";
		return s;
	}
}
