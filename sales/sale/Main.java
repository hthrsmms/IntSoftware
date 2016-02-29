package sale;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger logger = LoggerFactory
			.getLogger(Application.class);
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Point-Of-Sale Registration System");

		Cashier cashierOne = new Cashier();

		boolean validUsername = false;
		while (validUsername == false) {
			System.out.println("Please enter your user name:");
			String enteredUsername = keyboard.nextLine();
			cashierOne.setUsername(enteredUsername);
			if (cashierOne.checkUser(cashierOne.getUsername())) {
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
			if (cashierOne.checkPassword(enteredPassword)) {
				validPassword = true;
			} else {
				logger.info("Invalid password, please try again!");
			}
		}

		cashierOne.proceedToLogin(cashierOne.getUsername());
		Register r1 = new Register(cashierOne.getUsername());
		r1.logon();

		System.out.println("Enter one of the following: sale, logoff:");
		String firstAction = keyboard.nextLine();
		if (firstAction.equals("logoff")) {
			r1.logoff();
		} else if (firstAction.equals("sale")) {
			System.out.println("Enter sale amount: ");
			Sale s1 = new Sale(r1.getRegister());
			s1.addSale(Double.valueOf(keyboard.nextLine()));
			System.out.println("Sale added.  Total sales are "
					+ s1.getTotalSales());
		}

	}
}
