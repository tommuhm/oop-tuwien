public class Discount {
	public static float getDiscount(int days) {
		if (days > 7) {
			return 0.5f; //multiplier
		} else if (days > 2) {
			return 0.6f;
		} else if (days > 1) {
			return 0.7f;
		} else {
			return 1.0f;
		}
	}
}
