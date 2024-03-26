package meeting14;
import java.util.ArrayList;

/**
 * Create several items of each type and check
 * receipt strings and info strings.
 * 
 * @author Travis Martin, Eric Heisler and CS1410 students
 * @version Oct 23, 2023
 */
public class InventoryCheck {
	public static void main(String[] args) {
		
//		Drink d1 = new Drink("monster", 0.99, 250, "Glass");
//		Frozen f1 = new Frozen("peas", 0.99, "01/01/2026");
//		
//		System.out.println(d1.receiptString());
//		System.out.println(d1.infoString());
//		System.out.println(f1.receiptString());
//		System.out.println(f1.infoString());
		
		
		
		
		
		
		
		
		Drink i1 = new Drink("apple juice", 1.29, 500, "PET");
		Produce i2 = new Produce("cabbage", 0.79, "USA");
		Frozen i3 = new Frozen("pizza", 4.99, "2023/7/20");
		Drink i4 = new Drink("CS Cola", 1.49, 350, "glass");
		Deli i5 = new Deli("salad", 3.29, "9:00", "Lisa");
		Drink i6 = new Drink("coffee", 1.99, 250, "can");
		Produce i7 = new Produce("apple", 1.14, "Canada");
		Frozen i8 = new Frozen("peas", 0.89, "2022/10/31");
		Frozen i9 = new Frozen("ice cream", 2.59, "2023/4/14");
		Deli i10 = new Deli("sandwich", 2.49, "9:30", "Bob");
		Produce i11 = new Produce("grape", 2.09, "Mexico");
		Deli i12 = new Deli("pasta", 4.09, "11:20", "Lisa");
		Item i13 = new Item("gum", 0.99);
		
		// How to print everything out? It would be very annoying
		// I wish I could put these all in some data structure or something like that
		System.out.println(i1.infoString());
		System.out.println(i2.infoString());
		System.out.println(i3.infoString());
		System.out.println(i4.infoString());
		
		
		
		
		
		
		
		
		
		ArrayList<Item> inventory = new ArrayList<Item>();
		inventory.add(i1);
		inventory.add(i2);
		inventory.add(i3);
		inventory.add(i4);
		inventory.add(i5);
		inventory.add(i6);
		inventory.add(i7);
		inventory.add(i8);
		inventory.add(i9);
		inventory.add(i10);
		inventory.add(i11);
		inventory.add(i12);
		inventory.add(i13);
		
		for(Item i : inventory) {
			// In this case, we are calling a method called receiptString
			// This method ONLY exists in Item
			// We can call it for EVERY item, thanks to inheritance
			// i might be a drink, that has a recieptString method
			System.out.println(i.receiptString());
		}
		
		for(Item i : inventory) {
			// In this case, we are calling a method called infoString
			// Each item has a different implementation
			
			// When we call it, java knows what the actual type of the item
			// is and calls that respective method.
			// This is called polymorphism
			System.out.println(i.infoString());
		}
		Drink d1 = new Drink("monster", 0.99, 250, "Glass");
		System.out.println(isDeliItem(d1));
		
		// What about checking the type of different objects
		for(Item i : inventory) {
			System.out.print(i.isDeliItem() + " ");
			System.out.println(i.receiptString());
		}
		
		// What about checking the type of different objects
		for(Item i : inventory) {
			if (i instanceof Deli) {
				System.out.print("DELI DELI DELI ");
			}
			System.out.println(i.receiptString());
		}
	}
	
	public static boolean isDeliItem(Item item) {
		return item.isDeliItem();
	}
}
