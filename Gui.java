import javax.swing.*;
public class Gui extends JFrame {
	public String transactionFile= "";
   public Gui(String title, int height, int width) {
	    setTitle(title);
	    setSize(height,width);
       setLocation  (400,200);
	    createFileMenu();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
   } 

   public void createFileMenu( ) {
      JMenuItem   item;
      JMenuBar    menuBar  = new JMenuBar();
      JMenu       fileMenu = new JMenu("File");
      FileMenuHandler fmh  = new FileMenuHandler(this);

      JMenu fileEdit = new JMenu("Database");     
      DatabaseMenuHandler fnh  = new DatabaseMenuHandler(this);
      
      item = new JMenuItem("Open");    //Open...
      item.addActionListener( fmh );
      fileMenu.add( item );

      fileMenu.addSeparator();           //add a horizontal separator line
    
      item = new JMenuItem("Quit");       //Quit
      item.addActionListener( fmh );
      fileMenu.add( item );

      item = new JMenuItem("Open");
      item.addActionListener(fnh);
      fileEdit.add(item);
      
      item = new JMenuItem("Display Fruits");
      item.addActionListener(fnh);
      fileEdit.add(item);
      
      item = new JMenuItem("Display Vegetable");
      item.addActionListener(fnh);
      fileEdit.add(item);
      
      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
      menuBar.add(fileEdit);
      
    
   } 

} 
