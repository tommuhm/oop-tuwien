
public aspect ZaehlerObj {
	int objects = 0;
	
	pointcut neuesObj() : call(*.new(..)) && !within(ZaehlerObj);
	
	before() : neuesObj() {
		objects++;
	}
	
	pointcut ende() : execution(public static void main(String[]));
	
	after() : ende() {
		System.out.println("Objekte: " + objects);
	}
	
}
