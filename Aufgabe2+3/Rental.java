import java.util.Date;

public class Rental {
	private ArticleRent article;
	private Date date;
	// INVARIANT: article and date are never null

	// PRECONDITION: article and date must not be null
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

	// POSTCONDITION: returns a positive value for the price
	public float getPriceByNow() {
		if (this.getHours() < 24) {
			return article.getPricePerHour() * this.getHours();
		} else {
			return article.getPricePerDay() * this.getDays() * Discount.getDiscount(this.getDays());
		}
	}

	// POSTCONDITION: returns the number of hour which have passed since the borrow dateTime
	public int getHours() {
		return (int) Math.ceil((new Date().getTime() - date.getTime()) / 1000 / 60 / 60);
	}

	// POSTCONDITION: returns the number of days which have passed since the borrow dateTime
	public int getDays() {
		return (int) Math.ceil((new Date().getTime() - date.getTime()) / 1000 / 60 / 60 / 24);
	}

	@Override
	public String toString() {
		return this.article.getName() + " " + this.date.toString();
	}

}