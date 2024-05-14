package lab13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;

public class MapAndSetPractice {

	public static String sortWord(String word) {
		char[] characters = word.toCharArray();
		Arrays.sort(characters);
		String sortedWord = new String(characters);
		return sortedWord;
	}

	public static List<List<String>> groupAnagrams(String[] words) {
		Map<String, List<String>> anagrams = new HashMap<>();
		for (String word : words) {
			String sortedWord = sortWord(word);
			if (!anagrams.containsKey(sortedWord)) {
				anagrams.put(sortedWord, new ArrayList<String>());
			}
			anagrams.get(sortedWord).add(word);
		}
		Collection<List<String>> values = anagrams.values();
		return new ArrayList<List<String>>(values);
	}

	public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
		Set<Integer> union = new TreeSet<>();
		for (Integer element : set1) {
			union.add(element);
		}
		for (Integer element : set2) {
			union.add(element);
		}
		return union;
	}
}
