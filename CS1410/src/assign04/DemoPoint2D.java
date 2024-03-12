package assign04;

import java.util.Arrays;

/**
 * This class contains code to demonstrate how to instantiate the Point2D class, as
 * well as invoke methods on Point2D objects.
 *
 * Note that this class is NOT a tester and the statements below are NOT tests.
 * For testing the Point2D class, students must use JUnit 5.
 *
 * (Instantiating a class means to create objects of that class.
 * Invoking a method means to call that method.)
 *
 * @author Sinthia Kabir, Travis Martin, and Erin Parker
 * @version January 31, 2024
 */
public class DemoPoint2D {

	public static void main(String[] args) {
		// Create (3, 1)
		Point2D southWest = new Point2D(3, 1);
		// Create (10, 12)
		Point2D northEast = new Point2D(10, 12);

		System.out.println("The toString method is called automatically when printing " +
				"a Point object, like " + southWest + ".\n");

		System.out.println("The x coordinate of point " + southWest + " is " + southWest.getX() +
				".");
		System.out.println("The y coordinate of point " + northEast + " is " + northEast.getY() +
				".\n");

		System.out.println("The distance between " + southWest + " and " + northEast + " is "
				+ southWest.distance(northEast) + ".");
		System.out.println("This is the same as the distance between " + northEast + " and " +
				southWest + ", which is " + northEast.distance(southWest) + ".\n");

		System.out.println("The slope of the straight line that connects " + southWest + " and " +
				northEast + " is " + southWest.slope(northEast) + ".");
		System.out.println("This is the same as the slope of the straight line that connects " +
				northEast + " and " + southWest + ", which is " + northEast.slope(southWest) + ".\n");

		southWest.move(10, 12);
		System.out.println(southWest + " equal to " + northEast + "?  " + southWest.equals(northEast) + "\n");

		// Create (0, 0)
		Point2D zero = new Point2D();

		// Create array of Point objects and display each as text
		Point2D[] locations = new Point2D[3];
		locations[0] = zero;
		locations[1] = northEast;
		locations[2] = southWest;
		System.out.println(Arrays.toString(locations));
	}
}
