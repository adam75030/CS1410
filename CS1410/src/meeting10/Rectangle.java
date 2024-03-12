package meeting10;

public class Rectangle {
	private int length;
	private int width;

	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public int area() {
		return this.length * this.width;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Rectangle)) {
			return false;
		}
		Rectangle otherRect = (Rectangle) other;
		return this.length == otherRect.length && this.width == otherRect.width;
	}

}
