package assign11;

/** 
 * CS1410 Object Oriented Programming
 * Assignment 7: Image processing
 * @author Evan Agor
 * @version March 14th, 2024
 */
public class Pixel {
	
	// instance variables
	private int red;
	private int green;
	private int blue;
	
	/**
	 * This constructor creates a Pixel object with values are the given inputs
	 * 
	 * @param redAmount integer value representing the red color
	 * @param greenAmount integer value representing the green color
	 * @param blueAmount integer value representing the blue color 
	 */
	public Pixel( int redAmount, int greenAmount, int blueAmount ){
		// if the input for redAmount, greenAmount, or blueAmount is out of the range throw IllegalArgumentException exception
		if (redAmount > 255 || redAmount < 0 )
			throw new IllegalArgumentException ( "redAmount is out of range, valid range is 0 - 255");
		
		if (greenAmount > 255 || greenAmount < 0 )
			throw new IllegalArgumentException ( "greenAmount is out of range, valid range is 0 - 255");
		
		if (blueAmount > 255 || blueAmount < 0 )
			throw new IllegalArgumentException ( "blueAmount is out of range, valid range is 0 - 255");
		this.red = redAmount;
		
		this.green = greenAmount;
		
		this.blue = blueAmount;
		
	}
	
	/**
	 * Getter method to get red integer value
	 * 
	 * @return red value of the pixel
	 */
	public int getRedAmount() {
		return this.red;
	}
	
	/**
	 * Getter method to get green integer value
	 * 
	 * @return green value of the pixel
	 */
	public int getGreenAmount() {
		return this.green;
	}

	/**
	 * Getter method to get blue integer value
	 * 
	 * @return blue value of the pixel
	 */
	public int getBlueAmount() {
		return this.blue;
	}
	
	/**
	 * This method returns the red, green, and blue amount of a Pixel object (each a one-bye integer value) packed into a four-byte int value
	 * 
	 * @return red, green, and blue amount of the Pixel object
	 */
	public int getPackedRGB() {
		// moving each pixel color towards the right till it reaches the end
		// blue is already at the end so doesn't need to be moved
		return (this.red << 16 | this.green << 8 | this.blue);
	}
	
}
