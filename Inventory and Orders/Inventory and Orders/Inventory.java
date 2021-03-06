
public class Inventory {
	private String invNumber;
	private String invName;
	private static int invQuantity; // quantity of item in stock
	private double invPrice;
	private static int threshold;

	// Set up inventory with beginning quantity in stock
	public Inventory(String productNumber, String productName, int productQuantity, double productPrice,
			 int productThreshold) {
		invNumber = productNumber;
		invName = productName;
		invQuantity = productQuantity;
		invPrice = productPrice;
		threshold = productThreshold;
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
		double currPrice= invPrice * invQuantity;
		 return currPrice;
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
		return "Product: " + invName + "\nProduct Number: " + invNumber + "\nPrice Per Item: $"
				+ invPrice + "\nTotal Price in Inventory: $" + getInventoryPrice() + "\nQuantity in Stock: " + invQuantity
				+ "\nReorder Threshold: " + threshold + "\nHow Close to Threshold: " + getInventoryThreshold()
				+ "\nReorder Status: " + getThresholdStatus();
	}
	
	// Josh: add getter
		public String getName() {
			return invName;
		}
		

}
