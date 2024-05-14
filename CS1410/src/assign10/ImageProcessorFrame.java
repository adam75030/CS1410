package assign10;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageProcessorFrame extends JFrame implements ActionListener {
	private JMenu fileMenu;
	private JMenu filtersMenu;
	private JMenuItem open;
	private JMenuItem save;
	private JMenuItem redBlueSwap;
	private JMenuItem blackAndWhite;
	private JMenuItem rotateClockwise;
	private JMenuItem brighten;
	private JMenuItem photoNegative;
	private ImagePanel parentPanel;
	private ImagePanel imageDisplay;
	private Image displayImage;

	public ImageProcessorFrame() {
		// Create the parentPanel and menuBar
		Image defaultImage = new Image();
		parentPanel = new ImagePanel(defaultImage);

		// Create the file menu
		JMenuBar menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		this.open = new JMenuItem("Open new image file...");
		this.open.addActionListener(this);
		fileMenu.add(this.open);
		this.save = new JMenuItem("Save filtered image file...");
		// Disable save button by default
		this.save.setEnabled(false);
		this.save.addActionListener(this);
		fileMenu.add(this.save);
		menuBar.add(fileMenu);

		// Create the filters menu
		filtersMenu = new JMenu("Filters");
		// Disable filters menu by default
		filtersMenu.setEnabled(false);
		this.redBlueSwap = new JMenuItem("Red-Blue Swap");
		this.redBlueSwap.addActionListener(this);
		this.redBlueSwap.setToolTipText("Swaps the red and blue amounts of the RGB model for color");
		filtersMenu.add(this.redBlueSwap);
		this.blackAndWhite = new JMenuItem("Black and White");
		this.blackAndWhite.addActionListener(this);
		this.blackAndWhite.setToolTipText("Turns the image to black and white (grayscale)");
		filtersMenu.add(this.blackAndWhite);
		this.rotateClockwise = new JMenuItem("Rotate Clockwise");
		this.rotateClockwise.addActionListener(this);
		this.rotateClockwise.setToolTipText("Rotates the image clockwise by 90 degrees");
		filtersMenu.add(this.rotateClockwise);
		this.brighten = new JMenuItem("Brighten");
		this.brighten.addActionListener(this);
		this.brighten.setToolTipText("Brightens the image by a small, set amount");
		filtersMenu.add(this.brighten);
		this.photoNegative = new JMenuItem("Photo Negative");
		this.photoNegative.addActionListener(this);
		this.photoNegative.setToolTipText("Swaps the color of the image to the opposite of the original image");
		filtersMenu.add(this.photoNegative);
		menuBar.add(filtersMenu);

		// Initialize the frame settings
		this.setJMenuBar(menuBar);
		this.setContentPane(parentPanel);
		this.setPreferredSize(new Dimension(300, 300));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == this.open) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter(new FileNameExtensionFilter("JPG Images", "jpg"));
			chooser.setDialogTitle("Select the location for the new file.");
			int optionChosen = chooser.showOpenDialog(null);
			if (optionChosen != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "Open file cancelled.");
				return;
			}
			File file = chooser.getSelectedFile();
			String pathName = file.getAbsolutePath();
			displayImage = new Image(pathName);
			imageDisplay = new ImagePanel(displayImage);
			setContentPane(imageDisplay);
			revalidate();
			// Re-enable the save/filters menu items once an image is selected
			save.setEnabled(true);
			filtersMenu.setEnabled(true);

		} else if (src == this.save) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter(new FileNameExtensionFilter("JPG Images", "jpg"));
			chooser.setDialogTitle("Select the location for the new file.");
			int optionChosen = chooser.showSaveDialog(null);
			if (optionChosen != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "Save file cancelled.");
				return;
			}
			displayImage.writeImage(chooser.getSelectedFile().getAbsolutePath() + ".jpg");
		} else if (src == this.redBlueSwap) {
			displayImage.redBlueSwapFilter();
			imageDisplay = new ImagePanel(displayImage);
			setContentPane(imageDisplay);
			this.revalidate();
		} else if (src == this.blackAndWhite) {
			displayImage.blackAndWhiteFilter();
			imageDisplay = new ImagePanel(displayImage);
			setContentPane(imageDisplay);
			this.revalidate();
		} else if (src == this.rotateClockwise) {
			displayImage.rotateClockwiseFilter();
			imageDisplay = new ImagePanel(displayImage);
			setContentPane(imageDisplay);
			this.revalidate();
		} else if (src == this.brighten) {
			displayImage.brightenFilter();
			imageDisplay = new ImagePanel(displayImage);
			setContentPane(imageDisplay);
			this.revalidate();
		} else if (src == this.photoNegative) {
			displayImage.photoNegativeFilter();
			imageDisplay = new ImagePanel(displayImage);
			setContentPane(imageDisplay);
			this.revalidate();
		}
	}

	private static final long serialVersionUID = 1L;
}