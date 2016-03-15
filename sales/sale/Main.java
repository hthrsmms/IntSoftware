package sale;

import inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger logger = LoggerFactory
			.getLogger(Application.class);
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		// add products to list for available to sell
		Inventory product1 = new Inventory("ABC100", 10);
		Inventory product2 = new Inventory("DEF200", 20);
		Inventory product3 = new Inventory("XYZ300", 15);

		Inventory[] allInventory = { product1, product2, product3 };

		List<String> products = new ArrayList<String>();
		products.add(product1.getUpc());
		products.add(product2.getUpc());
		products.add(product3.getUpc());

		System.out.println("Welcome to the Point-Of-Sale Registration System");

		Cashier c1 = new Cashier();

		boolean validUsername = false;
		while (validUsername == false) {
			System.out.println("Please enter your user name:");
			String enteredUsername = keyboard.nextLine();
			c1.setUsername(enteredUsername);
			if (c1.checkUser(c1.getUsername())) {
				validUsername = true;
			} else {
				logger.info("Non-existent user " + enteredUsername
						+ " please enter again!");
			}
		}

		boolean validPassword = false;
		while (validPassword == false) {
			System.out.println("enter password:");
			String enteredPassword = keyboard.nextLine();
			if (c1.checkPassword(enteredPassword)) {
				validPassword = true;
			} else {
				logger.info("Invalid password, please try again!");
			}
		}

		c1.proceedToLogin(c1.getUsername());
		Register r1 = new Register(c1.getUsername());
		r1.logon();

		int transactions_max = 0; // set max to 10 transactions
		while (transactions_max < 10) {
			System.out
					.println("Enter one of the following: sale, inventory, report, logoff:");
			String firstAction = keyboard.nextLine();
			if (firstAction.equals("logoff")) {
				r1.logoff();
				break; // end program
			} else if (firstAction.equals("sale")) {
				System.out.println("Enter an item to sell. Options: "
						+ products);

				// get the user to select a product in catalog to sell
				int selectedIndex = -1;
				boolean validProduct = false;
				while (validProduct == false) {
					String product = keyboard.nextLine();
					for (int i = 0; i < products.size(); i++) {
						if (product.equals(products.get(i))) {
							selectedIndex = i;
						}
					}
					try {
						System.out.println("You selected: "
								+ products.get(selectedIndex));
						validProduct = true;
					} catch (Exception e) {
						logger.info("Invalid product name, please try again!");
					}

				}

				System.out.println("Enter unit amount: ");
				String saleAmount = keyboard.nextLine();

				// check if enough in-stock
				int remaining_inv = allInventory[selectedIndex].getQuantity();
				if (remaining_inv < Integer.valueOf(saleAmount)) {
					logger.info("Not enough in-stock to complete purchase");
				} else {

					r1.addSale(allInventory[selectedIndex].getUpc(),
							Integer.valueOf(saleAmount));
					System.out.println("Sale number "
							+ String.valueOf(r1.getSaleNum())
							+ " added.  Total unit sales are "
							+ r1.getTotalSales());

					// update inventory
					allInventory[selectedIndex].decreaseInventory(Integer
							.valueOf(saleAmount));
				}

			} else if (firstAction.equals("inventory")) {
				System.out
						.println("Enter an item increase inventory. Options: "
								+ products);

				// get the user to select a product in catalog to sell
				int selectedIndex = -1;
				boolean validProduct = false;
				while (validProduct == false) {
					String product = keyboard.nextLine();
					for (int i = 0; i < products.size(); i++) {
						if (product.equals(products.get(i))) {
							selectedIndex = i;
						}
					}
					try {
						System.out.println("You selected: "
								+ products.get(selectedIndex));
						validProduct = true;
					} catch (Exception e) {
						logger.info("Invalid product name, please try again!");
					}

				}

				System.out.println("Enter unit amount: ");
				String adjAmount = keyboard.nextLine();
				// update inventory
				allInventory[selectedIndex].increaseInventory(Integer
						.valueOf(adjAmount));
			}

			else if (firstAction.equals("report")) {
				System.out.println("For user " + c1.getUsername()
						+ ", for register " + String.valueOf(r1.getRegister())
						+ " Total sales are " + r1.getTotalSales() + "\n");

				System.out.println(product1.toString());
				System.out.println(product2.toString());
				System.out.println(product3.toString());
			}
			transactions_max = transactions_max + 1;
		}

	}
}
