import javax.swing.*;
import java.awt.*;

public class Receipt extends JFrame{
	static JFrame jFrame;
    static Container contentPane;
	static TextArea left;
	public Model mod = new Model();
	
	 public Receipt() {
		    setTitle("Project 3");
		    setSize(500,300);
	       setLocation  (400,200);
		    createFileMenu();
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
	       setVisible(true);
	   } // default constructor
	 /**
	  * 
	  * @param item takes in a array of Strings
	  * @param title takes in a String
	  * @param length takes in a integer
	  */
	 public Receipt(String[] item, String title, int length) {
		 left = new TextArea();
			jFrame=new JFrame();
			jFrame.setSize(700,700);
		    jFrame.setLocation(200, 200);
		    jFrame.setTitle(title);
		    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    jFrame.setLayout(new GridLayout(1,2));
		    contentPane = jFrame.getContentPane();
		    contentPane.add(left);
		    for (int i=0; i <length; i++){
		    	left.append(item[i]);
		    	left.append("\n");
		    }
		    jFrame.setVisible(true);
	 }
	 /**
	  * 
	  * @param item array of Strings
	  * @param counter integer
	  * @param cost String
	  */
	public Receipt(String[] item, int counter, String cost){
		createWindow(item,counter,cost);
	}// constructor Receipt  
	/**
	 * 
	 * @param array takes in the output array with stored transaction
	 * @param count takes in the size of the transaction array 
	 * @param value takes in the Total cost of all the produces bought
	 */
	public static void createWindow(String[] array, int count, String value) {
		left = new TextArea();
		jFrame=new JFrame();
	    jFrame.setSize(400,400);
	    jFrame.setLocation(200, 200);
	    jFrame.setTitle("");
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.setLayout(new GridLayout(1,2));
	    contentPane = jFrame.getContentPane();
	    contentPane.add(left);
	    for (int i=0; i < count; i++){
	    	left.append(array[i]);
	    	left.append("\n");
	    }
	    left.append("TOTAL COST =  $" +value);
	    jFrame.setVisible(true);
	    }// createWindow 
	
	public void createFileMenu( ) {
		  JMenuItem   item;
	      JMenuBar    menuBar  = new JMenuBar();
	      JMenu       fileMenu = new JMenu("File");
	      FileMenuHandler fmh  = new FileMenuHandler(this, mod);

	      JMenu fileEdit = new JMenu("Database");     
	      DatabaseMenuHandler dmh  = new DatabaseMenuHandler(this, mod);
	      
	      item = new JMenuItem("Open");    //Open...
	      item.addActionListener( fmh );
	      fileMenu.add( item );

	      fileMenu.addSeparator();           //add a horizontal separator line
	    
	      item = new JMenuItem("Quit");       //Quit
	      item.addActionListener( fmh );
	      fileMenu.add( item );

	      item = new JMenuItem("Open");
	      item.addActionListener(dmh);
	      fileEdit.add(item);
	      
	      item = new JMenuItem("Display Fruits");
	      item.addActionListener(dmh);
	      fileEdit.add(item);
	      
	      item = new JMenuItem("Display Vegetable");
	      item.addActionListener(dmh);
	      fileEdit.add(item);
	      
	      setJMenuBar(menuBar);
	      menuBar.add(fileMenu);
	      menuBar.add(fileEdit);
	      
	    
	   }

}
