package at.tuwien.oopj4.test;

import org.junit.Before;
import org.junit.Test;

import at.tuwien.oopj4.Surfstore;

public class SurfstoreTest {

  private Surfstore surfstore;

  @Before
  public void createTestDate() {
    surfstore = new Surfstore();
    surfstore.createPerson("Uli");
    surfstore.createPerson("David");
    surfstore.createPerson("Tom");
  }

  @Test
  public void borrowArticelTest() {
  }


}
