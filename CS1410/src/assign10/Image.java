package assign10;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class represents an image as a two-dimensional array of pixels and
 * provides a number of image filters (via instance methods) for changing the
 * appearance of the image. Application of multiple filters is cumulative; e.g.,
 * obj.redBlueSwapFilter() followed by obj.rotateClockwiseFilter() results in an
 * image altered both in color and orientation.
 *
 * @author Drs. Kabir, Martin and Adam Wightman
 * @version March 12, 2024
 */
public class Image {

	private Pixel[][] imageArray;

	/**
	 * Creates a new Image object by reading the image file with the given filename.
	 *
	 * @param filename - name of the given image file to read
	 * @throws IOException if file does not exist or cannot be read
	 */
	public Image(String filename) {
		BufferedImage imageInput = null;
		try {
			imageInput = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("Image file " + filename + " does not exist or cannot be read.");
		}

		imageArray = new Pixel[imageInput.getHeight()][imageInput.getWidth()];
		for (int i = 0; i < imageArray.length; i++)
			for (int j = 0; j < imageArray[0].length; j++) {
				int rgb = imageInput.getRGB(j, i);
				imageArray[i][j] = new Pixel((rgb >> 16) & 255, (rgb >> 8) & 255, rgb & 255);
			}
	}

	/**
	 * Create an Image object directly from a pre-made Pixel array. This is
	 * primarily to be used in testing.
	 * 
	 */
	public Image(Pixel[][] imageArray) {
		this.imageArray = imageArray;
	}

	/**
	 * Create a new "default" Image object, whose purpose is to be used in testing.
	 * The orientation of this image: cyan red green magenta yellow blue
	 *
	 */
	public Image() {
		imageArray = new Pixel[3][2];
		imageArray[0][0] = new Pixel(0, 255, 255); // cyan
		imageArray[0][1] = new Pixel(255, 0, 0); // red
		imageArray[1][0] = new Pixel(0, 255, 0); // green
		imageArray[1][1] = new Pixel(255, 0, 255); // magenta
		imageArray[2][0] = new Pixel(255, 255, 0); // yellow
		imageArray[2][1] = new Pixel(0, 0, 255); // blue
	}

	/**
	 * Gets the pixel at the specified row and column indexes.
	 *
	 * @param rowIndex    - given row index
	 * @param columnIndex - given column index
	 * @return the pixel at the given row index and column index
	 * @throws IndexOutOfBoundsException if row or column index is out of bounds
	 */
	public Pixel getPixel(int rowIndex, int columnIndex) {
		if (rowIndex < 0 || rowIndex >= imageArray.length)
			throw new IndexOutOfBoundsException("rowIndex must be in range 0-" + (imageArray.length - 1));

		if (columnIndex < 0 || columnIndex >= imageArray[0].length)
			throw new IndexOutOfBoundsException("columnIndex must be in range 0-" + (imageArray[0].length - 1));

		return imageArray[rowIndex][columnIndex];
	}

	/**
	 * Writes the image represented by this object to file. Does nothing if the
	 * image length is 0.
	 *
	 * @param filename - name of image file to write
	 * @throws IOException if file does cannot be written
	 */
	public void writeImage(String filename) {
		if (imageArray.length > 0) {
			BufferedImage imageOutput = new BufferedImage(imageArray[0].length, imageArray.length,
					BufferedImage.TYPE_INT_RGB);

			for (int i = 0; i < imageArray.length; i++)
				for (int j = 0; j < imageArray[0].length; j++)
					imageOutput.setRGB(j, i, imageArray[i][j].getPackedRGB());

			try {
				ImageIO.write(imageOutput, "png", new File(filename));
			} catch (IOException e) {
				System.out.println("The image cannot be written to file " + filename);
			}
		}
	}

	public int getNumberOfRows() {
		return this.imageArray.length;
	}

