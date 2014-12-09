
@Author(name = "David Jaffry")
public class Raumsonde {

	private final String name;
	private int maxValue = 0;
	private MyLinkedList mylist = new MyLinkedList();

	@Author(name = "David Jaffry")
	//Vorbedingung: String darf nicht null sein
	//Vorbedingung: String muss unique sein
	//Nachbedingung: Raumsonde erhaelt einen Namen
	public Raumsonde(String name) {
		this.name = name;
	}

	@Author(name = "David Jaffry")
	//Vorbedingung: rob darf nicht null sein
	//Nachbedingung: maxValue wird um eins erhoeht (es gibt ein element mehr in der liste), falls rob in die liste aufgenommen werden kann
	public boolean addRoboter(Erkundungsroboter rob) {
		boolean done = mylist.add(rob.getNummer(), rob);
		if (done) {
			maxValue++;
		}
		return done;
	}

	@Author(name = "David Jaffry")
	//Vorbedingung: nummer muss groesser gleich 0 sein
	//Vorbedingung: einsatzart muss entweder Bohrer oder Kamera sein
	//Nachbedingung: die einsatzart des ausgewaehlten roboters wird auf art geaendert
	public void modifyRoboter(int nummer, Einsatzart art) {
		((Erkundungsroboter) mylist.getById(nummer)).setEinsatzart(art);
	}

	@Author(name = "David Jaffry")
	//Vorbedingung: rob darf nicht null sein
	//Nachbedingung: rob wird aus der liste entfernt
	//Nachbedingung: die maximale anzahl der roboter in der liste maxValue verringert sich um 1
	public boolean removeRoboter(Erkundungsroboter rob) {
		boolean done = mylist.remove(rob);
		if (done) {
			maxValue--;
		}
		return done;
	}

	@Author(name = "David Jaffry")
	//Vorbedingung: rob darf nicht null sein
	//Nachbedingung: rob wird aus der liste entfernt
	//Nachbedingung: maxValue verringert sich um 1
	public boolean removeRoboter(int nummer) {
		boolean done = mylist.removeById(nummer);
		if (done) {
			maxValue--;
		}
		return done;
	}

	@Author(name = "David Jaffry")
	public String getName() {
		return name;
	}

