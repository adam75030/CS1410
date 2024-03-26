package assign08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCompareToTwoMagicsLessthan() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Magic greaterMagic = new Magic("greater", 31, 5); // also tests for integer division
		assertTrue(testMagic.compareTo(greaterMagic) < 0);
	}
}
