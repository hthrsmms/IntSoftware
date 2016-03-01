package sale;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JunitSale {

	@Test
	public void testGetTotalSales() {
		Sale test = new Sale();
		test.addSale(10.00);
		double tester = test.getTotalSales();
		assertEquals(10.00, tester, 0);

	}

}
