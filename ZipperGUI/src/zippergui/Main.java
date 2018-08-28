/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zippergui;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


public class Main {

    GUI gui;
    Model model;
    public void control()
    {
   
            model= new Model();
            gui = new GUI();
            gui.setVisible(true);    
            
            gui.setAddFileAction(new Action ("Add File" , "Add file to archive", new ImageIcon("add.png")));
            gui.setRemoveFileAction(new Action ("Remove File" , "Remove file from archive", new ImageIcon("remove.png")));
            gui.setZipAction(new Action ("Zip" , "Create archive", new ImageIcon("zip.png")));
            
            gui.initComponents();
            
            gui.getList().setModel(model.fileListModel);
            
            gui.getFileChooser().setMultiSelectionEnabled(true);
            gui.getFileChooser().setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
           
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


            if(ae.getActionCommand().equals("Add File"))
               if (gui.showFileChooserOpen()==0)
                   model.addToList(gui.getFileChooser().getSelectedFiles());
             
            if(ae.getActionCommand().equals("Remove File"))
                model.removeFromList(gui.getList().getSelectedIndices());
            
            if(ae.getActionCommand().equals("Zip"))
            {
                gui.getFileChooser().setSelectedFile(new File(System.getProperty("user.dir")+File.separator+"Archive.zip"));
                if (gui.showFileChooserSave()==0)
                    model.createZipArchive(gui.getFileChooser().getSelectedFile());
            }
         

        }


    }
    
    public static void main(String[] args) {
      
        new Main().control();
      
    }
    
    
    
    
}



