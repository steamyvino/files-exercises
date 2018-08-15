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
        
        writer.write("test");
        
        writer.close();
        
    }
    
}
