/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatingfilesanddirs;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maciek
 */
public class Main {

 
    public static void main(String[] args) {
      
        File fileOne = new File("file1.txt");
        File directoryOne = new File("folder1"+File.separator+"folder2");
        File directoryAndFile= new File("folder1"+File.separator+"folder2","fileTwo.txt");
      
        
        try 
        {
            if (!fileOne.exists())
             fileOne.createNewFile();
            else
                System.out.println("already exist");
            
            if (!directoryOne.exists())
             directoryOne.mkdirs();
            else
                System.out.println("already exist");
            
            if (!directoryAndFile.exists())
              directoryAndFile.createNewFile();
            else
                System.out.println("already exist");
            
        System.out.println("Can Write? "+fileOne.canWrite());
        System.out.println("Can Read? "+fileOne.canRead());
        System.out.println("is Hidden? "+fileOne.isHidden());
        System.out.println("is File? "+fileOne.isFile());
        System.out.println("is Directory? "+fileOne.isDirectory());
        System.out.println("Name: "+fileOne.getName());
        System.out.println("Directory: "+fileOne.getPath());
        System.out.println("Bytes: "+fileOne.length());
        System.out.println("Date modified "+new Date(fileOne.lastModified()));
     

        System.out.println(System.getProperty("user.dir"));
        System.out.println(fileOne.getAbsolutePath());  
        System.out.println(fileOne.getCanonicalPath());  
        System.out.println("-------------------------");
        // showDirectories(new File(System.getProperty("user.dir")));
            
            
        } 
        catch (IOException ex) 
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("-------------------------");
        System.out.println(System.getProperty("user.home"));
       //File lookedFile =  new File("hidden.txt");
       findFile(new File(System.getProperty("user.home")),new File("txt"));
        
       //showDirectories(new File(System.getProperty("user.dir")));
       
    }
    
    static void  showDirectories(File directory)
    {
       
        String[] directories=directory.list();
        for(int i=0; i<directories.length;i++)
        {
//           
           
           File subFile = new File(directory.getPath(),directories[i]);
            
           System.out.println(subFile);
//            
            if(subFile.isDirectory())
            {
                showDirectories(subFile);

            }
      
            
        }
    }   

    
    static void  findFile(File directory,File fileToFind)
    {
       
        String[] directories=directory.list();
        for(int i=0; i<directories.length;i++)
        {

            File searchDir = new File(directory.getPath(),directories[i]);
            File searchFile = new File(searchDir,fileToFind.getName());
            if(searchDir.getName().contains(searchFile.getName()))
                    System.out.println(searchDir);
            if (searchDir.isDirectory())
            {
              
                findFile(searchDir,searchFile);
                           
            }
            
        }
    }   
}



 


