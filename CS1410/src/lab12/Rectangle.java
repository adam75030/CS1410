package lab12;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a rectangle shape, with a method for drawing the rectangle onto a
 * Graphics context.
 *
 * @author Prof. Martin
 * @version Lab 12
 */
public class Rectangle extends Shape {

	/**
	 * Creates an rectangle for drawing, with given x and y position, size in each
	 * dimension, and color.
	 *
	 * @param positionX
	 * @param positionY
	 * @param sizeX
	 * @param sizeY
	 * @param color
	 */
	public Rectangle(int positionX, int positionY, int sizeX, int sizeY, Color color) {
		super(positionX, positionY, sizeX, sizeY, color);
	}

	/**
	 * Draws a visual representation of this rectangle.
	 *
	 * @param g - graphics context onto which we can draw
	 */
	public void paintMe(Graphics g) {
		super.paintMe(g);
		g.fillRect(getPositionX(), getPositionY(), getSizeX(), getSizeY());
	}
}
