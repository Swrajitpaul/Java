import java.text.DecimalFormat;
import java.util.StringTokenizer;
public class Project2 {
	public static double totalPurchase;
	public static Database file = new Database("DatabaseFile2.txt");
	public static Receipt transaction;
	
	public static void main(String[] args) {
		String[] info = new String[100];
		info[0] = "Name"+":               "+ "Price"+ " * "+ "Weight" + " = " + "Total";
		TextFileInput purchase = new TextFileInput("TransactionsFile2.txt");
		int arrC = 1;
		StringTokenizer buy;
		for(int i=0; i<100; i++){
			 String line = purchase.readLine();
			 if (line == null){
		    	 break;
		     }
			 buy= new StringTokenizer(line, ",");
		     while (buy.hasMoreTokens()){
		    	 info[arrC]=item(buy.nextToken(), buy.nextToken());
		    	 arrC +=1;
		     }
		}
		DecimalFormat dt = new DecimalFormat("#.##");
		String totalPrice = dt.format(totalPurchase);
		
		transaction = new Receipt(info,arrC,totalPrice);
		
	}
	/**
	 * 
	 * @param num  takes in the code of the produce
	 * @param w  take in the weight of purchased produce
	 * @return String returns the name, price, weight and total value 
	 */
	public static String item (String num, String w){
		 String number = num;
		 float weight = Float.parseFloat(w);
		 String name = file.getName(number);
		 float price= file.getPrice(number);
		 float total = price*weight;
		 double d = ((double)total);
		 DecimalFormat ddf = new DecimalFormat("#.##");
		 totalPurchase += d;
		 String returnLine = name + ":           $" + price + " * " + weight + "lb = $" + (ddf.format(d));
		 
		 return returnLine;
	}
		

}
