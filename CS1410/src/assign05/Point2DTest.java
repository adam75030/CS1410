package assign05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * CS 1410 Assignment 4: Point2D Class. This class contains tests for the
 * Point2D class.
 * 
 * @author Adam Wightman
 * @version February 22, 2024
 */
public class Point2DTest {

	// Tests for Assignment 4:
	@Test
	public void testGetX() {
		Point2D location = new Point2D(-43, 55);
		assertEquals(-43, location.getX());
	}

	@Test
	public void testGetY() {
		Point2D location = new Point2D(25, 50);
		assertEquals(50, location.getY());
	}

	@Test
	public void testClearZero() {
		Point2D zero = new Point2D();
		zero.clear();
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getY());
	}

	@Test
	public void testClearPositive() {
		Point2D positive = new Point2D(10, 20);
		positive.clear();
		assertEquals(0, positive.getX());
		assertEquals(0, positive.getY());
	}

	@Test
	public void testClearNegative() {
		Point2D negative = new Point2D(-10, -20);
		negative.clear();
		assertEquals(0, negative.getX());
		assertEquals(0, negative.getY());
	}

	@Test
	public void testMoveZero() {
		Point2D zero = new Point2D();
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getY());
		zero.move(100, -2);
		assertEquals(100, zero.getX());
		assertEquals(-2, zero.getY());
	}

	@Test
	public void testMoveNegative() {
		Point2D negative = new Point2D(-25, -50);
		assertEquals(-25, negative.getX());
		assertEquals(-50, negative.getY());
		negative.move(-125, -150);
		assertEquals(-125, negative.getX());
		assertEquals(-150, negative.getY());
	}

	@Test
	public void testMoveSame() {
		Point2D same = new Point2D(50, 100);
		assertEquals(50, same.getX());
		assertEquals(100, same.getY());
		same.move(50, 100);
		assertEquals(50, same.getX());
		assertEquals(100, same.getY());
	}

	@Test
	public void testToStringZero() {
		Point2D zero = new Point2D();
		assertEquals("(0, 0)", zero.toString());
	}

	@Test
	public void testToStringNegative() {
		Point2D negative = new Point2D(-25, -50);
		assertEquals("(-25, -50)", negative.toString());
	}

	@Test
	public void testToStringLarge() {
		Point2D large = new Point2D(123456789, 123456789);
		assertEquals("(123456789, 123456789)", large.toString());
	}

	@Test
	public void testDistance() {
		Point2D southWest = new Point2D(3, 1);
		Point2D northEast = new Point2D(10, 12);
		/*
		 * This version of assertEquals has a third parameter for the error tolerance
		 * when comparing two doubles, which is necessary since many values with decimal
		 * points cannot be represented exactly in a computer.
		 */
		assertEquals(13.0384, southWest.distance(northEast), 0.0001);
	}

	@Test
	public void testDistanceNone() {
		Point2D zero = new Point2D();
		Point2D zero2 = new Point2D();
		assertEquals(0, zero.distance(zero2));
	}

	@Test
	public void testDistanceLarge() {
		Point2D largeNorthEast = new Point2D(1234567, 1234567);
		Point2D largeSouthWest = new Point2D(0, 0);
		assertEquals(1745941.3950, largeNorthEast.distance(largeSouthWest), .0001);
	}

	@Test
	public void testSlope() {
		Point2D southWest = new Point2D(0, 0);
		Point2D northEast = new Point2D(5, 10);
		assertEquals(2.0, southWest.slope(northEast));
	}

	@Test
	public void testSlopeNegative() {
		Point2D smaller = new Point2D(-10, -20);
		Point2D bigger = new Point2D(10, 20);
		assertEquals(2.0, smaller.slope(bigger));
	}

	@Test
	public void testSlopeLarge() {
		Point2D zero = new Point2D();
		Point2D large = new Point2D(1, 1234567);
		assertEquals(1234567, zero.slope(large));
	}

	@Test
	public void testEquals() {
		Point2D center = new Point2D(50, 50);
		Object obj = new Point2D(50, 50);
		assertTrue(center.equals(obj), "The parameter of equals() does not correctly match the requirements.");
	}

	@Test
	public void testEqualsZero() {
		Point2D zero = new Point2D();
		Object obj = new Point2D();
		assertTrue(zero.equals(obj));
	}

	@Test
	public void testEqualsNegative() {
		Point2D negative = new Point2D(-50, -100);
		Object obj = new Point2D(-50, -100);
		assertTrue(negative.equals(obj));
	}

	// Tests for Assignment 5:
	@Test
	public void testCopyOfZero() {
		Point2D zero = new Point2D();
		assertEquals(zero, zero.copyOf());
	}

	@Test
	public void testCopyOfPositive() {
		Point2D positive = new Point2D(10, 20);
		assertEquals(positive, positive.copyOf());
	}

	@Test
	public void testCopyOfNegative() {
		Point2D negative = new Point2D(-10, -20);
		assertEquals(negative, negative.copyOf());
	}

	@Test
	public void testAddZero() {
		Point2D zero = new Point2D();
		Point2D zero2 = new Point2D();
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getY());
		zero = zero.add(zero2);
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getY());
	}

	@Test
	public void testAddPositive() {
		Point2D positive = new Point2D(10, 20);
		Point2D positive2 = new Point2D(5, 5);
		assertEquals(10, positive.getX());
		assertEquals(20, positive.getY());
		positive = positive.add(positive2);
		assertEquals(15, positive.getX());
		assertEquals(25, positive.getY());
	}

	@Test
	public void testAddNegative() {
		Point2D negative = new Point2D(-10, -20);
		Point2D positive = new Point2D(5, 5);
		assertEquals(-10, negative.getX());
		assertEquals(-20, negative.getY());
		negative = negative.add(positive);
		assertEquals(-5, negative.getX());
		assertEquals(-15, negative.getY());
	}

	@Test
	public void testMidpointZero() {
		Point2D zero = new Point2D();
		Point2D zero2 = new Point2D();
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getX());
		zero = zero.midpoint(zero2);
		assertEquals(0, zero.getX());
		assertEquals(0, zero.getX());
	}

	@Test
	public void testMidpointPositive() {
		Point2D positive = new Point2D(3, 10);
		Point2D positive2 = new Point2D(1, 0);
		assertEquals(3, positive.getX());
		assertEquals(10, positive.getY());
		positive = positive.midpoint(positive2);
		assertEquals(2, positive.getX());
		assertEquals(5, positive.getY());
	}

	@Test
	public void testMidpointNegative() {
		Point2D negative = new Point2D(-10, -20);
		Point2D negative2 = new Point2D(0, -10);
		assertEquals(-10, negative.getX());
		assertEquals(-20, negative.getY());
		negative = negative.midpoint(negative2);
		assertEquals(-5, negative.getX());
		assertEquals(-15, negative.getY());
	}
}