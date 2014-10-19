public class ArticleRent extends Article {

	private float pricePerHour;
	private float pricePerDay;

	public ArticleRent(String name, String size, float pricePerHour, float pricePerDay, boolean isNew) {
		super(name, size, isNew);
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
	}

	public ArticleRent(ArticleRent aricleRent) {
		this(aricleRent.getName(), aricleRent.getSize(), aricleRent.getPricePerHour(),
				aricleRent.getPricePerDay(), aricleRent.isNew());
	}

	public float getPricePerHour() {
		return pricePerHour;
	}

	public float getPricePerDay() {
		return pricePerDay;
	}

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
