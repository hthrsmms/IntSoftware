package sale;

public class Register extends Sale {
	private final int MAX = 5;// set register num from 1 to 5
	private int register_num;
	private boolean logon = false;
	private String cashier = "";

	public Register(String cashier_name) {
		cashier = cashier_name;
		// if (logon == false) {
		// logon();
		// } else {
		// logoff();
		// }
	}

	public int chooseRegister() {
		register_num = (int) (Math.random() * MAX) + 1;
		return register_num;
	}

	public boolean logon() {
		System.out.println("Hi " + cashier
				+ ", you're logged in and assigned to register "
				+ chooseRegister());
		logon = true;
		return logon;
	}

	public boolean logoff() {
		System.out.println("Hi " + cashier + ", you're logged out of register "
				+ register_num);
		logon = false;
		return logon;
	}

	public int getRegister() {
		return register_num;
	}

}
