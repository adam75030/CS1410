package assign08;

public class Armor extends Item {
	private int defense;

	public Armor(String name, int defense) {
		super(name);
		this.defense = defense;
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		return "Armor: " + this.getName() + " - defense=" + this.defense;
	}

	@Override
	public void useUpgrade() {
		this.defense++;

	}

}
