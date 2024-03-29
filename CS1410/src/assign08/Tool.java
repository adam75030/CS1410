package assign08;

import java.util.Random;

/**
 * This class represents a Tool object. It extends Item, and implements the
 * abstract methods from Item.
 * 
 * @author Adam Wightman
 * @version March 29, 2024
 */
public class Tool extends Item {
	private int power;

	/**
	 * This constructor builds a Tool object given name and power parameters.
	 * 
	 * @param name  - the name of the Tool
	 * @param power - the power level of the Tool
	 */
	public Tool(String name, int power) {
		super(name);
		this.power = power;
	}

	/**
	 * This method compares the power of two Tool objects, and also compares Tool
	 * objects to other subclasses.
	 * 
	 * @return an int representing > or < values
	 */
	@Override
	public int compareTo(Item other) {
		if (other instanceof Tool) {
			if (this.power > ((Tool) other).power) {
				return 1;
			} else if (this.power < ((Tool) other).power) {
				return -1;
			} else {
				return 0;
			}
		}
		return 1;
	}

	/**
	 * Returns a description of this Tool object.
	 * 
	 * @return a description of this Tool object
	 */
	@Override
	public String getDescription() {
		return "Tool: " + this.getName() + " - power=" + this.power;
	}

	/**
	 * This method adds a random number (1 - 100) to the power level of this Tool
	 * object.
	 */
	@Override
	public void useUpgrade() {
		Random random = new Random();
		int randomNum = random.nextInt(1, 100);
		this.power += randomNum;
	}
}
