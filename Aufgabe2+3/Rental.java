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

	// POSTCONDITION: value has to be greater than zero
	public float getPriceByNow() {
		// BAD: getHours should only return values between 1 and 23; if > 23 => getDays
		if (this.getHours() < 24) {
			return article.getPricePerHour() * this.getHours();
		} else {
			return article.getPricePerDay() * this.getDays() * Discount.getDiscount(this.getDays());
		}
	}

	// POSTCONDITION: value has to be greater than zero
	public int getHours() {
		return (int) Math.ceil((new Date().getTime() - date.getTime()) / 1000 / 60 / 60);
	}

	// POSTCONDITION: value has to be greater than zero
	public int getDays() {
		return (int) Math.ceil((new Date().getTime() - date.getTime()) / 1000 / 60 / 60 / 24);
	}

	@Override
	public String toString() {
		return this.article.getName() + " " + this.date.toString();
	}

}