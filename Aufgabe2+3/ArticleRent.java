public class ArticleRent extends Article {

	private float pricePerHour;

	public ArticleRent(String name, String size, float pricePerHour, boolean isNew) {
		super(name, size, isNew);
		this.pricePerHour = pricePerHour;
	}

	public float getPricePerHour() {
		return pricePerHour;
	}

	public String toString() {
		return super.toString() +
				", price/hour: " + this.pricePerHour;
	}
}
