public abstract class Himmelskoerper {
	
	private String name;
	
	public Himmelskoerper(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	abstract public boolean passtModul(Modul modul);
	
}