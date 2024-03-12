package assign03;

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * CS 1410 Assignment 3: Wordle
 * 
 * @author Adam Wightman
 * @version January 29, 2024
 */
public class ConsoleWordle {

	/**
	 * Uses the various helper methods to run a game of Wordle with 6 rounds.
	 */
	public static void main(String[] args) {
		try {
			String secretWord;
			secretWord = getSecretWord(readFile("words.txt"));
			Scanner scanner = new Scanner(System.in);
			int roundNumber = 1;
			while (roundNumber < 7) {
				System.out.println("ROUND " + roundNumber + " -- Enter a word:");
				String userGuess = getUserGuess(scanner);
				displayResultOfRound(userGuess, secretWord);
				if (userGuess.equals(secretWord)) {
					System.out.println("You Win!");
					break;
				} else if (roundNumber == 6) {
					System.out.println(
							"Sorry! You didn't guess the secret word " + '\"' + secretWord + '\"' + " in six rounds.");
				}
				roundNumber++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found, please try again. Exception: " + e);
		}
	}

	/**
	 * Returns an array representation of the contents of the input file.
	 * 
	 * @param filename the name of a file
	 * @return an array version of the input file
	 * @throws FileNotFoundException
	 */
	public static String[] readFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		// Use a scanner to go through the file contents
		Scanner fileInput = new Scanner(file);
		String[] fileArray = new String[fileInput.nextInt()];
		int index = 0;
		// Assign the contents of the file to an array
		while (fileInput.hasNext()) {
			fileArray[index] = fileInput.next();
			index++;
		}
		fileInput.close();
		return fileArray;
	} 

	/**
	 * Returns a random word from the input String[] array.
	 * 
	 * @param array the name of the String[] array
	 * @return a random String from the input array
	 */
	public static String getSecretWord(String[] array) {
		Random random = new Random();
		// The random number will be a number within the array indexes
		int randomNum = random.nextInt(array.length);
		String secretWord = array[randomNum];
		return secretWord;
	}

	/**
	 * Returns true if the input char is contained in the input String.
	 * 
	 * @param inputChar the char to look for in the input String
	 * @param inputWord the String to search through
	 * @return a boolean true if the char is in the String
	 */
	public static boolean letterContainedInWord(char inputChar, String inputWord) {
		// Compare every character of the inputWord to the inputCharacter
		for (int i = 0; i < inputWord.length(); i++) {
			if (inputWord.charAt(i) == inputChar) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the user-guessed 5 letter word using a scanner.
	 * 
	 * @param userInput the name of a scanner object
	 * @return the user input guess
	 */
	public static String getUserGuess(Scanner userInput) {
		while (true) {
			// Keep asking the user for valid input
			if (!userInput.hasNext()) {
				userInput.next();
				System.out.println("Invalid, try again:");
			} else {
				String userGuess = userInput.next();
				// Only return once the input is 5 characters
				if (userGuess.length() == 5) {
					return userGuess;
				} else {
					System.out.println("Invalid, try again:");
				}
			}
		}
	}

	/**
	 * Prints the results of the user guess depending on how close it is to the
	 * secret word.
	 * 
	 * @param userGuess  the user's 5 letter guess
	 * @param secretWord a randomly chosen word from the file
	 */
	public static void displayResultOfRound(String userGuess, String secretWord) {
		for (int i = 0; i < userGuess.length(); i++) {
			if (userGuess.charAt(i) == secretWord.charAt(i)) {
				System.out.print(Character.toUpperCase(userGuess.charAt(i)));
			} else if (letterContainedInWord(userGuess.charAt(i), secretWord)) {
				System.out.print(userGuess.charAt(i));
			} else {
				System.out.print("-");
			}
		}
		System.out.println();
	}
}
