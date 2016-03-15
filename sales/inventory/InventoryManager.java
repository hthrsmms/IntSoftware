package inventory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//import Inventory and Orders.Orders;

public class InventoryManager {

	ArrayList<String> upc = new ArrayList<String>();
	ArrayList<Inventory> products = new ArrayList<Inventory>();

	// Creates and prints inventory and order data

	public InventoryManager() {

		// Inventory array
		// ArrayList<Inventory> products = new ArrayList<Inventory>();

		// add inventory to start
		// Inventory product1 = new Inventory("ABC100", "Apples", 10, 1.00, 1);
		// Inventory product2 = new Inventory("DEF200", "Oranges", 20, 2.00,
		// 10);
		// Inventory product3 = new Inventory("XYZ300", "Bananas", 15, .55, 15);

		Inventory product1 = new Inventory("ABC100", 10);
		Inventory product2 = new Inventory("DEF200", 20);
		Inventory product3 = new Inventory("XYZ300", 15);

		products.add(product1);
		products.add(product2);
		products.add(product3);

		upc.add(product1.getUpc());
		upc.add(product2.getUpc());
		upc.add(product3.getUpc());

		// Orders
		ArrayList<Orders> CurrentOrders = new ArrayList<Orders>();
		Orders order1 = new Orders("555REX", "05/01/2014", "05/01/2015",
				"ABC100", 123, "Supplier1");
		Orders order2 = new Orders("55REX", "2/28/2016", "2/28/2017", "XYZ300",
				12, "Supplier2");

		CurrentOrders.add(order1);
		CurrentOrders.add(order2);

		// Compares today's date to removal date of Order and removes element if
		// matches
		Iterator<Orders> it = CurrentOrders.iterator();
		while (it.hasNext()) {
			if (it.next().todaysDate().equals(Orders.removalDate())) {
				it.remove();
				break;
			}
		}

		Scanner requestInventory = new Scanner(System.in);
		String inventoryInput;
		System.out.println("What would you like to view? ");
		System.out.println("1: Apples ");
		System.out.println("2: Oranges ");
		System.out.println("3: Bananas ");
		System.out.println("4: All Inventory ");
		System.out.println("5: Orders ");
		inventoryInput = requestInventory.nextLine();

		if (inventoryInput.equals("1")) {
			System.out.println(product1);
		}
		if (inventoryInput.equals("2")) {
			System.out.println(product2);
		}
		if (inventoryInput.equals("3")) {
			System.out.println(product3);
		}
		if (inventoryInput.equals("4")) {
			System.out.print(products);
		}
		if (inventoryInput.equals("5")) {
			System.out.print(CurrentOrders);
		}

		requestInventory.close();
	}

	public String[] getUpc() {
		return (String[]) (products.toArray());
	}

}
