import java.util.StringTokenizer;
public class Database {
	public static String filename;
	public static ProjectList ProduceList = new ProjectList();
	public static ProjectList fruitList = new ProjectList();
	public static ProjectList vegetableList = new ProjectList();
    public static int count =0;
	public static ProduceItem[] produce = new ProduceItem[25];
	/**
	 * 
	 * @param filename takes in a file
	 */
	public Database(String file){
		filename = file;
		readFromFile(filename);
	}
	/**
	 * 
	 * @param myFile takes in a file
	 */
	public static void readFromFile(String myFile){
		 TextFileInput data = new TextFileInput(myFile);
		 int arrCounter = 0;
		 StringTokenizer token;
	
		 for(int i=0; i<100; i++){
			 String line = data.readLine();
			 
			 if (line == null){
		    	 break;
		     }
			 
			 token= new StringTokenizer(line, ",");
		     
			 while (token.hasMoreTokens()){
		    	 if(token.nextToken().equals("F")){
		    		 produce[arrCounter] = new Fruit(token.nextToken(), token.nextToken(), token.nextToken());
		    		 ProduceList.append(produce[arrCounter].returnString());
		    		 fruitList.append(produce[arrCounter].returnString());
		    		 arrCounter +=1;
		    		 count++;
		    	 }
		    	else {
		    		 produce[arrCounter] = new Vegetable(token.nextToken(), token.nextToken(), token.nextToken());
		    		 ProduceList.append(produce[arrCounter].returnString());
		    		 vegetableList.append(produce[arrCounter].returnString());
		    		 arrCounter +=1;
		    		 count++;
		    	 }
		     }
		     
		 }
	 }
	/**
	 * 
	 * @return String[] returns an array
	 */
	public String[] displayFruits(){
		return fruitList.printNodes();
		
	}
	/**
	 * 
	 * @return String[] returns an array
	 */
	public String[] displayProduce(){
		return ProduceList.printNodes();
		
	}
	/**
	 * 
	 * @return String[] returns an array
	 */
	public String[] displayVegetables(){
		return vegetableList.printNodes();
		
	}
}

	