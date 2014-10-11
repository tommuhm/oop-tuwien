package at.tuwien.oopj4;

import java.util.ArrayList;

public class Surfstore {

	private ArrayList<Person> persons = new ArrayList<Person>();
	private ArrayList<Surfarticle> surfArticles = new ArrayList<Surfarticle>();

	public void createPerson(String firstname, String lastname) {
    		persons.add(new Person(firstname + " " + lastname));
  	}

  	public void createSurfarticle(String articelName, int articleNumber, float articlePrice) {
    		surfArticles.add(new Surfarticle(articelName, articleNumber, articlePrice));
  	}

	public void borrowSurfarticle(Person person, Surfarticle surfarticle, DateTime issueDate, int ) {

	}

	public void returnSurfarticle() {

	}

}
