package assign06;

/**
 * This class demonstrates how to create and use a Book object.
 *
 * @author Prof. Martin
 * @version Assignment 6
 */
public class BookDemo {

	public static void main(String[] args) {

		Book smallBook = new Book("small_book.txt");
		System.out.println("The book has " + smallBook.getWordCount() + " words.");
		System.out.println("The book has " + smallBook.getCharacterCount() + " characters.");
		System.out.println("On average, each word has " + smallBook.getAverageWordLength() + " characters.");
		System.out.println("The shortest word is \"" + smallBook.getShortestWord() + "\".");
		System.out.println("The longest word is \"" + smallBook.getLongestWord() + "\".");
		System.out.println("The word \"do\" occurs " + smallBook.getTargetWordCount("do") + " times.");
		System.out.println("The word that comes immediately before \"a\" (lexicographically) is \""
				+ smallBook.getWordLexicographicallyBefore("a") + "\".");
		System.out.println("The word that comes immediately after \"testing\" (lexicographically) is \""
				+ smallBook.getWordLexicographicallyAfter("testing") + "\".");
		smallBook.saveReversedBook("small_book_reversed.txt");
	}
}
