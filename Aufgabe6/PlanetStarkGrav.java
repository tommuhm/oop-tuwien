public class PlanetStarkGrav extends PlanetFest {

	private boolean atmosphaere;
	
	public PlanetStarkGrav(String name, boolean atmosphaere) {
		super(name);
		this.atmosphaere = atmosphaere;
	}
	
	public boolean hasAtmosphaere() {
		return atmosphaere;
	}	
}
