package assign08;

import java.util.Random;

/**
 * This class represents a Magic object. It extends Item, and implements the
 * abstract methods from Item.
 * 
 * @author Adam Wightman
 * @version March 29, 2024
 */
public class Magic extends Item {
	private int power;
	private int cost;

	/**
	 * This constructor builds a Magic object given name, power, and cost
	 * parameters.
	 * 
	 * @param name  - the name of the Magic
	 * @param power - the power level of the Magic
	 * @param cost  - the cost level of the Magic
	 */
	public Magic(String name, int power, int cost) {
		super(name);
		this.power = power;
		this.cost = cost;
	}

	/**
	 * This method compares the power of two Magic objects, and also compares Magic
	 * objects to other subclasses.
	 * 
	 * @return an int representing > or < values
	 */
	@Override
	public int compareTo(Item other) {
		if (other instanceof Magic) {
			double thisPowerRatio = (double) this.power / this.cost;
			double otherPowerRatio = (double) ((Magic) other).power / ((Magic) other).cost;
			if (thisPowerRatio > otherPowerRatio) {
				return 1;
			} else if (thisPowerRatio < otherPowerRatio) {
				return -1;
			} else {
				return 0;
			}
		} else if (other instanceof Tool) {
			return -1;
		} else if (other instanceof Armor) {
			return -1;
		}
		return 1;
	}

	/**
	 * Returns a description of this Magic object.
	 *
	 * @return a description of this Magic object
	 */
	@Override
	public String getDescription() {
		return "Magic: " + this.getName() + " - power=" + this.power + ", cost=" + this.cost;
	}

	/**
	 * This method adds a random number (1 - 100) to the power and cost levels of
	 * this Magic object.
	 */
	@Override
	public void useUpgrade() {
		Random random = new Random();
		int randomNum = random.nextInt(1, 100);
		this.power += randomNum;
		this.cost += randomNum;
	}
}
