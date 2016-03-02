package sale;

public class Sale {
	private int register;
	private int sale_units;
	private int total_unit_sales;
	private String product_name;

	public Sale() {
		// register = register_num;
		// sale_amount = amount;
		// addSale(sale_amount);
	}

	public void addSale(int amount) {
		total_unit_sales = total_unit_sales + amount;
	}

	public int getTotalSales() {
		return total_unit_sales;
	}
}
