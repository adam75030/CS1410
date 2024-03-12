package meeting03;

import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		while (input.hasNext()) {
			if (input.hasNextInt()) {
				System.out.println("int");
			} else if (input.hasNextDouble()) {
				System.out.println("double");
			} else if (input.hasNext()) {
				System.out.println("string");
			}
			input.next();
		}

	}

}
