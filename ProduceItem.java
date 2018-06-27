
public abstract class ProduceItem {
	private String code;
	private String name;
	private float price;
	private String reLine;
	/**
	 * 
	 * @param number  a variable for code
	 * @param id  a variable for name
	 * @param value  a variable for price
	 */
	public ProduceItem (String number, String id, String value){
		 code = number;
		 name = id;
		 price = Float.parseFloat(value);
		 
		 reLine = code + " " + name + " " +price;
		
	}
	/**
	 * A method that returns the String reLine
	 * necessary method because unable to return reLine from the constructor
	 * @return String   returns string reLine  
	 */
	public String returnString() {
		return reLine;
	}
	/**
	 * 
	 * @return String code of the produce
	 */
    public String getCode() {
    	return code;
	}
    /**
     * 
     * @return String name of the produce
     */
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @return float the price of the produce
	 */
	public float getPrice(){
		return price;
	}
	/**
	 * 
	 * @param num sets code of the produce to number
	 */
	public void setCode(String num){
		code = num;
	}
	/**
	 * 
	 * @param line sets name of the produce to line
	 */
	public void setName(String line){
		name = line;
	}
	/**
	 * 
	 * @param value sets price of the produce to value
	 */
	public void setPrice(float value){
		price = value;
	}
	
	
}