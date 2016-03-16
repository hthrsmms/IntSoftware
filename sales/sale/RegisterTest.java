package sale;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RegisterTest {

	@Test
	public void testLogon() {
		Register test = new Register("Josh");
		boolean test_logon = test.logon();
		assertEquals(true, test_logon);

	}

	@Test
	public void testLogoff() {
		Register test = new Register("Josh");
		boolean test_logoff = test.logoff();
		assertEquals(false, test_logoff);

	}

}
