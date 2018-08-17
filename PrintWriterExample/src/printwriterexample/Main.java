/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printwriterexample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maciek
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int weight=60;
        float height = 175.731f;
        
        try 
        {
            PrintWriter printw = new PrintWriter(new FileWriter("data.txt"));
          
            printw.println("123456");
            
            printw.flush(); // force empty buffer
            
            printw.close();
       
            printw = new PrintWriter(new FileWriter("data.txt",true));  // true allows to apped content to existing
            
            printw.append("654321");
            printw.println();
            printw.println("Weight: "+weight+"kg / Height: "+height);
            printw.printf("weight: %dkg/ Height %.2f",weight,height);
            
            
                     
            printw.close();
            BufferedWriter printw2 = new BufferedWriter(new FileWriter("data2.txt"));
            BufferedReader readw = new BufferedReader(new FileReader("data.txt"));
//            
//            System.out.println(readw.readLine());
//            System.out.println(readw.readLine());
//            System.out.println(readw.readLine());
//            System.out.println(readw.readLine());
            String text;
            while((text=readw.readLine())!=null)
            {
                  System.out.println(text);
                  printw2.write(text);
                  printw2.newLine();
            } 
            readw.close();
            printw2.close();
            
            
            
        } 
        catch (IOException ex) 
        {
            
            System.out.println(ex.getStackTrace());
        }
        
        
    
        
        
    }
    
}
