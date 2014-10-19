/**
 * @author: djaffry, uaschl, tmuhm
 */

public abstract class Article {

	private static int maxArticleNumber = 0;

	private final int id;
	private String name;
	private String size;
	private int currentAmount;
	private int totalAmount;
	boolean isNew;

	public Article(String name, String size, boolean isNew) {
		this.id = Article.maxArticleNumber++; //Set name and increment by 1
		this.name = name;
		this.size = size;
		this.totalAmount = 0;
		this.currentAmount = totalAmount;
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

	public int getCurrentAmount() {
		return currentAmount;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public boolean isNew() {
		return isNew;
	}

	public void addAmount(int amount) {
		totalAmount += amount;
		currentAmount += amount;
	}

	public void removeAmount(int amount) {
		totalAmount -= amount;
		currentAmount -= amount;
	}

	public boolean isAvailable(int amount) {
		return currentAmount >= amount;
	}

	public boolean borrowArticle(int amount) {
		if (isAvailable(amount)) {
			currentAmount -= amount;
			return true;
		}
		return false;
	}

	public void returnArticle(int amount) {
		currentAmount += amount;
	}
}