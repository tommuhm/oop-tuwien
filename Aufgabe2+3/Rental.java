/**
 * @author: djaffry, uaschl, tmuhm
 */

import java.util.Date;

public class Rental {
	private ArticleRent article;
	private Date date;

	public hRental(ArticleRent article, Date date) {
		this.article = article;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public Article getArticle() {
		return article;
	}

	public float getPriceByNow() {
		return article.getPricePerHour() * this.getHours();
	}

	public int getHours() {
		return (int) Math.ceil((new Date().getTime() - date.getTime()) / 1000 / 60 / 60);
	}

	@Override
	public String toString() {
		return this.article.getName() + " " + this.date.toString();
	}

}