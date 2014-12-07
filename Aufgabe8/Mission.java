
@Author(name = "Thomas Muhm")
public class Mission {

	private final String name;
	private MyLinkedList<Raumsonde> raumsonden;

	public Mission(String name) {
		this.name = name;
		this.raumsonden = new MyLinkedList<Raumsonde>();
	}

	public void addRaumsonde(Raumsonde raumsonde) {
		raumsonden.add(raumsonde);
	}

	public boolean removeRaumsonde(Raumsonde raumsonde) {
		return raumsonden.remove(raumsonde);
	}

	public void printRaumstonden() {
		for (int i = 0; i < raumsonden.size(); i++) {
			System.out.println(raumsonden.get(i));
		}
	}

}
