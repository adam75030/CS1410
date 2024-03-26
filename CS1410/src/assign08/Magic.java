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
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
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
