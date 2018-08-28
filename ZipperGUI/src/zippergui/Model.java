/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zippergui;

import java.io.*;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.DefaultListModel;

/**
 *
 * @author Maciek
 */
public class Model {
    
    DefaultListModel<String> fileListModel;
    ArrayList<File> zipList = new ArrayList<File>();
    public static final int BUFFER = 1024;
    
    Model()
    {
    
        fileListModel=new DefaultListModel<String>();
      
          
    
    }

    void addToList(File[] file)
    {
        for (int i=0;i<file.length;i++)
        {
           if(!isDuplicate(file[i].getName()))
           {
               zipList.add(file[i]);
               fileListModel.addElement(file[i].getName());
           }
        }
        
    }
    
    boolean isDuplicate(String checkedFile)
    {
    
        return fileListModel.contains(checkedFile);
            
    }
    
    void removeFromList(int[] indices)
    {
    
        for(int i=0;i<indices.length;i++)
        {        
            zipList.remove(indices[i]-i);
            fileListModel.remove(indices[i]-i);
        }
    }
    
    void createZipArchive(File file)
    {
        
        byte tempData[] = new byte[BUFFER];
    
        try 
        { 
            ZipOutputStream zOutS =new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
  
            for(int i=0;i<zipList.size();i++)
            {
              if(!zipList.get(i).isDirectory())
              addFileToArchive(zOutS,zipList.get(i),zipList.get(i).getPath(),tempData);
             
              else
              {
                 showDirectories(zipList.get(i));
                
                 
                 for(int j=0;j<directoriesList.size();j++)
                 {
                     System.out.println("TEST");
                     addFileToArchive(zOutS,zipList.get(j),zipList.get(i).getPath(),tempData);
                     
                 }
              }
            }
           
            zOutS.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    
    }
    
    void addFileToArchive(ZipOutputStream zOutS, File file, String path, byte[] tempData) throws IOException
    {
    
        BufferedInputStream InS = new BufferedInputStream(new FileInputStream(file),BUFFER);
      

                int counter;

                zOutS.putNextEntry(new ZipEntry(file.getPath().substring(path.lastIndexOf(File.separator)+1)));
                
                while((counter = InS.read(tempData, 0, BUFFER))!= -1)
                {
                    zOutS.write(tempData, 0, counter);
                }
                zOutS.closeEntry();
                InS.close();
    
    }
    
    void  showDirectories(File directory)
    {
       
        String[] directories=directory.list();
        for(int i=0; i<directories.length;i++)
        {
//           
           
           File subFile = new File(directory.getPath(),directories[i]);
            
           System.out.println(subFile);
//            
           
            if(subFile.isFile())
                directoriesList.add(subFile);
            
            if(subFile.isDirectory())
                showDirectories(new File(subFile.getPath()));

        }
    }
   
   ArrayList directoriesList = new ArrayList();
   
}
    
    
    

