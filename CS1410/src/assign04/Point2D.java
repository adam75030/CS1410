package assign04;

/**
 * CS 1410 Assignment 4: Point2D Class
 * 
 * @author Adam Wightman
 * @version February 12, 2024
 */
public class Point2D {
	private int x;
	private int y;

	/**
	 * This constructor builds a default Point2D object (0, 0).
	 */
	public Point2D() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * This constructor builds a Point2D object, given an x and y value.
	 * 
	 * @param x - the x value of the point
	 * @param y - the y value of the point
	 */
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter method for accessing the x value of this Point2D object.
	 * 
	 * @return the x value
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Getter method for accessing the y value of this Point2D object.
	 * 
	 * @return the y value
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Clears the Point2D object, setting x and y to 0.
	 */
	public void clear() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * Moves the Point2D object to the given x and y values.
	 * 
	 * @param x - the x value to move to
	 * @param y - the y value to move to
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns a String representation of the Point2D object.
	 * 
	 * @return String version of the Point2D object
	 */
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}

	/**
	 * Returns the distance between the given Point2D object and the second
	 * (parameter) Point2D object.
	 * 
	 * @param secondPoint - the second Point2D object
	 * @return the distance between the two Point2D objects
	 */
	public double distance(Point2D secondPoint) {
		return Math.sqrt(Math.pow(secondPoint.x - this.x, 2) + Math.pow(secondPoint.y - this.y, 2));
	}

	/**
	 * Returns the slope between the given Point2D object and the second (parameter)
	 * Point2D object.
	 * 
	 * @param secondPoint - the second Point2D object
	 * @return the slope between the two Point2D objects
	 */
	public double slope(Point2D secondPoint) {
		return (secondPoint.y - this.y) / (double) (secondPoint.x - this.x);
	}

	/**
	 * Determines if the given Point2D object is equal to the second (parameter)
	 * Point2D object.
	 * 
	 * @param other - the second Point2D object
	 * @return true if the two Point2D objects are equal
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Point2D)) {
			return false;
		}
		Point2D otherPoint = (Point2D) other;
		return this.x == otherPoint.x && this.y == otherPoint.y;
	}
}
