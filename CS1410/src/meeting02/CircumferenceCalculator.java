package meeting02;

public class CircumferenceCalculator {

	public static void main(String[] args) {
		double radius = 3;
		double pi = 3.14159265;
		// calculate the circumference
		double circumferenceOfCircle = 2 * pi * radius;

		String message = "The area of our circle with radius " + radius + " is " + calculateArea(radius);
		System.out.println(message);

		System.out.println(calculatePerimeter(5, 10));

	}

	// calculates and returns the area of a circle
	public static double calculateArea(double radius) {
		double pi = 3.14;
		return pi * radius * radius;
	}

	public static double calculatePerimeter(double length, double width) {
		return (2 * length) + (2 * width);
	}

}
