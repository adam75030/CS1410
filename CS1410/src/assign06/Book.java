package assign06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents a book (read from file), specifically all words in a
 * book. The instance methods provide various book stats, such as number of
 * words.
 *
 * @author Prof. Martin and Adam Wightman
 * @version February 25, 2024
 */
public class Book {
	private DynamicArray words;

	/**
	 * Creates a Book object, given a filename for the book file to read. If no file
	 * with the given name exists, creates an empty book.
	 * 
	 * @param filename - the name of the file containing the book
	 */
	public Book(String filename) {
		words = new DynamicArray();
		try (Scanner fileInput = new Scanner(new File(filename))) {
			while (fileInput.hasNext())
				words.append(fileInput.next());
		} catch (FileNotFoundException e) {
		}
	}

	/**
	 * Gets the number of words in this book.
	 * 
	 * @return the number of words in this book
	 */
	public int getWordCount() {
		return words.size();
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
	 * Gets the average word length of the words in this book.
	 * 
	 * @return the average word length of the words in this book
	 */
	public double getAverageWordLength() {
		return (double) getCharacterCount() / getWordCount();
	}

	/**
	 * Gets the shortest word in this book.
	 * 
	 * @return the shortest word in this book
	 */
	public String getShortestWord() {
		if (words.size() == 0) {
			return null;
		}
		String shortestWord = words.getElement(0);
		for (int i = 0; i < words.size(); i++) {
			if (words.getElement(i).length() < shortestWord.length()) {
				shortestWord = words.getElement(i);
			}
		}
		return shortestWord;
	}

	/**
	 * Gets the longest word in this book.
	 * 
	 * @return the longest word in this book
	 */
	public String getLongestWord() {
		if (words.size() == 0) {
			return null;
		}
		String longestWord = words.getElement(0);
		for (int i = 0; i < words.size(); i++) {
			if (words.getElement(i).length() > longestWord.length()) {
				longestWord = words.getElement(i);
			}
		}
		return longestWord;
	}

	/**
	 * Gets the amount of times that the given word appears in this book.
	 * 
	 * @param targetWord - the word to look for
	 * @return the amount that the target word appears in this book
	 */
	public int getTargetWordCount(String targetWord) {
		int targetWordCount = 0;
		for (int i = 0; i < words.size(); i++) {
			if (words.getElement(i).equals(targetWord)) {
				targetWordCount++;
			}
		}
		return targetWordCount;
	}

	/**
	 * Gets the word that comes immediately before the given target word in
	 * lexicographical order. If there is no such word, returns the target word.
	 * 
	 * @param targetWord - the given target word
	 * @return the word that comes immediately before the target word,
	 *         lexicographically
	 */
	public String getWordLexicographicallyBefore(String targetWord) {
		DynamicArray wordsThatComeBefore = new DynamicArray();
		for (int i = 0; i < words.size(); i++) {
			String word = words.getElement(i);
			if (word.compareTo(targetWord) < 0) {
				wordsThatComeBefore.append(word);
			}
		}
		if (wordsThatComeBefore.size() == 0) {
			return targetWord;
		}
		String latestWord = wordsThatComeBefore.getElement(0);
		for (int i = 1; i < wordsThatComeBefore.size(); i++) {
			String word = wordsThatComeBefore.getElement(i);
			if (word.compareTo(latestWord) > 0)
				latestWord = word;
		}
		return latestWord;
	}

	/**
	 * Gets the word that comes immediately after the given target word in
	 * lexicographical order. If there is no such word, returns the target word.
	 * 
	 * @param targetWord - the given target word
	 * @return the word that comes immediately after the target word,
	 *         lexicographically
	 */
	public String getWordLexicographicallyAfter(String targetWord) {
		DynamicArray wordsThatComeAfter = new DynamicArray();
		for (int i = 0; i < words.size(); i++) {
			String word = words.getElement(i);
			if (word.compareTo(targetWord) > 0) {
				wordsThatComeAfter.append(word);
			}
		}
		if (wordsThatComeAfter.size() == 0) {
			return targetWord;
		}
		String latestWord = wordsThatComeAfter.getElement(0);
		for (int i = 1; i < wordsThatComeAfter.size(); i++) {
			String word = wordsThatComeAfter.getElement(i);
			if (word.compareTo(latestWord) < 0)
				latestWord = word;
		}
		return latestWord;
	}

	/**
	 * Writes the words of this book to file, in reverse order.
	 * 
	 * @param filename - the name of the file to write
	 */
	public void saveReversedBook(String filename) {
		try (FileWriter fileOutput = new FileWriter(filename)) {
			int end = words.size() - 1;
			DynamicArray reversedBook = new DynamicArray();
			for (int i = 0; i < words.size(); i++) {
				reversedBook.append(words.getElement(end));
				end--;
			}
			for (int i = 0; i < reversedBook.size(); i++) {
				if (i == reversedBook.size() - 1) {
					fileOutput.write(reversedBook.getElement(i));
				} else {
					fileOutput.write(reversedBook.getElement(i) + " ");
				}
			}
			fileOutput.close();
		} catch (IOException e) {
		}
	}
}