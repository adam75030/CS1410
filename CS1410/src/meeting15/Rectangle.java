package meeting15;

public class Rectangle extends Shape2D {
	private int width;
	private int length;

	public Rectangle(int x, int y, int width, int length) {
		super(x, y, "Rectangle");
		this.width = width;
		this.length = length;
	}

	@Override
	public double area() {
		return length * width;
	}

	@Override
	public void draw() {
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < length; col++) {
				System.out.print("x");
			}
			System.out.println();
		}
	}
}
