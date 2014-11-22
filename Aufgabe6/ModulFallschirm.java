
public class ModulFallschirm extends ModulStark {

	public ModulFallschirm(int gewicht) {
		super(gewicht);
	}

	@Override
	public boolean funktioniertFuer(Gasplanet planet) {
		return false;
	}

	@Override
	public boolean funktioniertFuer(HimmelskoerperSchwach planet) {
		return false;
	}

	@Override
	public boolean funktioniertFuer(HimmelskoerperStark planet) {
		if(planet.hasAtmosphaere()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Modul clone() {
		return new ModulFallschirm(this.getGewicht());
	}

	@Override
	public String toString() {
		return "Modul für starke Grav. mit Fallschirm: " + this.getGewicht() + " kg";
	}
}
