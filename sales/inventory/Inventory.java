package inventory;

import java.util.ArrayList;

import sale.Item;

public class Inventory {
	String upc;
	String invName;
	static int invQuantity; // quantity of item in stock
	double invPrice;
	static int threshold;
	private ArrayList<String> upcList = new ArrayList<String>();

	// Set up inventory with beginning quantity in stock
	public Inventory(String productNumber, int productQuantity) {
		upc = productNumber;
		Item i1 = new Item(upc);
		invName = i1.getProductName();
		invQuantity = productQuantity;
		invPrice = i1.getProductPrice();
		threshold = i1.getProductThreshold();
		upcList.add(upc);
	}

	// Adds items to inventory
	public int increaseInventory(int amount) {
		if (amount > 0)
			invQuantity = invQuantity + amount;
		return invQuantity;
	}

	// Decrease inventory by amount of outstanding order
	public int decreaseInventory(int amount) {
		if (amount > 0)
			invQuantity = invQuantity - amount;
		return invQuantity;
	}

	// Current quantity of inventory
	public int getQuantity() {
		return invQuantity;
	}

	// Calculate price of inventory
	public double getInventoryPrice() {
		return invPrice * invQuantity;
	}

	// Calculate how far from reorder
	public int getInventoryThreshold() {
		return invQuantity - threshold;
	}

	// if less than 5 units in stock, set status to reorder
	public boolean getThresholdStatus() {
		int threshCalculated;
		boolean threshOrder;
		threshCalculated = invQuantity - threshold;

		if (threshCalculated > 5)
			threshOrder = false;
		else
			threshOrder = true;
		return threshOrder;
	}

	// calculates total price of inventory
	/*
	 * public static double getTotalPriceOfInventory(Inventory[] inv){
	 * 
	 * double totalPrice = 0.0;
	 * 
	 * for (int i = 0; i < inv.length; i++) { totalPrice +=
	 * inv[i].getInventoryPrice(); } return totalPrice; }
	 */

	// Inventory information
	public String toString() {
		return "Product: " + invName + "\nUpc: " + upc + "\nPrice Per Item: $"
				+ invPrice + "\nTotal Price in Inventory: $"
				+ getInventoryPrice() + "\nQuantity in Stock: " + invQuantity
				+ "\nReorder Threshold: " + threshold
				+ "\nHow Close to Threshold: " + getInventoryThreshold()
				+ "\nReorder Status: " + getThresholdStatus() + "\n";
	}

	public String getUpc() {
		return this.upc;
	}
}
