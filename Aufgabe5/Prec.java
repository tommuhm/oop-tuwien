
public interface Prec<E> {

	//Vorbedingung: x darf nicht null sein
	//Nachbedingung: vergleicht zwei Objekte zusammenpassender Typen miteinander
	public boolean prec(E x);

}
