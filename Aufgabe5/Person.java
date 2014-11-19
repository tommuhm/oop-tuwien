
public abstract class Person implements Prec<Person> {

	public String name;

	// Vorbedingung: name darf nicht null sein
	public Person(String name) {
		this.name = name;
	}

	// Vorbedingung: y darf nicht null sein
	// Nachbedingung: true, wenn der nameI gleich dem von nameY ist oder alphabetisch vor dem von nameY kommt
	@Override
	public boolean prec(Person y) {

		String nameI = name.replaceAll("\\s+", "").toLowerCase();
		String nameY = y.name.replaceAll("\\s+", "").toLowerCase();

		return nameI.compareTo(nameY) <= 0;
	}

	// Vorbedingung: o darf nicht null sein
	// Nachbedingung: true, wenn die Attribute von o gleich den Attributen des aktuellen Objekts sind
	@Override
	public boolean equals(Object o) {
		return this.toString().equals(o.toString());
	}

	// Nachbedinung: gibt den namen der person zurueck
	@Override
	public String toString() {
		return "Name: " + this.name;
	}
}
