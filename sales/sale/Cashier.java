package sale;

import java.util.Arrays;

public class Cashier {

	final static String password = "password";
	final static String[] users = { "Heather", "Josh", "Steve" };
	private String username = "";

	public Cashier() {

	}

	public boolean checkUser(String enteredUsername) {
		boolean checkUsername = false;
		if ((Arrays.asList(users).contains(enteredUsername))) {
			checkUsername = true;
		}
		return checkUsername;
	}

	public boolean checkPassword(String enteredPassword) {
		boolean validPassword = false;
		if (enteredPassword.equals(password)) {
			validPassword = true;
		}
		return validPassword;
	}

	public void setUsername(String user) {
		username = user;
	}

	public String getUsername() {
		return username;
	}

	@SuppressWarnings("unused")
	public void proceedToLogin(String user) {
		System.out.println("you are looged in " + (user));
	}

}
