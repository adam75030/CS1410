package lab07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class represents a book (read from file), specifically all words in a
 * book. The instance methods provide various book stats, such as number of
 * words.
 *
 * Note that a word is considered to be any sequence of symbols separated by
 * whitespace. For example, a book file containing "Hello, world." has two
 * words: "Hello," and "world."
 *
 * @author Drs. Kabir, Martin and ?
 * @version Lab 7
 */
public class Book {

	private DynamicArray words;

	/**
	 * Creates a Book object, given a filename for the book file to read. If no file
	 * with the given name exists, creates an empty book.
	 *
	 * @param filename - the name of the file containing the book
	 *
	 *                 DO NOT MODIFY THIS METHOD
	 */
	public Book(String filename) {
		words = new DynamicArray();

		// This try-with-resources block automatically closes the Scanner when the try
		// block
		// finishes or if an exception is handled.
		// Notice the omission of an explicit call to close.
		try (Scanner fileInput = new Scanner(new File(filename))) {
			while (fileInput.hasNext())
				words.append(fileInput.next());
		} catch (FileNotFoundException e) {
			// Do nothing -- words dynamic array contains 0 elements.
		}
	}

	/**
	 * Gets the number of characters in this book.
	 *
	 * @return the number of characters in this book
	 */
	public int getCharacterCount() {
		int characterCount = 0;
		for (int index = 0; index < words.size(); index++)
			characterCount += words.getElement(index).length();

		return characterCount;
	}

	/**
	 * Determines the word that would come immediately before the given target word
	 * if all the distinct words in this book were arranged in lexicographic order.
	 * If there is no such word, returns the target word.
	 *
	 * Note: This method does not actually put the words into lexicographic order.
	 *
	 * @param targetWord - the given target word
	 * @return the word that comes immediately before the target word,
	 *         lexicographically
	 */
	public String getWordLexicographicallyBefore(String targetWord) {
		// Step 1: Put all strings that come before targetWord (lexicographically)
		// in a *new* dynamic array (different from the words dynamic array).
		DynamicArray wordsThatComeBefore = new DynamicArray();
		for (int i = 0; i < words.size(); i++) {
			String word = words.getElement(i);
			if (word.compareTo(targetWord) < 0) {
				wordsThatComeBefore.append(word);

			}
		}
		// Step 2: If no strings come before targetWord (lexicographically),
		// return targetWord.
		if (wordsThatComeBefore.size() == 0) {
			return targetWord;
		}
		// Step 3: The (lexicographically) latest string in the wordsThatComeBefore
		// dynamic array is the one that comes immediately before targetWord
		// (lexicographically).
		String latestWord = wordsThatComeBefore.getElement(0);
		for (int i = 1; i < wordsThatComeBefore.size(); i++) {
			String word = wordsThatComeBefore.getElement(i);
			if (word.compareTo(latestWord) > 0)
				latestWord = word;
		} 
		return latestWord; // Update this code; do not return an empty string.
	}
}
