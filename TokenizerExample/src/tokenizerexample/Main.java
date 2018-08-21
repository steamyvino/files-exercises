/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizerexample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

   
    public static void main(String[] args)
    {
        
     
        
            Product[] products=new Product[3];
            products[0] = new Product("cz-75",3599.99,2015,11,04);
            products[1] = new Product("glock 19",2440.59,2018,5,2);
            products[2] = new Product("HK USP",2999.0,2018,2,9);
            
            
            
        try 
        {    
            PrintWriter  writer = new PrintWriter("database.txt");
            
            Product.writeToDataBase(products, writer);
            
            
            writer.close();
            
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
            
            Product[] products2;
            products2=Product.readFromFile(reader);
            for(int i=0; i<products2.length;i++)
            {
                System.out.println(products[i]);
            
            }
            
            
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      
        }
       
          
    
      
        
        
    }
    
}
