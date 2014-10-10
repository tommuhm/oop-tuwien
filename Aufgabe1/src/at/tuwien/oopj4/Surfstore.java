package at.tuwien.oopj4;

import java.util.ArrayList;

public class Surfstore {

  private ArrayList<Person> persons = new ArrayList<Person>();
  private ArrayList<Article> articles = new ArrayList<Article>();

  public void borrowArticle() {


  }

  public void returnArticle() {

  }


  public void createPerson(String name) {
    persons.add(new Person(name));
  }

  public void createArticle() {
    articles.add(new Article());
  }


}
