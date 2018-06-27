
public class Money {
	private int dollars;
	private int cents;
	
	public Money(){
		dollars = 0;
		cents = 0;
	}
	public Money(int x, int y){
		dollars = x;
		cents = y;
	}
	public int getDollars(){
		return dollars;
	}
	public int getCents(){
		return cents;
	}
	public void toString(int x, int y){
		if (y < 10)
		System.out.println("$"+ x + ".0" + y);
		else {
			System.out.println("$" + x + "." + y);
		}
			
	}
	public boolean equals(Money other){
		if(this.cents == other.cents){
			if(this.dollars == other.dollars)
				return true;
		}
		return false;
	}
	public String compareTo(Money other){
		int a, b;
		if(this.dollars > other.dollars){
			if(this.cents > other.cents) {
				a = this.dollars - other.dollars;
				b = this.cents - other.cents;
				System.out.println(this."");
			}
			else if (this.cents < other.cents){
				this.
				a =
				System.out.println(" ");
			}
			System.out.println("Money" );
		}
		else if (this.dollars < other.dollars){
			System.out.println("this ");
		}
		else if (this.dollars == other.dollars){
			System.out.println("");
		}
		
	}
}
