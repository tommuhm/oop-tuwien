public class ArticleRent extends Article {

	private float pricePerHour;
	private float pricePerDay;
	private int rentedCount;
	private int currentAmount;
	// INVARIANT: pricePerHour and pricePerDay are always greater than zero
	// INVARIANT: rentedCount and currentAmount are always greater or equal to zero

	// PRECONDITION: pricePerHour und pricePerDay have to be greater than zero, name and size must not be null
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

	// PRECONDITION: amount has to be greater than zero
	public boolean borrowArticle(int amount) {
		if (isAvailable(amount)) {
			currentAmount -= amount;
			rentedCount += amount;
			return true;
		}
		return false;
	}

	// PRECONDITION: amount has to be greater than zero
	public void returnArticle(int amount) {
		currentAmount += amount;
	}

	@Override
	// PRECONDITION: amount has to be greater than zero
	// GOOD: Uses super.method -> no duplicate code
	public void addAmount(int amount) {
		super.addAmount(amount);
		currentAmount += amount;
	}

	@Override
	// PRECONDITION: amount has to be greater or equal to totalAmount
	// POSTCONDITION: currentAmount has to be greater or equal to totalAmount
	public void removeAmount(int amount) {
		super.removeAmount(amount);
		currentAmount -= amount;
	}

	@Override
	// PRECONDITION: amount has to be greater than zero
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
