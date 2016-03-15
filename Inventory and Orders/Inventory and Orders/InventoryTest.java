import static org.junit.Assert.*;

import org.junit.*;  

public class InventoryTest {

	@Test
	public void testIncreaseInventory() {
		
		Inventory product4 = new Inventory("RBG", "Pineapple", 20, 5.00, 5);
		assertEquals(25, product4.increaseInventory(5));
	}

	@Test
	public void testDecreaseInventory() {
		Inventory product4 = new Inventory("RBG", "Pineapple", 20, 5.00, 5);
		assertEquals(15, product4.decreaseInventory(5));
	}

}
