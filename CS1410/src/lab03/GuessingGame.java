package lab03;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		// Generate a random number
		Random generator = new Random();
		int computerNumber = generator.nextInt(1, 101);
		Scanner userInput = new Scanner(System.in);

		// Compare user input to computer
		int tries = 7;
		for (int i = 0; i < tries; i++) {
			int guess = getUserGuess(userInput);
			if (guess < computerNumber) {
				System.out.println("too low");
			} else if (guess > computerNumber) {
				System.out.println("too high");
			} else {
				System.out.println("you win!");
				System.exit(0);
			}
		}
	}

	public static int getUserGuess(Scanner userInput) {
		// Verify user input
		while (true) {
			System.out.print("Enter an integer (1 - 100): ");
			if (!userInput.hasNextInt()) {
				userInput.next();
				System.out.println("Invalid, try again!");
			} else {
				int guess = userInput.nextInt();
				if (guess > 0 && guess <= 100) {
					return guess;
				} else {
					System.out.println("Invalid, try again!");
				}
			}
		}
	}
}
