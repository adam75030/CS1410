package lab13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * This class contains one test for each method written in Lab 13.
 * Students should add two more tests for each method.
 *
 * @author Prof. Martin
 * @version Lab 13
 */
public class MapAndSetPracticeTest {

	@Test
	public void testGroupAnagramsNormalCase() {
		String[] words = { "are", "bat", "ear", "code", "tab", "era" };
		List<List<String>> actual = MapAndSetPractice.groupAnagrams(words);

		assertEquals(3, actual.size(), "There should be three groups of anagrams.");

		// sort the list of groups by size (more on Comparator next week)
		actual.sort((list1, list2) -> list1.size() - list2.size());

		assertEquals(1, actual.get(0).size(), "There should be a group of only \"code\".");
		assertEquals("code", actual.get(0).get(0), "There should be a group of only \"code\".");

		assertEquals(2, actual.get(1).size(), "There should be a group of only \"bat\" and \"tab\".");
		actual.get(1).sort(null);  // sorts group lexicographically
		assertEquals("bat", actual.get(1).get(0), "There should be a group of only \"bat\" and \"tab\".");
		assertEquals("tab", actual.get(1).get(1), "There should be a group of only \"bat\" and \"tab\".");

		assertEquals(3, actual.get(2).size(), "There should be a group of only \"are\", \"ear\", and \"era\".");
		actual.get(2).sort(null);  // sorts group lexicographically
		assertEquals("are", actual.get(2).get(0), "There should be a group of only \"are\", \"ear\", and \"era\".");
		assertEquals("ear", actual.get(2).get(1), "There should be a group of only \"are\", \"ear\", and \"era\".");
		assertEquals("era", actual.get(2).get(2), "There should be a group of only \"are\", \"ear\", and \"era\".");
	}

	@Test
	public void testUnionNormalCase() {
		Set<Integer> set1 = Set.of(4, 8, 15, 16, 23, 42);
		Set<Integer> set2 = Set.of(16, 12, 8, 4, 0, -4);
		Set<Integer> actual = MapAndSetPractice.union(set1, set2);

		assertEquals(9, actual.size(), "There should be nine elements in the union set.");

		assertTrue(actual.contains(-4), "The union set should contain -4.");
		assertTrue(actual.contains(0), "The union set should contain 0.");
		assertTrue(actual.contains(4), "The union set should contain 4.");
		assertTrue(actual.contains(8), "The union set should contain 8.");
		assertTrue(actual.contains(12), "The union set should contain 12.");
		assertTrue(actual.contains(15), "The union set should contain 15.");
		assertTrue(actual.contains(16), "The union set should contain 16.");
		assertTrue(actual.contains(23), "The union set should contain 23.");
		assertTrue(actual.contains(42), "The union set should contain 42.");
	}
}
