public abstract class Planet {
	
	private String name;
	
	public Planet(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	abstract public boolean passtModul(Modul modul);
	
}