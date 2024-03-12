package assign05;

import java.util.Arrays;

/**
 * This class contains code to demonstrate how to instantiate the Line2D class, as
 * well as invoke methods on Line2D objects.
 *
 * Note that this class is NOT a tester and the statements below are NOT tests.
 * For testing the Line2D class, students must use JUnit 5.
 *
 * @author Drs. Kabir and Martin
 * @version Feb 14, 2023
 */
public class DemoLine2D {

	public static void main(String[] args) {
		// Create (4, 2)
		Point2D southWest = new Point2D(4, 2);
		// Create (10, 12)
		Point2D northEast = new Point2D(10, 12);

		// Create line segment with endpoints (4, 2) and (10, 12)
		Line2D line = new Line2D(southWest, northEast);

		System.out.println("For the line segment with endpoints " + Arrays.toString(line.getEndpoints()));
		System.out.println("  the distance is " + line.distance());
		System.out.println("  the slope is " + line.slope());
		System.out.println("  the midpoint is "  + line.midpoint());

		// Create line segment with endpoints (10, 12) and (4, 12)
		Line2D line2 = new Line2D(northEast, southWest);

		System.out.println("Is the line segment with endpoints " + Arrays.toString(line.getEndpoints()) +
				" equal to the line segment with endpoints " + Arrays.toString(line2.getEndpoints()) + "?  ");
		if(line.equals(line2))
			System.out.println("  yes");
		else
			System.out.println("  no");
	}
}
