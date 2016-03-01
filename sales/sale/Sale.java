package sale;

public class Sale {
	private int register;
	private double sale_amount;
	private double total_sales;

	public Sale() {
		// register = register_num;
		// sale_amount = amount;
		// addSale(sale_amount);
	}

	public void addSale(double amount) {
		total_sales = total_sales + amount;
	}

	public double getTotalSales() {
		return total_sales;
	}
}
