package meeting15;

public class Circle extends Shape2D {
	private int radius;

	public Circle(int x, int y, int radius) {
		super(x, y, "Circle"); // Subclasses STILL have to call their superclass constructor
								// the superclass constructor (whether or not the super is abstract)
								// is responsible for setting up the superclass inst variables
		this.radius = radius;
	}

	public double area() {
		return Math.PI * radius * radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public void draw() {
		System.out.println("O");
	}
}
