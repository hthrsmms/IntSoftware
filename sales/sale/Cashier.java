package sale;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cashier {
	private static final Logger logger = LoggerFactory
			.getLogger(Application.class);
	final static String password = "password";

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		boolean validUsername = false;
		boolean validPassword = false;
		String username = "";

		System.out.println("Welcome to the Point-Of-Sale Registration System");

		while (validUsername == false) {
			username = getUsername();
			validUsername = checkUser(username);
			if (validUsername == false) {
				getUsername();
			}
		}

		while (validPassword == false) {
			validPassword = checkPassword();
			if (validPassword == true) {
				proceedToLogin(username);
			}
		}

	}

	public static String getUsername() {
		System.out.println("Please enter your user name:");
		String enteredUsername = keyboard.nextLine();
		return enteredUsername;
	}

	private static boolean checkUser(String passedUsername) {
		boolean username = false;
		final String[] users = { "Heather", "Josh", "Steve" };
		if ((Arrays.asList(users).contains(passedUsername))) {
			username = true;
		} else {
			logger.info("Non-existent user " + passedUsername
					+ "please enter again!");
		}
		return username;
	}

	public static boolean checkPassword() {
		boolean validPassword = false;
		System.out.println("enter password:");
		String enteredPassword = keyboard.nextLine();
		if (enteredPassword.equals(password)) {
			validPassword = true;
		}
		return validPassword;
	}

	private static void proceedToLogin(String user) {
		System.out.println("you are looged in " + (user));
	}

}
