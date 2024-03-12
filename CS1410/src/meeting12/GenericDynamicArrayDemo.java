package meeting12;

import assign05.Point2D;
import lab05.Fraction;

/**
 * This class demonstrates how to use the generic version of DynamicArray.
 * Three differently-typed dynamic arrays are used.
 * 
 * @author Prof. Martin
 * @version February 26, 2024
 */
public class GenericDynamicArrayDemo {

	public static void main(String[] args) {
		// Create a dynamic array to hold several student strings
		DynamicArray<String> myArrayOfStudents = new DynamicArray<String>();
		myArrayOfStudents.insert(0, "abc");
		
		DynamicArray<Fraction> myArrayOfFractions = new DynamicArray<Fraction>();
		myArrayOfFractions.append(new Fraction(1,2));
		
		Fraction first = myArrayOfFractions.getElement(0);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		DynamicArray<String> students = new DynamicArray<String>();
		students.append("Bob");
		students.append("Susan");
		students.append("Rogelio");
		students.append("Min");
		System.out.println(students);
		
		// Create a dynamic array to hold fractions
		DynamicArray<Fraction> portions = new DynamicArray<Fraction>();
		portions.append(new Fraction(1, 2));
		portions.append(new Fraction(1, 3));
		portions.append(new Fraction(1, 4));
		System.out.println(portions);
		
		// Create a dynamic array to hold 2D points
		DynamicArray<Point2D> points = new DynamicArray<Point2D>();
		points.append(new Point2D(10, 2));
		points.append(new Point2D(-1, 3));
		points.append(new Point2D(100, 40));	
		points.append(points.getElement(0).midpoint(points.getElement(1)));		
		System.out.println(points);
		
		
		
		
		
		// Create a dynamic array to hold integers
		DynamicArray<Integer> primeNumbers = new DynamicArray<Integer>();
		primeNumbers.append(2);  // autoboxing is happening to wrap int 2 as an Integer object
		primeNumbers.append(3);
		primeNumbers.append(5);	
		primeNumbers.append(7);		
		primeNumbers.append(11);
		primeNumbers.append(13);	
		primeNumbers.append(17);
		System.out.println(primeNumbers);
	}
}