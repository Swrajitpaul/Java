import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class DatabaseMenuHandler implements ActionListener {
   JFrame jframe;
   Model model;
   public DatabaseMenuHandler (JFrame jf, Model m) {
      jframe = jf;
      model = m;
   }
   public void actionPerformed(ActionEvent event) {
	   String  menuName;
	      menuName = event.getActionCommand();
	      if (menuName.equals("Open"))
	         openFile( ); 
	      else if (menuName.equals("Display Fruits")){
	    	 model.displayFruits();
	      }
	      else if (menuName.equals("Display Vegetable"))
	    	  model.displayVegetables();
   } 

	    private void openFile( ) {
	       JFileChooser chooser;
	       int          status;
	       chooser = new JFileChooser( );
	       status = chooser.showOpenDialog(null);
	       File f;
		if (status == JFileChooser.APPROVE_OPTION) {
			f = chooser.getSelectedFile();
			model.openDb(f.getPath());
		}
	             
		else 
	          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
	    } //openFile
   
}