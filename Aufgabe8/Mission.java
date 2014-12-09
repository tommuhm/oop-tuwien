
@Author(name = "Thomas Muhm")
public class Mission {

	private final String name;
	private MyLinkedList raumsonden;

	public Mission(String name) {
		this.name = name;
		this.raumsonden = new MyLinkedList();
	}

	public boolean addRaumsonde(String name) {
		return raumsonden.add(name, new Raumsonde(name));
	}

	public boolean addRaumsonde(Raumsonde raumsonde) {
		return raumsonden.add(raumsonde.getName(), raumsonde);
	}

	public boolean removeRaumsonde(String name) {
		return raumsonden.removeById(name);
	}

	public void printRaumsonden() {
		for (int i = 0; i < raumsonden.size(); i++) {
			System.out.println(raumsonden.get(i));
		}
	}

}
