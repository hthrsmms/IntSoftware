import java.util.Scanner;

public class InventoryManager {

	// Creates and prints inventory and order data

	public static void main(String[] args) {

		//Inventory array
		Inventory[]product= new Inventory[3];
		product[0]= new Inventory("ABC100", "Apples", 10,  1.00,  1);
		product[1]= new Inventory("DEF200", "Oranges", 20, 2.00,  10);
		product[2]= new Inventory("XYZ300", "Bananas", 15,  .55,  15);

		//Orders array
		Orders[]order=new Orders[2];
		order[0]= new Orders("555REX", "01/11/2016","ABC100", 10, "Supplier1");
		order[1]= new Orders("55REX", "02/28/2016","XYZ300", 22, "Supplier2");


		//increasing inventory by order size
		String compareProductNumbers;
		
		for(Orders order1:order){ 
			compareProductNumbers=order1.prodNumber;
				for(Inventory product1:product){
					if (compareProductNumbers.equals(product1.invNumber))
					product1.increaseInventory(order1.ordQuantity);
				}
		 }

		
		//request and print inventory
		
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
			System.out.println(product[0]);
			} 
			else {
			if (inventoryInput.equals("2")){
					System.out.println(product[1]);
					}
			else {
			if (inventoryInput.equals("3")){
					System.out.println(product[2]);
					}
			else {
			if (inventoryInput.equals("4")){
				for (int j = 0; j < product.length; j++) {
					System.out.println(product[j].toString());
					System.out.println();
					}
				}
			else {
			if (inventoryInput.equals("5")){
				for (int j = 0; j < order.length; j++) {
					System.out.println(order[j].toString());
					System.out.println();
					}
				}
				}
			}
			}
		requestInventory.close();
		
	}
	}
}



