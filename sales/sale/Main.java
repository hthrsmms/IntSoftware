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
		// cashierOne.checkUser("Josh");

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

	}

}
