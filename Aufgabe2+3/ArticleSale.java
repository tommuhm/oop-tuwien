public class ArticleSale extends Article {

	private float priceSale;
	private int soldCount;

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

	public int getSoldCount() {
		return soldCount;
	}

	public boolean sellArticle(int amount) {
		if (isAvailable(amount)) {
			removeAmount(amount);
			soldCount += amount;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "| ID: " + this.getId()
				+ "\t| Name: " + this.getName()
				+ "\t| Size: " + this.getSize()
				+ "\t| Price: " + this.getPriceSale() + "€"
				+ "\t| Total: " + this.getTotalAmount();
	}

}
