package meeting13;

/**
 * This generic class represents a dynamic array of object (of any type).
 * 
 * A dynamic array behaves like a regular array that uses [], except it can grow
 * and shrink, as needed. Like a regular array, it is indexed beginning with 0.
 * When a DynamicArray object is created, it is empty.
 * 
 * @author Prof. Martin and CS 1410 students
 * @version February 26, 2024
 */
public class DynamicArray<Type> {

	private Type[] elements; // the backing array

	/**
	 * Creates an empty dynamic array.
	 */
	public DynamicArray() {
		elements = (Type[])new Object[0];  // This warning is acceptable for creating a generic array.
	}

	/**
	 * Appends the given item to end of this dynamic array.
	 * 
	 * @param item - the item to append
	 */
	public void append(Type item) {
		insert(elements.length, item);
	}

	/**
	 * Inserts a given item into this dynamic array at a given index.
	 * Throws an exception if the given index is out of bounds.
	 * 
	 * @param index - the index at which to insert
	 * @param item - the item to insert
	 */
	public void insert(int index, Type item) {
		// Ensure the value of index is valid.
		if(index < 0 || index > elements.length)
			throw new IndexOutOfBoundsException("Index " + index + 
					"is invalid for adding to this array with length " + elements.length);

		// Adding a new element requires more space, so make a new array.
		Type[] largerArray = (Type[]) new Object[elements.length + 1];  // This warning is acceptable for creating a generic array.

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
	public Type getElement(int index) {
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
	public void setElement(int index, Type item) {
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
		Type[] smallerArray = (Type[])new Object[elements.length - 1];  // This warning is acceptable for creating a generic array.

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
