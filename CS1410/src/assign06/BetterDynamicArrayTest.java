package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the BetterDynamicArray class.
 *
 * @author Prof. Martin and Adam Wightman
 * @version February 25, 2024
 */
public class BetterDynamicArrayTest {

	private static BetterDynamicArray threeStrings;

	@BeforeEach
	public void setup() {
		threeStrings = new BetterDynamicArray();
		threeStrings.append("9");
		threeStrings.append("0");
		threeStrings.append("cats");
	}

	@Test
	public void testConstructor() {
		BetterDynamicArray array = new BetterDynamicArray();
		assertEquals(0, array.size(), "Constructor did not yield a 0-sized dynamic array");
		assertEquals("[] backing array length: 10", array.toString(),
				"Constructor did not yield the correct dynamic array (via toString)");
	}

	@Test
	public void testConstructorCreatesDistinctArrays() {
		BetterDynamicArray array = new BetterDynamicArray();
		BetterDynamicArray otherArray = new BetterDynamicArray();
		otherArray.append("test");
		assertEquals(0, array.size(),
				"Appending an element to one DynamicArray object changed the size of a different DynamicArray object");
	}

	@Test
	public void testAppendSimple() {
		String expected = "[9, 0, cats] backing array length: 10";
		assertEquals(expected, threeStrings.toString(), "Failed appending 3 elements to empty dynamic array");
		assertEquals(3, threeStrings.size(), "Incorrect size after appending 3 elements to dynamic array");
	}

	@Test
	public void testAppendLarger() {
		String[] largeArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		BetterDynamicArray array = new BetterDynamicArray();
		for (String elem : largeArray)
			array.append(elem);
		String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10] backing array length: 20";
		assertEquals(expected, array.toString(), "Failed appending 11 elements to dynamic array");
		assertEquals(11, array.size(), "Incorrect size after appending 11 elements to dynamic array");
	}

	@Test
	public void testInsertFront() {
		threeStrings.insert(0, "front");
		String expected = "[front, 9, 0, cats] backing array length: 10";
		assertEquals(expected, threeStrings.toString(), "Failed inserting an element to the front");
		assertEquals(4, threeStrings.size(), "Incorrect size after inserting element to the front");
	}

	@Test
	public void testInsertMiddle() {
		threeStrings.insert(1, "middle");
		String expected = "[9, middle, 0, cats] backing array length: 10";
		assertEquals(expected, threeStrings.toString(), "Failed inserting an element to the middle");
		assertEquals(4, threeStrings.size(), "Incorrect size after inserting element to the middle");
	}

	@Test
	public void testInsertEnd() {
		threeStrings.insert(3, "end");
		String expected = "[9, 0, cats, end] backing array length: 10";
		assertEquals(expected, threeStrings.toString(), "Failed inserting an element to the end");
		assertEquals(4, threeStrings.size(), "Incorrect size after inserting element to the end");
	}

	@Test
	public void testInsertInvalidLowIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			threeStrings.insert(-1, "low");
		}, "Failed to throw exception when inserting with too-low index");
	}

	@Test
	public void testInsertInvalidHighIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			threeStrings.insert(4, "high");
		}, "Failed to throw exception when inserting with too-high index");
	}

	@Test
	public void testGetElement() {
		assertEquals("9", threeStrings.getElement(0), "Failed getting element from front");
		assertEquals("0", threeStrings.getElement(1), "Failed getting element from middle");
		assertEquals("cats", threeStrings.getElement(2), "Failed getting element from end");
		assertEquals(3, threeStrings.size(), "Calling getElement changed the size of dynamic array");
	}

	@Test
	public void testGetElementInvalidLow() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			threeStrings.getElement(-1);
		}, "Failed to throw exception when getting element with too-low index");
	}

	@Test
	public void testGetElementInvalidHigh() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			threeStrings.getElement(3);
		}, "Failed to throw exception when getting element with too-high index");
	}

	@Test
	public void testDoublingIsFaster() {
		double DynamicArrayTime = SpeedTest.appendToBetterDynamicArray(10000);
		double regularDynamicArrayTime = SpeedTest.appendToDynamicArray(10000);
		assertTrue(DynamicArrayTime < regularDynamicArrayTime,
				"The time to add 10k items to a doubling dynamic array should be faster, "
						+ "but it is not with the current implementation");
	}

	@Test
	public void testSetElement() {
		String expected = "[9, hello, cats] backing array length: 10";
		threeStrings.setElement(1, "hello");
		assertEquals(expected, threeStrings.toString());
	}

	@Test
	public void testSetElementInvalidLow() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			threeStrings.setElement(-1, "hello");
		}, "Failed to throw exception when getting element with too-low index");
	}

	@Test
	public void testSetElementInvalidHigh() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			threeStrings.setElement(4, "hello");
		}, "Failed to throw exception when getting element with too-low index");
	}

	@Test
	public void testDelete() {
		String expected = "[0, cats] backing array length: 10";
		threeStrings.delete(0);
		assertEquals(expected, threeStrings.toString());
	}

	@Test
	public void testDeleteInvalidLow() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			threeStrings.delete(-1);
		}, "Failed to throw exception when getting element with too-low index");
	}

	@Test
	public void testDeleteInvalidHigh() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			threeStrings.delete(4);
		}, "Failed to throw exception when getting element with too-low index");
	}

	@Test
	public void testAppendLarge() {
		String expected = "[9, 0, cats, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14] backing array length: 20";
		for (int i = 0; i < 15; i++) {
			threeStrings.append("" + i);
		}
		assertEquals(expected, threeStrings.toString());
	}

	@Test
	public void testInsertLarge() {
		String expected = "[9, 0, cats, 0, 1, 2, 3, 4, 5, 6, 7, 8, insert, 9, 10, 11, 12, 13, 14] backing array length: 20";
		for (int i = 0; i < 15; i++) {
			threeStrings.append("" + i);
		}
		threeStrings.insert(12, "insert");
		assertEquals(expected, threeStrings.toString());
	}

	@Test
	public void testGetElementLarge() {
		DynamicArray array = new DynamicArray();
		for (int i = 0; i < 15; i++) {
			array.append("" + i);
		}
		assertEquals("14", array.getElement(14));
	}

	@Test
	public void testSetElementLarge() {
		String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, hello]";
		DynamicArray array = new DynamicArray();
		for (int i = 0; i < 15; i++) {
			array.append("" + i);
		}
		array.setElement(14, "hello");
		assertEquals(expected, array.toString());
	}

	@Test
	public void testDeleteLarge() {
		String expected = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14]";
		DynamicArray array = new DynamicArray();
		for (int i = 0; i < 15; i++) {
			array.append("" + i);
		}
		array.delete(10);
		assertEquals(expected, array.toString());
	}
}
