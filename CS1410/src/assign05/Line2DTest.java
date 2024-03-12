package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * CS1410 Assignment 5: Line2D Class. This class contains tests for the Line2D
 * class.
 * 
 * @author Adam Wightman
 * @version February 22, 2024
 */
class Line2DTest {

	@Test
	public void testGetEndpoints() {
		Point2D endPoint1 = new Point2D(-23, 45);
		Point2D endPoint2 = new Point2D(100, 67);
		Point2D[] arr = new Point2D[2];
		arr[0] = endPoint1;
		arr[1] = endPoint2;
		Line2D location = new Line2D(endPoint1, endPoint2);
		assertTrue(Arrays.equals(arr, location.getEndpoints()));
	}

	@Test
	public void testDistanceZero() {
		Point2D endPoint1 = new Point2D();
		Point2D endPoint2 = new Point2D();
		Line2D line = new Line2D(endPoint1, endPoint2);
		assertEquals(0, line.distance());
	}

	@Test
	public void testDistancePositive() {
		Point2D endPoint1 = new Point2D(0, 10);
		Point2D endPoint2 = new Point2D(0, 30);
		Line2D line = new Line2D(endPoint1, endPoint2);
		assertEquals(20, line.distance());
	}

	@Test
	public void testDistanceNegative() {
		Point2D endPoint1 = new Point2D(-10, 0);
		Point2D endPoint2 = new Point2D(-20, 0);
		Line2D line = new Line2D(endPoint1, endPoint2);
		assertEquals(10, line.distance());
	}

	@Test
	public void testSlope() {
		Point2D endPoint1 = new Point2D(1, 5);
		Point2D endPoint2 = new Point2D(10, 50);
		Line2D line = new Line2D(endPoint1, endPoint2);
		assertEquals(5, line.slope());
	}

	@Test
	public void testSlopeNegative() {
		Point2D endPoint1 = new Point2D(-10, -20);
		Point2D endPoint2 = new Point2D(10, 20);
		Line2D line = new Line2D(endPoint1, endPoint2);
		assertEquals(2, line.slope());
	}

	@Test
	public void testSlopeLarge() {
		Point2D endPoint1 = new Point2D();
		Point2D endPoint2 = new Point2D(100000, 2000000);
		Line2D line = new Line2D(endPoint1, endPoint2);
		assertEquals(20, line.slope());
	}

	@Test
	public void testMidpointZero() {
		Point2D endPoint1 = new Point2D();
		Point2D endPoint2 = new Point2D();
		Line2D line = new Line2D(endPoint1, endPoint2);
		Point2D midpoint = new Point2D();
		assertEquals(midpoint, line.midpoint());
	}

	@Test
	public void testMidpointPositive() {
		Point2D endPoint1 = new Point2D(10, 20);
		Point2D endPoint2 = new Point2D(30, 40);
		Line2D line = new Line2D(endPoint1, endPoint2);
		Point2D midpoint = new Point2D(20, 30);
		assertEquals(midpoint, line.midpoint());
	}

	@Test
	public void testMidpointNegative() {
		Point2D endPoint1 = new Point2D(-10, -20);
		Point2D endPoint2 = new Point2D(-50, -50);
		Line2D line = new Line2D(endPoint1, endPoint2);
		Point2D midpoint = new Point2D(-30, -35);
		assertEquals(midpoint, line.midpoint());
	}

	@Test
	public void testEqualsDefault() {
		Line2D line = new Line2D();
		Line2D otherLine = new Line2D();
		assertTrue(line.equals(otherLine));
	}

	@Test
	public void testEqualsPositive() {
		Point2D point1 = new Point2D(10, 20);
		Point2D point2 = new Point2D(30, 40);
		Line2D line = new Line2D(point1, point2);

		Point2D point3 = new Point2D(10, 20);
		Point2D point4 = new Point2D(30, 40);
		Line2D line2 = new Line2D(point3, point4);
		assertTrue(line.equals(line2));
	}

	@Test
	public void testEqualsNegative() {
		Point2D point1 = new Point2D(-123, -456);
		Point2D point2 = new Point2D(-789, -100);
		Line2D line = new Line2D(point1, point2);

		Point2D point3 = new Point2D(-123, -456);
		Point2D point4 = new Point2D(-789, -100);
		Line2D line2 = new Line2D(point3, point4);
		assertTrue(line.equals(line2));
	}
}