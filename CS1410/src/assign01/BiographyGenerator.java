// CS 1410 Assignment 1: Generating biographies by Adam Wightman (January 13, 2024).

package assign01;

public class BiographyGenerator {

	public static void main(String[] args) {
		// https://www.ncitech.co.uk/media/2_1174_Original_Famous_People_in_Computer_History_1deb09.pdf
		System.out.println(biographyMaker("Alan Turing", 2024, 1912,
				"deciphering the Enigma code with a primitive computer, and inventing the Turing Test for AI"));
		// https://www.ncitech.co.uk/media/2_1174_Original_Famous_People_in_Computer_History_1deb09.pdf
		System.out.println(biographyMaker("Linus Torvalds", 2024, 1964,
				"creating and developing the Linux kernel, used in the Linux OS"));
	}

	// Returns a difference in years using the current year and a past year
	public static int calculateYearDifference(int currentYear, int pastYear) {
		return currentYear - pastYear;
	}

	// Generates a String that describes a person, with how long ago they lived, and
	// a famous achievement
	public static String biographyMaker(String name, int currentYear, int birthYear, String famousAchievement) {
		return name + " was born " + calculateYearDifference(currentYear, birthYear) + " years ago. " + name
				+ " is famous for " + famousAchievement + ".";
	}

}
