
public class ModulGas extends Modul {

	public ModulGas(int gewicht) {
		super(gewicht);
	}

	@Override
	public boolean funktioniertFuer(Gasplanet planet) {
		return true;
	}
	
	@Override
	public boolean funktioniertFuer(HimmelskoerperSchwach planet) {
		return false;
	}
	
	@Override
	public boolean funktioniertFuer(HimmelskoerperStark planet) {
		return false;
	}
	
	@Override
	public Modul clone() {
		return new ModulGas(this.getGewicht());
	}

	@Override
	public String toString() {
		return "Modul für Gasplaneten: " + this.getGewicht() + " kg";
	}
}
