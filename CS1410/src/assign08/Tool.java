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
			return this.power > other.power;
			
		}
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
