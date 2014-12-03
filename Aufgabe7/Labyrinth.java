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

		// create dumb path from a to b
		
		int hoehe, breite;
		hoehe = ameisenkolonieY - futterstelleY;
		breite = ameisenkolonieX - futterstelleX;
		
		while(breite != 0) {
			if(breite > 0) breite--;
			else breite++;
			
			felder[futterstelleY][futterstelleX + breite] = new Feld(futterstelleX + breite, futterstelleY);
		}
		while(hoehe != 0) {
			if(hoehe > 0) hoehe--;
			else hoehe++;
			
			felder[futterstelleY + hoehe][futterstelleX] = new Feld(futterstelleX, futterstelleY + hoehe);
		}
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

		int maxDuft = 1;
		for (int x = 0; x < getCols(); x++) {
			for (int y = 0; y < getRows(); y++) {
				get(x, y).lock();
				if (get(x, y).getDosis() > maxDuft) {
					maxDuft = get(x, y).getDosis();
				}
			}
		}

		for (int y = 0; y < getRows(); y++) {
			for (int x = 0; x < getCols(); x++) {
				if (y != 0) {
					if (get(x, y).hatMauerOben()) {
						output += "--";
					} else {
						output += "  ";
					}
				}
			}
			output += "\n";

			for (int x = 0; x < getCols(); x++) {
				int percentDosis = get(x, y).getDosis()*10/maxDuft;
				output += percentDosis == 10 ? 9 : percentDosis;
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
