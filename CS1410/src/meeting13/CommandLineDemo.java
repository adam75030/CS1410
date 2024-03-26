package meeting13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class demonstrates how to use command-line arguments.
 * 
 * @author Prof. Martin
 * @version February 28, 2024
 */
public class CommandLineDemo {

	public static void main(String[] args) {

		if (args.length != 2)
			throw new RuntimeException("Use command-line arguments: Filename followed by the number of repetitions");

		String filename = args[0];
		int repeatTimes = Integer.parseInt(args[1]);

		ArrayList<String> lines = new ArrayList<String>();

		try (Scanner fileInput = new Scanner(new File(filename))) {
			while (fileInput.hasNextLine())
				lines.add(fileInput.nextLine());
		} catch (FileNotFoundException e) {
			System.out.println("File " + filename + " does not exist.");
		}

		for (int i = 0; i < repeatTimes; i++) {
			for (String line : lines)
				System.out.println(line);
		}
	}
}
