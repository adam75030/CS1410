package meeting15;

import assign05.Point2D;

public abstract class Shape2D implements Drawable {
	// we cannot create instances of Shape2D
	// Shape2D can now (optionally) have abstract methods
	// Variables
	private Point2D center;
	private String name;

	// Constructor
	public Shape2D(int x, int y, String name) {
		this.center = new Point2D(x, y);
		this.name = name;
	}

	// Methods
	public String toString() {
		return name + ": " + center.getX() + "," + center.getY();
	}

	public abstract double area();

	public abstract void draw();

//	public double perimiter() {
//		return 0;
//	}

	// Other options: translate, scale, reflection, etc.

}
