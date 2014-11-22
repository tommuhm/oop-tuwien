
public class Mission {

	private String name;
	private RaumSonde raumsonde;
	
	public Mission (String name, RaumSonde raumsonde){
		this.name = name;
		this.raumsonde = raumsonde;
	}
	
	public Mission (String name) {
		this.name = name;
		this.raumsonde = new RaumSonde();
	}
	
	public Modul add(Himmelskoerper himmelskoerper) {
		//TODO implement add.
		return null;
	}
	
	
	public Himmelskoerper remove (String name) {
		//TODO implement remove.
		return null;
	}

	public void missionslist() {
		//TODO implement
		return;
	}

	public void utilization() {
		//TODO implement
		return;
	}
}
