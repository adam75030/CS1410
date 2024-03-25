package assign07;

/**
 * This class represents a Pixel object, with individual red, green, and blue
 * values.
 * 
 * @author Adam Wightman
 * @version March 12, 2024
 */
public class Pixel {
	
	private int red;
	private int green;
	private int blue;

	/**
	 * This constructor builds a Pixel object, with red, green, and blue values.
	 * 
	 * @param redAmount   the red value of the pixel
	 * @param greenAmount the green value of the pixel
	 * @param blueAmount  the blue value of the pixel
	 * @throws IllegalArgumentException
	 */
	public Pixel(int redAmount, int greenAmount, int blueAmount) {
		if (redAmount < 0 || redAmount > 255 || greenAmount < 0 || greenAmount > 255 || blueAmount < 0
				|| blueAmount > 255) {
			throw new IllegalArgumentException();
		}
		this.red = redAmount;
		this.green = greenAmount;
		this.blue = blueAmount;
	}

	/**
	 * Getter method for accessing the red amount of this pixel.
	 * 
	 * @return the red value
	 */
	public int getRedAmount() {
		return this.red;
	}

	/**
	 * Getter method for accessing the green amount of this pixel.
	 * 
	 * @return the green value
	 */
	public int getGreenAmount() {
		return this.green;
	}

	/**
	 * Getter method for accessing the blue amount of this pixel.
	 * 
	 * @return the blue value
	 */
	public int getBlueAmount() {
		return this.blue;
	}

	/**
	 * Getter method for accessing the packedRGB value of this pixel.
	 * 
	 * @return the packedRGB value
	 */
	public int getPackedRGB() {
		return this.red << 16 | this.green << 8 | this.blue;
	}
}
