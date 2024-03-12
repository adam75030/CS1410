package assign05;

/**
 * CS1410 Assignment 5: Line2D Class. This class represents a line, using two
 * endpoints. The endpoints are Point2D objects.
 * 
 * @author Adam Wightman
 * @version February 22, 2024
 */
public class Line2D {
	private Point2D endPoint1;
	private Point2D endPoint2;

	/**
	 * This constructor builds a default Line2D object with endpoints (0,0) and
	 * (1,1).
	 */
	public Line2D() {
		this.endPoint1 = new Point2D(0, 0);
		this.endPoint2 = new Point2D(1, 1);
	}

	/**
	 * This constructor builds a Line2D object, given two endpoints.
	 * 
	 * @param endPoint1 - the (x,y) value of the first endpoint
	 * @param endPoint2 - the (x,y) value of the second endpoint
	 */
	public Line2D(Point2D endPoint1, Point2D endPoint2) {
		this.endPoint1 = new Point2D(endPoint1.getX(), endPoint1.getY());
		this.endPoint2 = new Point2D(endPoint2.getX(), endPoint2.getY());

	}

	/**
	 * Getter method for accessing the endpoints of this Line2D object.
	 * 
	 * @return a Point2D[] array of endpoints
	 */
	public Point2D[] getEndpoints() {
		Point2D copyEndPoint1 = this.endPoint1;
		Point2D copyEndPoint2 = this.endPoint2;
		Point2D[] endPoints = new Point2D[2];
		endPoints[0] = copyEndPoint1;
		endPoints[1] = copyEndPoint2;
		return endPoints;
	}

	/**
	 * Returns the distance between two endpoints of this Line2D object.
	 * 
	 * @return the distance between two endpoints of this Line2D object
	 */
	public double distance() {
		return this.endPoint1.distance(endPoint2);
	}

	/**
	 * Returns the slope between two endpoints of this Line2D object.
	 * 
	 * @return the slope between two endpoints of this Line2D object
	 */
	public double slope() {
		return this.endPoint1.slope(endPoint2);
	}

	/**
	 * Returns the midpoint of two endpoints of this Line2D object.
	 * 
	 * @return the midpoint of two endpoints of this Line2D object
	 */
	public Point2D midpoint() {
		return this.endPoint1.midpoint(endPoint2);
	}

	/**
	 * Determines if the given Line2D object is equal to the second (parameter)
	 * Line2D object.
	 * 
	 * @param other - the second Line2D object
	 * @return true if the two Line2D objects are equal
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Line2D)) {
			return false;
		}
		Line2D otherLine = (Line2D) other;
		return this.endPoint1.equals(otherLine.endPoint1) && this.endPoint2.equals(otherLine.endPoint2)
				|| this.endPoint1.equals(otherLine.endPoint2) && this.endPoint2.equals(otherLine.endPoint1);
	}
}
