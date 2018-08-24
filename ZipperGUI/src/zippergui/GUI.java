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
    
        initComponents();
    
    }
    
    private JButton addFileBtn=new JButton("add file");
    private JButton removeFileBtn=new JButton("remove file");
    private JButton zipBtn=new JButton("Zip");
    JList fileList=new JList();
    
    private JMenuBar menu = new JMenuBar();
    private JMenu file = new JMenu("file");
    private JMenuItem addFileMenuItem = new JMenuItem("add file");
    private JMenuItem removeFileMenuItem = new JMenuItem("remove file");
    private JMenuItem zipMenuItem = new JMenuItem("zip");
    
    
    void initComponents()
    {
        
        this.setBounds(300,300,300,200);
        this.setDefaultCloseOperation(3);
        
        
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
                    layout.createParallelGroup().addComponent(addFileBtn).addComponent(removeFileBtn).addComponent(zipBtn)
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
