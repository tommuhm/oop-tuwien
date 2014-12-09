import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Author(name = "David Jaffry")
public class Raumsonde {

	private final String name;
	private final MyLinkedList roboterList;

	@Author(name = "David Jaffry")
	// Vorbedingung: String darf nicht null sein
	// Vorbedingung: String muss unique sein
	// Nachbedingung: Raumsonde erhaelt einen Namen
	public Raumsonde(String name) {
		this.name = name;
		this.roboterList = new MyLinkedList();
	}

	@Author(name = "David Jaffry")
	// Vorbedingung: rob darf nicht null sein
	// Nachbedingung: gibt true zurueck wenn rob zu der sonde hinzugefuegt wurde
	// Nachbedingung: gibt false zurueck wenn der roboter bereits in der raumsonde vorhanden ist
	public boolean addRoboter(Erkundungsroboter rob) {
		return roboterList.add(rob.getNummer(), rob);
	}

	@Author(name = "David Jaffry")
	// Vorbedingung: roboter mit der angebenen nummer muss in der sonde vorhanden sein
	// Vorbedingung: art darf nicht null sein
	// Nachbedingung: die einsatzart des ausgewaehlten roboters wird auf art geaendert
	public void modifyRoboter(int nummer, Einsatzart art) {
		Object o = roboterList.getById(nummer);
		if (o != null && o instanceof Erkundungsroboter) {
			Erkundungsroboter roboter = (Erkundungsroboter) o;
			roboter.setEinsatzart(art);
		}
	}

	@Author(name = "David Jaffry")
	// Nachbedingung: true wenn der roboter mit der angebenen nummer aus der raumsonde entfernt wurde
	// Nachbedingung: false wenn der roboter mit der angebenen nummer nicht in der raumsonde existiert
	public boolean removeRoboter(int nummer) {
		return roboterList.removeById(nummer);
	}

	@Author(name = "David Jaffry")
	// Nachbedingung: gibt den namen der raumsonde zurueck
	public String getName() {
		return name;
	}

