package lab12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Defines a specific kind of GUI panel for drawing shapes.
 *
 * @author Prof. Martin
 * @version Lab 12
 */
public class PaintPanel extends JPanel implements MouseListener {

	private ArrayList<Shape> shapes;
	private int currentSizeX;
	private int currentSizeY;
	private Color currentColor;
	private Random rng;

	/**
	 * Creates a PaintPanel containing a list of shapes.
	 */
	public PaintPanel() {
		this.shapes = new ArrayList<Shape>();
		this.currentSizeX = 10;
		this.currentSizeY = 10;
		this.currentColor = Color.black;
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.rng = new Random();
	}

	/**
	 * Sets the color of the next shape(s) to be drawn.
	 */
	public void setCurrentColor(Color color) {
		this.currentColor = color;
	}

	/**
	 * Sets the size of the next shape(s) to be drawn.
	 */
	public void setCurrentSize(int size, boolean isX) {
		if(isX)
			currentSizeX = size;
		else
			currentSizeY = size;
	}

	/**
	 * "Erases" shapes from the panel and resets size.
	 */
	public void clearPanel() {
		this.shapes.clear();
		this.currentSizeX = 10;
		this.currentSizeY = 10;
		this.repaint();
	}

	/**
	 * This method is called by the system when a component needs to be painted.
	 *
	 * @param g -- graphics context onto which we can draw
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : this.shapes)
			s.paintMe(g);
	}

	/**
	 * The method is invoked when the user clicks the mouse on the GUI.
	 *
	 * @param e -- object with info on the mouse event
	 */
	public void mouseClicked(MouseEvent e) {
		if(rng.nextBoolean())
			shapes.add(new Oval(e.getX(), e.getY(), this.currentSizeX, this.currentSizeY, this.currentColor));
		else
			shapes.add(new Rectangle(e.getX(), e.getY(), this.currentSizeX, this.currentSizeY, this.currentColor));
		this.repaint();
	}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

	// Required by a serializable class (ignore for now)
	private static final long serialVersionUID = 1L;
}
