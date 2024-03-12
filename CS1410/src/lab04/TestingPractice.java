package lab04;

import java.util.Scanner;

public class TestingPractice {

	public static void main(String[] args) {
		System.out.println(camelCase("hello world 1 2 3 hello"));
		
		// Normal Cases:
		// camel case
		// computer science
		//
		// Edge Cases:
		// ""
		// word
		// 123!@#$
		//
		// Corner Cases: (two or more edge cases)
		// None, because of only one input
	}
	
	/**
	 * Returns a camelCase version of an originalText input.
	 * @param originalText any String
	 * @return a camelCase version of the originalText
	 */
	public static String camelCase(String originalText) {
		String camelCaseText = "";
		Scanner wordScanner = new Scanner(originalText);
		boolean firstWord = true;
		while (wordScanner.hasNext()) {
			String word = wordScanner.next();
			if (firstWord)
				camelCaseText = word;
			else {
				char firstLetter = word.charAt(0);
				char upperLetter = Character.toUpperCase(firstLetter);
				String camelWord = upperLetter + word.substring(1, word.length());
				camelCaseText += camelWord;
			}
			firstWord = false;
		}
		wordScanner.close();
		return camelCaseText;
	}
}
