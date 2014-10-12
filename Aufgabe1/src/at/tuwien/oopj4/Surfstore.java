package at.tuwien.oopj4;

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

	public Surfarticle createSurfarticle(String articelName, int articleNumber, float articlePrice, int totalAmount) {
		Surfarticle surfarticle = new Surfarticle(articelName, articleNumber, articlePrice, totalAmount);
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
				rentedArticles.add(new Rental(surfarticle, issueDate));
			}
		} else {
			System.out.println("Could not borrow " + surfarticle.getArticleName());
		}
	}

	public void returnSurfarticle(Person person, Surfarticle surfarticle, int amount) {
		if (rentedMap.containsKey(person)) {
			ArrayList<Rental> rentedArticles = rentedMap.get(person);
			ArrayList<Rental> toRemove = new ArrayList<Rental>();
			for (Rental rentedArticle: rentedArticles) {
				if (amount <= 0) {
					break;
				}
				if (rentedArticle.getSurfarticle().getArticleNumber() == surfarticle.getArticleNumber()) {
					surfarticle.returnArticle(1);
					toRemove.add(rentedArticle);
					amount--;
				}
			}
			for (Rental removeArticle : toRemove) {
				rentedArticles.remove(removeArticle);
			}
		} else {
			System.out.println("Not articles borrowed");
		}
	}

	public void printSurfArticles() {
		for (Surfarticle surfarticle : surfArticles) {
			System.out.println(surfarticle);
		}
	}

	public void printPersons() {
		for (Person person : persons) {
			System.out.println(person);
		}
	}

}
