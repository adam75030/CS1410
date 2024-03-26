package meeting14;

/**
 * An Item has a name and price.
 * 
 * @author Travis Martin and CS1410 students
 * @version Mar 11, 2024
 */
public class Item {
	private String name;
	private double price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	/**
	 * Returns a string for a receipt, like "Apple Juice : 1.29"
	 */
	public String receiptString() {
		return name + " : " + price;
	}
	
	/**
	 * Make a string like 
	 *   "Drink: Apple juice, $1.29, 500ml PET"
	 *   
	 * @return a detailed string with all info
	 */
	public String infoString() {
		return "Item: " + name + ", " + price;
	}
	
	public boolean isDeliItem()  { // an instance method that says
								   // whether THIS current object is a deli or not
		return false;
	}
}
