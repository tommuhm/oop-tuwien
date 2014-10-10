package at.tuwien.oopj4;

import java.util.ArrayList;

public class Surfstore {

  private ArrayList<Person> persons = new ArrayList<Person>();
  private ArrayList<Surfartikel> articles = new ArrayList<Surfartikel>();

  public void borrowArticel() {


  }

  public void returnArticel() {

  }


  public void createPerson(String name) {
    persons.add(new Person(name));
  }

  public void createArticle() {
    articles.add(new Surfartikel());
  }


}
