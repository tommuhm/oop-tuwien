package at.tuwien.oopj4.test;

import org.junit.Before;
import org.junit.Test;

import at.tuwien.oopj4.Surfstore;

public class SurfstoreTest {

	private Surfstore surfstore;

	@Before
	public void createTestDate() {
		surfstore = new Surfstore();
		surfstore.createPerson("Ulrich", "A");
		surfstore.createPerson("David", "J");
		surfstore.createPerson("Tom", "M");
	}

	@Test
	public void borrowSurfarticleTest() {
	}

  @Test
  public void returnSurfarticleTest() {
  }

}
