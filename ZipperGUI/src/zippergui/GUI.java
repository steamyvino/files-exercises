/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zippergui;


import javax.swing.*;


public class GUI extends JFrame{
    
    GUI()
    {
 
    
    }
    
    
    private JButton addFileBtn=new JButton();
    private JButton removeFileBtn=new JButton();
    private JButton zipBtn=new JButton();;
    private JList fileList=new JList();
    private JMenuBar menu = new JMenuBar();
    private JMenu file = new JMenu("file");
    private JMenuItem addFileMenuItem=new JMenuItem();
    private JMenuItem removeFileMenuItem=new JMenuItem();
    private JMenuItem zipMenuItem=new JMenuItem();
    
 
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
                .addComponent(fileList, 100,150, Short.MAX_VALUE)
                .addContainerGap(0,Short.MAX_VALUE)
                .addGroup
                (
                    layout.createParallelGroup().addComponent(addFileBtn,110,GroupLayout.DEFAULT_SIZE,110).addComponent(removeFileBtn).addComponent(zipBtn)
                )
        );
        layout.setVerticalGroup
        (
                layout.createParallelGroup()
                .addComponent(fileList,100,150,Short.MAX_VALUE)
                .addGroup
                (
                    layout.createSequentialGroup().addComponent(addFileBtn).addComponent(removeFileBtn).addGap(5,40,Short.MAX_VALUE).addComponent(zipBtn)
                )
        );
        
        this.getContentPane().setLayout(layout);
        
        fileList.setBorder(BorderFactory.createEtchedBorder());
    
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


