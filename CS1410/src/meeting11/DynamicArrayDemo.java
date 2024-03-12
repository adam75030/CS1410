package meeting11;

import lab07.DynamicArray;

/**
 * This class demonstrates how to use DynamicArray objects.
 * 
 * @author Prof. Martin
 * @version Feb 21, 2024
 */
public class DynamicArrayDemo {

	public static void main(String[] args) {
		
		// Suppose that students are in the call queue to ask the TA a question.
		// How would we simulate this with a basic array?
		// (the actual TA queue does something like this, but within some functions)
		
		// We don't know how many students there will be to start
		// But this variable will always hold our TA queue information
		String[] taQueue = new String[0];
		
		// Sally joins the queue
		String[] tempQueue = new String[1];
		tempQueue[0] = "Sally";
		taQueue = tempQueue;
		
		// Joe joins the queue
		tempQueue = new String[2];
		tempQueue[0] = taQueue[0];
		tempQueue[1] = "Joe";
		taQueue = tempQueue;
		
		// Rogelio joins the queue
		tempQueue = new String[3];
		tempQueue[0] = taQueue[0];
		tempQueue[1] = taQueue[1];
		tempQueue[1] = "Rogelio";
		taQueue = tempQueue;
		
		/*
		 * Well Python does this much much better
		 * 
		 * myList = []
		 * myList.append("Sue")
		 * myList.append("Joe")
		 * myList.append("Rogelio")
		 * 
		 * Why is Python so much better than Java?
		 * What is going in Python. Does python  just have better stuff than Java
		 * NO, Python isn'd doing anything different than we can do in Java
		 * 
		 * How does it store this data at a low-level? Is it magic? NO
		 * 
		 * Actually, Java and Python both don't have anything fancier to store data
		 * than a fixed length array.
		 * 
		 * Python lists are convenient because of the magic of ABSTRACTION
		 * 
		 * Python list is just a class. And this class is using fixed length arrays underneath
		 * it is much more convenient because we just worry about calling a function, not how
		 * it works.
		 * 
		 * We can do the same thing today
		 * 
		 * Big questions:
		 * - how should this class work?
		 * - can we write code to grow our array?
		 * - this is programming in a nutshell. think of a problem we want to solve,
		 *   think about how to implement a solution, write code for that solution
		 *   test your solution
		 */
		
		
		
		// Suppose that students are in the call queue to ask the TA a question.
		DynamicArray taCallQueue = new DynamicArray();
		
		// Three students enter the queue when TA help hours start.
		taCallQueue.append("Bob");
		taCallQueue.append("Susan");
		taCallQueue.append("Rogelio");

		
		// The TA helps the first student.
		System.out.println("The TA is helping: " + taCallQueue.getElement(0));
		taCallQueue.delete(0);
		System.out.println("There are " + taCallQueue.size() + " students remaining in the queue " + taCallQueue + ".");

		// How can you append to an array
		// We ARE NOT APPENDING TO A FIXED LENGTH ARRAY
		// We think, there are two concepts now:
		// -- the dynamic array, which is a class we will write, which users will use
		// -- some underlying fixed-length array storing the data for the dynamic array
		
		// Is this the least expensive way, memory-wise to make a dynamic array
		// It seems very wasteful to keep creating more arrays every time
		
		
		
		
		
		
		
		
		
//		// Two more students enter the queue.
//		taCallQueue.append("Min");
//		taCallQueue.append("Riley");
//		
//		// The TA helps the next student.
//		System.out.println("The TA is helping: " + taCallQueue.getElement(0));
//		taCallQueue.delete(0);
//		System.out.println("There are " + taCallQueue.size() + " students remaining in the queue " + taCallQueue + ".");
//		
//		// Min solves her problem on her own and leaves the queue.
//		taCallQueue.delete(1);
//		
//		// The TA helps the next student.
//		System.out.println("The TA is helping: " + taCallQueue.getElement(0));
//		taCallQueue.delete(0);
//		System.out.println("There are " + taCallQueue.size() + " students remaining in the queue " + taCallQueue + ".");
		
		
		
		
		
		
		
		System.out.println("Beginning add test");
		for(int i = 0; i < 100000; i++) {
			taCallQueue.append("Sally" + i);
		}
		System.out.println("Done with add test");
	}
}