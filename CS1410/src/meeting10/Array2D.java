package meeting10;

import java.util.Arrays;

public class Array2D {

	public static void main(String[] args) {
		double[][] answer = fill(2, 3, 5);
		System.out.println(Arrays.deepToString(answer));
	}

	public static double[][] fill(int rowCount, int columnCount, double value) {
		double[][] array = new double[rowCount][columnCount];
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				array[row][col] = value;
			}
		}
		return array;
	}
}
