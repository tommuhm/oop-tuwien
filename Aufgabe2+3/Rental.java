import java.util.Date;

//GOOD: 
public class Rental {
	private ArticleRent article;
	private Date date;
	//INVARIANT: article != null, date != null

	//PRECONDITION: article != null, date != null
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

	//POSTCONDITION: value > 0
	public float getPriceByNow() {
		if (this.getHours() < 24) { //BAD: getHours should only return values between 1 and 23; if > 23 => getDays
			return article.getPricePerHour() * this.getHours();
		} else {
			return article.getPricePerDay() * this.getDays() * Discount.getDiscount(this.getDays());
		}
	}

	//POSTCONDITION: value > 0
	public int getHours() {
		return (int) Math.ceil((new Date().getTime() - date.getTime()) / 1000 / 60 / 60);
	}

	//POSTCONDITION: value > 0
	public int getDays() {
		return (int) Math.ceil((new Date().getTime() - date.getTime()) / 1000 / 60 / 60 / 24);
	}

	@Override
	public String toString() {
		return this.article.getName() + " " + this.date.toString();
	}

}