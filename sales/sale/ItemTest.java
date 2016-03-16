package sale;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testGetProductName() {
		Item test = new Item("ABC100");
		String test_product = test.getProductName();
		assertEquals("Apples", test_product);

	}

	@Test
	public void testGetProductPrice() {
		Item test = new Item("ABC100");
		Double test_price = test.getProductPrice();
		assertEquals(1.00, test_price, 0);

	}

	@Test
	public void testGetProductThreshold() {
		Item test = new Item("XYZ300");
		int test_theshold = test.getProductThreshold();
		assertEquals(15, test_theshold, 0);

	}

}
