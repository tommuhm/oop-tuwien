public class Discount {

	// PRECONDITION: days has to be greater or equal to one
	// POSTCONDITION: value has to be between zero and one
	public static float getDiscount(int days) {
		if (days > 7) {
			return 0.5f;
		} else if (days > 2) {
			return 0.6f;
		} else if (days > 1) {
			return 0.7f;
		} else {
			return 1.0f;
		}
	}

}
