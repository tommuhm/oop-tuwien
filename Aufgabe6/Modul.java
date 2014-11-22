
public abstract class Modul {
	
	private int gewicht;
	
	public Modul(int gewicht) {
		this.gewicht = gewicht;		
	}

	abstract public boolean funktioniertFuer(PlanetGas planet);
	abstract public boolean funktioniertFuer(PlanetSchwachGrav planet);
	abstract public boolean funktioniertFuer(PlanetStarkGrav planet);
}
