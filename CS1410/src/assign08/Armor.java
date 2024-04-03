package assign08;

import java.util.Random;

/**
 * This class represents an Armor object. It extends Item, and implements the
 * abstract methods from Item.
 * 
 * @author Adam Wightman
 * @version March 29, 2024
 */
public class Armor extends Item {
	private int defense;

	/**
	 * This constructor builds an Armor object given name and defense parameters.
	 * 
	 * @param name    - the name of the Armor
	 * @param defense - the defense level of the Armor
	 */
	public Armor(String name, int defense) {
		super(name);
		this.defense = defense;
	}

	/**
	 * This method compares the power of two Armor objects, and also compares Armor
	 * objects to other subclasses.
	 * 
	 * @return an int representing > or < values
	 */
	@Override
	public int compareTo(Item other) {
		if (other instanceof Armor) {
			if (this.defense > ((Armor) other).defense) {
				return 1;
			} else if (this.defense < ((Armor) other).defense) {
				return -1;
			} else {
				return 0;
			}
		} else if (other instanceof Tool) {
			return -1;
		}
		return 1;
	}

	/**
	 * Returns a description of this Armor object.
	 *
	 * @return a description of this Armor object
	 */
	@Override
	public String getDescription() {
		return "Armor: " + this.getName() + " - defense=" + this.defense;
	}

	/**
	 * This method adds a random number (1 - 100) to the defense level of this Armor
	 * object.
	 */
	@Override
	public void useUpgrade() {
		Random random = new Random();
		int randomNum = random.nextInt(1, 100);
		this.defense += randomNum;
	}
}
