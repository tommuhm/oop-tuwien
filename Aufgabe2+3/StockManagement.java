import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class StockManagement {

  private HashMap<Integer, Article> articles;
  private HashMap<Person, ArrayList<Rental>> rentedArticleMap;

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

  public Article addArticle(Article a, int amount) {
    Article article = articles.get(a.getId());
    if (article == null) {
      article = new Article(a);
      articles.put(article.getId(), article);
    }

    article.addAmount(amount);
    return article;
  }

  public boolean removeArticle(Article a, int amount) {
    Article article = articles.get(a.getId());

    if (article == null)
      return false;

    if (!article.isAvailable(amount))
      return false;

    article.removeAmount(amount);
    return true;
  }

  public Rental borrowArticle(Person person, Article a, Date issueDate) {
    Article article = articles.get(a.getId());

    if (article == null)
      return null;

    if (!article.isAvailable(1))
      return null;

    article.borrowArticle(1);
    ArrayList<Rental> rentedArticles;
    if (!rentedArticleMap.containsKey(person)) {
      rentedArticles = new ArrayList<Rental>();
      rentedArticleMap.put(person, rentedArticles);
    } else {
      rentedArticles = rentedArticleMap.get(person);
    }

    Rental rental = new Rental(article, new Date(issueDate.getTime()));
    rentedArticles.add(rental);

    return rental;
  }

  public boolean returnArticle(Person person, Rental rental, int amount) {
    if (!rentedArticleMap.containsKey(person))
      return false;

    ArrayList<Rental> rentedArticles = rentedArticleMap.get(person);

    if (!rentedArticles.contains(rental))
      return false;

    rentedArticles.remove(rental);
    rental.getArticle().returnArticle(1);
    return true;
  }

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

}