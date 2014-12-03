import java.util.Random;

public class Labyrinth {

	private final Feld[][] felder;
	private final FeldAmeisenkolonie ameisenkolonie;
	private final FeldFutterstelle futterstelle;
	private final int rows;
	private final int cols;

	public Labyrinth(int cols, int rows) {
		this.cols = cols;
		this.rows = rows;

		this.felder = new Feld[rows][cols];

		Random rand = new Random();
		for (int x = 0; x < cols; x++) {
			for (int y = 0; y < rows; y++) {
				boolean mauerOben = (rand.nextInt(10) < 3 ? true : false);
				boolean mauerRechts = (rand.nextInt(10) < 3 ? true : false);
				felder[y][x] = new Feld(x, y, mauerOben, mauerRechts);
			}
		}

		int ameisenkolonieX = rand.nextInt(cols);
		int ameisenkolonieY = rand.nextInt(rows);
		int futterstelleX = rand.nextInt(cols);
		int futterstelleY = rand.nextInt(rows);

		ameisenkolonie = new FeldAmeisenkolonie(get(ameisenkolonieX, ameisenkolonieY));
		futterstelle = new FeldFutterstelle(get(futterstelleX, futterstelleY));
		felder[ameisenkolonieY][ameisenkolonieX] = ameisenkolonie;
		felder[futterstelleY][futterstelleX] = futterstelle;

		// remove walls
		// TODO

	}

	// felder x between 1 and 500
	public Labyrinth(Feld[][] felder, FeldAmeisenkolonie ameisenkolonie, FeldFutterstelle futterstelle) {
		this.felder = felder;
		this.rows = felder.length;
		this.cols = felder[0].length;
		this.ameisenkolonie = ameisenkolonie;
		this.futterstelle = futterstelle;
	}

	public Feld get(int x, int y) {
		return felder[y][x];
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public FeldFutterstelle getFutterstelle() {
		return futterstelle;
	}

	public FeldAmeisenkolonie getAmeisenkolonie() {
		return ameisenkolonie;
	}

	@Override
	public String toString() {

		String output = "";

		int duftspur = 0;
		for (int x = 0; x < getCols(); x++) {
			for (int y = 0; y < getRows(); y++) {
				duftspur += get(x, y).getDosis();
				get(x, y).lock();
			}
		}

		for (int y = 0; y < getRows(); y++) {
			for (int x = 0; x < getCols(); x++) {
				if (y != 0) {
					if (get(x, y).hatMauerOben()) {
						output += "--\n";
					} else {
						output += "  \n";
					}
				}
			}
			System.out.println();

			for (int x = 0; x < getCols(); x++) {
				System.out.print(get(x, y).getDosis());
				if (get(x, y).hatMauerRechts()) {
					output += "|";
				} else {
					output += " ";
				}
			}
			output += "\n";
		}

		// unlock labyrinth
		for (int x = 0; x < getCols(); x++) {
			for (int y = 0; y < getRows(); y++) {
				get(x, y).unlock();
			}
		}

		return output;
	}

}
