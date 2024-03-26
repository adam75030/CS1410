package meeting14;

/**
 * Frozen food has a name, price, and expiration date
 * 
 * @author Travis Martin and CS1410 students
 * @version Mar 11, 2024
 */
public class Frozen extends Item {
	private String expiration;
	
	public Frozen(String name, double price, String expiration) {
		super(name, price);
		this.expiration = expiration;
	}
	
	/**
	 * Make a string like 
	 *   "Frozen: peas, $0.99, expires 2022/10/31"
	 *   
	 * @return a detailed string with all info
	 */
	public String infoString() {
		return "Frozen: " + getName() + ", $" + getPrice() + ", expires " + expiration;
	}
}
