import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
* @author: djaffry, uaschl, tmuhm
*
*/

public class Surfstore {

	private ArrayList<Person> persons = new ArrayList<Person>();
	private ArrayList<Surfarticle> surfArticles = new ArrayList<Surfarticle>();
	private HashMap<Person, ArrayList<Rental>> rentedMap = new HashMap<Person, ArrayList<Rental>>();

	public Person createPerson(String firstname, String lastname) {
		Person person = new Person(firstname + " " + lastname);
		persons.add(person);
		return person;
	}

	public Surfarticle createSurfarticle(String articelName, float articlePrice, int totalAmount) {
		Surfarticle surfarticle = new Surfarticle(articelName, articlePrice, totalAmount);
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
		} else {
//			System.out.println(person.getPersonName() + " could not borrow " + amount + " '"+ surfarticle.getArticleName() + "'");
		}
	}

	public float returnSurfarticle(Person person, Surfarticle surfarticle, int amount) {
		float price = 0;
		int toReturnAmount = amount;
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
					price += rentedArticle.getPriceByNow();
				}
			}
//			if (amount == toReturnAmount) {
//				System.out.println(person.getPersonName() + " has no '" + surfarticle.getArticleName() + "' borrowed.");
//			} else {
//				System.out.println(person.getPersonName() + " returned " + (toReturnAmount-amount) + " '" + surfarticle.getArticleName() + "'");
//			}

			for (Rental removeArticle : toRemove) {
				rentedArticles.remove(removeArticle);
			}
		} else {
//			System.out.println(person.getPersonName() + " has no articles borrowed.");
		}
		return price;
	}

	public void printSurfArticles() {
		Date currentDate = new Date();
		for (Surfarticle surfarticle : surfArticles) {
			System.out.println("-----------");
			System.out.println("Articlename: " + surfarticle.getArticleName()
					+ " , Articlenumber: " + surfarticle.getArticleNumber()
					+ ", Price per Hour: " + surfarticle.getPricePerHour());
			for (ArrayList<Rental> rentedArticles : rentedMap.values()) {
				for (Rental rentedArticle : rentedArticles) {
					if (rentedArticle.getSurfarticle().equals(surfarticle)) {
						System.out.println("\tRented from " + rentedArticle.getDate()
								+ ", rented hours " + rentedArticle.getHours());
					}
				}
			}
		}
	}

	public void printPersons() {
		for (Person person : persons) {
			System.out.println("-----------");
			System.out.println("Name: " + person.getPersonName() + ", Person ID: " + person.getPersonID());
			if (rentedMap.containsKey(person)) {
				ArrayList<Rental> rentedArticles = rentedMap.get(person);
				System.out.println("Rented Articles: " + rentedArticles.size());
				for (Rental rentedArticle : rentedArticles) {
					System.out.println("Article: " + rentedArticle.getSurfarticle().getArticleName()
							+ ", rented from: " + rentedArticle.getDate()
							+ ", rented hours " + rentedArticle.getHours()
							+ ", current price: " + rentedArticle.getPriceByNow());
				}
			} else {
				System.out.println("Rented Articles: 0");
			}
		}
	}
}
