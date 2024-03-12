package meeting11;

/**
 * This class demonstrates how to use and throw Exceptions.
 * 
 * @author Prof. Martin
 * @version Feb 21, 2024
 */
public class ExceptionDemo {
	
	public static void main(String[] args) {
		IndexOutOfBoundsException ex =
				new IndexOutOfBoundsException();
		throw new IndexOutOfBoundsException("That was a way too large of index");
	}

}
