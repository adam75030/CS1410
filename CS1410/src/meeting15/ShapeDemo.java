package meeting15;

import java.util.ArrayList;

public class ShapeDemo {
	public static void main(String[] args) {
		// Create a Shape2D and create a Circle
//		Shape2D generalShape = new Shape2D(0,0,"random undetermined shape");
		Circle circle = new Circle(1, 1, 5);
		// polymorphism
		Shape2D anotherGeneralShape = circle;

		System.out.println(circle.getRadius());
		System.out.println(anotherGeneralShape.area());

		isSmall(circle); // it feels weird that the area of a shape is 0

		Rectangle rect1 = new Rectangle(0, 0, 3, 3);
		rect1.draw();
		Rectangle rect2 = new Rectangle(0, 0, 2, 10);
		rect2.draw();

		ArrayList<Drawable> myThingsToDraw = new ArrayList<Drawable>();
		myThingsToDraw.add(rect2);
		myThingsToDraw.add(new Chair());
		for (Drawable d : myThingsToDraw) {
			d.draw();
		}
	}

	// create a method that checks if a shape is small (reminder about polymorphism)
	public static void isSmall(Shape2D shape) {
		System.out.println("We are checking the shape: " + shape.toString());
		if (shape.area() < 10)
			System.out.println("BOY THAT'S SMALL");
		else
			System.out.println("pretty big");
	}

}
