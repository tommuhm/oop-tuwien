
public abstract class Person implements Prec {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public boolean prec(Object y) {
		if (y instanceof Person) {
			String nameI, nameY;
			nameI = name.toLowerCase();
			nameY = ((Person) y).name.toLowerCase();

			nameI = nameI.replaceAll(" ", "");
			nameY = nameY.replaceAll(" ", "");
			
			
			return nameI.compareTo(nameY) <= 0; //Equals oder nameI ist alphabetisch kleiner 
		}

		return false;
	}


}