	@Author(name = "David Jaffry")
	//Nachbedingungen: errechnet sich die betriebsstunden sortiert nach einsatzart und gibt diese als lesbaren String zurueck 
	//Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	public String getBetriebsstundenEinsatzartSchnitt() {
		if (maxValue < 1) {
			return null; //TODO
		}
		double wertbohrer = 0;
		double wertkamera = 0;
		int counterbohrer = 0;
		int counterkamera = 0;
		for (int i = 0; i < maxValue; i++) {
			Erkundungsroboter rob = (Erkundungsroboter) mylist.get(i);
			if (rob.getEinsatzart() instanceof Bohrer) {
				wertbohrer += ((RadRoboter) rob).getStunden();
				counterbohrer++;
			} else {
				wertkamera += ((SprungRoboter) rob).getStunden();
				counterkamera++;
			}
		}
		return ("\n### Statistik Betriebsstunden Einsatzart ###\n"
				+ "Schnitt - RadRoboter:\t " + wertbohrer + " / " + counterbohrer + " = " + wertbohrer / counterbohrer + '\n'
				+ "Schnitt - SprungRoboter:\t " + wertkamera + " / " + counterkamera + " = " + wertkamera / counterkamera + '\n'
				+ "Schnitt - Gesamt:\t " + (wertbohrer + wertkamera) + " / " + (counterbohrer + counterkamera) + " = " + (wertbohrer + wertkamera) / (counterbohrer + counterkamera) + '\n'
		);
	}

	@Author(name = "David Jaffry")
	//Nachbedingungen: errechnet sich die betriebsstunden sortiert nach bauart und gibt diese als lesbaren String zurueck 
	//Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	public String getBetriebsstundenBauartSchnitt() {
		if (maxValue < 1) {
			return ("\n### Keine Roboter in Raumsonde \"" + name + "\" ###");
		}
		double wertrad = 0;
		double wertsprung = 0;
		int counterrad = 0;
		int countersprung = 0;
		for (int i = 0; i < maxValue; i++) {
			Erkundungsroboter rob = (Erkundungsroboter) mylist.get(i);
			if (rob instanceof RadRoboter) {
				wertrad += ((RadRoboter) rob).getStunden();
				counterrad++;
			} else {
				wertsprung += ((SprungRoboter) rob).getStunden();
				countersprung++;
			}
		}
		return ("\n### Statistik Betriebsstunden Bauart ###\n"
				+ "Schnitt - RadRoboter:\t " + wertrad + " / " + counterrad + " = " + wertrad / counterrad + '\n'
				+ "Schnitt - SprungRoboter:\t " + wertsprung + " / " + countersprung + " = " + wertsprung / countersprung + '\n'
				+ "Schnitt - Gesamt:\t " + (wertrad + wertsprung) + " / " + (counterrad + countersprung) + " = " + (wertrad + wertsprung) / (counterrad + countersprung) + '\n'
		);
	}

	@Author(name = "David Jaffry")
	//Nachbedingung: errechnet sich die statistik zu radrobotern und gibt diese als lesbaren String zurueck
	//Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	public String getWegstreckeSchnitt() {
		if (maxValue < 1) {
			return ("\n### Keine Roboter in Raumsonde \"" + name + "\" ###");
		}
		double wertkamera = 0;
		double wertbohrer = 0;
		int counterkamera = 0;
		int counterbohrer = 0;
		for (int i = 0; i < maxValue; i++) {
			Erkundungsroboter rob = (Erkundungsroboter) mylist.get(i);
			if (rob instanceof RadRoboter) {
				if (rob.getEinsatzart() instanceof Bohrer) {
					wertbohrer += ((RadRoboter) rob).getWegstrecke();
					counterbohrer++;
				} else {
					wertkamera += ((RadRoboter) rob).getWegstrecke();
					counterkamera++;
				}
			}
		}
		return ("\n### Statistik RadRoboter Wegstrecken ###\n"
				+ "Schnitt - Bohrer:\t " + wertbohrer + " / " + counterbohrer + " = " + wertbohrer / counterbohrer + '\n'
				+ "Schnitt - Kamera:\t " + wertkamera + " / " + counterkamera + " = " + wertkamera / counterkamera + '\n'
				+ "Schnitt - Gesamt:\t " + (wertbohrer + wertkamera) + " / " + (counterbohrer + counterkamera) + " = " + (wertbohrer + wertkamera) / (counterbohrer + counterkamera) + '\n'
		);
	}

	@Author(name = "David Jaffry")
	//Nachbedingungen: errechnet sich die statistik zu spruenge von sprungrobotern und gibt diese als lesbaren String zurueck 
	//Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	public String getSpruengeSchnitt() {
		if (maxValue < 1) {
			return ("\n### Keine Roboter in Raumsonde \"" + name + "\"###");
		}
		int wertkamera = 0;
		int wertbohrer = 0;
		int counterkamera = 0;
		int counterbohrer = 0;
		for (int i = 0; i < maxValue; i++) {
			Erkundungsroboter rob = (Erkundungsroboter) mylist.get(i);
			if (rob instanceof SprungRoboter) {
				if (rob.getEinsatzart() instanceof Bohrer) {
					wertbohrer += ((SprungRoboter) rob).getSpruenge();
					counterbohrer++;
				} else {
					wertkamera += ((SprungRoboter) rob).getSpruenge();
					counterkamera++;
				}
			}
		}

		return ("\n### Statistik SprungRoboter Spruenge ###\n"
				+ "Schnitt - Bohrer:\t " + wertbohrer + " / " + counterbohrer + " = " + wertbohrer / counterbohrer + '\n'
				+ "Schnitt - Kamera:\t " + wertkamera + " / " + counterkamera + " = " + wertkamera / counterkamera + '\n'
				+ "Schnitt - Gesamt:\t " + (wertbohrer + wertkamera) + " / " + (counterbohrer + counterkamera) + " = " + (wertbohrer + wertkamera) / (counterbohrer + counterkamera) + '\n'
		);
	}

	@Author(name = "David Jaffry")
	//Nachbedingungen: errechnet sich die statistik zu robotern mit kamera und gibt diese als lesbaren String zurueck 
	//Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	public String getMinMaxPixel() {
		if (maxValue < 1) {
			return ("\n### Keine Roboter in Raumsonde \"" + name + "\"###");
		}
		int minrad = 0;
		int maxrad = 0;
		int minsprung = 0;
		int maxsprung = 0;
		for (int i = 0; i < maxValue; i++) {
			Erkundungsroboter rob = (Erkundungsroboter) mylist.get(i);
			if (rob.getEinsatzart() instanceof Kamera) {
				if (rob instanceof RadRoboter) {
					if (minrad > ((Kamera) rob.getEinsatzart()).getPixel()) {
						minrad = ((Kamera) rob.getEinsatzart()).getPixel();
					}
					if (maxrad < ((Kamera) rob.getEinsatzart()).getPixel()) {
						maxrad = ((Kamera) rob.getEinsatzart()).getPixel();
					}
				} else {
					if (minsprung > ((Kamera) rob.getEinsatzart()).getPixel()) {
						minsprung = ((Kamera) rob.getEinsatzart()).getPixel();
					}
					if (maxsprung < ((Kamera) rob.getEinsatzart()).getPixel()) {
						maxsprung = ((Kamera) rob.getEinsatzart()).getPixel();
					}

				}
			}
		}
		int min = (minrad < minsprung) ? minrad : minsprung;
		int max = (maxrad > maxsprung) ? maxrad : maxsprung;

		return ("\n### Statistik Kamera ###\n"
				+ "RadRoboter:\t " + " Min: " + minrad + "\t Max: " + maxrad + '\n'
				+ "SprungRoboter:\t " + " Min: " + minsprung + "\t Max: " + maxrad + '\n'
				+ "Gesamt:\t " + " Min: " + min + "\t Max " + max + '\n'
		);
	}

	@Author(name = "David Jaffry")
	//Nachbedingungen: errechnet sich die statistik zu robotern mit bohrern und gibt diese als lesbaren String zurueck 
	//Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	public String getBohrerSchnitt() {
		if (maxValue < 1) {
			return ("\n### Keine Roboter in Raumsonde \"" + name + "\"###");
		}
		double wertrad = 0;
		double wertsprung = 0;
		int counterrad = 0;
		int countersprung = 0;
		for (int i = 0; i < maxValue; i++) {
			Erkundungsroboter rob = (Erkundungsroboter) mylist.get(i);
			if (rob.getEinsatzart() instanceof Bohrer) {
				if (rob instanceof SprungRoboter) {
					wertsprung += ((Bohrer) rob.getEinsatzart()).getLaenge();
					countersprung++;
				} else {
					wertrad += ((Bohrer) rob.getEinsatzart()).getLaenge();
					counterrad++;
				}
			}
		}

		return ("\n### Statistik Bohrer ###\n"
				+ "Schnitt - RadRoboter:\t " + wertrad + " / " + counterrad + " = " + wertrad / counterrad + '\n'
				+ "Schnitt - SprungRoboter:\t " + wertsprung + " / " + countersprung + " = " + wertsprung / countersprung + '\n'
				+ "Schnitt - Gesamt:\t " + (wertrad + wertsprung) + " / " + (countersprung + counterrad) + " = " + (wertrad + wertsprung) / (counterrad + countersprung) + '\n'
		);
	}

	@Author(name = "David Jaffry")
	@Override
	//Nachbedingung: gibt einen string mit dem namen der raumsonde und der anzahl der gespeicherten roboter zurueck
	public String toString() {
		return "Raumsonde " + name + ", Roboter: " + maxValue;
	}
}
