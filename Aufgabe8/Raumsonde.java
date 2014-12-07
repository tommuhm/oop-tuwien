import MyLinkedList.Node;


public class Raumsonde {

	final String name;
	static int maxValue = 0; 
	MyLinkedList mylist = new MyLinkedList();


	public Raumsonde( String name ) {
		this.name = name;
	}


	public void addRoboter(Erkundungsroboter rob) {
		mylist.add(rob);
		maxValue++;
	}

	public void modifyRoboter(Erkundungsroboter rob, Einsatzart art) {
		rob.setEinsatzart(art);
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
			if ((Erkundungsroboter) mylist.get(i) instanceof RadRoboter ) {
				if (((RadRoboter) mylist.get(i)).getEinsatzart() instanceof Bohrer) {
					wertbohrer += ((RadRoboter) mylist.get(i)).getWegstrecke();
					counterbohrer++;
				} else {
					wertkamera += ((RadRoboter) mylist.get(i)).getWegstrecke();
					counterkamera++;
				}
			}
		}
		System.out.println("\n#######################\n"
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
			if ((Erkundungsroboter) mylist.get(i) instanceof SprungRoboter ) {
				if (((SprungRoboter) mylist.get(i)).getEinsatzart() instanceof Bohrer) {
					wertbohrer += ((SprungRoboter) mylist.get(i)).getSpruenge();
					counterbohrer++;
				} else {
					wertkamera += ((SprungRoboter) mylist.get(i)).getSpruenge();
					counterkamera++;
				}
			}
		}
		System.out.println("\n#######################\n"
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

	public String getMaxKameraPixel() {
		return null;
	}

	public String getMinKameraPixel() {
		return null;
	}

	public String getBohrerSchnitt() {
		return null;
	}



}
