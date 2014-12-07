
public class Raumsonde {
	
	final String name;
	MyLinkedList mylist = new MyLinkedList();

	
	public Raumsonde( String name ) {
		this.name = name;
	}
	

	public void addRoboter(Erkundungsroboter rob) {
		mylist.add(rob);
	}

	public boolean modifyRoboter(Erkundungsroboter rob) {
		
		return false;
	}

	public boolean removeRoboter(Erkundungsroboter rob) {
		return mylist.remove(rob);
	}


	public String getBetriebsstundenEinsatzartSchnitt() { //aufgeschluesselt nach Bohrer, Foto
		return null;
	}
	
	public String getBetriebsstundenBauartSchnitt() { //aufgeschluesselt Spring, Rad
		return null;
	}
	
	public String getWegstreckeSchnitt() {
		return null;
	}
	
	public String getSpruengeSchnitt() {
		return null;
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
