/**
 * @author: djaffry, uaschl, tmuhm
 */

import java.util.*;

public class Surfstore {

	private ArrayList<Person> persons;
	private StockManagement stockManagement;

	public Surfstore() {
		persons = new ArrayList<Person>();
		stockManagement = new StockManagement();
	}

	public Person createCustomer(String firstname, String lastname) {
		Person person = new Customer(firstname + " " + lastname);
		persons.add(person);
		return person;
	}

	public Collection<Article> getArticleList() {
		return stockManagement.getArticles().values();
	}

	public ArrayList<Rental> getRentedArticles(Person person) {
		return stockManagement.getRentedArticleMap().get(person);
	}

	public Article buyArticles(Article article, float priceBuy, int amount) {
		// TODO remove price from balance
		return stockManagement.addArticle(article, amount);
	}

	public boolean sellArticles(Article article, float priceSell, int amount) {
		// TODO add price to balance
		return stockManagement.removeArticle(article, amount);
	}

	public boolean discardArticles(Article article, int amount) {
		return stockManagement.removeArticle(article, amount);
	}

	public Rental borrowArticle(Person person, Article article, Date issueDate) {
		return stockManagement.borrowArticle(person, article, issueDate);
	}

	public ArrayList<Rental> borrowArticles(Person person, Article article, Date issueDate, int amount) {
		ArrayList<Rental> rentals = new ArrayList<Rental>();
		for (int i = 0; i < amount; i++) {
			Rental rental = this.borrowArticle(person, article, issueDate);
			if (rental != null)
				rentals.add(rental);
		}
		return rentals;
	}

	public float returnArticle(Person person, Rental rental) {
		// TODO add income to balance
		if (stockManagement.returnArticle(person, rental))
			return rental.getPriceByNow();
		else
			return 0f;
	}

	public float returnArticles(Person person, ArrayList<Rental> rentals) {
		float price = 0f;
		for (Rental rental : rentals)
			price += returnArticle(person, rental);
		return price;
	}


	public String printArticles() {
		StringBuilder ausgabe = new StringBuilder();

		Collection<Article> articles = stockManagement.getArticles().values();
		HashMap<Person, ArrayList<Rental>> rentedArticleMap = stockManagement.getRentedArticleMap();

		for (Article article : articles) {
			ausgabe.append("-----------------------------\n");
			ausgabe.append(article.toString());

			for (ArrayList<Rental> rentedArticles : rentedArticleMap.values()) {
				for (Rental rentedArticle : rentedArticles) {
					if (rentedArticle.getArticle().equals(article)) {
						ausgabe.append("\t| Rented from " + rentedArticle.getDate()
								+ "\t| Rented Hours " + rentedArticle.getHours()
								+ "\n");
					}
				}
			}
		}
		return ausgabe.toString();
	}

	public String printPersons() {
		HashMap<Person, ArrayList<Rental>> rentedArticleMap = stockManagement.getRentedArticleMap();
		StringBuilder ausgabe = new StringBuilder();

		for (Person person : persons) {
			ausgabe.append("--------------------------\n");
			ausgabe.append("| Name: " + person.getPersonName()
					+ "\t| Person ID: " + person.getPersonID() + " |\n");
			if (rentedArticleMap.containsKey(person)) {
				ArrayList<Rental> rentedArticles = rentedArticleMap.get(person);
				ausgabe.append("| " + rentedArticles.size() + " Rented Articles: \n");
				for (Rental rentedArticle : rentedArticles) {
					ausgabe.append("| Article: " + rentedArticle.getArticle().getName()
							+ "\t| Rented from: " + rentedArticle.getDate()
							+ "\t| Rented Hours " + rentedArticle.getHours()
							+ "\t| Current Price: " + rentedArticle.getPriceByNow()
							+ "\n");
				}
			} else {
				ausgabe.append("|  0 Rented Articles: \n");
			}
		}
		return ausgabe.toString();
	}
}
