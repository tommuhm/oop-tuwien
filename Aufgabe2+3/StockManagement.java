import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class StockManagement {

	private HashMap<Integer, Article> articles;
	private HashMap<Person, ArrayList<Rental>> rentedArticleMap;
	// INVARIANT: articles and rentedArticleMap are never null

	public StockManagement() {
		articles = new HashMap<Integer, Article>();
		rentedArticleMap = new HashMap<Person, ArrayList<Rental>>();
	}

	// POSTCONDITION: returns a map of all articles in our StockManagement, with ArticleID as Key
	public HashMap<Integer, Article> getArticles() {
		return articles;
	}

	// POSTCONDITION: returns a map of all rentedArticles for every person
	public HashMap<Person, ArrayList<Rental>> getRentedArticleMap() {
		return rentedArticleMap;
	}

	// PRECONDITION: articleName and articleSize must not be null
	// POSTCONDITION: articleName and articleSize must not be null
	// POSTCONDITION: returns the article with 'articleName' and 'articleSize', returns null if the article does not exist
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

	// PRECONDITION: a must not be null, amount has to be greater than zero
	// POSTCONDITOIN: article is added to the stock if was not already in there
	// POSTCONDITOIN: amount of the specified article has been increased
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

	// PRECONDITION: articles has to contain a, amount has to be greater than zero
	// POSTCONDITION: returns true if the specified amount has been discarded, otherwise false
	public boolean removeArticle(Article a, int amount) {
		Article article = articles.get(a.getId());

		if (article == null)
			return false;

		return article.discardArticle(amount);
	}

	// PRECONDITION: a must not be null, amount has to be greater than zero, a has to be an instance of ArticleSale, articles has to contain a
	// POSTCONDITION: returns true if the specified amount has been sold, otherwise false
	public boolean sellArticle(Article a, int amount) {
		Article article = articles.get(a.getId());

		if (article == null)
			return false;

		if (!(a instanceof ArticleSale))
			return false;

		return ((ArticleSale) a).sellArticle(amount);
	}

	// PRECONDITION: person, a and issueDate must not be null, articles has to contain a, a has to be an instance of ArticleRent
	// POSTCONDITION: a new rental is added to the rentedArticleMap
	// POSTCONDITION: returns true if the specified amount has been borrowed, otherwise false
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

	// PRECONDITION: person and rental must not be null, rentedArticleMap has to contain person
	// POSTCONDITION: rental is removed from rentedArticleMap, one article is returned to stock
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

	// GOOD: Dynamic binding is used to determine if the current article in the for-loop is rentable or for sale.
	public String getRentalStatistic() {
		StringBuilder statistic = new StringBuilder();

		for (Article article : articles.values()) {
			statistic.append(article.toString());
			statistic.append("\t| Discarded: " + article.getDiscardCount() + "\n");
		}

		return statistic.toString();
	}

}