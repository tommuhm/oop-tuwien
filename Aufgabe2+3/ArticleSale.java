public class ArticleSale extends Article {

	private float priceSale;

	public ArticleSale(String name, String size, float priceSale, boolean isNew) {
		super(name, size, isNew);
	}

	public String toString() {
		return super.toString() +
				", price: " + this.priceSale;
	}

}
