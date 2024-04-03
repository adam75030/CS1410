package assign08;

/**
 * This class represents an Upgrade object. It extends Item, and implements the
 * abstract methods from Item.
 * 
 * @author Adam Wightman
 * @version March 29, 2024
 */
public class Upgrade extends Item {
	private boolean isUsed;

	/**
	 * This constructor builds an Upgrade object with a default name and sets the
	 * Upgrade to "unused"
	 * 
	 */
	public Upgrade() {
		super("Upgrade");
		this.isUsed = false;
	}

	/**
	 * This method compares two Upgrade objects, and also compares Upgrade objects
	 * to other subclasses.
	 * 
	 * @return an int representing > or < values
	 */
	@Override
	public int compareTo(Item other) {
		if (other instanceof Upgrade) {
			if (!this.isUsed && ((Upgrade) other).isUsed) {
				return 1;
			} else if (this.isUsed && !((Upgrade) other).isUsed) {
				return -1;
			} else {
				return 0;
			}
		}
		return -1;
	}

	/**
	 * Returns a description of this Upgrade object.
	 *
	 * @return a description of this Upgrade object
	 */
	@Override
	public String getDescription() {
		if (isUsed) {
			return "Upgrade: used";
		}
		return "Upgrade: ready";
	}

	/**
	 * This method sets the Upgrade object to "used".
	 */
	@Override
	public void useUpgrade() {
		this.isUsed = true;
	}

	/**
	 * This method returns the current state of the upgrade object (used or unused).
	 * 
	 * @return isUsed - a boolean representing the state of the Upgrade object
	 */
	public boolean isUsed() {
		return isUsed;
	}
}
