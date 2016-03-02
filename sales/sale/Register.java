package sale;

import java.util.Date;

public class Register extends Sale {
	private final int MAX = 5;// set register num from 1 to 5
	private int register_num;
	private boolean logon = false;
	private String cashier = "";
	private String date_logon = "";
	private String date_logoff = "";

	public Register(String cashier_name) {
		cashier = cashier_name;
	}

	public int chooseRegister() {
		register_num = (int) (Math.random() * MAX) + 1;
		return register_num;
	}

	public boolean logon() {
		setDate(true);
		System.out.println("Hi " + cashier
				+ ", you're logged in and assigned to register "
				+ chooseRegister() + " at " + date_logon);
		logon = true;
		return logon;
	}

	public boolean logoff() {
		setDate(false);
		System.out.println("Hi " + cashier + ", you're logged out of register "
				+ register_num + " at " + date_logoff);
		logon = false;
		return logon;
	}

	public int getRegister() {
		return register_num;
	}

	public String getDate() {
		Date date = new Date();
		// String dayTime = String.format("tc", date);
		return date.toString();
	}

	public void setDate(boolean logon) {
		if (logon) {
			date_logon = getDate();
		} else {
			date_logoff = getDate();
		}
	}

}
