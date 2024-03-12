// CS 1410 Assignment 2: Problem solving practice by Adam Wightman (January 18, 2024).

package assign02;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemSolvingPractice {

	// Checks if a given String is a palindrome by comparing the start and end
	// characters
	public static boolean isPalindrome(String input) {
		int index = 0;
		while (index < input.length()) {
			// if the char at the front is the same as the char at the end, increment the
			// index and continue
			if (input.charAt(index) == input.charAt(input.length() - 1 - index)) {
				index++;
			} else {
				return false; 
			}
		}
		return true;
	}

	// Counts the amount of integer tokens in a given String
	public static int countIntTokens(String text) {
		Scanner scanner = new Scanner(text);
		int count = 0;
		while (scanner.hasNext()) {
			// if the token is an int, increment the count and advance the scanner
			if (scanner.hasNextInt()) {
				count++;
				scanner.next();
			} else {
				scanner.next();
			}
		}
		scanner.close();
		return count;
	}

	// Checks if there are more odd than even integers in a given String
	public static boolean moreOddThanEven(String text) {
		Scanner scanner = new Scanner(text);
		int evenCount = 0;
		int oddCount = 0;
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				// set the current integer equal to a currentNum variable
				int currentNum = scanner.nextInt();
				// if the current number is even, increase the count
				if (currentNum % 2 == 0) {
					evenCount++;
				} else {
					oddCount++;
				}
				// advance the scanner if the token isn't an integer
			} else {
				scanner.next();
			}
		}
		scanner.close();
		return oddCount > evenCount;
	}

	// Returns a camelCase version of a given String
	public static String camelCase(String words) {
		Scanner scanner = new Scanner(words);
		// return empty string if an empty string is input
		if (words.equals("")) {
			scanner.close();
			return "";
		}
		// initialize the return string
		String camelCaseString = "";
		while (scanner.hasNext()) {
			String currentWord = scanner.next();
			// get the first char from the word
			char firstChar = currentWord.charAt(0);
			// make that char upperCase
			firstChar = Character.toUpperCase(firstChar);
			String restOfWord = currentWord.substring(1); 
			// add the upperCase char to the rest of the word
			String upperCaseWord = firstChar + restOfWord;
			camelCaseString += upperCaseWord;
		}
		char lowercaseChar = camelCaseString.charAt(0);
		// change the first character of the return string to lowerCase
		lowercaseChar = Character.toLowerCase(lowercaseChar);
		String restOfCamelCaseWord = camelCaseString.substring(1);
		// add the lowerCase char to the rest of the String
		camelCaseString = lowercaseChar + restOfCamelCaseWord;
		scanner.close();
		return camelCaseString;
	}

	// Returns the average of all the positive integers in a given array
	public static double positiveAverage(int[] nums) {
		int positiveCount = 0;
		double positiveTotal = 0;
		for (int i = 0; i < nums.length; i++) {
			// if the current element is positive, increment the counter
			if (nums[i] > 0) {
				positiveCount++;
				// add the current element to total
				positiveTotal += nums[i];
			}
		}
		return positiveTotal / positiveCount;
	}

	// Returns the amount that each integer (1-10) appears in a given array
	public static int[] frequencyCount(int[] nums) {
		// create a new array of 10 ints
		int[] frequencyArray = new int[10];
		// loop through the input array
		for (int i = 0; i < nums.length; i++) {
			// the new array will add 1 at the index of the current element, thus the
			// frequency
			frequencyArray[nums[i] - 1] += 1;
		}
		return frequencyArray;
	}

	public static void main(String[] args) {
		// isPalindrome Tests
		System.out.println("Checking isPalindrome(\"abba\"). Expecting a result of true. The actual result is "
				+ isPalindrome("abba") + ".");
		System.out.println(
				"Checking isPalindrome(\"saippuakivikauppias\"). Expecting a result of true. The actual result is "
						+ isPalindrome("saippuakivikauppias") + ".");
		System.out.println("Checking isPalindrome(\"hello\"). Expecting a result of false. The actual result is "
				+ isPalindrome("hello") + ".");
		System.out.println("Checking isPalindrome(\"\"). Expecting a result of true. The actual result is "
				+ isPalindrome("") + ".");
		System.out.println();

		// countIntTokens Tests
		System.out.println(
				"Checking countIntTokens(\"there are 3 exams in 1410\"). Expecting a result of 2. The actual result is "
						+ countIntTokens("there are 3 exams in 1410") + ".");
		System.out
				.println("Checking countIntTokens(\"-5 -4 -3 -2 -1 0\"). Expecting a result of 6. The actual result is "
						+ countIntTokens("-5 -4 -3 -2 -1 0") + ".");
		System.out
				.println("Checking countIntTokens(\"hello30hello 10\"). Expecting a result of 1. The actual result is "
						+ countIntTokens("hello30hello 10") + ".");
		System.out.println("Checking countIntTokens(\"\"). Expecting a result of 0. The actual result is "
				+ countIntTokens("") + ".");
		System.out.println();

		// moreOddThanEven Tests
		System.out.println(
				"Checking moreOddThanEven(\"1 3 4 6 Hello -8\"). Expecting a result of false. The actual result is "
						+ moreOddThanEven("1 3 4 6 Hello -8") + ".");
		System.out
				.println("Checking moreOddThanEven(\"hello world\"). Expecting a result of false. The actual result is "
						+ moreOddThanEven("hello world") + ".");
		System.out.println(
				"Checking moreOddThanEven(\"-1 -2 -3 -4 -5\"). Expecting a result of true. The actual result is "
						+ moreOddThanEven("-1 -2 -3 -4 -5") + ".");
		System.out.println("Checking moreOddThanEven(\"\"). Expecting a result of false. The actual result is "
				+ moreOddThanEven("") + ".");
		System.out.println();

		// camelCase Tests
		System.out.println(
				"Checking camelCase(\"first letter in word\"). Expecting a result of firstLetterInWord. The actual result is "
						+ camelCase("first letter in word") + ".");
		System.out
				.println("Checking camelCase(\"hello world\"). Expecting a result of helloWorld. The actual result is "
						+ camelCase("hello world") + ".");
		System.out.println("Checking camelCase(\"singleword\"). Expecting a result of singleword. The actual result is "
				+ camelCase("singleword") + ".");
		System.out.println(
				"Checking camelCase(\"\"). Expecting a result of . The actual result is " + camelCase("") + ".");
		System.out.println();

		// positiveAverage Tests
		System.out.println(
				"Checking positiveAverage(new int[] { 2, 3, 4 }). Expecting a result of 3.0. The actual result is "
						+ positiveAverage(new int[] { 2, 3, 4 }) + ".");
		System.out.println(
				"Checking positiveAverage(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }). Expecting a result of 5.5. The actual result is "
						+ positiveAverage(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }) + ".");
		System.out.println(
				"Checking positiveAverage(new int[] { -3, -2, -1, 0, 1, 2 }). Expecting a result of 1.5. The actual result is "
						+ positiveAverage(new int[] { -3, -2, -1, 0, 1, 2 }) + ".");
		System.out.println("Checking positiveAverage(new int[] { 1 }). Expecting a result of 1.0. The actual result is "
				+ positiveAverage(new int[] { 1 }) + ".");
		System.out.println();

		// frequencyCount Tests
		int[] duplicates = { 5, 3, 4, 6, 5, 5, 4, 3, 10, 2, 4, 5, 6, 3, 2, 6 };
		System.out.println(
				"Checking frequencyCount(duplicates). Expecting a result of [0, 2, 3, 3, 4, 3, 0, 0, 0, 1]. The actual result is "
						+ Arrays.toString(frequencyCount(duplicates)) + ".");
		int[] duplicates2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(
				"Checking frequencyCount(duplicates2). Expecting a result of [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]. The actual result is "
						+ Arrays.toString(frequencyCount(duplicates2)) + ".");
		int[] duplicates3 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(
				"Checking frequencyCount(duplicates2). Expecting a result of [11, 0, 0, 0, 0, 0, 0, 0, 0, 0]. The actual result is "
						+ Arrays.toString(frequencyCount(duplicates3)) + ".");
		int[] duplicates4 = { 5 };
		System.out.println(
				"Checking frequencyCount(duplicates4). Expecting a result of [0, 0, 0, 0, 1, 0, 0, 0, 0, 0]. The actual result is "
						+ Arrays.toString(frequencyCount(duplicates4)) + ".");
	}
}