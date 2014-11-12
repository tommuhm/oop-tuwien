
public abstract class Article {

	private static int maxArticleNumber = 0;

	private final int id;
	private String name;
	private String size;
	private int totalAmount;
	private boolean isNew;
	private int discardCount;
	// INVARIANT: maxArticleNumber gets incremented by one after each new article
	// INVARIANT: maxArticleNumber, id, totalAmount and discardCount are always greater or equal to zero
	// INVARIANT: name and size are never null

	// PRECONDITION: name and size are never null
	public Article(String name, String size, boolean isNew) {
		this.id = Article.maxArticleNumber++;
		this.name = name;
		this.size = size;
		this.totalAmount = 0;
		this.isNew = isNew;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public int getDiscardCount() {
		return discardCount;
	}

	protected int getTotalAmount() {
		return totalAmount;
	}

	protected boolean isNew() {
		return isNew;
	}

	// PRECONDITION: amount has to be greater than zero
	// POSTCONDITION: totalAmount is increased by amount
	protected void addAmount(int amount) {
		totalAmount += amount;
	}

	// PRECONDITION: amount has to be greater or equal to totalAmount
	// POSTCONDITION: totalAmount is decreased by amount
	protected void removeAmount(int amount) {
		if (isAvailable(amount)) {
			totalAmount -= amount;
		}
	}

	// PRECONDITION: amount has to be greater than zero
	// POSTCONDITION: returns true if the specified amount is available, otherwise false
	public boolean isAvailable(int amount) {
		return totalAmount >= amount;
	}

	// PRECONDITION: amount has to be greater than zero
	// PRECONDITION: amount has to be greater or equal to totalAmount
	// POSTCONDITION: totalAmount is decreased by amount and discardCounter is increased by amount
	// POSTCONDITION: returns true if the specified amount has been discarded, otherwise false
	public boolean discardArticle(int amount) {
		if (isAvailable(amount)) {
			removeAmount(amount);
			discardCount += amount;
			return true;
		}
		return false;
	}
}