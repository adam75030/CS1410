package meeting14;

/**
 * Produce has a name, price, and country
 * 
 * @author Travis Martin and CS1410 students
 * @version Mar 11, 2024
 */
public class Produce extends Item {
	private String country;
	
	public Produce(String name, double price, String country) {
		super(name, price);
		this.country = country;
	}
	
	/**
	 * Make a string like 
	 *   "Produce: apple, $1.29, product of USA"
	 *   
	 * @return a detailed string with all info
	 */
	public String infoString() {
		return "Produce: " + getName() + ", $" + getPrice() + ", product of " + country;
	}
}
