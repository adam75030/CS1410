package assign08;

public abstract class Item implements Comparable<Item> {
	private String name;

	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public abstract String getDescription();

	public abstract void useUpgrade();

}
