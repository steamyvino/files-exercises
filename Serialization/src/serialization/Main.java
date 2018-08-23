/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

   
    public static void main(String[] args)
    {
        
     
        
            Product[] products=new Product[3];
            products[0] = new Product("cz-85 Combat",3599.99,2015,11,04);
            products[1] = new Product("glock 19",2440.59,2018,5,2);
            products[2] = new Product("HK USP",2999.0,2018,2,9);
            
            
            
        try 
        {   
            
            ObjectOutputStream OutS = new ObjectOutputStream(new FileOutputStream("database.txt"));
            OutS.writeObject(products);
            OutS.close();
            
            
            
            
            ObjectInputStream InS = new ObjectInputStream(new FileInputStream("database.txt"));
            Product[] otherGuns = (Product[])InS.readObject();
            for (int i=0;i<otherGuns.length;i++)
            {
            
                System.out.println(otherGuns[i]);
            
            }
        
            InS.close();
            
        } 
        
        
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
      
        }
        catch(ClassNotFoundException e)
        {
        
           System.out.println(e.getMessage()); 
        
        }
       
          
    
      
        
        
    }
    
}
