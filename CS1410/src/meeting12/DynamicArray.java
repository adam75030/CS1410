package meeting12;

/**
 * This generic class represents a dynamic array of object (of any type).
 * 
 * A dynamic array behaves like a regular array that uses [], except it can grow
 * and shrink, as needed. Like a regular array, it is indexed beginning with 0.
 * When a DynamicArray object is created, it is empty.
 * 
 * @author Prof. Martin and CS 1410 students
 * @version Feb 26, 2024
 */
// I am going to make this a generic class
// This is a built-in java syntax that makes it so
// that this class can store ANY type of element
// (and, it's convenient to use)
public class DynamicArray<MyElementType> {
				// To make this a generic class, we need to add
				// a type parameter to the class definition
				// in this case, we put something inside
				// the angle brackets, it can be ANY valid variable name
				// this is the type parameter.
	
	
	// Once we have declared that dynamic array is GENERIC, we can use
	// the type parameter ANYWHERE within our class where we would normally
	// write a type

	private MyElementType[] elements; // the backing array
	
	/**
	 * Creates an empty dynamic array.
	 */
	public DynamicArray() {
		elements = (MyElementType[])new Object[0];  // This warning is acceptable for creating a generic array.
	}

	/**
	 * Appends the given item to end of this dynamic array.
	 * 
	 * @param item - the item to append
	 */
	public void append(MyElementType item) {
		insert(elements.length, item);
	}

	/**
	 * Inserts a given item into this dynamic array at a given index.
	 * Throws an exception if the given index is out of bounds.
	 * 
	 * @param index - the index at which to insert
	 * @param item - the item to insert
	 */
	public void insert(int index, MyElementType item) {
		// Ensure the value of index is valid.
		if(index < 0 || index > elements.length)
			throw new IndexOutOfBoundsException("Index " + index + 
					"is invalid for adding to this array with length " + elements.length);

		// Adding a new element requires more space, so make a new array.
		MyElementType[] largerArray = (MyElementType[]) new Object[elements.length + 1];  // This warning is acceptable for creating a generic array.

		// Copy elements from the backing array to the new array, up to the given index.
		for(int i = 0; i < index; i++) 
			largerArray[i] = elements[i];
		
		// Insert the new element at index.
		largerArray[index] = item;

		// Copy the remaining elements from the backing array to the new array, but 
		// shifted up one array slot.
		for(int i = index; i < elements.length; i++) 
			largerArray[i + 1] = elements[i];
	
		// Set the backing array reference to the new array.
		elements = largerArray;
	}

	/**
	 * Gets the element stored in this dynamic array at the given index.
	 * Throws an exception if the given index is out of bounds.
	 * 
	 * @param index - the index of the element to get
	 * @return the element at the given index
	 */
	public MyElementType getElement(int index) {
		if(index < 0 || index >= elements.length)
			throw new IndexOutOfBoundsException(
					"Index " + index + "is invalid for this array with length " + elements.length);

		return elements[index];
	}

	/**
	 * Returns the number of elements in this dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return elements.length;
	}

	/**
	 * Sets (i.e., changes) the element stored in this dynamic array at the given index
	 * to the given item.
	 * Throws an exception if the given index is out of bounds.
	 * 
	 * @param index - the index of the element to set
	 * @param item - the new item value for setting the element
	 */
	public void setElement(int index, MyElementType item) {
		if(index < 0 || index >= elements.length)
			throw new IndexOutOfBoundsException(
					"Index " + index + "is invalid for this array with length " + elements.length);

		elements[index] = item;
	}

	/**
	 * Deletes the item at the given index from this dynamic array. 
	 * Throws an exception if the given index is out of bounds.
	 * 
	 * @param index - the index of the element to delete
	 */
	public void delete(int index) {
		if(index < 0 || index >= elements.length)
			throw new IndexOutOfBoundsException(
					"Index " + index + "is invalid for this array with length " + elements.length);

		// Deleting an element requires less space, so make a new array.
		MyElementType[] smallerArray = (MyElementType[])new Object[elements.length - 1];  // This warning is acceptable for creating a generic array.

		// Copy elements from the backing array to the new array, up to the given index.
		for(int i = 0; i < index; i++) 
			smallerArray[i] = elements[i];

		// Copy the elements from the backing array to the new array, but 
		// shifted down one array slot.  This overwrites the deleted element.
		for(int i = index + 1; i < elements.length; i++) 
			smallerArray[i - 1] = elements[i];
		
		// Set the backing array reference to the new array.
		elements = smallerArray;
	}

	/**
	 * Generates a textual representation of this dynamic array.
	 * 
	 * @return the textual representation
	 */
	public String toString() {
		String result = "[";
		if(elements.length > 0) 
			result += elements[0];
		for(int i = 1; i < elements.length; i++) 
			result += ", " + elements[i];
		return result + "]";
	}
}