/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writerexample;

import java.io.*;

/**
 *
 * @author Maciek
 */
public class Main {

   
    
    public static void main(String[] args) throws IOException {
     
        Writer writer = new FileWriter("test.txt");

        BufferedWriter writer2= new BufferedWriter(new FileWriter("test2.txt"));
        
        
        
        writer.write("test");
        
        writer2.newLine();
        writer2.write("new line");
        
        writer.close();
        writer2.close();
    }
    
}
