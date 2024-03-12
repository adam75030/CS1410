package meeting05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDemo {

	public static void main(String[] args) {
		String filename = "sample_text.txt";
		File file = new File(filename);
		printContents(file);
	}

	public static void printContents(File file) {
		try {
			Scanner fileInput = new Scanner(file);
			while (fileInput.hasNext()) {
				String token = fileInput.next();
				System.out.println(token);
			}
			fileInput.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found, try again");
		}
	}
}
