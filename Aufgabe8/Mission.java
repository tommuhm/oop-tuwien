
@Author(name = "Thomas Muhm")
public class Mission {

	private final String name;
	private MyLinkedList raumsonden;

	@Author(name = "Thomas Muhm")
	public Mission(String name) {
		this.name = name;
		this.raumsonden = new MyLinkedList();
	}

	@Author(name = "Thomas Muhm")
	public boolean addRaumsonde(String name) {
		return raumsonden.add(name, new Raumsonde(name));
	}

	@Author(name = "Thomas Muhm")
	public boolean addRaumsonde(Raumsonde raumsonde) {
		return raumsonden.add(raumsonde.getName(), raumsonde);
	}

	@Author(name = "Thomas Muhm")
	public boolean removeRaumsonde(String name) {
		return raumsonden.removeById(name);
	}

	@Author(name = "Thomas Muhm")
	public void printRaumsonden() {
		for (int i = 0; i < raumsonden.size(); i++) {
			System.out.println(raumsonden.get(i));
		}
	}

}
