/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenizerexample;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;


public class Product
{
    public static final int NAME_LENGTH = 30;
    public static final int RECORD_LENGTH = (Character.BYTES*NAME_LENGTH+Double.BYTES+3*Integer.BYTES);
    private String name; // 60 byte
    private double price; // 8 byte
    private Date dateOfProduction; //  4+4+4=12 (3 integers) 
    
    Product()
    {
        name=" ";
        price=0.0;
        dateOfProduction = new GregorianCalendar().getTime();

    }
    
    Product(String name,double price)
    {
        this();
        this.name=name;
        this.price=price;
    }
    
    Product(String name,double price,int year,int month,int day)
    {
        
        this.name=name;
        this.price=price;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        this.dateOfProduction=calendar.getTime();
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public Date getDate()
    {
        return dateOfProduction;     
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public void setPrice(double price)
    {
        this.price=price;
    }
    
    public void setDate(Date date)
    {
        this.dateOfProduction=date;
    }
    
    public void setDate(int year, int month ,int day)
    {
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        this.dateOfProduction=calendar.getTime();
    }
    
    @Override
    public String toString()
    {   
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(this.getDate());
        return ("Name: "+this.getName()+" "+"|Price: "+this.getPrice()+"|Year "+calendar.get(Calendar.YEAR)+"|Month "+calendar.get(Calendar.MONTH)+"|Day "+calendar.get(Calendar.DAY_OF_MONTH));
    }
    
    
    
    static void writeToDataBase(Product[] products, DataOutput OutS) throws IOException
    {

        for(int i=0; i<products.length;i++)
        {
            products[i].writeSingleRecordToDatabase(OutS);

        }
    }
    
    
    public void writeSingleRecordToDatabase(DataOutput OutS) throws IOException
    {
        
        StringBuffer stringB = new StringBuffer();
        stringB.append(name);
        stringB.setLength(30);
        OutS.writeChars(stringB.toString());
        
        OutS.writeDouble(price);
        
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dateOfProduction);
        OutS.writeInt(calendar.get(Calendar.YEAR));
        OutS.writeInt(calendar.get(Calendar.MONTH));
        OutS.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
      
    
    }
    
    public void readRecord(RandomAccessFile InS ,int n) throws IOException, NoRecord
    {
        if (n<=InS.length()/RECORD_LENGTH)
        {
        
        InS.seek((n-1)*RECORD_LENGTH);
        this.readRecord(InS);
        
        }
        else
           throw new NoRecord("There is no record");
    }
    
    public void readRecord(DataInput InS) throws IOException
    {
       
       StringBuffer stringB = new StringBuffer(NAME_LENGTH);
       
       
        
     
       for(int i=0; i<NAME_LENGTH;i++)
       {
           
           char tempChar = InS.readChar();
           
           if(tempChar!='\0')
              stringB.append(tempChar);
       
           
       }  
           this.name=stringB.toString();
           this.price=InS.readDouble();
           int year = InS.readInt();
           int month = InS.readInt();
           int day = InS.readInt();
           
           GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
           this.dateOfProduction=calendar.getTime();
           
      
        
    
    }
    
    
    static Product[] readFromFile (RandomAccessFile InS) throws IOException
    {
       ((RandomAccessFile)InS).seek(0);
        int length= (int)(InS.length()/RECORD_LENGTH);
        
        Product[] products = new Product[length];
        
        
        for(int i=0; i<length;i++)
        {
           products[i]=new Product();
           products[i].readRecord(InS);
        
        }
    
         return products;       
    
    }
     
    
}
