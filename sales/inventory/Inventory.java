package inventory;

public class Inventory {
	String number;
	String name;
	int quantity; // quantity of item in stock
	double price;
	String supplier;
	int threshold;

	// Set up inventory with beginning quantity in stock
	public Inventory(String productNumber, String productName, int productQuantity, double productPrice,
			String productSupplier, int productThreshold) {
		number = productNumber;
		name = productName;
		quantity = productQuantity;
		price = productPrice;
		supplier = productSupplier;
		threshold = productThreshold;
	}

	// Adds items to inventory
	public int increaseInventory(int amount) {
		if (amount > 0)
			quantity = quantity + amount;
		return quantity;
	}

	// Decrease inventory by amount of outstanding order
	public double decreaseInventory(int amount) {
		if (amount > 0)
			quantity = quantity - amount;
		return quantity;
	}

	// Current quantity of inventory
	public int getQuantity() {
		return quantity;
	}

	// Calculate price of inventory
	public double getInventoryPrice() {
		return price * quantity;
	}

	// Calculate how far from reorder
	public int getInventoryThreshold() {
		return quantity - threshold;
	}

	// if less than 5 units in stock, set status to reorder
	public String getThresholdStatus() {
		int threshCalculated;
		String threshOrder;
		threshCalculated = quantity - threshold;

		if (threshCalculated > 5)
			threshOrder = "Plenty in stock";
		else
			threshOrder = "REORDER SOON!";
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
		return "Product: " + name + "\nProduct Number: " + number + "\nSupplier: " + supplier + "\nPrice Per Item: $"
				+ price + "\nTotal Price in Inventory: $" + getInventoryPrice() + "\nQuantity in Stock: " + quantity
				+ "\nReorder Threshold: " + threshold + "\nHow Close to Threshold: " + getInventoryThreshold()
				+ "\nReorder Status: " + getThresholdStatus();
	}

}
