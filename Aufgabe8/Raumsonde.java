
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
		return ("\n#######################\n"
				+ "Statistik RadRoboter Wegstrecken \n"
				+ "Bohrer:\n"
				+ " Anzahl: " + counterbohrer + '\n'
				+ " Insgesamt: " + wertbohrer + '\n'
				+ " Durchschnitt: " + wertbohrer/counterbohrer + '\n'
				+ "Kamera:\n"
				+ " Anzahl: " + counterkamera + '\n'
				+ " Insgesamt: " + wertkamera + '\n'
				+ " Durchschnitt: " + wertkamera/counterkamera + '\n'
				+ "Alle: RadRoboter\n"
				+ " Anzahl: " + (counterbohrer + counterkamera) + '\n'
				+ " Insgesamt: " + (wertbohrer + wertkamera) + '\n'
				+ " Durchschnitt: " + (counterbohrer + counterkamera)/(wertbohrer + wertkamera) 
				);
	}

	public String getSpruengeSchnitt() {
		double wertkamera = 0;
		double wertbohrer = 0;
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
		return ("\n#######################\n"
				+ "Statistik SprungRoboter Spruenge \n"
				+ "Bohrer:\n"
				+ " Anzahl: " + counterbohrer + '\n'
				+ " Insgesamt: " + wertbohrer + '\n'
				+ " Durchschnitt: " + wertbohrer/counterbohrer + '\n'
				+ "Kamera:\n"
				+ " Anzahl: " + counterkamera + '\n'
				+ " Insgesamt: " + wertkamera + '\n'
				+ " Durchschnitt: " + wertkamera/counterkamera + '\n'
				+ "Alle SprungRoboter: \n"
				+ " Anzahl: " + (counterbohrer + counterkamera) + '\n'
				+ " Insgesamt: " + (wertbohrer + wertkamera) + '\n'
				+ " Durchschnitt: " + (counterbohrer + counterkamera)/(wertbohrer + wertkamera) 
				);
	}

	public String getPixelSchnitt() {
		double wertrad = 0;
		double wertsprung = 0;
		int counterrad = 0;
		int countersprung = 0;
		for (int i = 0; i < maxValue; i++ ) {
			Erkundungsroboter rob = mylist.get(i);
			if ( rob.getEinsatzart() instanceof Kamera ) {
				if (rob instanceof SprungRoboter) {
					wertsprung += ((Kamera)rob.getEinsatzart()).getPixel();
					countersprung++;
				} else {
					wertrad += ((Kamera)rob.getEinsatzart()).getPixel();
					counterrad++;
				}
			}
		}
		return ("\n#######################\n"
				+ "Statistik Kamera \n"
				+ "RadRoboter:\n"
				+ " Anzahl: " + counterrad + '\n'
				+ " Insgesamt: " + wertrad + '\n'
				+ " Durchschnitt: " + wertrad/counterrad + '\n'
				+ "SprungRoboter:\n"
				+ " Anzahl: " + countersprung + '\n'
				+ " Insgesamt: " + wertsprung + '\n'
				+ " Durchschnitt: " + wertsprung/countersprung + '\n'
				+ "Alle Roboter mit Kamera: \n"
				+ " Anzahl: " + (counterrad + countersprung) + '\n'
				+ " Insgesamt: " + (wertrad + wertsprung) + '\n'
				+ " Durchschnitt: " + (countersprung + counterrad)/(wertrad + wertsprung) 
				);
	}

	public String getBohrerSchnitt() {
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
		return ("\n#######################\n"
				+ "Statistik Bohrer \n"
				+ "RadRoboter:\n"
				+ " Anzahl: " + counterrad + '\n'
				+ " Insgesamt: " + wertrad + '\n'
				+ " Durchschnitt: " + wertrad/counterrad + '\n'
				+ "SprungRoboter:\n"
				+ " Anzahl: " + countersprung + '\n'
				+ " Insgesamt: " + wertsprung + '\n'
				+ " Durchschnitt: " + wertsprung/countersprung + '\n'
				+ "Alle Roboter mit Bohrer: \n"
				+ " Anzahl: " + (counterrad + countersprung) + '\n'
				+ " Insgesamt: " + (wertrad + wertsprung) + '\n'
				+ " Durchschnitt: " + (countersprung + counterrad)/(wertrad + wertsprung) 
				);
	}
}
