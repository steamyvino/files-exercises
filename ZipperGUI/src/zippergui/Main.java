/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zippergui;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Main {

    public void control()
    {
   
            
            GUI gui = new GUI();
            gui.setVisible(true);
            gui.setAddFileAction(new Action ("Add File" , "Add file to archive", new ImageIcon("add.png")));
            gui.setRemoveFileAction(new Action ("Remove File" , "Remove file from archive", new ImageIcon("remove.png")));
            gui.setZipAction(new Action ("Zip" , "Create archive", new ImageIcon("zip.png")));
            
            
   
    }
    
    
    public static void main(String[] args) {
      
        new Main().control();
      
    }
    
}



class Action extends AbstractAction
{

    Action(String name, String description, Icon icon)
    {
        this.putValue(Action.NAME, name);
        this.putValue(Action.SHORT_DESCRIPTION, description);
        this.putValue(Action.SMALL_ICON, icon);

    }
    
    Action(String name, String description)
    {
        this.putValue(Action.NAME, name);
        this.putValue(Action.SHORT_DESCRIPTION, description);
       

    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    
        System.out.println(ae.getActionCommand());
        
    }


}