	public int getNumberOfColumns() {
		if (this.imageArray.length == 0)
			return 0;
		return this.imageArray[0].length;
	}

	/**
	 * Applies a filter to the image represented by this object such that for each
	 * pixel the red amount and blue amount are swapped.
	 */
	public void redBlueSwapFilter() {
		for (int i = 0; i < imageArray.length; i++) {
			for (int j = 0; j < imageArray[0].length; j++) {
				int origRed = imageArray[i][j].getRedAmount();
				int origGreen = imageArray[i][j].getGreenAmount();
				int origBlue = imageArray[i][j].getBlueAmount();
				Pixel swapRedBlue = new Pixel(origBlue, origGreen, origRed);
				imageArray[i][j] = swapRedBlue;
			}
		}
	}

	/**
	 * Applies a filter to the image represented by this object such that the color
	 * of each pixel is converted to its corresponding grayscale shade, producing
	 * the effect of a black and white photo.
	 */
	public void blackAndWhiteFilter() {
		for (int i = 0; i < imageArray.length; i++) {
			for (int j = 0; j < imageArray[0].length; j++) {
				int origRed = imageArray[i][j].getRedAmount();
				int origGreen = imageArray[i][j].getGreenAmount();
				int origBlue = imageArray[i][j].getBlueAmount();
				int average = (origRed + origGreen + origBlue) / 3;
				Pixel blackAndWhite = new Pixel(average, average, average);
				imageArray[i][j] = blackAndWhite;
			}
		}
	}

	/**
	 * Applies a filter to the image represented by this object such that it is
	 * rotated clockwise (by 90 degrees).
	 */
	public void rotateClockwiseFilter() {
		Pixel[][] rotatedImage = new Pixel[imageArray[0].length][imageArray.length];
		for (int j = 0; j < imageArray[0].length; j++) {
			for (int i = 0; i < imageArray.length; i++) {
				rotatedImage[j][i] = imageArray[imageArray.length - 1 - i][j];
			}
		}
		imageArray = rotatedImage;
	}

	/**
	 * Applies a filter to the image represented by this object such that the color
	 * of each pixel is increased and the image is "brightened". The brightness
	 * cannot exceed 255.
	 */
	public void brightenFilter() {
		for (int i = 0; i < imageArray.length; i++) {
			for (int j = 0; j < imageArray[0].length; j++) {
				int origRed = imageArray[i][j].getRedAmount();
				int origGreen = imageArray[i][j].getGreenAmount();
				int origBlue = imageArray[i][j].getBlueAmount();
				int brightenedRed = origRed + 20;
				int brightenedGreen = origGreen + 20;
				int brightenedBlue = origBlue + 20;
				if (brightenedRed > 255) {
					brightenedRed = 255;
				}
				if (brightenedGreen > 255) {
					brightenedGreen = 255;
				}
				if (brightenedBlue > 255) {
					brightenedBlue = 255;
				}
				Pixel brightened = new Pixel(brightenedRed, brightenedGreen, brightenedBlue);
				imageArray[i][j] = brightened;
			}
		}
	}

	/**
	 * Applies a filter to the image represented by this object such that the color
	 * of each pixel is the exact opposite of the pixels from the original image
	 */
	public void photoNegativeFilter() {
		// iterate through the rows and columns of the Pixel array
		for (int row = 0; row < imageArray.length; row++) {
			for (int col = 0; col < imageArray[0].length; col++) {
				// get the RGB from every pixel
				int greenColor = imageArray[row][col].getGreenAmount();
				int redColor = imageArray[row][col].getRedAmount();
				int blueColor = imageArray[row][col].getBlueAmount();
				// creating the new colors
				int newRed = 255 - redColor;
				int newGreen = 255 - greenColor;
				int newBlue = 255 - blueColor;
				// set the image array to contain the modified pixels
				imageArray[row][col] = new Pixel(newRed, newGreen, newBlue);
			}
		}
	}
}
