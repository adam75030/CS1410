package assign08;

public class Upgrade extends Item {
	private boolean isUsed;

	public Upgrade() {
		super("Upgrade");
		this.isUsed = false;
	}

	@Override
	public int compareTo(Item other) {
		if (other instanceof Upgrade) {
			if (this.isUsed) {
				return 1;
			} else {
				return 0;
			}
		} else if (other instanceof Tool) {
			return -1;
		} else if (other instanceof Armor) {
			return -1;
		} else if (other instanceof Magic) {
			return -1;
		}
		return 0;
	}

	@Override
	public String getDescription() {
		if (isUsed) {
			return "Upgrade: used";
		}
		return "Upgrade: ready";
	}

	@Override
	public void useUpgrade() {
		this.isUsed = true;

	}

	public boolean isUsed() {
		return isUsed;
	}

}
