import inventory.Inventory;


public class Orders {

	// Creates inventory and orders

	public static void main(String[] args) {
		Inventory product1 = new Inventory("ABC100", "Apples", 10, 1.00, "Supplier1", 1);
		Inventory product2 = new Inventory("DEF200", "Oranges", 20, 2.00, "Supplier2", 10);
		Inventory product3 = new Inventory("XYZ300", "Bananas", 15, .55, "Supplier3", 15);

		// testing increasing and decreasing inventory
		product1.increaseInventory(20);
		product2.decreaseInventory(10);

		// print current inventory info
		System.out.println();
		System.out.println(product1);
		System.out.println();
		System.out.println(product2);
		System.out.println();
		System.out.println(product3);

	}
}
