package at.tuwien.oopj4;

/**
* @author: djaffry, uaschl, tmuhm
*
*/
public class Surfarticle{
	private static int maxArticleNumber = 0;
	
	private int articleNumber;
	private String articleName;
	private float articlePrice;
	private int currentAmount;
	private int totalAmount;
	
	public Surfarticle( String aName, float aPrice, int total ) {
		this.articleName = aName;
		this.articleNumber = Surfarticle.maxArticleNumber++; //Set articleNmae and increment by 1
		this.articlePrice = aPrice;
		this.totalAmount = total;
		this.currentAmount = total;
	}
	
	public float getPricePerTimeunit() {
		return  this.articlePrice;
	} 
	
	public String getArticleName() {
		return  this.articleName;
	} 
	
	public int getArticleNumber() {
		return  this.articleNumber;
	} 
	
	public int getAmount() {
		return this.currentAmount;
	}
	
	public int getTotalAmount() {
		return this.totalAmount;
	}
	
	public void setAmount(int amount) {
		currentAmount = amount;
	}
	
	public boolean isAvailable( int amount ) {
		return currentAmount > amount;
	}
	
	public boolean borrowArticle( int amount ) {
		if (isAvailable( amount )) {
			currentAmount = currentAmount - amount;
			return true;
		} return false;
	}
	
	public boolean returnArticle( int amount) {
		int tempAmount = amount + currentAmount;
		if ( tempAmount > totalAmount ) {
			currentAmount = tempAmount;
			return true;
		} return false;
	}
	
	public String toString() {
		return this.articleName + " " + this.articleNumber + "" + this.articlePrice + " current: " + this.currentAmount + " total :" + this.totalAmount;
	}
	
}
