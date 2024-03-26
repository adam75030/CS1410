package meeting15;

import meeting14.Item;

/**
 * Demo to try out an iterator for inventory.
 * 
 * @author Prof Martin and 1410 students
 * @version Mar 13, 2024
 */
public class InventoryDemo {
	public static void main(String[] args) {
		ShopInventory inventory = new ShopInventory();

		// Loop to print receipt strings or do other things with items
		for (Item item : inventory) { // loop through something iterable
			System.out.println(item.receiptString());
		}
	}
}
