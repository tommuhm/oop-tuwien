
public class Raumsonde {

	final String name;
	MyLinkedList mylist = new MyLinkedList();

	
	public Raumsonde( String name ) {
		this.name = name;
	}
	

	public boolean addRoboter(ErkundungsRoboter rob) {
		return mylist.add(rob);
	}

	public boolean modifyRoboter(ErkundungsRoboter rob) {
		
		return false;
	}

	public boolean removeRoboter(ErkundungsRoboter rob) {
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
