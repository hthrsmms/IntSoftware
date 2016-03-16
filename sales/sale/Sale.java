package sale;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Sale {
	private int register;
	private int sale_units;
	private int total_unit_sales;
	private String product_name;
	private static int sale_num = 0;

	public Sale() {

	}

	public void addSale(String upc, int amount) {
		total_unit_sales = total_unit_sales + amount;
		sale_num = sale_num + 1;
		finalizeSale(upc, amount);
	}

	public double getTotalSales() {
		BufferedReader br = null;
		Double totalSalesAmount = 0.00;
		try {

			String sCurrentLine;

			File path = new File("data"); // path to your folder.
			for (File f : path.listFiles()) { // this loops through all the
												// files + directories
				if (f.isFile()) {

					br = new BufferedReader(new FileReader(f));
					while ((sCurrentLine = br.readLine()) != null) {
						// System.out.println(sCurrentLine);
						String[] values = sCurrentLine.split(",", -1);
						totalSalesAmount = totalSalesAmount
								+ Double.valueOf(values[2]);
					}

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return totalSalesAmount;
	}

	public int getSaleNum() {
		return sale_num;
	}

	public void finalizeSale(String upc, int amount) {

		try {
			Item i1 = new Item(upc);
			double invPrice = i1.getProductPrice();
			Date date = new Date();
			String content = date.toString() + "," + upc + ","
					+ String.valueOf(amount) + ","
					+ String.valueOf(invPrice * Double.valueOf(amount));
			String fileName = "data/sale" + String.valueOf(getSaleNum())
					+ ".txt";

			File file = new File(fileName);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
