/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unzipperexample1;

import java.io.File;
import java.io.*;
import java.util.zip.*;
   


public class Main {

    public static final int BUFFER = 1024;
    
    
    public static void main(String[] args) {
     
        
        
        
        File folder = new File(System.getProperty("user.dir")+File.separator+"nameOfFIle");
         
        ZipEntry entry = null;
        byte[] tmpData = new byte[BUFFER];
        
        
        try
        {
            if(!folder.exists())
                folder.mkdir();
            
             ZipInputStream zInS = new ZipInputStream(new BufferedInputStream(new FileInputStream("archive.zip"),BUFFER));
             
             while((entry=zInS.getNextEntry())!=null)
             {
                 BufferedOutputStream fOutS = new BufferedOutputStream(new FileOutputStream(folder+File.separator+entry.getName()),BUFFER);
                 
                 int counter;
                 
                 while((counter = zInS.read(tmpData, 0, BUFFER))!=-1)
                 {
                 
                     fOutS.write(tmpData, 0, BUFFER);
                 
                 }
                     
                     
                 zInS.closeEntry();
                 fOutS.close();
              
             }
             
             zInS.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());      
        }
    }
    
}
