package assign08;

public class Tool extends Item {
	private int power;

	public Tool(String name, int power) {
		super(name);
		this.power = power;
	}

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

	@Override
	public String getDescription() {
		return "Tool: " + this.getName() + " - power=" + this.power;
	}

	@Override
	public void useUpgrade() {
		this.power++;

	}

}
