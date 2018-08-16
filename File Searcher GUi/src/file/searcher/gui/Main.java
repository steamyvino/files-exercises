/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.searcher.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Maciek
 */
public class Main extends JFrame {

   
    Main()
    {
    
       
        initComponents();
    }
    
    JPanel searchPanel = new JPanel();
    JTextField findFileField = new JTextField(10);
    JLabel findFileLabel = new JLabel("Find what: ");
    JButton findFileBtn = new JButton("find");
    JTextArea resultArea = new JTextArea("test");
    JScrollPane resultAreaPane = new JScrollPane(resultArea);
    File fileToFind;
    Runnable runnable = new ValidateThread();
    Thread thread = new Thread(runnable);
    
    void initComponents()
    {
    
         this.setBounds(300,300,350,250);
         this.setDefaultCloseOperation((3));
     
         
         this.getContentPane().add(searchPanel,BorderLayout.NORTH);
         searchPanel.add(findFileLabel);
         searchPanel.add(findFileField);
         searchPanel.add(findFileBtn);
        
         
         this.getContentPane().add(resultAreaPane);
         
         findFileBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) 
             {
                 fileToFind = new File(findFileField.getText());
                 
                 thread.start();
             
                       
                File fileToFind = new File(findFileField.getText());
              
                 
             }
         });
         
         
    }
    
   
 
    
    void  findFile(File directory,File fileToFind)
    {
       
        String[] directories=directory.list();
        for(int i=0; i<directories.length;i++)
        {
   
            File searchDir = new File(directory.getPath(),directories[i]);
            File searchFile = new File(searchDir,fileToFind.getName());
            System.out.println(searchDir);
            if(searchDir.getName().contains(searchFile.getName()))
            {
                       
                resultArea.append(searchDir.toString()+"\n");
                resultArea.setCaretPosition(resultArea.getText().length() - 1);
                resultArea.update(resultArea.getGraphics());
            }
            
            if (searchDir.isDirectory())
            {
              
                findFile(searchDir,searchFile);
                           
            }
            
        }
        
        System.out.println("ENDED");
    }   
    
    class ValidateThread implements Runnable {
    public void run() {
        findFile(new File(System.getProperty("user.dir")),fileToFind);
    }
}
    
    
    public static void main(String[] args) {
        
          SwingUtilities.invokeLater(new Runnable() {
            public void run() {
       new Main().setVisible(true);
                }
            });
                 
           

    
    }
}
