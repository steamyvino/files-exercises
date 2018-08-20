/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizerexample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

   
    public static void main(String[] args)
    {
        
     
        
            Product[] products=new Product[3];
            products[0] = new Product();
            products[0] = new Product("cz-75",3599.99,2015,11,04);
            products[0] = new Product("glock 19 gen V",2440.59,2018,5,2);
            products[0] = new Product("Pistolet HK USP",2999.0,2018,2,9);
            
            
            
        try 
        {    
            PrintWriter  writer = new PrintWriter("database.txt");
            
            Product.writeToDataBase(products, writer);
            
            writer.close();
            
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      
        }
       
        
        
    }
    
}
