package assign08;

public class Magic extends Item {
	private int power;
	private int cost;

	public Magic(String name, int power, int cost) {
		super(name);
		this.power = power;
		this.cost = cost;
	}

	@Override
	public int compareTo(Item other) {
		if (other instanceof Magic) {
			double thisPowerRatio = ((double) this.power) / this.cost;
			double otherPowerRatio = ((Magic) other).power / ((Magic) other).cost;
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
		} else if (other instanceof Upgrade) {
			return 1;
		}
		return 1;
	}

	@Override
	public String getDescription() {
		return "Magic: " + this.getName() + " - power=" + this.power + ", cost=" + this.cost;
	}

	@Override
	public void useUpgrade() {
		this.power++;

	}

}
