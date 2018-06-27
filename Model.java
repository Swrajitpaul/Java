import java.text.DecimalFormat;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


public class Model {
	static Database data;
	public static String[] info;
	String[] fruits;
	String[] vegetables;
	static Receipt transactions, fruitgui, vegetablegui;
	static int totalPurchase;
	static boolean yesDatafile = false;
	
	public Model(){
		
	}// constructor
	/**
	 * 
	 * @param filename takes in a filename
	 */
	public void openDb(String filename){
		try{
		data = new Database(filename);
		info = data.displayProduce();
	    yesDatafile = true;
		JOptionPane.showMessageDialog(null, "Database initialized");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "The file selected for the Database is not in the correct format");
		}
	}
	/**
	 * 
	 * @param filename takes in a filename
	 */
	public void openTrans(String filename){
			transcript(filename);
	}
	// void method used to display list of fruits
	public void displayFruits(){
		try{	
	    fruits = data.displayFruits();
	    fruitgui = new Receipt(fruits, "List of FruitS", data.fruitList.getLength());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "SELECT A DATABASE FILE FIRST!!!");
		}

	}
	// void method for vegetable
	public void displayVegetables(){
		try{	
	    vegetables = data.displayVegetables();
	    vegetablegui = new Receipt(vegetables, "List of Vegetables", data.vegetableList.getLength());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "SELECT A DATABASE FILE FIRST!!!");
		}

	}
	/**
	 * 
	 * @param file takes in a transactionfile
	 */
	public static void transcript(String file){
		if(yesDatafile == false){
			JOptionPane.showMessageDialog(null, "A DATABASE FILE MUST BE SELECTED FIRST!!!");
			System.exit(0);
		}
		String[] trans = new String[100];
		trans[0] = "Name"+":               "+ "Price"+ " * "+ "Weight" + " = " + "Total";
		TextFileInput purchase = new TextFileInput(file);
		int arrC = 1;
		StringTokenizer buy;
		for(int i=0; i<100; i++){
			 String line = purchase.readLine();
			 if (line == null){
		    	 break;
		     }
			 buy= new StringTokenizer(line, ",");
		     while (buy.hasMoreTokens()){
		    	 trans[arrC]=item(buy.nextToken(), buy.nextToken());
		    	 arrC +=1;
		     }
		}
		DecimalFormat dt = new DecimalFormat("#.##");
		String totalPrice = dt.format(totalPurchase);
		
		transactions = new Receipt(trans,arrC,totalPrice);
		}
		/**
		 * 
		 * @param num  takes in the code of the produce
		 * @param w  take in the weight of purchased produce
		 * @return String returns the name, price, weight and total value 
		 */
		public static String item (String num, String w){
			String name = " "; 
			float price = 0;
			 float weight = Float.parseFloat(w);
			 
			 try {
				 StringTokenizer mnm = new StringTokenizer(data.ProduceList.toString(), " ");
					boolean found = false;
					while(mnm.hasMoreTokens()){
							if (num.equals(mnm.nextToken())){
								mnm.nextToken();
								price = Float.parseFloat((String.valueOf(mnm.nextToken())));
								found = true;
								break;
							}
					}
			
					if (!found) throw new ItemNotFoundException("");
			 }
			 catch (ItemNotFoundException abc){
				 name = JOptionPane.showInputDialog("PLU code from the transactions is not in the database \n Enter the produce name:");
			 }
			 
			 try {
				 StringTokenizer mnm = new StringTokenizer(data.ProduceList.toString(), " ");
					boolean found = false;
					while(mnm.hasMoreTokens()){
							if (num.equals(mnm.nextToken())){
								name = String.valueOf(mnm.nextToken());
							    found = true;
								break;
							}
					}
					if (!found) throw new ItemNotFoundException("");

			 }
			 catch(ItemNotFoundException error){
					String digits = JOptionPane.showInputDialog("Enter the price corresponding to the previously entered produce :");
					price = Float.parseFloat(String.valueOf(digits));
			 }
			 
			 float total = price*weight;
			 double d = ((double)total);
			 DecimalFormat ddf = new DecimalFormat("#.##");
			 totalPurchase += d;
			 String returnLine = name + ":           $" + price + " * " + weight + "lb = $" + (ddf.format(d));
			
			 return returnLine;
		}
			
}
