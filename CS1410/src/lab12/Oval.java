package lab12;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents an oval shape, with a method for drawing the oval onto a Graphics
 * context.
 *
 * @author Prof. Martin
 * @version Lab 12
 */
public class Oval extends Shape {

	/**
	 * Creates an oval for drawing, with given x and y position, size in each
	 * dimension, and color.
	 *
	 * @param positionX
	 * @param positionY
	 * @param sizeX
	 * @param sizeY
	 * @param color
	 */
	public Oval(int positionX, int positionY, int sizeX, int sizeY, Color color) {
		super(positionX, positionY, sizeX, sizeY, color);
	}

	/**
	 * Draws a visual representation of this oval.
	 *
	 * @param g - graphics context onto which we can draw
	 */
	public void paintMe(Graphics g) {
		super.paintMe(g);
		g.fillOval(getPositionX(), getPositionY(), getSizeX(), getSizeY());
	}
}
