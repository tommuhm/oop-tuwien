
@Author(name = "Thomas Muhm")
public class Mission {

	private final String name;
	private MyLinkedList raumsonden;

	@Author(name = "Thomas Muhm")
	public Mission(String name) {
		this.name = name;
		this.raumsonden = new MyLinkedList();
	}

	// Vorbedingung: raumsonde darf nicht null sein
	// Nachbedingung: gibt true zurueck wenn die raumsonde zu der mission hinzugefuegt wurde
	// Nachbedingung: gibt false zurueck wenn die raumsonde zu der mission nicht hinzugefuegt werden konnte
	@Author(name = "Thomas Muhm")
	public boolean addRaumsonde(Raumsonde raumsonde) {
		return raumsonden.add(raumsonde.getName(), raumsonde);
	}

	// Vorbedingung: name darf nicht null sein
	// Nachbedingung: gibt true zurueck wenn die raumsonde aus der mission entfernt wurde
	// Nachbedingung: gibt false zurueck wenn die raumsonde nicht an der mission teilnimmt
	@Author(name = "Thomas Muhm")
	public boolean removeRaumsonde(String name) {
		return raumsonden.removeById(name);
	}

	// Nachbedingung: gibt alle raumsonden aus
	@Author(name = "Thomas Muhm")
	public void printRaumsonden() {
		for (int i = 0; i < raumsonden.size(); i++) {
			System.out.println(raumsonden.get(i));
		}
	}

}
