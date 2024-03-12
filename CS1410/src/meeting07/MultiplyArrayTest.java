package meeting07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplyArrayTest {

	@Test
	void multiplyArrayTest() {
		int[] array = { 1, 2, 3 };
		int[] testArray = { 3, 6, 9 };
		int multiple = 3;
		MultiplyArray.multiplyArray(array, multiple);

		assertArrayEquals(testArray, array);
	}
}