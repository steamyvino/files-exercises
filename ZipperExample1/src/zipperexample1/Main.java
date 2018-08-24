/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipperexample1;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.*;

/**
 *
 * @author Maciek
 */
public class Main {

    
    
        public static final int BUFFER = 1024;
       
    
    public static void main(String[] args) {
     
        byte tempData[] = new byte[BUFFER];
        
        String[] files = new String[] {"test.txt","logo.ico"};
        
        try 
        {
            
            ZipOutputStream zOutS =new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("archive.zip")));
            
            
            for(int i=0;i<files.length;i++)
            {
            
                BufferedInputStream InS = new BufferedInputStream(new FileInputStream(files[i]));

                int counter;

                zOutS.putNextEntry(new ZipEntry(files[i]));

                while((counter = InS.read(tempData, 0, BUFFER))!= -1)
                {
                    zOutS.write(tempData, 0, counter);
                }
                zOutS.closeEntry();
                InS.close();
            }
           
            zOutS.close();
        }     
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
