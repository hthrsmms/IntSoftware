package sale;

import inventory.Inventory;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger logger = LoggerFactory
			.getLogger(Application.class);
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		// add inventory
		Inventory product1 = new Inventory("ABC100", "Apples", 10, 1.00,
				"Supplier1", 1);
		Inventory product2 = new Inventory("DEF200", "Oranges", 20, 2.00,
				"Supplier2", 10);
		Inventory product3 = new Inventory("XYZ300", "Bananas", 15, .55,
				"Supplier3", 15);

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
					.println("Enter one of the following: sale, report, logoff:");
			String firstAction = keyboard.nextLine();
			if (firstAction.equals("logoff")) {
				r1.logoff();
			} else if (firstAction.equals("sale")) {
				System.out.println("Enter sale amount: ");
				r1.addSale(Double.valueOf(keyboard.nextLine()));
				// Sale s1 = new Sale(r1.getRegister());
				// s1.addSale(Double.valueOf(keyboard.nextLine()));
				System.out.println("Sale added.  Total sales are "
						+ r1.getTotalSales());
			} else if (firstAction.equals("report")) {
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
