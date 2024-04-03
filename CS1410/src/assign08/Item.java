package assign08;

/**
 * This class represents an Item object. It is an abstract class, and the
 * implementations are in the 4 subclasses. This class implements comparable for
 * future comparisons between subclasses.
 * 
 * @author Adam Wightman
 * @version March 29, 2024
 */
public abstract class Item implements Comparable<Item> {
	private String name;

	/**
	 * This constructor builds a default Item object.
	 * 
	 * @param name - the name of the object
	 */
	public Item(String name) {
		this.name = name;
	}

	/**
	 * Getter method for the Item name.
	 * 
	 * @return the name of the Item
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Abstract method to be implemented in other subclasses.
	 * 
	 * @return a description of the object
	 */
	public abstract String getDescription();

	/**
	 * Abstract method that will specify how the object is upgraded in the
	 * subclasses.
	 */
	public abstract void useUpgrade();
}
