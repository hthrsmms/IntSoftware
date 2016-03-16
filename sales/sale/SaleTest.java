package sale;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SaleTest {

	@Test
	public void testGetTotalSales() {
		Sale test = new Sale();
		test.addSale("apple", 10);
		double tester = test.getTotalSales();
		assertEquals(10, tester, 0);

	}

}
