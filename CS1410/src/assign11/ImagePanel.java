package assign11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * This class represents a GUI component for displaying an image.
 *
 * @author Prof. Martin, Evan Agor, and Adam Wightman
 * @version April 22nd, 2024
 */
public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener {
	private BufferedImage bufferedImg;
	private int x1, x2, y1, y2;
	boolean mouse_dragged;
	boolean crop_enabled;
	boolean rectangle_drawn;
	ImageProcessorFrame frame;

	/**
	 * Creates a new ImagePanel to display the given image.
	 *
	 * @param img - the given image
	 */
	public ImagePanel(Image img, ImageProcessorFrame frame) {
		this.frame = frame;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.mouse_dragged = false;
		this.crop_enabled = false;
		int rowCount = img.getNumberOfRows();
		int colCount = img.getNumberOfColumns();

		this.bufferedImg = new BufferedImage(colCount, rowCount, BufferedImage.TYPE_INT_RGB);

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				Pixel p = img.getPixel(i, j);
				if (p != null) {
					this.bufferedImg.setRGB(j, i, p.getPackedRGB());
				}
			}
		}
		this.setPreferredSize(new Dimension(colCount, rowCount));
	}

	/**
	 * This method is called by the system when a component needs to be painted.
	 * Which can be at one of three times: --when the component first appears --when
	 * the size of the component changes (including resizing by the user) --when
	 * repaint() is called
	 *
	 * Partially overrides the paintComponent method of JPanel.
	 *
	 * @param g -- graphics context onto which we can draw
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.bufferedImg, 0, 0, this);
	}

	/**
	 * This method is called when using the crop filter. It draws a rectangle using
	 * the crop bounds.
	 */
	public void paint(Graphics g) {
		super.paint(g);
		int transparency = 127;
		Color square_color = new Color(255, 255, 255, transparency);
		g.setColor(square_color);
		int width = x2 - x1;
		int height = y2 - y1;
		if (0 > width) {
			width *= -1;
		}
		if (0 > height) {
			height *= -1;
		}
		g.fillRect(x1, y1, width, height);
	}

	/**
	 * Draws a rectangle using the crop bounds if the mouse is released after being
	 * dragged.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		if (mouse_dragged) {
			paint(super.getGraphics());
			rectangle_drawn = true;
		}
		mouse_dragged = false;
	}

	/**
	 * Checks for a mouse drag event for the crop feature.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if (!mouse_dragged) {
			x1 = e.getX();
			y1 = e.getY();
			mouse_dragged = true;
		}
		if (mouse_dragged) {
			frame.cropMode();
		}
	}
	
	/**
	 * Helper method for crop feature.
	 */
	public void start_cropping() {
		crop_enabled = true;

	}

	/**
	 * Helper method for crop feature.
	 */
	public void stop_cropping() {
		crop_enabled = false;
	}

	/**
	 * Helper method for crop feature.
	 * 
	 * @return if the crop has started
	 */
	public boolean is_crop_started() {
		return crop_enabled;
	}

	/**
	 * Helper method for crop feature.
	 * 
	 * @return if the rectangle has been drawn
	 */
	public boolean rectangle_drawn() {
		return rectangle_drawn;
	}

	// The following 4 methods are getters for the crop feature
	public int getx1() {
		return x1;
	}

	public int getx2() {
		return x2;
	}

	public int gety1() {
		return y1;
	}

	public int gety2() {
		return y2;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	private static final long serialVersionUID = 1L;
}