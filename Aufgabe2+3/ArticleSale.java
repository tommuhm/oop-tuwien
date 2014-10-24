//GOOD: class cohesion is high, even though the copy constructor uses getters and variables.
//BAD: object linking is not as low as it could be. Getters/Setters could be protected and the classes should be in different packages.
public class ArticleSale extends Article {

	private float priceSale;
	private int soldCount;
	//INVARIANT: priceSale > 0, soldCount >= 0

	//PRECONDITION: priceSale > 0, name != null, size != null
	public ArticleSale(String name, String size, float priceSale, boolean isNew) {
		super(name, size, isNew);
		this.priceSale = priceSale;
	}

	//ERROR: Getter not used. Even though it works. Class cohesion is lowered.
	//PRECONDITION: articleSale != null
	public ArticleSale(ArticleSale aricleSale) {
		this(aricleSale.getName(), aricleSale.getSize(), aricleSale.priceSale, aricleSale.isNew());
	}

	public float getPriceSale() {
		return priceSale;
	}

	public int getSoldCount() {
		return soldCount;
	}

	//PRECONDITION: amount > 0
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
