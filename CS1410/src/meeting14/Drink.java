package meeting14;

/**
 * A drink has a name, price, volume, and container type
 * 
 * @author Travis Martin and CS1410 students
 * @version Mar 11, 2024
 */
public class Drink extends Item {
	private int volume; // in milliliters
	private String container;
	
	public Drink(String name, double price, int volume, String container) {
		super(name, price); // super is a keyword in Java, it is calling the 
							// *superclass* constructor
		// Second step -- call the superclass constructor as the FIRST
		// line in the subclass constructor
		// Drink's constructor is responsible for establishing values
		// for drink's variables
		// Item's constructor is responsible for establishing values
		// for Item's variables
		this.volume = volume;
		this.container = container;
	}
	
	/**
	 * Make a string like 
	 *   "Drink: Apple juice, $1.29, 500ml PET"
	 *   
	 * @return a detailed string with all info
	 */
	public String infoString() {
		return "Drink: " + getName() + ", $" + getPrice() + ", " + volume + "ml " + container;
	}
}
