import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   Model model;
   public FileMenuHandler (JFrame jf,Model m) {
      jframe = jf;
      model = m;
   }
   public void actionPerformed(ActionEvent event) {
      String  menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile( ); 
      else if (menuName.equals("Quit"))
         System.exit(0);
   } //actionPerformed

    private void openFile( ) {
       JFileChooser chooser;
       int          status;
       chooser = new JFileChooser( );
       status = chooser.showOpenDialog(null);
       File f;
	if (status == JFileChooser.APPROVE_OPTION) {
		f = chooser.getSelectedFile();
		model.openTrans(f.getPath());
	}
             
	else 
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
  
}