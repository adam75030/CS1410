package meeting06;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		// reverse array
		double[] array = { 95.5, 80, 76.2, 100, 0, 67.7 };
		double[] reversedArray = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			reversedArray[i] = array[array.length - i - 1];
		}
		System.out.println(Arrays.toString(reversedArray));

		
		// swap x and y
		int x = 5;
		int y = 10;
		int temporary = x;
		x = y;
		y = temporary;
		System.out.println("x is " + x + " , y is " + y);

		
		// memory efficient array reverse
		double[] array2 = { 95.5, 80, 76.2, 100, 0, 67.7 };
		for (int i = 0; i < array2.length / 2; i++) {
			double temp = array2[i];
			array2[i] = array2[array2.length - i - 1];
			array2[array2.length - i - 1] = temp;
		}
		System.out.println(Arrays.toString(array2));
	}
}
