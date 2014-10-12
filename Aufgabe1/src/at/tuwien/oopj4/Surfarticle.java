package at.tuwien.oopj4;

/**
* @author: djaffry, uaschl, tmuhm
*
*/
public class Surfarticle{
	
	private String articleName;
	private int articleNumber;
	private float articlePrice;
	private int currentAmount;
	private int totalAmount;
	
	public Surfarticle( String aName, int aNumber, float aPrice ) {
		this.articleName = aName;
		this.articleNumber = aNumber; 
		this.articlePrice = aPrice;
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
	
	public int getTotalAMount() {
		return this.totalAmount;
	}
	
	public void setAmount(int amount) {
		currentAmount = amount;
	}
	
	public boolean isAvailable( int amount ) {
		return currentAmount < amount;
	}
	
	public boolean borrowArticle( int amount ) {
		if (isAvailable( amount )) {
			currentAmount = currentAmount - amount;
			return true;
		} return false;
	}
	
	public boolean returnArticle( int amount) {
		tempAmount = amount + currentAmount;
		if ( tempAmount > totalAmount ) {
			currentAmount = tempAmount;
		}
	}
	
	public String toString() {
		return this.articleName + " " + this.articleNumber + "" + this.articlePrice;
	}
	
}
