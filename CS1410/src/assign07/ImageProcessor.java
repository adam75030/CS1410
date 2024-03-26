package assign07;

import java.util.Scanner;

/**
 * This class uses the filters and methods from Image and Pixel classes to make
 * a UI for an image processor program. It lists the effects in the console and
 * allows for the user to choose various filters and save the result as a file.
 * 
 * @author Adam Wightman
 * @version March 12, 2024
 */
public class ImageProcessor {

	public static void main(String[] args) {
		if (args.length != 2) {
			throw new RuntimeException("Use command-line arguments: Filename followed name of file to write to.");
		}
		Image image = new Image(args[0]);
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Select an option:\n" + "  1 -- Swap red and blue\n"
					+ "  2 -- Convert to black and white\n" + "  3 -- Rotate clockwise\n" + "  4 -- Brighten\n"
					+ "  5 -- Write image to file and quit");
			while (!scanner.hasNextInt()) {
				System.out.println("You must enter an integer 1 to 5. Try again.");
				scanner.next();
			}
			int input = scanner.nextInt();
			if (input < 1 || input > 5) {
				System.out.println("You must enter an integer 1 to 5. Try again.");
				scanner.next();
			}
			if (input == 1) {
				image.redBlueSwapFilter();
				System.out.println("... applying red and blue swap image filter");
			} else if (input == 2) {
				image.blackAndWhiteFilter();
				System.out.println("... applying black and white image filter");
			} else if (input == 3) {
				image.rotateClockwiseFilter();
				System.out.println("... applying rotate clockwise image filter");
			} else if (input == 4) {
				image.brightenFilter();
				System.out.println("... applying brighten image filter");
			} else if (input == 5) {
				image.writeImage(args[1]);
				System.out.println("Filtered image written to " + args[1]);
				break;
			}
			System.out.println();
			System.out.println("To cumulatively apply another filter, select 1-4. To see the results of the previous filter(s), select 5.");
		}
		scanner.close();
	}
}
