package lab05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains unit test for the Fraction class.
 *
 * @author Drs. Kabir and Martin
 * @version Lab 5
 */
public class FractionTest {

	@Test
	public void testThirdConstructor() {
		Fraction five = new Fraction(5);
		assertEquals("5/1", five.toString());
		assertEquals(5, five.toDouble(), 0.00001);
	}

	@Test
	public void testAddOne() {
		Fraction half = new Fraction(1, 2);
		half.addOne();
		assertEquals("3/2", half.toString());
		assertEquals(1.5, half.toDouble(), 0.00001);
	}

	@Test
	public void testReduce() {
		Fraction threeFourths = new Fraction(42, 56);
		threeFourths.reduce();
		assertEquals("3/4", threeFourths.toString());
		assertEquals(0.75, threeFourths.toDouble(), 0.00001);
	}

	@Test
	public void testReduceAlreadySimplified() {
		Fraction half = new Fraction(1, 2);
		half.reduce();
		assertEquals("1/2", half.toString());
		assertEquals(0.5, half.toDouble(), 0.00001);
	}
}
