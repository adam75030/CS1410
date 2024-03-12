package meeting09;

public class CircleDemo {

	public static void main(String[] args) {
		// scale the circle by 3
		Circle circle1 = new Circle(5);
		System.out.println(circle1.getRadius());
		circle1.scale(3);
		System.out.println(circle1.getRadius());
		
		// scales the circle by 3 without changing the original
		Circle circle2 = circle1.scaledCopy(3);
		System.out.println(circle1.getRadius());
		System.out.println(circle2.getRadius());

	}
}
