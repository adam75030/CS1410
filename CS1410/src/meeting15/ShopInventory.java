package meeting15;
import java.util.ArrayList;
import java.util.Iterator;

import meeting14.Deli;
import meeting14.Drink;
import meeting14.Frozen;
import meeting14.Item;
import meeting14.Produce;

/**
 * Create several items of each type and check
 * receipt strings and info strings.
 * 
 * @author Prof Martin
 * @version Mar 13, 2024
 */
public class ShopInventory implements Iterable<Item> {
	private ArrayList<Item> inventory;
	
	/**
	 * Constructs this class, starting with our basic shop inventory.
	 */
	public ShopInventory() {
		inventory = new ArrayList<Item>();
		inventory.add(new Drink("apple juice", 1.29, 500, "PET"));
		inventory.add(new Produce("cabbage", 0.79, "USA"));
		inventory.add(new Frozen("pizza", 4.99, "2023/7/20"));
		inventory.add(new Drink("CS Cola", 1.49, 350, "glass"));
		inventory.add(new Deli("salad", 3.29, "9:00", "Lisa"));
		inventory.add(new Drink("coffee", 1.99, 250, "can"));
		inventory.add(new Produce("apple", 1.14, "Canada"));
		inventory.add(new Frozen("peas", 0.89, "2022/10/31"));
		inventory.add(new Frozen("ice cream", 2.59, "2023/4/14"));
		inventory.add(new Deli("sandwich", 2.49, "9:30", "Bob"));
		inventory.add(new Produce("grape", 2.09, "Mexico"));
		inventory.add(new Deli("pasta", 4.09, "11:20", "Lisa"));
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	@Override
	public Iterator<Item> iterator() {
		return inventory.iterator();
	}

}
