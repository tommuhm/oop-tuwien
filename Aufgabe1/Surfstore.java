/**
 * @author: djaffry, uaschl, tmuhm
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Surfstore {

	private ArrayList<Person> persons = new ArrayList<Person>();
	private ArrayList<Surfarticle> surfArticles = new ArrayList<Surfarticle>();
	private HashMap<Person, ArrayList<Rental>> rentedMap = new HashMap<Person, ArrayList<Rental>>();

	public Person createPerson(String firstname, String lastname) {
		Person person = new Person(firstname + " " + lastname);
		persons.add(person);
		return person;
	}

	public Surfarticle createSurfarticle(String articleName, float articlePrice, int totalAmount) { // articleName
		Surfarticle surfarticle = new Surfarticle(articleName, articlePrice, totalAmount);
		surfArticles.add(surfarticle);
		return surfarticle;
	}

	public void borrowSurfarticle(Person person, Surfarticle surfarticle, int amount, Date issueDate) {
		if (surfarticle.borrowArticle(amount)) {
			ArrayList<Rental> rentedArticles;
			if (!rentedMap.containsKey(person)) {
				rentedArticles = new ArrayList<Rental>();
				rentedMap.put(person, rentedArticles);
			} else {
				rentedArticles = rentedMap.get(person);
			}

			for (int i = 0; i < amount; i++) {
				rentedArticles.add(new Rental(surfarticle, new Date(issueDate.getTime())));
			}
		}
	}

	public float returnSurfarticle(Person person, Surfarticle surfarticle, int amount) {
		float price = 0;

		if (rentedMap.containsKey(person)) {
			ArrayList<Rental> rentedArticles = rentedMap.get(person);
			ArrayList<Rental> toRemove = new ArrayList<Rental>();
			for (Rental rentedArticle : rentedArticles) {
				if (amount <= 0) {
					break;
				}
				if (rentedArticle.getSurfarticle().getArticleNumber() == surfarticle.getArticleNumber()) {
					surfarticle.returnArticle(1);
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

	public void printSurfArticles() {
		for (Surfarticle surfarticle : surfArticles) {
			System.out.println("-----------------------------");
			System.out.println("| Name: " + surfarticle.getArticleName()
					+ "\t| Article ID: " + surfarticle.getArticleNumber()
					+ "\t| Price per Hour: " + surfarticle.getPricePerHour()
					+ "\t| Total Amount: " + surfarticle.getTotalAmount()
					+ "\t| Rented Count: " + (surfarticle.getTotalAmount() - surfarticle.getCurrentAmount()));
			for (ArrayList<Rental> rentedArticles : rentedMap.values()) {
				for (Rental rentedArticle : rentedArticles) {
					if (rentedArticle.getSurfarticle().equals(surfarticle)) {
						System.out.println("\t| Rented from " + rentedArticle.getDate()
								+ "\t| Rented Hours " + rentedArticle.getHours());
					}
				}
			}
		}
	}

	public void printPersons() {
		for (Person person : persons) {
			System.out.println("--------------------------");
			System.out.println("| Name: " + person.getPersonName()
					+ "\t| Person ID: " + person.getPersonID() + " |");
			if (rentedMap.containsKey(person)) {
				ArrayList<Rental> rentedArticles = rentedMap.get(person);
				System.out.println("| " + rentedArticles.size() + " Rented Articles: ");
				for (Rental rentedArticle : rentedArticles) {
					System.out.println("| Article: " + rentedArticle.getSurfarticle().getArticleName()
							+ "\t| Rented from: " + rentedArticle.getDate()
							+ "\t| Rented Hours " + rentedArticle.getHours()
							+ "\t| Current Price: " + rentedArticle.getPriceByNow());
				}
			} else {
				System.out.println("|  0 Rented Articles: ");
			}
		}
	}
}
