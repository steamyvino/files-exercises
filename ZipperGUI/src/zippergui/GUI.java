/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zippergui;


import java.io.File;
import javax.swing.*;


public class GUI extends JFrame{
    
    private JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
    
    GUI()
    {
 
    
    }
    
    private JButton addFileBtn=new JButton();
    private JButton removeFileBtn=new JButton();
    private JButton zipBtn=new JButton();;
    private JList<String> fileList=new JList<String>();
    private JMenuBar menu = new JMenuBar();
    private JMenu file = new JMenu("file");
    private JMenuItem addFileMenuItem=new JMenuItem();
    private JMenuItem removeFileMenuItem=new JMenuItem();
    private JMenuItem zipMenuItem=new JMenuItem();
    private JScrollPane scrollPane = new JScrollPane(fileList);
 
    void setAddFileAction(Action action)
    {
       
        addFileBtn.setAction(action);  
        addFileMenuItem.setAction(action);
    }
    void setRemoveFileAction(Action action)
    {
        removeFileBtn.setAction(action);  
        removeFileMenuItem.setAction(action);
    }
    void setZipAction(Action action)
    {
        zipBtn.setAction(action);  
        zipMenuItem.setAction(action);
    }
    int showFileChooserOpen()
    {
        return fileChooser.showOpenDialog(rootPane);
    
    }
    int showFileChooserSave()
    {
        return fileChooser.showSaveDialog(rootPane);
    
    }
    JFileChooser getFileChooser()
    {
    
        return fileChooser;
    
    }
    
    JList getList()
    {
    
        return fileList;
        
    }
    
    
    
    void initComponents()
    {
  
        this.setBounds(300,300,330,260);
        this.setDefaultCloseOperation(3);
        this.setJMenuBar(menu);
        addFileBtn.setHorizontalAlignment(SwingConstants.LEFT);
        
        GroupLayout layout = new GroupLayout(this.getContentPane());
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup
        (
                layout.createSequentialGroup()
                .addComponent(scrollPane, 100,150, Short.MAX_VALUE)
                .addContainerGap(0,Short.MAX_VALUE)
                .addGroup
                (
                    layout.createParallelGroup().addComponent(addFileBtn,110,GroupLayout.DEFAULT_SIZE,110).addComponent(removeFileBtn).addComponent(zipBtn)
                )
        );
        layout.setVerticalGroup
        (
                layout.createParallelGroup()
                .addComponent(scrollPane,100,150,Short.MAX_VALUE)
                .addGroup
                (
                    layout.createSequentialGroup().addComponent(addFileBtn).addComponent(removeFileBtn).addGap(5,40,Short.MAX_VALUE).addComponent(zipBtn)
                )
        );
        
        this.getContentPane().setLayout(layout);
        
        scrollPane.setBorder(BorderFactory.createEtchedBorder());
    
        /**
         * menu
         */
        
        menu.add(file);
        file.add(addFileMenuItem);
        file.add(removeFileMenuItem);
        file.add(zipMenuItem);
        this.setJMenuBar(menu);
        
    }
    
    
}


