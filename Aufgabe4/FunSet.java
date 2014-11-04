import java.util.ArrayList;
/**Ein Objekt des Typs FunSet stellt ein Paar Skier inklusive Bindungen und Stöcken,
 *  ein Snowboard inklusive Bindungen oder ähnliches dar. Je nach Produkt wird bereits 
 *  bei der Erstellung des Objekts eine maximale Anzahl an Verleihungen festgelegt, 
 *  die nicht überschritten werden darf. Folgende Methoden sind nur in benutztem 
 *  Zustand aufrufbar: Die Methode void service() sollte spätestens nach jeder dritten 
 *  Retournierung aufgerufen werden. Die Methode kontrolle() gibt beeinflusst durch Zufall
 *   true oder false zurück, aber true darf nur zurückgegeben werden, wenn die maximale 
 *   Anzahl an Verleihungen noch nicht überschritten und spätestens nach jeweils drei 
 *   Verleihungen zuvor service() aufgerufen wurde.*/
public class FunSet extends Set {

	private int maxVerleihungen;
	private int serviceCount;
	
	public FunSet(String name, int maxVerleihungen) {
		super(name);
		this.maxVerleihungen = maxVerleihungen;
		this.serviceCount = 0;
	}
	
	public void service() {
		if(this.serviceCount <= 3)
			this.serviceCount = 0;		
	}
	
	@Override
	public void retour() {
		if(zustand() != Zustand.verliehen)
			return;
		
		super.retour();
		this.serviceCount++;
	}
	
	@Override
	public void verleihe(String kunde) {
		if(zustand() != Zustand.verleihbar && maxVerleihungen > 0)	
			return;
		
		maxVerleihungen--;
		super.verleihe(kunde);	
	}
	
	@Override
	public boolean kontrolle() {
		if(serviceCount >= 4 && maxVerleihungen <= 0)
			return false;
		
		return super.kontrolle();
	}
	
}
