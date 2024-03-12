package meeting07;

import java.util.Arrays;

public class MultiplyArray {

	public static void main(String[] args) {
		int[] array = { 20, 0, 3, -100, 6, 7 };
		int multiple = 3;
		multiplyArray(array, multiple);
	}

	public static void multiplyArray(int[] array, int multiple) {
		for (int i = 0; i < array.length; i++) {
			array[i] *= multiple;
		}
		System.out.println(Arrays.toString(array));
	}
}
