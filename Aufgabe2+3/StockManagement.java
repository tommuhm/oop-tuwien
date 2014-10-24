import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class StockManagement {

	private HashMap<Integer, Article> articles;
	private HashMap<Person, ArrayList<Rental>> rentedArticleMap;
	//INVARIANT: articles != null, rentedArticleMap != null

	public StockManagement() {
		articles = new HashMap<Integer, Article>();
		rentedArticleMap = new HashMap<Person, ArrayList<Rental>>();
	}

	public HashMap<Integer, Article> getArticles() {
		return articles;
	}

	public HashMap<Person, ArrayList<Rental>> getRentedArticleMap() {
		return rentedArticleMap;
	}

	//PRECONDITION: articleName != null, articleSize != null
	private Article getArticle(String articleName, String articleSize) {
		Article foundArticle = null;

		for (Article article : articles.values()) {
			if (article.getName().equals(articleName) &&
					article.getSize().equals(articleSize)) {
				foundArticle = article;
				break;
			}
		}
		return foundArticle;
	}

	//PRECONDITION: a != null, amount > 0
	//POSTCONDITOIN: article != null
	public Article addArticle(Article a, int amount) {
		Article article = articles.get(a.getId());
		if (article == null) {
			if (a instanceof ArticleRent) {
				article = new ArticleRent((ArticleRent) a);
			}
			if (a instanceof ArticleSale) {
				article = new ArticleSale((ArticleSale) a);
			}
			articles.put(article.getId(), article);
		}

		article.addAmount(amount);
		return article;
	}

	//PRECONDITION: articles contains a, amount > 0
	public boolean removeArticle(Article a, int amount) {
		Article article = articles.get(a.getId());

		if (article == null)
			return false;
		
		return article.discardArticle(amount);
	}

	//PRECONDITION: a != null, amount >= 0, a instanceof ArticleSale, articles contains a
	public boolean sellArticle(Article a, int amount) {
		Article article = articles.get(a.getId());

		if (article == null)
			return false;

		if (!(a instanceof ArticleSale))
			return false;

		return ((ArticleSale) a).sellArticle(amount);
	}

	//PRECONDITION: person != null, a != null, issueDate != null, articles contains a, a instanceof ArticleRent
	public Rental borrowArticle(Person person, Article a, Date issueDate) {
		Article article = articles.get(a.getId());

		if (article == null)
			return null;

		if (!article.isAvailable(1))
			return null;

		if (!(article instanceof ArticleRent))
			return null;

		((ArticleRent) article).borrowArticle(1);

		ArrayList<Rental> rentedArticles;
		if (!rentedArticleMap.containsKey(person)) {
			rentedArticles = new ArrayList<Rental>();
			rentedArticleMap.put(person, rentedArticles);
		} else {
			rentedArticles = rentedArticleMap.get(person);
		}

		Rental rental = new Rental((ArticleRent) article, new Date(issueDate.getTime()));
		rentedArticles.add(rental);

		return rental;
	}

	//PRECONDITION: person != null, rental != null, rentedArticleMap contains person
	public boolean returnArticle(Person person, Rental rental) {
		if (!rentedArticleMap.containsKey(person))
			return false;

		ArrayList<Rental> rentedArticles = rentedArticleMap.get(person);

		if (!rentedArticles.contains(rental))
			return false;

		rentedArticles.remove(rental);
		rental.getArticle().returnArticle(1);
		return true;
	}

	public String getRentalStatistic() {
		StringBuilder statistic = new StringBuilder();

		for (Article article : articles.values()) {
			if (article instanceof ArticleRent) {
				statistic.append(article.toString() + "\t| Rented " + ((ArticleRent) article).getRentedCount() + " time(s).");
			}
			if (article instanceof ArticleSale) {
				ArticleSale articleSale = (ArticleSale) article;
				statistic.append(article.toString() + "\t| Sold: " + articleSale.getSoldCount());
			}
			statistic.append("\t| Discarded: " + article.getDiscardCount() + "\n");
		}

		return statistic.toString();
	}

}