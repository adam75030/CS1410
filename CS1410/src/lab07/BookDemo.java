package lab07;

/**
 * This class demonstrates how to create and use a Book object.
 *
 * @author Drs. Kabir, Martin
 * @version Lab 7
 */
public class BookDemo {

	public static void main(String[] args) {

		Book smallBook = new Book("small_book.txt");
		System.out.println("The book has " + smallBook.getCharacterCount() + " characters.");

		System.out.println("The word that comes immediately before \"book\" (lexicographically) is \"" + smallBook.getWordLexicographicallyBefore("book") + "\".");
		System.out.println("The word that comes immediately before \"the\" (lexicographically) is \"" + smallBook.getWordLexicographicallyBefore("the") + "\".");
		System.out.println("The word that comes immediately before \"a\" (lexicographically) is \"" + smallBook.getWordLexicographicallyBefore("a") + "\".");
		System.out.println("No word comes immediately before \"Book\" (lexicographically), so \"" + smallBook.getWordLexicographicallyBefore("Book") + "\" is returned.");
	}
}
