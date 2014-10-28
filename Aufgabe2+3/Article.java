
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

	// BAD: object linking is not as low as it could be. Some Getters/Setters could be "protected" and the classes should have been in different packages, to avoid unauthorized using of the methods.
	public int getTotalAmount() {
		return totalAmount;
	}

	public int getDiscardCount() {
		return discardCount;
	}

	public boolean isNew() {
		return isNew;
	}

	// PRECONDITION: amount has to be greater than zero
	public void addAmount(int amount) {
		totalAmount += amount;
	}

	// PRECONDITION: amount has to be greater or equal to totalAmount
	// POSTCONDITION: totalAmount has to be greater or equal to zero
	// BAD: Should be combined with isAvailable(amount), but the classes using removeAmount use isAvailable first, so it's not that bad.
	public void removeAmount(int amount) {
		totalAmount -= amount;
	}

	// PRECONDITION: amount has to be greater than zero
	public boolean isAvailable(int amount) {
		return totalAmount >= amount;
	}

	// PRECONDITION: amount has to be greater than zero
	public boolean discardArticle(int amount) {
		if (isAvailable(amount)) {
			removeAmount(amount);
			discardCount += amount;
			return true;
		}
		return false;
	}
}