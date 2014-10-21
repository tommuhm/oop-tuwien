import java.util.Date;

public class Rental {
	private ArticleRent article;
	private Date date;

	public Rental(ArticleRent article, Date date) {
		this.article = article;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public ArticleRent getArticle() {
		return article;
	}

	public float getPriceByNow() {
		if (this.getHours() < 24) { //Pricing
			return article.getPricePerHour() * this.getHours();
		} else {
			return article.getPricePerDay() * this.getDays() * Discount.getDiscount(this.getDays());
		}
	}

	public int getHours() {
		return (int) Math.ceil((new Date().getTime() - date.getTime()) / 1000 / 60 / 60);
	}

	public int getDays() {
		return (int) Math.ceil((new Date().getTime() - date.getTime()) / 1000 / 60 / 60 / 24);
	}

	@Override
	public String toString() {
		return this.article.getName() + " " + this.date.toString();
	}

}