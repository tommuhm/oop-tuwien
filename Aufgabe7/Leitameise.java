public class Leitameise extends Ameise {

	private int anzZuege;

	public Leitameise(Kammer[][] labyrinth, Kammer ameisenkolonie, Strategie strategie, int anzZuege) {
		super(labyrinth, ameisenkolonie, strategie);
		this.anzZuege = anzZuege;
	}

	@Override
	public void run() {
		try {
			while (anzZuege > 0) {
				next();
				synchronized (this) {
					anzZuege--;
					notify();
					wait();
				}
			}
		} catch (InterruptedException e) {
			this.interrupt();
		}
	}

}
