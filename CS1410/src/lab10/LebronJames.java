package lab10;

public class LebronJames implements SpellCaster {
	private int health = 2147483647;
	
	@Override
	public String toString() {
		return "Lebron James";
	}

	@Override
	public int doDamage() {
		System.out.println("Lebron James with no regard for human life!");
		return 100;
	}

	@Override
	public boolean takeAHit(int damage) {
		if (health < 0) {
			return true;
		} else {
			System.out.println("Blocked by James!");
			return false;
		}
	}
}
