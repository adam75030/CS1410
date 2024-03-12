package meeting01;

public class HelloWorld {
	
	public static void anotherMethod() {
		System.out.println("Other method");
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		anotherMethod();
		
		int count = 1;
		count += 12;
		
		boolean test = true;
		
		test = ! test;
		
		System.out.println(test);
	}

}

