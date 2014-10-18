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

	public Article buyArticle(Article article, int amount) {
		return stockManagement.addArticle(article, amount);
	}

	public Rental borrowArticle(Person person, Article article, Date issueDate) {
		return stockManagement.borrowArticle(person, article, issueDate);
	}

	public float returnArticle(Person person, Article article, int amount) {
		float price = 0;

		HashMap<Person, ArrayList<Rental>> rentedArticleMap = stockManagement.getRentedArticleMap();

		if (rentedArticleMap.containsKey(person)) {
			ArrayList<Rental> rentedArticles = rentedArticleMap.get(person);
			ArrayList<Rental> toRemove = new ArrayList<Rental>();
			for (Rental rentedArticle : rentedArticles) {
				if (amount <= 0) {
					break;
				}
				if (rentedArticle.getArticle().getId() == article.getId()) {
					article.returnArticle(1);
					toRemove.add(rentedArticle);
					amount--;
					price += rentedArticle.getPriceByNow();
				}
			}
			for (Rental removeArticle : toRemove) {
				rentedArticles.remove(removeArticle);
			}
		}
		return price;
	}

	public String printArticles() {
		StringBuilder ausgabe = new StringBuilder();

		Collection<Article> articles = stockManagement.getArticles().values();
		HashMap<Person, ArrayList<Rental>> rentedArticleMap = stockManagement.getRentedArticleMap();

		for (Article article : articles) {
			ausgabe.append("-----------------------------\n");
			ausgabe.append("| Name: " + article.getName()
					+ "\t| Article ID: " + article.getId()
					+ "\t| Price per Hour: " + article.getPricePerHour()
					+ "\t| Total Amount: " + article.getTotalAmount()
					+ "\t| Rented Count: " + (article.getTotalAmount() - article.getCurrentAmount())
					+ "\n");


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
