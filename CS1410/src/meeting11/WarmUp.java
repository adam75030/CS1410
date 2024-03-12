package meeting11;

/**
 * This class solves the warm-up problem for Class Meeting 11.
 * 
 * @author Prof. Martin and CS 1410 students
 * @version Feb 21, 2023
 */
public class WarmUp {

	/**
	 * Creates a new two-dimensional array that is the same as the given 
	 * array, but rotated left.  Assumes the given array has the same number 
	 * of rows as columns (i.e., is square).
	 * 
	 * @param arr - the given array
	 * @return - left-rotated version of the given array
	 */
	public static int[][] rotateLeft(int[][] arr) {
		int size = arr.length; // {{1, 2, 3, 4}, {other inner array}, {third inner array}}
		int[][] rotatedArray = new int[size][size];
		
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				// Find the correct value of the rotated array
				// at location row, col
				rotatedArray[row][col] = arr[col][size - 1 - row];
			}
		}
		return rotatedArray;
	}
		
	/**
	 * Prints a given two-dimensional array, each column separated by 
	 * blank space and each row by newline.
	 * 
	 * (Student challenge from Class Meeting 10)
	 * 
	 * @param arr - the given array
	 */
	public static void print(int[][] arr) {
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[0].length; col++)
				System.out.print(arr[row][col] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int[][] matrix = { { 1, 2, 3 },
				           { 4, 5, 6 },
				           { 7, 8, 9 }};
		
		System.out.println("Original: ");
		print(matrix);
				
		System.out.println("\nRotated left: ");
		print(rotateLeft(matrix));
	}
}