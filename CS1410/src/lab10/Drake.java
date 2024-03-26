package lab10;

public class Drake implements SpellCaster {
	private int health = 100;
	
	@Override
	public String toString() {
		return "Drake";
	}
	
	@Override
	public int doDamage() {
		System.out.println("Money for fun!");
		return 30;
	}
	
	@Override
	public boolean takeAHit(int damage) {
		if (health < 0) {
			System.out.println("I know when that hotline bling");
			return true;
		} else {
			System.out.println("Anita Max Win");
			return false;
		}
	}
}
