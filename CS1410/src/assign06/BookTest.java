package assign06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains tests for the Book class.
 *
 * @author Prof. Martin and Adam Wightman
 * @version February 25, 2024
 */
public class BookTest {

	private static Book smallBook;

	@BeforeAll
	public static void setup() {
		smallBook = new Book("small_book.txt");
	}

	@Test
	public void testGetWordCount() {
		assertEquals(32, smallBook.getWordCount());
	}

	@Test
	public void testGetCharacterCount() {
		assertEquals(137, smallBook.getCharacterCount());
	}

	@Test
	public void testGetAverageWordLength() {
		assertEquals(4.28125, smallBook.getAverageWordLength(), 0.00001);
	}

	@Test
	public void testGetShortestWord() {
		assertEquals("a", smallBook.getShortestWord());
	}

	@Test
	public void testGetLongestWord() {
		assertEquals("checking", smallBook.getLongestWord());
	}

	@Test
	public void testGetTargetWordCount() {
		assertEquals(2, smallBook.getTargetWordCount("do"));
	}

	@Test
	public void testGetWordLexicographicallyBefore() {
		assertEquals("Use", smallBook.getWordLexicographicallyBefore("a"));
	}

	@Test
	public void testGetWordLexicographicallyAfter() {
		assertEquals("the", smallBook.getWordLexicographicallyAfter("testing"));
	}

	@Test
	public void testSaveReversedBook() {
		String expected = "files. book large using testing thorough do also to sure be However, class. Book the of checking initial simple, some do to it Use book. small very a of example an This";
		String filename = "reverse_test.txt";
		smallBook.saveReversedBook(filename);
		try {
			Scanner fileInput = new Scanner(new File(filename));
			String actual = fileInput.nextLine();
			assertEquals(expected, actual);
			fileInput.close();
		} catch (FileNotFoundException e) {
			fail("File not written or written using incorrect path.");
		}
	}

	// Edge case testing
	@Test
	public void testGetTargetWordCountEmptyString() {
		assertEquals(0, smallBook.getTargetWordCount(""));
	}

	@Test
	public void testGetTargetWordCountDNE() {
		assertEquals(0, smallBook.getTargetWordCount("helloworld"));
	}

	@Test
	public void testGetWordLexicographicallyBeforeLetterA() {
		assertEquals("AAA", smallBook.getWordLexicographicallyBefore("AAA"));
	}

	@Test
	public void testGetWordLexicographicallyAfterLetterZ() {
		assertEquals("zebra", smallBook.getWordLexicographicallyAfter("zebra"));
	}

	// Tests for a regular book
	Book testBook = new Book("testBook.txt");

	@Test
	public void testGetWordCount2() {
		assertEquals(32, testBook.getWordCount());
	}

	@Test
	public void testGetCharacterCount2() {
		assertEquals(135, testBook.getCharacterCount());
	}

	@Test
	public void testGetAverageWordLength2() {
		assertEquals(4.21875, testBook.getAverageWordLength(), 0.00001);
	}

	@Test
	public void testGetShortestWord2() {
		assertEquals("a", testBook.getShortestWord());
	}

	@Test
	public void testGetLongestWord2() {
		assertEquals("characters.", testBook.getLongestWord());
	}

	@Test
	public void testGetTargetWordCount2() {
		assertEquals(0, testBook.getTargetWordCount("do"));
	}

	@Test
	public void testGetWordLexicographicallyBefore2() {
		assertEquals("has", testBook.getWordLexicographicallyBefore("hello"));
	}

	@Test
	public void testGetWordLexicographicallyAfter2() {
		assertEquals("that", testBook.getWordLexicographicallyAfter("testing"));
	}

	// Empty book edge case tests
	Book emptyBook = new Book("empty");

	@Test
	public void testGetWordCountEmpty() {
		assertEquals(0, emptyBook.getWordCount());
	}

	@Test
	public void testGetCharacterCountEmpty() {
		assertEquals(0, emptyBook.getCharacterCount());
	}

	@Test
	public void testGetAverageWordLengthEmpty() {
		assertEquals(Double.NaN, emptyBook.getAverageWordLength(), 0.00001);
	}

	@Test
	public void testGetShortestWordEmpty() {
		assertEquals(null, emptyBook.getShortestWord());
	}

	@Test
	public void testGetLongestWordEmpty() {
		assertEquals(null, emptyBook.getLongestWord());
	}

	@Test
	public void testGetTargetWordCountEmpty() {
		assertEquals(0, emptyBook.getTargetWordCount("do"));
	}

	@Test
	public void testGetWordLexicographicallyBeforeEmpty() {
		assertEquals("a", emptyBook.getWordLexicographicallyBefore("a"));
	}

	@Test
	public void testGetWordLexicographicallyAfterEmpty() {
		assertEquals("testing", emptyBook.getWordLexicographicallyAfter("testing"));
	}
}
