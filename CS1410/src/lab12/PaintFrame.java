package lab12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class implements a GUI for painting / drawing shapes, as well as saving
 * a drawing to file.
 *
 * @author Prof. Martin and Adam Wightman
 * @version Lab 12
 */
public class PaintFrame extends JFrame implements ActionListener, ChangeListener {

	// Menu items for closing, clearing, and saving-to-file the drawing application
	private JMenuItem closeItem;
	private JMenuItem clearItem;
	private JMenuItem saveItem;

	// Menu items for selecting a color
	private JMenuItem cyanItem;
	private JMenuItem pinkItem;
	private JMenuItem greenItem;
	private JMenuItem magentaItem;
	private JMenuItem orangeItem;

	// The paint panel
	private PaintPanel paintPanel;

	// The slider objects
	private JSlider sliderX;
	private JSlider sliderY;

	public PaintFrame() {
		JPanel parentPanel = new JPanel(new BorderLayout());
		JPanel sliderPanel = new JPanel();
		this.paintPanel = new PaintPanel();

		// Create the sliders
		sliderX = new JSlider(5, 205, 10);
		sliderX.setPaintTicks(true);
		sliderX.setMajorTickSpacing(50);
		sliderX.setPaintLabels(true);
		sliderX.addChangeListener(this);

		sliderY = new JSlider(5, 205, 10);
		sliderY.setPaintTicks(true);
		sliderY.setMajorTickSpacing(50);
		sliderY.setPaintLabels(true);
		sliderY.addChangeListener(this);

		sliderPanel.add(sliderX);
		sliderPanel.add(sliderY);

		parentPanel.add(this.paintPanel, BorderLayout.CENTER);
		parentPanel.add(sliderPanel, BorderLayout.SOUTH);

		// Make a PaintPanel the content of this frame.
		this.setContentPane(parentPanel);

		// Add a File menu with Close, Clear, and Save options.
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		this.closeItem = new JMenuItem("Close");
		this.closeItem.addActionListener(this);
		fileMenu.add(this.closeItem);
		this.clearItem = new JMenuItem("Clear");
		this.clearItem.addActionListener(this);
		fileMenu.add(this.clearItem);
		this.saveItem = new JMenuItem("Save");
		this.saveItem.addActionListener(this);
		fileMenu.add(this.saveItem);
		menubar.add(fileMenu);

		// Add a Set-color menu with options for several colors.
		JMenu colorMenu = new JMenu("Set color");
		this.cyanItem = new JMenuItem("Cyan");
		this.cyanItem.addActionListener(this);
		colorMenu.add(this.cyanItem);
		this.pinkItem = new JMenuItem("Pink");
		this.pinkItem.addActionListener(this);
		colorMenu.add(this.pinkItem);
		this.greenItem = new JMenuItem("Green");
		this.greenItem.addActionListener(this);
		colorMenu.add(this.greenItem);
		this.magentaItem = new JMenuItem("Magenta");
		this.magentaItem.addActionListener(this);
		colorMenu.add(this.magentaItem);
		this.orangeItem = new JMenuItem("Orange");
		this.orangeItem.addActionListener(this);
		colorMenu.add(this.orangeItem);
		menubar.add(colorMenu);
		this.setJMenuBar(menubar);

		// Setup this frame.
		this.setPreferredSize(new Dimension(300, 300));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}

	/**
	 * The method is called when the user makes a menu selection.
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == closeItem)
			dispose();
		else if (src == clearItem)
			this.paintPanel.clearPanel();
		else if (src == saveItem) {
			JFileChooser chooser = new JFileChooser();
			chooser.setSelectedFile(new File("new_drawing.jpg"));
			chooser.setFileFilter(new FileNameExtensionFilter("JPG  Images", "jpg"));
			chooser.setDialogTitle("Select the location for the new file.");
			if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "Save file cancelled.");
				return;
			}
			BufferedImage img = new BufferedImage(this.paintPanel.getWidth(), this.paintPanel.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			this.paintPanel.paint(img.getGraphics());
			try {
				ImageIO.write(img, "jpg", chooser.getSelectedFile());
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "The drawing cannot be written to file.");
			}
		} else {
			Color newColor = null;
			if (src == this.cyanItem)
				newColor = Color.cyan;
			else if (src == this.pinkItem)
				newColor = Color.pink;
			else if (src == this.greenItem)
				newColor = Color.green;
			else if (src == this.magentaItem)
				newColor = Color.magenta;
			else
				newColor = Color.orange;
			this.paintPanel.setCurrentColor(newColor);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider src = (JSlider) e.getSource(); // A JSlider is the only possible source of the change event.
		if (!src.getValueIsAdjusting()) { // Do not set size if the user is still dragging the slider.
			int val = (int) src.getValue();
			boolean isX = false;
			if (src == this.sliderX) // Assumes the name of the horizontal-size slider is called sliderX.
				isX = true;
			this.paintPanel.setCurrentSize(val, isX); // Assumes that the name of the PaintPanel is panel.
		}
	}

	// Required by a serializable class (ignore for now)
	private static final long serialVersionUID = 1L;
}
