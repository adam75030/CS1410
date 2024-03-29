package lab06;

/**
 * This class contains a potentially buggy average method.
 * 
 * @author Prof. Martin
 * @version Lab 6
 */
public class Part3 {
	
	public static Fraction average(Fraction[] arr) {
		if(arr.length < 2)
			return null;
		Fraction sum = arr[0].add(arr[1]);
		for(int i = 2; i < arr.length; i++)
			sum = sum.add(arr[i]);
		return sum.multiply(new Fraction(1, arr.length));
	}
}