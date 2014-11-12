import java.util.*;

// BAD: This class has a very high object cohesion. StockManagement, Accounting and SurfSchool should work all on their own to lower object cohesion.
//		  Some methods in this class "redirect" to methods of StockManagement, Accounting and SurfSchool, so the test class can use them. (this should also be avoided)
public class Surfstore {

	private ArrayList<Customer> customers;
	private StockManagement stockManagement;
	private SurfSchool surfSchool;
	private Accounting accounting;
	// INVARIANT: stockManagement, surfSchool, accounting and customers are never null.

	public Surfstore(float balanceAccount, float balanceCash) {
		customers = new ArrayList<Customer>();
		stockManagement = new StockManagement();
		surfSchool = new SurfSchool();
		accounting = new Accounting(balanceAccount, balanceCash);
	}

	// POSTCONDITION: returns all articles from the stock
	public Collection<Article> getArticles() {
		return stockManagement.getArticles().values();
	}

	// PRECONDITION: person must not be null
	// POSTCONDITION: returns all rented articles for the specified person
	public ArrayList<Rental> getRentedArticles(Person person) {
		return stockManagement.getRentedArticleMap().get(person);
	}

	public float getBalanceAccount() {
		return accounting.getBalanceAccount();
	}

	public float getBalanceCash() {
		return accounting.getBalanceCash();
	}

	public float getTotalBalance() {
		return (getBalanceAccount() + getBalanceCash());
	}

	public String getStockingStatistics() {
		return stockManagement.getRentalStatistic();
	}

	public String getAccountingStatistics() {
		return accounting.getAccountStatistics();
	}

	// PRECONDITION: customer must not be null
	// POSTCONDITION: customers contains the specified customer
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	// PRECONDITION: course must not be null
	// POSTCONDITION: surfSchool contains the specified course
	public Course addCourse(Course course) {
		return surfSchool.addCourse(course);
	}

	// PRECONDITION: order must not be null
	// POSTCONDITION: accounting contains the specified order
	public Order addOrder(Order order) {
		accounting.addOrder(order);
		return order;
	}

	// PRECONDITION: article must not be null, priceBuy has to be equal or greater than zero, amount has to be greater than zero
	// POSTCONDITION: a new bill for the purchase is added to accounting
	// POSTCONDITION: stockManagement contains the article
	public Article buyArticles(Article article, float priceBuy, int amount, boolean inCash) {
		IncomingBill bill = new IncomingBill(article.getName() + ": " + amount, priceBuy, new Date(), inCash);
		accounting.addBill(bill);
		return stockManagement.addArticle(article, amount);
	}

	// PRECONDITION: article and person must not be null, amount has to be greater than zero
	// POSTCONDITION: sale successful: returns true and a new bill for the sale is added to accounting
	// POSTCONDITION: sale failed: returns false
	public boolean sellArticles(Article article, int amount, boolean inCash, Person person) {
		if (stockManagement.sellArticle(article, amount)) {
			OutgoingBill bill = new OutgoingBill(article.getName() + ": " + amount, ((ArticleSale) article).getPriceSale(), new Date(), inCash, person);
			accounting.addBill(bill);
			return true;
		} else {
			return false;
		}
	}

	// PRECONDITION: article must not be null, amount has to be greater than zero
	// POSTCONDITION: returns true if the specified amount is discarded, otherwise false
	public boolean discardArticles(Article article, int amount) {
		return stockManagement.removeArticle(article, amount);
	}

	// PRECONDITION: person, article and issueDate must not be null, amount has to be greater than zero
	// POSTCONDITION: returns all successfully rented articles
	public ArrayList<Rental> borrowArticle(Person person, Article article, Date issueDate, int amount) {
		ArrayList<Rental> rentals = new ArrayList<Rental>();
		for (int i = 0; i < amount; i++) {
			Rental rental = stockManagement.borrowArticle(person, article, issueDate);
			if (rental != null)
				rentals.add(rental);
		}
		return rentals;
	}

	// PRECONDITION: person and rentals must not be null
	// POSTCONDITION: returns the bill for the returned objects
	public OutgoingBill returnArticles(Person person, ArrayList<Rental> rentals, boolean inCash) {
		float price = 0f;
		int amount = 0;

		for (Rental rental : rentals) {
			if (stockManagement.returnArticle(person, rental)) {
				price += rental.getPriceByNow();
				amount++;
			}
		}

		OutgoingBill oBill = null;
		if (amount > 0) {
			oBill = new OutgoingBill("Rented articles: " + amount, price, new Date(), inCash, person);
			accounting.addBill(oBill);
		}
		return oBill;
	}

	// PRECONDITION: order and a must not be null, amount has to be greater than zero
	public OutgoingBill createBillForOrder(Order order, boolean inCash, Article a, int amount) {
		if (stockManagement.removeArticle(a, amount)) {
			OutgoingBill bill = order.createOutgoingBill(inCash);
			accounting.addBill(bill);
			return bill;
		} else {
			return null;
		}
	}

	// PRECONDITION: course must not be null
	// POSTCONDITION: returns bills for each person in the specified course
	public ArrayList<OutgoingBill> createBillsForSurfSchool(Course course) {
		ArrayList<OutgoingBill> outgoingBills = surfSchool.createOutgoingBills(course);

		for (OutgoingBill bill : outgoingBills) {
			accounting.addBill(bill);
		}
		return outgoingBills;
	}


	public String printArticles() {
		StringBuilder ausgabe = new StringBuilder();

		Collection<Article> articles = stockManagement.getArticles().values();
		HashMap<Person, ArrayList<Rental>> rentedArticleMap = stockManagement
				.getRentedArticleMap();

		for (Article article : articles) {
			ausgabe.append(article.toString());

			for (ArrayList<Rental> rentedArticles : rentedArticleMap.values()) {
				for (Rental rentedArticle : rentedArticles) {
					if (rentedArticle.getArticle().equals(article)) {
						ausgabe.append("\t| Rented from " + rentedArticle.getDate()
								+ "\t| Rented Hours " + rentedArticle.getHours() + "\n");
					}
				}
			}
			ausgabe.append("\n");
		}
		return ausgabe.toString();
	}

	public String printPersons() {
		HashMap<Person, ArrayList<Rental>> rentedArticleMap = stockManagement.getRentedArticleMap();
		StringBuilder ausgabe = new StringBuilder();

		for (Person person : customers) {
			ausgabe.append("--------------------------\n");
			ausgabe.append("| Name: " + person.getPersonName()
					+ "\t| Person ID: " + person.getPersonID() + " |\n");

			if (rentedArticleMap.containsKey(person)) {
				ArrayList<Rental> rentedArticles = rentedArticleMap.get(person);
				ausgabe.append("| " + rentedArticles.size() + " Rented Articles: \n");

				for (Rental rentedArticle : rentedArticles) {
					ausgabe.append("| Article: "
							+ rentedArticle.getArticle().getName()
							+ "\t| Rented from: " + rentedArticle.getDate()
							+ "\t| Rented Hours " + rentedArticle.getHours()
							+ "\t| Current Price: "
							+ rentedArticle.getPriceByNow() + "\n");
				}
			} else {
				ausgabe.append("|  0 Rented Articles: \n");
			}
		}
		return ausgabe.toString();
	}
}
