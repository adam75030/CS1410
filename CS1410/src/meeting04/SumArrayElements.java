package meeting04;

public class SumArrayElements {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };

		// variable to hold our sum
		int sum = 0;

		// loop through the elements
		for (int i : array) {
			sum += i;
		}
		System.out.println(sum);
	}
}
