package meeting13;

import java.util.ArrayList;

/**
 * This class demonstrates how to use Java's generic class, ArrayList.
 * 
 * @author Prof. Martin and Dr. Kabir
 * @version February 28, 2024
 */
public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<String> daysOfWeek = new ArrayList<String>();
		daysOfWeek.add("Sunday");
		daysOfWeek.add("Monday");
		daysOfWeek.add("Tuesday");
		daysOfWeek.add("Wednesday");
		daysOfWeek.add("Thursday");
		daysOfWeek.add("Friday");
		daysOfWeek.add("Saturday");
		System.out.println(daysOfWeek);

	}
}
