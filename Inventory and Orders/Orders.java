

public class Orders {

	String ordNumber;
	String prodNumber;
	String ordDate;
	int ordQuantity; // quantity of items ordered
	String supplier;

	
	// Set up inventory with beginning quantity in stock
	public Orders(String orderNumber, String orderDate, String productNumber, int orderQuantity, String orderSupplier) {
	
		ordNumber = orderNumber;
		ordDate = orderDate;
		prodNumber = productNumber;
		ordQuantity = orderQuantity;
		supplier = orderSupplier;
	}
	
	
	public String toString() {
		return "Order Number: " + ordNumber + "\nOrder Date: " + ordDate + "\nProduct Number:"+prodNumber 
				+ "\nOrder Quantity:"+ ordQuantity + "\nSupplier:" + supplier ;
	}

}
