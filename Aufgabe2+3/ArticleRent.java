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
		return super.toString() +
				", price/hour: " + this.pricePerHour;
	}
}
