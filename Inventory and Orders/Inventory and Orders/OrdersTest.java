import static org.junit.Assert.*;

import org.junit.*; 

public class OrdersTest {

	@Test
	public void testTodaysDate() {
		assertEquals("2016-03-15", Orders.todaysDate());
		
	}

	@Test
	public void testRemovalDate() {
		assertEquals("2017-03-15", Orders.removalDate());

	}

}
