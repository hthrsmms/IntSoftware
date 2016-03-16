package sale;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CashierTest {

	@Test
	public void testCheckUser() {
		Cashier test = new Cashier();
		boolean tester = test.checkUser("Josh");
		assertEquals(true, tester);
	}

	@Test
	public void testCheckPassword() {
		Cashier test = new Cashier();
		boolean tester = test.checkPassword("password");
		assertEquals(true, tester);
	}

}
