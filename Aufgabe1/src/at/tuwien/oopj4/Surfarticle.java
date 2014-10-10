package at.tuwien.oopj4;

/**
 * @author: djaffry, uaschl, tmuhm
 *
 * @changelog:
 *
 */
public class Surfarticle{
	
	private String articlename;
	private int articlenumber;
	private float articleprice;
	
	public Surfarticle( String aname, int anumber, float aprice ) {
		this.articlename = aname;
		this.articlenumber = anumber; 
		this.articleprice = aprice;
	}
	
	public float getPricePerTimeunit() {
		return  this.articleprice;
	} 
	
	public String getArticleName() {
		return  this.articlename;
	} 
	
	public int getArticleNumber() {
		return  this.articlenumber;
	} 
	
	public String toString() {
		return this.articlename + " " + this.articlenumber + "" + this.articleprice;
	}
	
}
