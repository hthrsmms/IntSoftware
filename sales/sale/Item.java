package sale;

public class Item {
	private String upc;

	public Item(String upc) {
		this.upc = upc;
	}

	public String getProductName() {
		String product = null;
		if (upc.equals("ABC100")) {
			product = "Apples";
		} else if (upc.equals("DEF200")) {
			product = "Oranges";
		} else if (upc.equals("XYZ300")) {
			product = "Bananas";
		}
		return product;
	}

	public Double getProductPrice() {
		double price = 0;
		if (upc.equals("ABC100")) {
			price = 1.00;
		} else if (upc.equals("DEF200")) {
			price = 2.00;
		} else if (upc.equals("XYZ300")) {
			price = 0.55;
		}
		return price;
	}

	public int getProductThreshold() {
		int threshold = 0;
		if (upc.equals("ABC100")) {
			threshold = 1;
		} else if (upc.equals("DEF200")) {
			threshold = 10;
		} else if (upc.equals("XYZ300")) {
			threshold = 15;
		}
		return threshold;
	}

}
