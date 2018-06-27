
public class book {
	private String title;
	private String author;
	private float price;
	
	private book(String a, String b, float c){
		if( a == null || b == null || c < 0.0f){
			throw new IllegalArgumentException("argument is not correct");
		}
		title = a;
		author = b;
		price = c;
	}
	public String getTitle(){
		return title;
	}
	

}
