package assign11;

import java.awt.BorderLayout;
import java.awt.Color;
// Needed Imports
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

//import meeting20.Shape;

/**
 * CS1410 Object Oriented Programming Assignment 11: Final Project, Part 2
 * 
 * @author Evan Agor and Adam Wightman
 * @version April 8th, 2024
 */
public class ImageProcessorFrame extends JFrame implements ActionListener, ChangeListener {
	private Image image;
	private JMenu fileMenu;
	private JMenu filtersMenu;
	private JMenuItem openButton, saveButton, redBlueSwap, blackAndWhite, rotateClockwise, brighten, photoNegative,
			brightness, crop, undo, saturation;
	private JPanel mainPanel;
	private ImagePanel imagePanel;
	private JMenuBar menuBar;
	private JSlider brightnessSlider;
	private JSlider saturationSlider;
	private JPanel brightnessSliderPanel;
	private JPanel saturationSliderPanel;
	private ArrayList<Image> undoList;
	private int undoListSize;

	/**
	 * Constructor for Image Processor Frame
	 */
	public ImageProcessorFrame() {
		// Initialize the main panel and the menu bar
		mainPanel = new JPanel(new BorderLayout());
		menuBar = new JMenuBar();

		// Initialize the file menu
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		// Initialize each of the file menu items
		openButton = new JMenuItem("Open new image file...");
		openButton.addActionListener(this);
		fileMenu.add(openButton);
		saveButton = new JMenuItem("Save filtered image file...");
		saveButton.setEnabled(false);
		saveButton.addActionListener(this);
		fileMenu.add(this.saveButton);

		// Initialize the filters menu
		filtersMenu = new JMenu("Filters");
		filtersMenu.setEnabled(false);
		menuBar.add(filtersMenu);

		// Initialize each of the filter menu items
		redBlueSwap = addMenuItem("Red-Blue Swap", "Swaps the red and blue amounts of the RGB model for color",
				filtersMenu);
		blackAndWhite = addMenuItem("Black and White", "Turns the image to black and white (grayscale)", filtersMenu);
		rotateClockwise = addMenuItem("Rotate Clockwise", "Rotates the image clockwise by 90 degrees", filtersMenu);
		brighten = addMenuItem("Brighten", "Brightens the image by a small, set amount", filtersMenu);
		photoNegative = addMenuItem("Photo Negative",
				"Swaps the color of the image to the opposite of the original image", filtersMenu);
		brightness = addMenuItem("Brightness", "Brightens the image using a slider", filtersMenu);
		saturation = addMenuItem("Saturation", "Saturates the colors of the image using a slider", filtersMenu);
		crop = addMenuItem("Crop", "Select an area of the picture to crop", filtersMenu);
		undo = addMenuItem("Undo", "Undoes the last filter applied", filtersMenu);

		// Initialize brightnessSlider settings
		brightnessSliderPanel = new JPanel();
		brightnessSlider = new JSlider(0, -200, 200, 0);
		brightnessSlider.setPaintTicks(true);
		brightnessSlider.setPaintLabels(true);
		brightnessSlider.setMajorTickSpacing(50);
		brightnessSlider.addChangeListener(this);
		brightnessSliderPanel.add(brightnessSlider);

		// Initialize zoomSlider settings
		saturationSliderPanel = new JPanel();
		saturationSlider = new JSlider(SwingConstants.VERTICAL, 0, 100, 0);
		saturationSlider.setPaintTicks(true);
		saturationSlider.setPaintLabels(true);
		saturationSlider.setMajorTickSpacing(20);
		saturationSlider.addChangeListener(this);
		saturationSliderPanel.add(saturationSlider);

		// Initialize the undo ArrayList
		undoList = new ArrayList<Image>();
		undoListSize = 0;

		// Initialize the frame settings
		this.setJMenuBar(menuBar);
		this.setContentPane(mainPanel);
		this.setPreferredSize(new Dimension(500, 500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
	}

	/**
	 * Initializes each of the menuItems.
	 * 
	 * @param buttonLabel, toolTip, filters
	 * @return menuItem
	 */
	private JMenuItem addMenuItem(String buttonLabel, String toolTip, JMenu filtersMenu) {
		JMenuItem menuItem = new JMenuItem(buttonLabel);
		menuItem.setToolTipText(toolTip);
		menuItem.addActionListener(this);
		menuItem.setEnabled(false);
		filtersMenu.add(menuItem);
		return menuItem;
	}

	/**
	 * This method performs actions according to the user's interactions
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		/////////////////
		// Open button //
		/////////////////
		if (src == this.openButton) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter(new FileNameExtensionFilter("JPG Images", "jpg", "jpeg", "png", "bmp", "gif"));
			chooser.setDialogTitle("Select the location for the new file.");
			int optionChosen = chooser.showOpenDialog(null);
			if (optionChosen != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "Open file cancelled.");
				return;
			}
			File imageFile = chooser.getSelectedFile();
			String pathName = imageFile.getAbsolutePath();
			image = new Image(pathName);

			Image duplicatedImage = new Image(image.copy(image));
			undoList.add(duplicatedImage);
			undoListSize++;

			saveButton.setEnabled(true);
			filtersMenu.setEnabled(true);
			enableFilters();
			imagePanel = new ImagePanel(image, this);
			setContentPane(imagePanel);
			revalidate();

			/////////////////
			// Save button //
			/////////////////
		} else if (src == this.saveButton) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter(new FileNameExtensionFilter("JPG Images", "jpg", "jpeg", "png", "bmp", "gif"));
			chooser.setDialogTitle("Select the location for the new file.");
			int optionChosen = chooser.showSaveDialog(null);
			if (optionChosen != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "Save file cancelled.");
				return;
			}
			image.writeImage(chooser.getSelectedFile().getAbsolutePath() + ".jpg");

			///////////////////
			// Red-Blue Swap //
			///////////////////
		} else if (src == this.redBlueSwap) {
			imagePanel.stop_cropping();
			image.redBlueSwapFilter();
			Image duplicatedImage = new Image(image.copy(image));
			undoList.add(duplicatedImage);
			undoListSize++;
			imagePanel = new ImagePanel(image, this);
			setContentPane(imagePanel);
			this.revalidate();

			/////////////////////
			// Black and White //
			/////////////////////
		} else if (src == this.blackAndWhite) {
			imagePanel.stop_cropping();
			image.blackAndWhiteFilter();
			Image duplicatedImage = new Image(image.copy(image));
			undoList.add(duplicatedImage);
			undoListSize++;
			imagePanel = new ImagePanel(image, this);
			setContentPane(imagePanel);
			this.revalidate();

			//////////////////////
			// Rotate Clockwise //
			//////////////////////
		} else if (src == this.rotateClockwise) {
			imagePanel.stop_cropping();
			image.rotateClockwiseFilter();
			Image duplicatedImage = new Image(image.copy(image));
			undoList.add(duplicatedImage);
			undoListSize++;
			imagePanel = new ImagePanel(image, this);
			setContentPane(imagePanel);
			this.revalidate();

			//////////////
			// Brighten //
			//////////////
		} else if (src == this.brighten) {
			imagePanel.stop_cropping();
			image.brightenFilter();
			Image duplicatedImage = new Image(image.copy(image));
			undoList.add(duplicatedImage);
			undoListSize++;
			imagePanel = new ImagePanel(image, this);
			setContentPane(imagePanel);
			this.revalidate();

			////////////////////
			// Photo Negative //
			////////////////////
		} else if (src == this.photoNegative) {
			imagePanel.stop_cropping();
			image.photoNegativeFilter();
			Image duplicatedImage = new Image(image.copy(image));
			undoList.add(duplicatedImage);
			undoListSize++;
			imagePanel = new ImagePanel(image, this);
			setContentPane(imagePanel);
			this.revalidate();

			////////////////
			// Brightness //
			////////////////
		} else if (src == this.brightness) {
			imagePanel.stop_cropping();
			imagePanel = new ImagePanel(image, this);
			imagePanel.add(brightnessSliderPanel, BorderLayout.SOUTH);
			setContentPane(imagePanel);
			this.revalidate();

			//////////
			// Crop //
			//////////
		} else if (src == this.crop) {
			crop.setEnabled(false);
			image.crop(imagePanel.getx1(), imagePanel.getx2(), imagePanel.gety1(), imagePanel.gety2());
			imagePanel.stop_cropping();
			Image duplicatedImage = new Image(image.copy(image));
			undoList.add(duplicatedImage);
			undoListSize++;
			imagePanel = new ImagePanel(duplicatedImage, this);
			setContentPane(imagePanel);
			enableFilters();
			this.revalidate();

			//////////
			// Undo //
			//////////
		} else if (src == this.undo) {
			imagePanel.stop_cropping();
			undo();
			setContentPane(imagePanel);
			this.revalidate();
			
			////////////////
			// Saturation //
			////////////////
		} else if (src == this.saturation) {
			imagePanel.stop_cropping();
			imagePanel.add(saturationSliderPanel);
			setContentPane(imagePanel);
			this.revalidate();
		}
	}

	/**
	 * Handles the slider inputs from the user for both brightness and saturation.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider src = (JSlider) e.getSource();
		if (!src.getValueIsAdjusting()) {
			if (src == brightnessSlider) {
				int brightnessVal = (int) src.getValue();
				image.brightness(brightnessVal);

				Image duplicatedImage = new Image(image.copy(image));
				undoList.add(duplicatedImage);
				undoListSize++;
				imagePanel = new ImagePanel(duplicatedImage, this);

			} else if (src == saturationSlider) {
				int sliderValue = (int) src.getValue();
				image.saturation(sliderValue);

				Image duplicatedImage = new Image(image.copy(image));
				undoList.add(duplicatedImage);
				undoListSize++;
				imagePanel = new ImagePanel(duplicatedImage, this);

			}
			setContentPane(imagePanel);
			this.revalidate();
		}
	}

	/**
	 * Uses an ArrayList of images to undo the previous filter by showing the
	 * previous image.
	 */
	public void undo() {
		// index for current image
		int currentImageIndex = undoListSize - 1;
		// displayed image
		int indexToDisplay = currentImageIndex - 1;

		// display images contained in the image array list
		if (indexToDisplay >= 0) {
			Image tempImage = undoList.get(indexToDisplay);
			undoList.remove(currentImageIndex);
			image = new Image(tempImage.copy(tempImage));
			imagePanel = new ImagePanel(tempImage, this);
			--undoListSize;
		}
	}

	/**
	 * Disables all filters except crop.
	 */
	public void cropMode() {
		this.crop.setEnabled(true);
		this.redBlueSwap.setEnabled(false);
		this.rotateClockwise.setEnabled(false);
		this.blackAndWhite.setEnabled(false);
		this.brighten.setEnabled(false);
		this.photoNegative.setEnabled(false);
		this.brightness.setEnabled(false);
		this.undo.setEnabled(false);
		this.saturation.setEnabled(false);
	}

	/**
	 * Enables all filters.
	 */
	public void enableFilters() {
		this.redBlueSwap.setEnabled(true);
		this.rotateClockwise.setEnabled(true);
		this.blackAndWhite.setEnabled(true);
		this.brighten.setEnabled(true);
		this.photoNegative.setEnabled(true);
		this.brightness.setEnabled(true);
		this.undo.setEnabled(true);
		this.saturation.setEnabled(true);

	}

	public void paintMe(Graphics g) {
		g.setColor(new Color(105, 105, 105, 125));
		this.repaint();
	}

	private static final long serialVersionUID = 1L;
}