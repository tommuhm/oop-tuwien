
public abstract class Modul {
	
	private int gewicht;
	
	public Modul(int gewicht) {
		this.gewicht = gewicht;		
	}

	public int getGewicht() {
		return gewicht;
	}
	
	abstract public boolean funktioniertFuer(Gasplanet planet);
	abstract public boolean funktioniertFuer(HimmelskoerperSchwach planet);
	abstract public boolean funktioniertFuer(HimmelskoerperStark planet);
}
