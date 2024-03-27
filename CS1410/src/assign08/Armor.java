package assign08;

public class Armor extends Item {
	private int defense;

	public Armor(String name, int defense) {
		super(name);
		this.defense = defense;
	}

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

	@Override
	public String getDescription() {
		return "Armor: " + this.getName() + " - defense=" + this.defense;
	}

	@Override
	public void useUpgrade() {
		this.defense++;

	}

}
