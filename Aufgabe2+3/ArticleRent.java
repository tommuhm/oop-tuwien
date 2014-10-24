//GOOD: class cohesion is high.
//BAD: object linking is not as low as it could be. Getters/Setters could be protected and the classes should be in different packages.
public class ArticleRent extends Article {

	private float pricePerHour;
	private float pricePerDay;
	private int rentedCount;
	private int currentAmount;
	//INVARIANT: pricePerHour > 0, pricePerDay > 0, rentedCount >= 0, currentAmount >= 0

	//PRECONDITION: pricePerHour > 0, pricePerDay > 0
	public ArticleRent(String name, String size, float pricePerHour, float pricePerDay, boolean isNew) {
		super(name, size, isNew);
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.rentedCount = 0;
		this.currentAmount = getTotalAmount();
	}

	public ArticleRent(ArticleRent aricleRent) {
		this(aricleRent.getName(), aricleRent.getSize(), aricleRent.getPricePerHour(), aricleRent.getPricePerDay(), aricleRent.isNew());
	}

	public float getPricePerHour() {
		return pricePerHour;
	}

	public float getPricePerDay() {
		return pricePerDay;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public int getRentedCount() {
		return rentedCount;
	}

	//PRECONDITION: amount > 0
	public boolean borrowArticle(int amount) {
		if (isAvailable(amount)) {
			currentAmount -= amount;
			rentedCount += amount;
			return true;
		}
		return false;
	}

	//PRECONDITION: amount > 0
	public void returnArticle(int amount) {
		currentAmount += amount;
	}

	@Override
	//PRECONDITION: amount > 0
	//GOOD: Uses super.method -> no duplicated code
	public void addAmount(int amount) {
		super.addAmount(amount);
		currentAmount += amount;
	}

	@Override
	//PRECONDITION: amount > 0
	//POSTCONDITION: currentAmount >= 0
	//BAD: isAvailable should have been used in an if-clause
	public void removeAmount(int amount) {
		super.removeAmount(amount);
		currentAmount -= amount;
	}

	@Override
	//PRECONDITION: amount > 0
	public boolean isAvailable(int amount) {
		return currentAmount >= amount;
	}

	@Override
	public String toString() {
		return "| ID: " + this.getId()
				+ "\t| Name: " + this.getName()
				+ "\t| Size: " + this.getSize()
				+ "\t| Price/Hour: " + this.getPricePerHour() + "€"
				+ "\t| Price/Day: " + this.getPricePerDay() + "€"
				+ "\t| Total: " + this.getTotalAmount()
				+ "\t| Available: " + this.getCurrentAmount()
				+ "\t| Rented: " + (this.getTotalAmount() - this.getCurrentAmount());
	}
}
