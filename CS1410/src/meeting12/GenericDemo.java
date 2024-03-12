package meeting12;

import java.util.Arrays;

/**
 * This class demonstrates how to use the generic Triple class,
 * as well as define a generic static method.
 * 
 * @author Prof. Martin and CS 1410 class
 * @version February 26, 2024
 */
public class GenericDemo {
	
	public static void main(String[] args) {
		// Use the generic class for specific type String.
		Triple<String> greetings = new Triple<String>("Hello", "Hi", "Howdy");
		System.out.println(greetings);
		
		// Use the generic class for specific type Integer.
		Triple<Integer> numbers = new Triple<Integer>(1, 2, 3);
		System.out.println(numbers);
		
		// Use the generic class for specific type Triple.
		// I.e., this triple contains three triples.
		// Inception.
		// We have declared a type. The type is "triple of some thing"
		// "some thing" can be ANY type, including a triple
		Triple<Character> second = new Triple<Character>('m', 'n', 'o');
		Triple<Triple<Character>> letterTriples = 
				new Triple<Triple<Character>>(new Triple<Character>('a', 'b', 'c'), 
												second,
						                        new Triple<Character>('x', 'y', 'z'));
		System.out.println(letterTriples);
		
		// FILL IN: Use the generic class for specific type Fraction.
	}
	
}