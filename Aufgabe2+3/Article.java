//GOOD: class cohesion is high.
//BAD: object linking is not as low as it could be. Getters/Setters could be protected and the classes should be in different packages.
public abstract class Article {

	private static int maxArticleNumber = 0;
	//INVARIANT: maxArticleNumber >= 0, gets incremented by 1 every Article

	private final int id;
	private String name;
	private String size;
	private int totalAmount;
	private boolean isNew;
	private int discardCount;
	//INVARIANT: id >= 0, totalAmount >= 0, discardCount >= 0, name != null, size != null

	//PRECONDITION: name != null, size != null
	public Article(String name, String size, boolean isNew) {
		this.id = Article.maxArticleNumber++; //Set name and increment by 1
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
	
	public int getTotalAmount() {
		return totalAmount;
	}

	public int getDiscardCount() {
		return discardCount;
	}

	public boolean isNew() {
		return isNew;
	}

	//PRECONDITION: amount > 0
	public void addAmount(int amount) {
		totalAmount += amount;
	}

	//PRECONDITION: amount > 0
	//POSTCONDITION: totalAmount >= 0
	//BAD: Should be combined with isAvailable(amount), but the classes which use removeAmount use isAvailable first.
	public void removeAmount(int amount) {
		totalAmount -= amount;
	}

	//PRECONDITION: amount > 0
	public boolean isAvailable(int amount) {
		return totalAmount >= amount;
	}

	//PRECONDITION: amount > 0
	public boolean discardArticle(int amount) {
		if (isAvailable(amount)) {
			removeAmount(amount);
			discardCount += amount;
			return true;
		}
		return false;
	}
}