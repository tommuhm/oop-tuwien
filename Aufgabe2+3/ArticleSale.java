public class ArticleSale extends Article {

	private float priceSale;
	private int soldCount;
	// INVARIANT: priceSale is always greater than zero
	// INVARIANT: soldCount is always greater or equal to zero

	// PRECONDITION: priceSale has to be greater than zero, name and size must not be null
	public ArticleSale(String name, String size, float priceSale, boolean isNew) {
		super(name, size, isNew);
		this.priceSale = priceSale;
	}

	// PRECONDITION: articleSale must not be null
	public ArticleSale(ArticleSale aricleSale) {
		this(aricleSale.getName(), aricleSale.getSize(), aricleSale.priceSale, aricleSale.isNew());
	}

	public float getPriceSale() {
		return priceSale;
	}

	public int getSoldCount() {
		return soldCount;
	}

	// PRECONDITION: amount has to be greater than zero
	// POSTCONDITION: totalAmount is decreased by amount and soldCounter is increased by amount
	// POSTCONDITION: returns true if the specified amount has been sold, otherwise false
	public boolean sellArticle(int amount) {
		if (isAvailable(amount)) {
			super.removeAmount(amount);
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
				+ "\t| Price: " + this.getPriceSale() + " Euro"
				+ "\t| Total: " + this.getTotalAmount()
				+ "\t| Sold: " + this.getSoldCount();
	}

}