	// Vorbedingung: statistikName, filterClass, classCheck1, classCheck2, methodName duerfen nicht null sein
	// Vorbedingung: methodName muss eine gueltige Methode von Roboter oder Einsatzart sein (wird ueber reflection aufgerufen)
	// Nachbedingung: erstellt eine Statistik ueber alle Roboter der Sonde fuer die angebenen Parameter
	// Parameter:
	// 		statistikName: name der Statistik (in der Ausgabe)
	// 		filterClass: jeder Roboter muss eine instance dieser Klasse sein
	// 		checkEinsatzart: gibt an ob classCheck1 und classCheck2 auf den Roboter oder auf dessen Einsatzart angewendet wird
	// 		useEinsatzartMethod: gibt an ob die methode von Roboter oder von dessen Einsatzart verwendet werden soll
	//	 	methodName: name der Methode, welche ueber refection von Roboter oder Einsatzart ausgefuert wird
	@Author(name = "Thomas Muhm")
	private String getStatistik(String statistikName, Class filterClass, boolean checkEinsatzart, Class classCheck1, Class classCheck2, boolean useEinsatzartMethod, String methodName) {
		if (roboterList.size() == 0) {
			return ("\n### Keine Roboter in Raumsonde '" + name + "' vorhanden ###");
		}
		double stundenClass1 = 0;
		double stundenClass2 = 0;
		int anzClass1 = 0;
		int anzClass2 = 0;
		try {
			for (int i = 0; i < roboterList.size(); i++) {
				Object o = roboterList.get(i);
				if (o instanceof Erkundungsroboter) {
					Erkundungsroboter rob = (Erkundungsroboter) o;
					if (filterClass.isInstance(rob) || filterClass.isInstance(rob.getEinsatzart())) {
						if (useEinsatzartMethod) {
							o = rob.getEinsatzart();
						}
						Method method = o.getClass().getMethod(methodName);
						Object value = method.invoke(o);

						if ((checkEinsatzart && classCheck1.isInstance(rob.getEinsatzart())) || (!checkEinsatzart && classCheck1.isInstance(rob))) {

							if (value instanceof Integer) {
								stundenClass1 += (Integer) value;
							} else if (value instanceof Double) {
								stundenClass1 += (Double) value;
							}

							anzClass1++;
						} else if ((checkEinsatzart && classCheck2.isInstance(rob.getEinsatzart())) || (!checkEinsatzart && classCheck2.isInstance(rob))) {

							if (value instanceof Integer) {
								stundenClass2 += (Integer) value;
							} else if (value instanceof Double) {
								stundenClass2 += (Double) value;
							}

							anzClass2++;
						}
					}
				}
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return ("\n### " + statistikName + " ###\n"
				+ "Schnitt - " + classCheck1.getName() + ":\t " + stundenClass1 + " / " + anzClass1 + " = " + stundenClass1 / (anzClass1 != 0 ? anzClass1 : 1) + '\n'
				+ "Schnitt - " + classCheck2.getName() + ":\t " + stundenClass2 + " / " + anzClass2 + " = " + stundenClass2 / (anzClass2 != 0 ? anzClass2 : 1) + '\n'
				+ "Schnitt - Gesamt:\t " + (stundenClass1 + stundenClass2) + " / " + (anzClass1 + anzClass2) + " = " + (stundenClass1 + stundenClass2) / (anzClass1 + anzClass2 != 0 ? anzClass1 + anzClass2 : 1) + '\n'
		);
	}

	// Nachbedingung: errechnet die betriebsstunden sortiert nach einsatzart und gibt diese als lesbaren String zurueck
	// Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	@Author(name = "David Jaffry")
	public String getBetriebsstundenEinsatzartSchnitt() {
		return getStatistik("Statistik Betriebsstunden Einsatzart", Erkundungsroboter.class, true, Bohrer.class, Kamera.class, false, "getStunden");
	}

	// Nachbedingung: errechnet die betriebsstunden sortiert nach bauart und gibt diese als lesbaren String zurueck
	// Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	@Author(name = "David Jaffry")
	public String getBetriebsstundenBauartSchnitt() {
		return getStatistik("Statistik Betriebsstunden Bauart", Erkundungsroboter.class, false, RadRoboter.class, SprungRoboter.class, false, "getStunden");
	}

	// Nachbedingung: errechnet die statistik zu radrobotern und gibt diese als lesbaren String zurueck
	// Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	@Author(name = "David Jaffry")
	public String getWegstreckeSchnitt() {
		return getStatistik("Statistik RadRoboter Wegstrecken", RadRoboter.class, true, Bohrer.class, Kamera.class, false, "getWegstrecke");
	}

	@Author(name = "David Jaffry")
	// Nachbedingung: errechnet die statistik zu spruenge von sprungrobotern und gibt diese als lesbaren String zurueck
	// Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	public String getSpruengeSchnitt() {
		return getStatistik("Statistik SprungRoboter Spruenge", SprungRoboter.class, true, Bohrer.class, Kamera.class, false, "getSpruenge");
	}

	// Nachbedingung: errechnet die statistik zu robotern mit bohrern und gibt diese als lesbaren String zurueck
	// Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	@Author(name = "David Jaffry")
	public String getBohrerSchnitt() {
		return getStatistik("Statistik Bohrer", Bohrer.class, false, RadRoboter.class, SprungRoboter.class, true, "getLaenge");
	}

	@Author(name = "David Jaffry")
	// Nachbedingung: errechnet die statistik zu robotern mit kamera und gibt diese als lesbaren String zurueck
	// Nachbedingung: falls keine roboter in der raumsonde verfuegbar sind dann wird ein string ohne statistik zurueckgegeben
	public String getMinMaxPixel() {
		if (roboterList.size() == 0) {
			return ("\n### Keine Roboter in Raumsonde '" + name + "' vorhanden ###");
		}
		int minrad = 0;
		int maxrad = 0;
		int minsprung = 0;
		int maxsprung = 0;
		for (int i = 0; i < roboterList.size(); i++) {
			Object o = roboterList.get(i);
			if (o instanceof Erkundungsroboter) {
				Erkundungsroboter rob = (Erkundungsroboter) o;
				if (rob.getEinsatzart() instanceof Kamera) {
					if (rob instanceof RadRoboter) {
						if (minrad > ((Kamera) rob.getEinsatzart()).getPixel()) {
							minrad = ((Kamera) rob.getEinsatzart()).getPixel();
						}
						if (maxrad < ((Kamera) rob.getEinsatzart()).getPixel()) {
							maxrad = ((Kamera) rob.getEinsatzart()).getPixel();
						}
					} else if (rob instanceof SprungRoboter) {
						if (minsprung > ((Kamera) rob.getEinsatzart()).getPixel()) {
							minsprung = ((Kamera) rob.getEinsatzart()).getPixel();
						}
						if (maxsprung < ((Kamera) rob.getEinsatzart()).getPixel()) {
							maxsprung = ((Kamera) rob.getEinsatzart()).getPixel();
						}
					}
				}
			}
		}
		int min = (minrad < minsprung) ? minrad : minsprung;
		int max = (maxrad > maxsprung) ? maxrad : maxsprung;

		return ("\n### Statistik Kamera ###\n"
				+ "Pixel - RadRoboter:\t " + " min: " + minrad + ", max: " + maxrad + '\n'
				+ "Pixel - SprungRoboter:\t " + " min: " + minsprung + ", max: " + maxrad + '\n'
				+ "Pixel - Gesamt:\t " + " min: " + min + ", max " + max + '\n'
		);
	}

	@Override
	@Author(name = "David Jaffry")
	// Nachbedingung: gibt einen string mit dem namen der raumsonde und der anzahl der gespeicherten roboter zurueck
	public String toString() {
		return "Raumsonde " + name + ", anzahl Roboter: " + roboterList.size();
	}
}
