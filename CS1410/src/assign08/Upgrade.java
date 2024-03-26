package assign08;

public class Upgrade extends Item {
	private boolean isUsed;

	public Upgrade() {
		super("Upgrade");
		this.isUsed = false;
	}
	
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
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
