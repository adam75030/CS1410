package meeting14;

/**
 * Deli has a name, price, time made, and cook's name
 * 
 * @author Travis Martin and CS1410 students
 * @version Mar 11, 2024
 */
public class Deli extends Item {
	private String time;
	private String maker;
	
	public Deli(String name, double price, String time, String maker) {
		super(name, price);
		this.time = time;
		this.maker = maker;
	}
	
	/**
	 * Make a string like 
	 *   "Deli: sandwich, $2.49, made at 9:30 by Harold"
	 *   
	 * @return a detailed string with all info
	 */
	public String infoString() {
		return "Deli: " + getName() + ", $" + getPrice() +
				", made at " + time + " by " + maker;
	}
	
	public boolean isDeliItem()  { 
		return true; // The power of inheritance!
	}
}
