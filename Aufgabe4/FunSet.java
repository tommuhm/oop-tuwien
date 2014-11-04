public class FunSet extends Set {

	private int maxVerleihungen;
	private int serviceCount;
	
	//Vorbedingung: name darf nicht NULL sein. ServiceCount wird auf 0 gesetzt. 
	public FunSet(String name, int maxVerleihungen) {
		super(name);
		this.maxVerleihungen = maxVerleihungen;
		this.serviceCount = 0;
	}
	
	//Nachbedingung: ServiceCount wird auf 0 gesetzt.
	public void service() {
		if(this.serviceCount <= 3) //Angabe unklar: wissen nicht, was passier, falls der Artikel 4 mal gebraucht wurde, ohne dass ein Service durchgefuehrt worden ist. 
			this.serviceCount = 0;		 
	}
	
	//Nachbedingung: Ggstand wird zurueckgegeben, Zustand geht auf verliehen. ServiceCount wird um 1 erhoeht.
	@Override
	public void retour() {
		if(zustand() != Zustand.verliehen)
			return;
		
		super.retour();
		this.serviceCount++;
	}
	//Vorbedingung: Der Zustand des Ggstd muss verleihbar sein, und es muss mindestens ein Gegenstand noch vorhanden sein.
	//Nachbedingung: Die Anzahl wird um ein Stueck verringert.
	@Override
	public void verleihe(String kunde) {
		if(zustand() != Zustand.verleihbar && maxVerleihungen > 0)	
			return;
		
		maxVerleihungen--;
		super.verleihe(kunde);	
	}
	//Nachbedingung: siehe ArtikelKlasse.kontrolle, zusaetzlich wird geprueft, ob die Artikelanzahl noch ein gueltiger Wert ist und der Ggstd noch in Ordnung ist.
	@Override
	public boolean kontrolle() {
		if(serviceCount >= 4 && maxVerleihungen <= 0)
			return false;
		
		return super.kontrolle();
	}
	
}
