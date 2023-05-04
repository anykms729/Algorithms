import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class ReadStockData {
	public static void main(String[] args) throws IOException {
		try {
			readStockData();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void readStockData() throws IOException {

		// parsing and reading the CSV file data into the stock (object) array
		// provide the path here...
		File directory = new File("./");
		String name = directory.getAbsolutePath() + "//Stock.csv";
		BufferedReader br = new BufferedReader(new FileReader(name));
		Stock[] stocks = new Stock[10000];

		// This will just print the header in CSV file
		br.readLine();

		int i = 0;
		String st;

		while ((st = br.readLine()) != null) // Read the file line by line
		{
			String[] data = st.split(",");
			stocks[i++] = new Stock(Integer.parseInt(data[0]), Float.parseFloat(data[1]), Float.parseFloat(data[2]),
					data[3], Float.parseFloat(data[4]), data[5]);
		}
		br.close(); // close the BufferedReader

		// Print stock details due to overridden toString method in Stock class
		for (int j = 0; j < stocks.length; j++) {
			System.out.println(stocks[j]);
		}

		// Compare stocks based on their ID due to overridden CompareTo method in Stock class
		System.out.println(stocks[0] == stocks[0]);
		System.out.println(stocks[0] == stocks[1]);
	}

 	static class Stock implements Comparable<Object> {

		private int stockNo;
		private float stockSize;
		private float profit;
		private String productType;
		private float weight;
		private String productName;

		// Constructor
		public Stock(int stockNo, float stockSize, float profit, String productType, float weight, String productName) {
			super();
			this.stockNo = stockNo;
			this.stockSize = stockSize;
			this.profit = profit;
			this.productType = productType;
			this.weight = weight;
			this.productName = productName;
		}

		// setters and getters
		public int getStockNo() {
			return stockNo;
		}

		public void setStockNo(int stockNo) {
			this.stockNo = stockNo;
		}

		public float getStockSize() {
			return stockSize;
		}

		public void setStockSize(float stockSize) {
			this.stockSize = stockSize;
		}

		public float getProfit() {
			return profit;
		}

		public void setProfit(float profit) {
			this.profit = profit;
		}

		public float getWeight() {
			return weight;
		}

		public void setWeight(float weight) {
			this.weight = weight;
		}

		public String getProductType() {
			return productType;
		}

		public void setProductType(String productType) {
			this.productType = productType;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		// so the stock objects can be compared when sorting/searching
		// NOTE: this will only allow comparisons based on the stockNo of the stock
		@Override
		public int compareTo(Object obj) {

        /*
        Edit this section so it compares the appropriate
        column you wish to sort by
        */

			Stock stk = (Stock) obj;
			return stockNo - (stk.getStockNo());
		}

		@Override
		public String toString() {
			return "Stock{" +
					"stockNo=" + stockNo +
					", stockSize=" + stockSize +
					", profit=" + profit +
					", productType='" + productType + '\'' +
					", weight=" + weight +
					", productName='" + productName + '\'' +
					'}';
		}
}
}