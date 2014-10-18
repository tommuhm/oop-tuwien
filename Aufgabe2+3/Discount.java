public class Discount {
	public static float getDiscount(int hours)
	{
		if(hours > 24*7) {
			return 0.5f; //multiplier
		} 
		else if(hours > 24*2) {
			return 0.6f;
		} 
		else if(hours > 24) {
			return 0.7f;
		}
		else {
			return 1.0f;
		}
	}
}
