public class ArticleSale extends Article {

	private float priceSale;

	public ArticleSale(String name, String size, float priceSale, boolean isNew) {
		super(name, size, isNew);
		this.priceSale = priceSale;
	}

	public ArticleSale(ArticleSale aricleSale) {
		this(aricleSale.getName(), aricleSale.getSize(), aricleSale.priceSale, aricleSale.isNew());
	}

	public float getPriceSale() {
		return priceSale;
	}

	public String toString() {
		return super.toString() +
				", price: " + this.priceSale;
	}

}
