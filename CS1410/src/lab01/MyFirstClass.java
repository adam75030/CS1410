package lab01;

public class MyFirstClass {

	public static void main(String[] args) {
		System.out.println("Hello!");
		System.out.println(multiply(5, 10));
		printSomething();
	}

	public static double multiply(double number1, double number2) {
		return number1 * number2;
	}

	public static void printSomething() {
		System.out.println("something");
		return; //don't need this line 
	}

}
 