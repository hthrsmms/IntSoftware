import java.time.LocalDate;
import java.time.ZoneId;



public class Orders {

	private String ordNumber;
	private String prodNumber;
	private String ordDate;
	@SuppressWarnings("unused")
	private String remDate;
	private int ordQuantity; // quantity of items ordered
	private String supplier;

	
	// Set up inventory with beginning quantity in stock
	public Orders(String orderNumber, String orderDate, String removeDate, String productNumber, int orderQuantity, String orderSupplier) {
	
		ordNumber = orderNumber;
		ordDate = orderDate;
		remDate = removeDate;
		prodNumber = productNumber;
		ordQuantity = orderQuantity;
		supplier = orderSupplier;
	}
	

	public static String todaysDate() {  
	    ZoneId zonedId = ZoneId.of( "America/Chicago" );
	    LocalDate today = LocalDate.now( zonedId );
	    String orderDate = today.toString();
	    return orderDate;
	}	
	
	public static  String removalDate() {  //one year from today - indicates when to remove from order history
	    ZoneId zonedId = ZoneId.of( "America/Chicago" );
	    LocalDate today = LocalDate.now( zonedId );
		LocalDate nextYear = today.plusYears( 1 );
	    String removeDate = nextYear.toString();
	    return removeDate;
	}	
	
	public String toString() {
		return "\n\nOrder Number: " + ordNumber + "\nOrder Date: " + ordDate + "\nProduct Number:"+prodNumber 
				+ "\nOrder Quantity:"+ ordQuantity + "\nSupplier:" + supplier ;
	}

}

	