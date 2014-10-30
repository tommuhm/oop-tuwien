public class ProfiSet extends Set {

	private boolean serviceAusgefuehrt;
	private boolean serviceImmerAusgefuehrt;
	
	public ProfiSet() {
		super();
		this.serviceAusgefuehrt = true;
		this.serviceImmerAusgefuehrt = true;
	}
	
	public void service() {
		//Service ausführen.
		this.serviceAusgefuehrt = true;		
	}
	
	@Override
	public void retour() {
		if(zustand() != Zustand.verliehen)
			return;
		
		super.retour();
		
		if(!this.serviceAusgefuehrt) this.serviceImmerAusgefuehrt = false;
		this.serviceAusgefuehrt = false;
	}
	
	@Override
	public boolean kontrolle() {
		if(this.serviceImmerAusgefuehrt)
			return super.kontrolle();
		else
			return false;
	}
}
