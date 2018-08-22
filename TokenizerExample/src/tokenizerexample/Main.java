/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizerexample;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
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
            
            /**
             * Lesson 89
             */
//            PrintWriter  writer = new PrintWriter("database.txt");
//            
//            Product.writeToDataBase(products, writer);
//            
//            
//            writer.close();
//            
//            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
//            
//            Product[] products2;
//            products2=Product.readFromFile(reader);
//            for(int i=0; i<products2.length;i++)
//            {
//                System.out.println(products[i]);
//            
//            }
            
            /**
             * Lesson 90 part 1
             */
            
//            DataOutputStream outS = new DataOutputStream(new FileOutputStream("data.txt"));
//            
//            outS.writeDouble(1245.342);
//            outS.close();
//            
//            DataInputStream inS = new DataInputStream(new FileInputStream("data.txt"));
//            
//            System.out.println(inS.readDouble());
//            inS.close();
            
            /**
             * Lesson 90 part 2
             */
//            
//            RandomAccessFile raf = new RandomAccessFile("data2.txt","rw");    
//            
//            raf.writeDouble(23.34);
//            raf.writeDouble(9.4);
//            raf.writeChars("test");
//            
//            raf.seek(0);
//            System.out.println(raf.readDouble());
//            raf.seek(8);
//            System.out.println(raf.readDouble());
//            raf.seek(16);
//            System.out.println(raf.getFilePointer());  // output: 16
//            System.out.println(raf.readChar()); //output: "t" 
//            raf.close();
//            
            
            /**
             * Lesson 91
             */
            
            RandomAccessFile raf = new RandomAccessFile("database.txt","rw");
            
            Product.writeToDataBase(products, raf);
            
            
          
            Product[] products2= Product.readFromFile(raf);
            System.out.println(products2[0].getName());
             
            
             
             raf.close();
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      
        }
       
          
    
      
        
        
    }
    
}
