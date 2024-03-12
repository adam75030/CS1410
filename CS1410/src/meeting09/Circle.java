package meeting09;

public class Circle {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	// this method changes the object's state
	public void scale(int amount) {
		this.radius *= amount;
	}

	// this method does not change the original object's state
	public Circle scaledCopy(int amount) {
		Circle copy = new Circle(this.radius * amount);
		return copy;
	}

	public double getRadius() {
		return this.radius;
	}

	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Circle)) {
			return false;
		}
		Circle otherCircle = (Circle) other;
		return this.radius == otherCircle.radius;
	}
}
