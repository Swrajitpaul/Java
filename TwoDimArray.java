import java.util.StringTokenizer;


public class TwoDimArray {

	public static int[][] myArray = {{1,2,3},{4,5,6},{7,8,9}};
	
	public static void main(String[] args) {
		fillArray(args[0]);
		//printArray(fillArray(args[0]));
		//printArrayEven(myArray);
	}
	
	private static void printArray (int[][] theArray) {
		for (int i=0; i<theArray.length; i++) {
			for (int j=0; j<theArray[i].length;j++)
				display(theArray[i][j]);
			System.out.println();
		}
	}
	
	private static void display (int num){
		System.out.print(num+" ");
	}
	
	private static void printArrayEven(int[][] theArray){
		for (int r=0; r<theArray.length; r++){
			for (int c=0; c<theArray[r].length; c++) {
				if (theArray[r][c]%2 == 0)
					System.out.print(theArray[r][c] + " ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	private static int[][] fillArray (String myFile) {
		TextFileInput in = new TextFileInput(myFile);
		String line = in.readLine();
		StringTokenizer myToken = new StringTokenizer(line,",");
		int row = Integer.parseInt(myToken.nextToken());
		int col = Integer.parseInt(myToken.nextToken());
		line = in.readLine();
		myToken = new StringTokenizer(line, ",");
		
		int[][] array = new int [row][col];
		
		for (int r=0; r<row; r++){
	      for (int c=0; c<col; c++){
				array[r][c] = Integer.parseInt(myToken.nextToken());
	      }
	      line = in.readLine();
	      myToken = new StringTokenizer(line, ",");
		return array;
		}
	}
}
