
public class Raumsonde {

	private final String name;
	private int maxValue = 0; 
	MyLinkedList<Erkundungsroboter> mylist = new MyLinkedList<Erkundungsroboter>();


	public Raumsonde( String name ) {
		this.name = name;
	}

	public void addRoboter(Erkundungsroboter rob) {
		mylist.add(rob);
		maxValue++;
	}

	public void modifyRoboter(int index, Einsatzart art) {
		((Erkundungsroboter) mylist.get(index)).setEinsatzart(art);
	}

	public boolean removeRoboter(Erkundungsroboter rob) {
		maxValue--;
		return mylist.remove(rob);
	}

	public String getBetriebsstundenEinsatzartSchnitt() { //aufgeschluesselt nach Bohrer, Foto
		return null;
	}

	public String getBetriebsstundenBauartSchnitt() { //aufgeschluesselt Spring, Rad
		return null;
	}

	public String getWegstreckeSchnitt() {
		if (maxValue < 1) {
			return null;
		}
		double wertkamera = 0;
		double wertbohrer = 0;
		int counterkamera = 0;
		int counterbohrer = 0;
		for (int i = 0; i < maxValue; i++ ) {
			Erkundungsroboter rob = mylist.get(i);
			if ( rob instanceof RadRoboter ) {
				if ( rob.getEinsatzart() instanceof Bohrer) {
					wertbohrer += ((RadRoboter) rob).getWegstrecke();
					counterbohrer++;
				} else {
					wertkamera += ((RadRoboter) rob).getWegstrecke();
					counterkamera++;
				}
			}
		}
		return ("\n### Statistik RadRoboter Wegstrecken ###\n"
				+ "Schnitt - Bohrer:\t " + wertbohrer + " / " + counterbohrer + " = " + wertbohrer/counterbohrer  + '\n' 
				+ "Schnitt - Kamera:\t " + wertkamera + " / " + counterkamera + " = " + wertkamera/counterkamera  + '\n' 
				+ "Schnitt - Gesamt:\t " + (wertbohrer + wertkamera)  + " / " + (counterbohrer + counterkamera) + " = "  + (wertbohrer + wertkamera)/(counterbohrer + counterkamera) + '\n'
				);
	}

	public String getSpruengeSchnitt() {
		if (maxValue < 1) {
			return null;
		}
		int wertkamera = 0;
		int wertbohrer = 0;
		int counterkamera = 0;
		int counterbohrer = 0;
		for (int i = 0; i < maxValue; i++ ) {
			Erkundungsroboter rob = mylist.get(i);
			if ( rob instanceof SprungRoboter ) {
				if ( rob.getEinsatzart() instanceof Bohrer) {
					wertbohrer += ((SprungRoboter) rob).getSpruenge();
					counterbohrer++;
				} else {
					wertkamera += ((SprungRoboter) rob).getSpruenge();
					counterkamera++;
				}
			}
		}
		
		return ("\n### Statistik SprungRoboter Spruenge ###\n"
				+ "Schnitt - Bohrer:\t " + wertbohrer + " / " + counterbohrer + " = " + wertbohrer/counterbohrer  + '\n' 
				+ "Schnitt - Kamera:\t " + wertkamera + " / " + counterkamera + " = " + wertkamera/counterkamera  + '\n' 
				+ "Schnitt - Gesamt:\t " + (wertbohrer + wertkamera)  + " / " + (counterbohrer + counterkamera) + " = "  + (wertbohrer + wertkamera)/(counterbohrer + counterkamera) + '\n'
				);
	}

	public String getMinMaxPixel() {
		if (maxValue < 1) {
			return null;
		}
		int minrad = 0;
		int maxrad = 0;
		int minsprung = 0;
		int maxsprung = 0;
		for (int i = 0; i < maxValue; i++ ) {
			Erkundungsroboter rob = mylist.get(i);
			if ( rob.getEinsatzart() instanceof Kamera ) {
				if (rob instanceof RadRoboter) {
					if (minrad > ((Kamera)rob.getEinsatzart()).getPixel()) {
						minrad = ((Kamera)rob.getEinsatzart()).getPixel();
					}
					if (maxrad < ((Kamera)rob.getEinsatzart()).getPixel()) {
						maxrad = ((Kamera)rob.getEinsatzart()).getPixel();
					}
				} else {
					if (minsprung > ((Kamera)rob.getEinsatzart()).getPixel()) {
						minsprung = ((Kamera)rob.getEinsatzart()).getPixel();
					}
					if (maxsprung < ((Kamera)rob.getEinsatzart()).getPixel()) {
						maxsprung = ((Kamera)rob.getEinsatzart()).getPixel();
					}
					
				}
			}
		}
		int min = (minrad < minsprung) ? minrad : minsprung;
		int max = (maxrad > maxsprung) ? maxrad : maxsprung;
		
		return ("\n### Statistik Kamera ###\n"
				+ "RadRoboter:\t " + " Min: " + minrad + "\t Max: " + maxrad + '\n' 
				+ "SprungRoboter:\t " + " Min: " + minsprung  + "\t Max: " + maxrad + '\n' 
				+ "Gesamt:\t " + " Min: " + min +  "\t Max " + max + '\n'
				);
	}

	public String getBohrerSchnitt() {
		if (maxValue < 1) {
			return null;
		}
		double wertrad = 0;
		double wertsprung = 0;
		int counterrad = 0;
		int countersprung = 0;
		for (int i = 0; i < maxValue; i++ ) {
			Erkundungsroboter rob = mylist.get(i);
			if ( rob.getEinsatzart() instanceof Bohrer ) {
				if (rob instanceof SprungRoboter) {
					wertsprung += ((Bohrer)rob.getEinsatzart()).getLaenge();
					countersprung++;
				} else {
					wertrad += ((Bohrer)rob.getEinsatzart()).getLaenge();
					counterrad++;
				}
			}
		}
		
		return ("\n### Statistik Bohrer ###\n"
				+ "Schnitt - RadRoboter:\t " + wertrad + " / " + counterrad + " = " + wertrad/counterrad  + '\n' 
				+ "Schnitt - SprungRoboter:\t " + wertsprung + " / " + countersprung + " = " + wertsprung/countersprung  + '\n' 
				+ "Schnitt - Gesamt:\t " + (wertrad + wertsprung)  + " / " + (countersprung + counterrad) + " = "  + (wertrad + wertsprung)/(counterrad + countersprung) + '\n'
				);
	}
	@Override
	public String toString() {
		return "Raumsonde " + name + ", Roboter: " + maxValue;
	}
}
