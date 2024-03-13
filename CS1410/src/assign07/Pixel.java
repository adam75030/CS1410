package assign07;

/**
 * This class represents a Pixel object, with individual red, green, and blue values.
 * @author Adam Wightman
 * @version March 12, 2024
 */
public class Pixel {
	private int red;
	private int green;
	private int blue;

	public Pixel(int redAmount, int greenAmount, int blueAmount) {
		if (redAmount < 0 || redAmount > 255 || greenAmount < 0 || greenAmount > 255 || blueAmount < 0
				|| blueAmount > 255) {
			throw new IllegalArgumentException();
		}
		this.red = redAmount;
		this.green = greenAmount;
		this.blue = blueAmount;
	}

	public int getRedAmount() {
		return this.red;
	}

	public int getGreenAmount() {
		return this.green;
	}

	public int getBlueAmount() {
		return this.blue;
	}

	public int getPackedRGB() {
		return this.red << 8 | this.green << 8 | this.blue << 8;
	}

}
